package com.example.Leogo.capstone2_anziday;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;


public class UpdateUserActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    EditText edtUpdateName,edtDateBirth,edtUpdateAddress,edtFavoriteFood,edtDiUng,editIllness,editGroupPerson;
    Button btnUpdate, btnCancle;
    User user;
    String [] diungItems,groupItems,illnessItems;
    boolean[] diungchecked;
    boolean[] groupchecked;
    boolean[] illnessChecked;
    ArrayList<Integer> mUserItems = new ArrayList<>();
        ArrayList<Integer> mDiungItems = new ArrayList<>();
    ArrayList<Integer> mGroupItems = new ArrayList<>();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        AnhXa();
        //  bắt sự kiện click trên edit để arlet
        editIllness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder  illnessArlert = new AlertDialog.Builder(UpdateUserActivity.this);
                illnessArlert.setTitle("Chọn bệnh mà bạn đang mắc phải");
                illnessArlert.setMultiChoiceItems(illnessItems, illnessChecked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean checked) {
                        if(checked) {
                            if (!mUserItems.contains(position)) {
                                mUserItems.add(position);
                            }
                        }
                        else {
                            if (mUserItems.contains(position)) {
                                mUserItems.remove(position);
                            }
                        }
                    }
                });
                illnessArlert.setCancelable(false);
                illnessArlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String item = "";
                        int length = mUserItems.size();
                        for (int il = 0; i <length ; il++) {
                            item = item + illnessItems[mUserItems.get(il)];
                            if (il != length - 1) {
                                item = item + ",";
                            }
                            if (il == length -1) {
                                break;
                            }
                        }
                        editIllness.setText(item);
                    }
                });
                illnessArlert.setNegativeButton("Trở về", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                illnessArlert.setNeutralButton("Xóa hết", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        for(int il = 0 ; i < illnessChecked.length;i++){
                            illnessChecked[i] = false;
                            mUserItems.clear();
                            editIllness.setText("");
                        }
                    }
                });
                AlertDialog mDialog = illnessArlert.create();
                mDialog.show();
            }

        });
        editGroupPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder  groupAlert = new AlertDialog.Builder(UpdateUserActivity.this);
                groupAlert.setTitle("Bạn thuộc nhóm người nào ?");
                groupAlert.setMultiChoiceItems(groupItems, groupchecked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean checked) {
                        if(checked) {
                            if(!mGroupItems.contains(position)) {
                                mGroupItems.add(position);
                            }
                        } else {
                            if(mGroupItems.contains(position)) {
                                mGroupItems.remove(position);
                            }
                        }
                    }
                });
                groupAlert.setCancelable(false);
                groupAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String item = "";
                        int length = mGroupItems.size();
                        for (int il = 0; i <length ; il++) {
                            item = item + groupItems[mGroupItems.get(il)];
                            if (il != length - 1) {
                                item = item + ",";
                            }
                            if (il == length -1) {
                                break;
                            }
                        }
                        editGroupPerson.setText(item);
                    }
                });
                groupAlert.setNegativeButton("Trở về", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                groupAlert.setNeutralButton("Xóa hết", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        for(int il = 0 ; i < groupchecked.length;i++){
                            groupchecked[i] = false;
                            mGroupItems.clear();
                            editGroupPerson.setText("");
                        }
                    }
                });
                AlertDialog mDialog = groupAlert.create();
                mDialog.show();
            }
        });

        edtDiUng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder  agelicArlert = new AlertDialog.Builder(UpdateUserActivity.this);
                agelicArlert.setTitle("Chọn loại dị ứng mà bạn đang mắc phải");
                agelicArlert.setMultiChoiceItems(diungItems, diungchecked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean checked) {
                        if (checked) {
                            if (!mDiungItems.contains(position)) {
                                mDiungItems.add(position);
                            }
                        } else {
                            if (mDiungItems.contains(position)) {
                                mDiungItems.remove(position);
                            }
                        }
                    }
                });
                agelicArlert.setCancelable(false);
                agelicArlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String item = "";
                        int length = mDiungItems.size();
                        for (int il = 0; i <length ; il++) {
                            item = item + diungItems[mDiungItems.get(il)];
                            if (il != length - 1) {
                                item = item + ",";
                            }
                            if (il == length -1) {
                                break;
                            }
                        }
                        edtDiUng.setText(item);
                    }
                });
                agelicArlert.setNegativeButton("Trở về", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                agelicArlert.setNeutralButton("Xóa hết", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        for(int il = 0 ; i < diungchecked.length;i++){
                            diungchecked[i] = false;
                            mDiungItems.clear();
                            edtDiUng.setText("");
                        }
                    }
                });
                AlertDialog mDialog = agelicArlert.create();
                mDialog.show();
            }
        });
        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putInt("loginForCart",2);
                editor.commit();
                Intent intent = new Intent(UpdateUserActivity.this,MainActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getIntent().getExtras();
                User user = (User) bundle.getParcelable("Account");
                user.setAddress(edtUpdateAddress.getText().toString());
                user.setAllergy(edtDiUng.getText().toString());
                user.setIllness(editIllness.getText().toString());
                user.setGroupPerson(editGroupPerson.getText().toString());
                user.setDateBirth(edtDateBirth.getText().toString());
                updateUser(user);
                bundle.putParcelable("user",user);
                Intent intent = new Intent(UpdateUserActivity.this,MainActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
    public void AnhXa(){
        edtUpdateAddress = (EditText) findViewById(R.id.edtUpdateAddress);
        edtDateBirth = (EditText) findViewById(R.id.edtDateBirth);
        edtFavoriteFood = (EditText) findViewById(R.id.edtFavoriteFood);
        edtDiUng =(EditText) findViewById(R.id.edtDiUng);
        editIllness = (EditText) findViewById(R.id.editIllness);
        editGroupPerson = (EditText) findViewById(R.id.editGroupPerson);
        btnCancle = (Button) findViewById(R.id.btnCancel);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        diungItems = getResources().getStringArray(R.array.diung_item);
        illnessItems = getResources().getStringArray(R.array.illness_item);
        groupItems = getResources().getStringArray(R.array.nhomnguoi_item);
        illnessChecked = new boolean[illnessItems.length];
        groupchecked = new boolean[groupItems.length];
        diungchecked = new boolean[diungItems.length];
    }
    private void updateUser(User user){
        db.collection("users").document(user.getUserName())
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(UpdateUserActivity.this, "Cập nhật tài khoản thành công", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(UpdateUserActivity.this, "Cập nhật khoản thất bại", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
