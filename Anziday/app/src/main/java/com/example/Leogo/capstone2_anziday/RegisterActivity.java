package com.example.Leogo.capstone2_anziday;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    Button btnCreateAcc, btnCancel;
    EditText edtFullname, edtUser , edtPassword,edtRepassword;
    User user ;
    Fragment_Profile fragment_profile = new Fragment_Profile();

    Validation validation = new Validation();
    StringLibrary stringLibrary = new StringLibrary();
    Intent intent;
    ArrayList<String> keyString = new ArrayList<String>();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = null;
    private ArrayList<String> getUser;
    private static final int REQUEST_CODE = 1221;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        AnhXa();


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtUser.getText().toString().equals("") || edtPassword.getText().toString().equals("") || edtFullname.getText().toString().equals("")
                ) {
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else if (edtRepassword.getText().toString().equals(edtPassword.getText().toString().trim()) == false) {
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập lại đúng password", Toast.LENGTH_SHORT).show();
                } else if (edtPassword.getText().toString().length() < 8) {
                    Toast.makeText(RegisterActivity.this, "Mật khẩu phải từ 8 đến 20 ký tự", Toast.LENGTH_SHORT).show();
                } else if (edtUser.getText().toString().length() < 4) {
                    Toast.makeText(RegisterActivity.this, "Username phải từ 4 đến 16 ký tự", Toast.LENGTH_SHORT).show();
                } else if (edtFullname.getText().toString().length() < 10) {
                    Toast.makeText(RegisterActivity.this, "Họ và tên phải từ 10 đến 80 ký tự", Toast.LENGTH_SHORT).show();
                } else if (validation.checkNumberInString(edtFullname.getText().toString().trim()) == false) {
                    Toast.makeText(RegisterActivity.this, "Họ và tên không chứa ký tự số", Toast.LENGTH_SHORT).show();
                } else if (validation.checkSpecialKey(edtFullname.getText().toString().trim()) == false) {
                    Toast.makeText(RegisterActivity.this, "Họ và tên không chứa ký tự đặc biệt", Toast.LENGTH_SHORT).show();
                } else if (validation.checkSpecialKey(edtUser.getText().toString().trim()) == false) {
                    Toast.makeText(RegisterActivity.this, "Tên đăng nhập không chứa ký tự đặc biệt", Toast.LENGTH_SHORT).show();
                } else if (validation.checkSpecialKey(edtPassword.getText().toString().trim()) == false) {
                    Toast.makeText(RegisterActivity.this, "Mật khẩu không chứa ký tự đặc biệt", Toast.LENGTH_SHORT).show();
                } else {
//                    if(checkExistUser(edtFullname.getText().toString()) == true){
//                        Toast.makeText(RegisterActivity.this, "Tài khoản đã có người sử dụng", Toast.LENGTH_SHORT).show();
//                    }
//                    else {
                    intent = new Intent(RegisterActivity.this,UpdateUserActivity.class);
                    Bundle bundle = new Bundle();
                        user = new User();
                        user.setFullName(edtFullname.getText().toString());
                        user.setUserName(edtUser.getText().toString());
                        user.setPassWord(edtPassword.getText().toString());
                        addUser(user);
                    bundle.putParcelable("Account", user);
                    // truyền đối tượng bundle sang fragment
                    fragment_profile.setArguments(bundle);
                    intent.putExtras(bundle);
                    startActivityForResult(intent,REQUEST_CODE);
                    setResult(RESULT_OK, intent);
                        finish();
//                    }
                }
            }
        });

        ArrayList<String> usernames = getData();
        for(String user : usernames){
            Log.d("TAG",user);
        }
    }



    public ArrayList<String> getData() {
        getUser = new ArrayList<String>();
        db.collection("users")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                getUser.add(document.getId());
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
        // length của ArrayList = 0
        return getUser;
    }



    public void AnhXa(){
        edtUser = findViewById(R.id.edtUser);
        edtPassword = findViewById(R.id.edtPassword);
        edtRepassword = findViewById(R.id.edtRePassword);
        edtFullname = findViewById(R.id.edtFullname);
        btnCreateAcc = findViewById(R.id.btnCreateAcc);
        btnCancel = findViewById(R.id.btnCancel);
    }

    public void addUser(User user)    {

        db.collection("users").document(user.getUserName())
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(RegisterActivity.this, "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegisterActivity.this, "Tạo tài khoản thất bại", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    public void checkExistUser(){
//        for(String user : getUser) {
//            Toast.makeText(this, user, Toast.LENGTH_SHORT).show();
//        }
//            if(us.equals(user) == true) {
//                Log.d(TAG, "True");
//                return true;
//            }
//            else {
//                Log.d(TAG, "False");
//                return false;
//            }
//        }
//     return false;
    }
}
