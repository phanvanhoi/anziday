package com.example.Leogo.capstone2_anziday;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.app.Activity.RESULT_OK;

public class Fragment_Profile extends Fragment {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    Button btnLogin;
    EditText edtUser , edtPassword;
    TextView txtRegister;
    Fragment_Home fragment_home;
    User user = new User();
    Intent intent;
    Validation validation = new Validation();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    public static final int REQUEST_CODE = 1997;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_profile,container,false);

        edtUser = view.findViewById(R.id.edtUserLogin);
        edtPassword = view.findViewById(R.id.edtPasswordLogin);
        btnLogin = view.findViewById(R.id.btnLogin);
        txtRegister = view.findViewById(R.id.txtRegister);
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),RegisterActivity.class);
                startActivityForResult(intent,REQUEST_CODE);

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtUser.getText().toString().equals("") || edtPassword.getText().toString().equals("")
                ) {
                    Toast.makeText(getActivity(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else if (edtUser.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "Tên đăng nhập không được để trống", Toast.LENGTH_SHORT).show();
                } else if (edtPassword.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "Mật khẩu không được để trống", Toast.LENGTH_SHORT).show();
                } else if (edtUser.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "Tên đăng nhập không được để trống", Toast.LENGTH_SHORT).show();
                } else if (edtUser.getText().toString().length() < 4 || edtUser.getText().toString().length() > 16) {
                    Toast.makeText(getActivity(), "Tên đăng nhập từ 4 > 16 kí tự", Toast.LENGTH_SHORT).show();
                } else if (edtPassword.getText().toString().length() < 4 || edtPassword.getText().toString().length() > 16) {
                    Toast.makeText(getActivity(), "Mật khẩu từ 4 > 16 kí tự", Toast.LENGTH_SHORT).show();
                } else if (validation.checkSpecialKey(edtUser.getText().toString().trim()) == false) {
                    Toast.makeText(getActivity(), "Tên đăng nhập không được chứa kí tự đặc biệt", Toast.LENGTH_SHORT).show();
                } else {
                    checkUser(edtUser.getText().toString(), edtPassword.getText().toString());
                    new Thread() {
                        @Override
                        public void run() {
                            try {
                                this.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (user.getUserName() == null) {
                                // đăng nhập thất bại
                                getActivity().runOnUiThread(new Runnable() {
                                    public void run() {
                                        Toast.makeText(getActivity(), "Tên đăng nhập hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            } else if (user.getUserName() != null) {

                                // đăng nhập thành công
                                intent = new Intent(getActivity(), MainActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putParcelable("user", user);
                                intent.putExtras(bundle);
                                startActivityForResult(intent, REQUEST_CODE);
                                getActivity().runOnUiThread(new Runnable() {
                                    public void run() {
                                        Toast.makeText(getActivity(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }


                        }
                    }.start();
                }

            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                User user = data.getExtras().getParcelable("Account");
                edtUser.setText(user.getUserName());
                edtPassword.setText(user.getPassWord());
            }
        }
    }

    private void checkUser(String username,String password) {
        db.collection("users").whereEqualTo("userName", username).whereEqualTo("passWord",password).get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                user.setUserName(document.get("userName").toString());
                                user.setFullName(document.get("fullName").toString());
                                user.setDateBirth(document.get("dateBirth").toString());
                                user.setIllness(document.get("illness").toString());
                                user.setGroupPerson(document.get("groupPerson").toString());
                                user.setAllergy(document.get("allergy").toString());
                                user.setAddress(document.get("address").toString());
//                                Log.d("AAA",user.getUserName());
                            }
                        } else {
                            Log.d("AAA", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }
}
