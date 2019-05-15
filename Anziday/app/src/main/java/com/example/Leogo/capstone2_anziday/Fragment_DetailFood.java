package com.example.Leogo.capstone2_anziday;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Leogo.capstone2_anziday.Models.user;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Fragment_DetailFood extends Fragment {
    private ImageView imageView_foodDetail;
    private TextView textView_foodNameDetail;
    private TextView textView_RatingDetail,textView_decription;
    private ArrayList<String> list;
    private Button btn_Raiting;
    private RatingBar ratingBar;
    private MainActivity mainActivity;
    private FirebaseFirestore db;
    private User user;
    private String id ="";
    Intent intent;



    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_food, container, false);
        imageView_foodDetail = view.findViewById(R.id.imageView_foodDetail);
        textView_foodNameDetail = view.findViewById(R.id.textView_foodNameDetail);
        textView_RatingDetail = view.findViewById(R.id.textView_RatingDetail);
        textView_decription = view.findViewById(R.id.textView_decription);
        btn_Raiting = view.findViewById(R.id.btn_Raiting);
        ratingBar = view.findViewById(R.id.ratingBar);
        Bundle bundle = getArguments();
        list = bundle.getStringArrayList("foodDetail");
        mainActivity = (MainActivity) getActivity();

        btn_Raiting.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                user = getArguments().getParcelable("objUser");

                if(user == null){
                    mainActivity.yeuCauLogin();
                }else {
                    intent = new Intent(getActivity(), MainActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("user", user);
                    intent.putExtras(bundle);
                    startActivityForResult(intent, Fragment_Profile.REQUEST_CODE);

                    db = FirebaseFirestore.getInstance();
                    db.collection("rating")
                            .whereEqualTo("user", user.getUserName()).whereEqualTo("foodID",list.get(4))
                            .get()
                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                    if (task.isSuccessful()) {
                                        if (!Objects.requireNonNull(task.getResult()).isEmpty()){
                                            for (QueryDocumentSnapshot document : task.getResult()) {
                                                updateRaitingContain(document.getId());
                                            }
                                        }
                                        else {
                                            updateRaitingNotContain();
                                        }

                                    }
                                }
                            });
                }
                Toast.makeText(getContext(),
                        String.valueOf(ratingBar.getRating()),
                        Toast.LENGTH_SHORT).show();

            }

        });
        return view;
    }

    public void updateRaitingContain(String id){
        db = FirebaseFirestore.getInstance();
        db.collection("rating").document(id)
                .update(
                        "pointRate", ratingBar.getRating()
                );
    }

    public void updateRaitingNotContain(){

        Map<String, Object> rating1 = new HashMap<>();
        rating1.put("user", user.getUserName());
        rating1.put("foodID", list.get(4));
        rating1.put("pointRate", ratingBar.getRating());
        db.collection("rating").add(rating1);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onResume() {
        super.onResume();
        int imageId = this.getMipmapResIdByName(list.get(1));

        imageView_foodDetail.setImageResource(imageId);
        textView_foodNameDetail.setText(list.get(0));
        textView_RatingDetail.setText(list.get(2));
        textView_decription.setText(list.get(3));
        textView_decription.setMovementMethod(new ScrollingMovementMethod());
        btn_Raiting.setText("Submit");

        /*if (id.equals("newField")){
            new Thread() {
                @Override
                public void run() {
                    try {
                        this.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Toast.makeText(getContext(),
                                "newField",
                                Toast.LENGTH_SHORT).show();
                    }
                    updateRaitingNotContain();
                }
            }.start();
        }else if (!id.equals("")){
            new Thread() {
                @Override
                public void run() {
                    try {
                        this.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    updateRaitingContain(id);
                    Toast.makeText(getContext(),
                            "null",
                            Toast.LENGTH_SHORT).show();
                }
            }.start();
        }else
            Toast.makeText(getContext(),
                    "không có dữ liệu",
                    Toast.LENGTH_SHORT).show();*/
    }

    // Tìm ID của Image ứng với tên của ảnh (Trong thư mục mipmap).
    public int getMipmapResIdByName(String resName) {
        String pkgName = getActivity().getApplicationContext().getPackageName();

        // Trả về 0 nếu không tìm thấy.
        int resID = this.getActivity().getResources().getIdentifier("" + resName, "drawable", pkgName);
        Log.i("CustomGridView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }
}
