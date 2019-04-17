package com.example.Leogo.capstone2_anziday;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
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
    private DatabaseReference mDatabase;

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
                } else if (edtPassword.getText().toString().length() < 2) {
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
                    if(checkExistUser(edtFullname.getText().toString()) == true){
                        Toast.makeText(RegisterActivity.this, "Tài khoản đã có người sử dụng", Toast.LENGTH_SHORT).show();
                    }
                    else {
//                    intent = new Intent(RegisterActivity.this,Fragment_Profile.class);
//                    Bundle bundle = new Bundle();
                        user = new User();
                        user.setFullName(edtFullname.getText().toString());
                        user.setUserName(edtUser.getText().toString());
                        user.setPassWord(edtPassword.getText().toString());
                        addUser(user);
//                    bundle.putParcelable("Account", user);
//                    // truyền đối tượng bundle sang fragment
//                    fragment_profile.setArguments(bundle);
//                    intent.putExtras(bundle);
//                    setResult(RESULT_OK, intent);
                        finish();
                    }
                }
            }
        });
    }

    public void AnhXa(){
        edtUser = findViewById(R.id.edtUser);
        edtPassword = findViewById(R.id.edtPassword);
        edtRepassword = findViewById(R.id.edtRePassword);
        edtFullname = findViewById(R.id.edtFullname);
        btnCreateAcc = findViewById(R.id.btnCreateAcc);
        btnCancel = findViewById(R.id.btnCancel);
    }

    public void addUser(User user){
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("user").child(user.getUserName()).setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(RegisterActivity.this, "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
    }
    public void getData() {

        mDatabase = FirebaseDatabase.getInstance().getReference("user");
        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                keyString.add(dataSnapshot.getKey().toString());
                Toast.makeText(RegisterActivity.this, dataSnapshot.getKey().toString(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public boolean checkExistUser(String us){
        getData();
        for(String user : keyString){
            Toast.makeText(RegisterActivity.this, user, Toast.LENGTH_SHORT).show();
            if(us.equals(user) == true)
                return true;
                break;
        }
     return false;
    }
}
