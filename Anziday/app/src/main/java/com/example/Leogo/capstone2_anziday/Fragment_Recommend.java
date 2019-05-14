package com.example.Leogo.capstone2_anziday;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.Leogo.capstone2_anziday.Adapter.FoodRecyclerViewAdapter;
import com.example.Leogo.capstone2_anziday.Adapter.FoodRecyclerViewImageAdapter;
import com.example.Leogo.capstone2_anziday.Models.food;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Fragment_Recommend extends Fragment {
    private final String TAG = "CHECK";
    private ArrayList<food> listSang;
    private ArrayList<food> listFullData;
    private ArrayList<food> listTrua;
    private ArrayList<food> listToi;
    private RecyclerView recyclerView;
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    ViewGroup.LayoutParams params;
    ViewGroup.LayoutParams params1;
    ViewGroup.LayoutParams params2;
    FoodRecyclerViewImageAdapter foodRecyclerViewImageAdapter;
    FoodRecyclerViewAdapter foodRecyclerViewAdapter;
    FoodRecyclerViewAdapter foodRecyclerViewAdapter1;
    FoodRecyclerViewAdapter foodRecyclerViewAdapter2;

    private TextView textView;
    private TextView textView1;
    private TextView textView2;

    private FirebaseFirestore db;
    private MainActivity myContext;


    @Override
    public void onAttach(Context context) {
        myContext = (MainActivity) context;
        super.onAttach(context);
    }

    private int position;

    //Lưu Fragment
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        ///Save the fragment's instance
    }

    Bundle saved;

    //Restore Fragment
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        saved = savedInstanceState;

    }

    public static Fragment_Home newInstance() {
        Fragment_Home myFragment = new Fragment_Home();
        return myFragment;
    }


    private Map<String, Double> mapRating;

    public void getListRating() {
        mapRating = new HashMap<>();
        db = FirebaseFirestore.getInstance();
        db.collection("rating")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                if (mapRating.get(document.getData().get("foodID").toString()) == null) {
                                    mapRating.put(document.getData().get("foodID").toString(),
                                            Double.parseDouble(document.getData().get("pointRate").toString()));
                                } else {
                                    DecimalFormat df = new DecimalFormat("#,0");
                                    double value = (mapRating.get(document.getData().get("foodID").toString()) +
                                            Double.parseDouble(document.getData().get("pointRate").toString())) / 2;
                                    value = Double.parseDouble(df.format(value));
                                    mapRating.replace(document.getData().get("foodID").toString(), value);
                                }

                                //Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
    }


    public void getData1() {
        db = FirebaseFirestore.getInstance();
        db.collection("foods")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            if (myContext.edtSearchSubNav.getText() == null) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    String decription = document.getData().get("decription").toString();
                                    ArrayList<String> formatly = (ArrayList) document.getData().get("formatly");
                                    ArrayList<String> illness = (ArrayList) document.getData().get("illness");
                                    String image = document.getData().get("image").toString();
                                    String link = document.getData().get("link").toString();
                                    ArrayList<String> material = (ArrayList) document.getData().get("material");
                                    String nameFood = document.getData().get("nameFood").toString();

                                    ArrayList<String> region = (ArrayList) document.getData().get("region");

                                    ArrayList<String> session = (ArrayList) document.getData().get("session");
                                    double rating;
                                    if (mapRating.get(document.getId()) != null){
                                        rating = mapRating.get(document.getId());
                                    }
                                    else rating = 0.0;

                                    food food = new food(document.getId(),decription, formatly, illness, image, link, material, nameFood, rating, region, session);

                                    Log.d(TAG, document.getId() + " => " + document.getData());

                                    try {
                                        for (String x : formatly) {
                                            if (x.equals("Điểm tâm") || x.equals("Tráng miệng")) {
                                                listSang.add(food);
                                            }
                                            if (x.equals("Ăn trưa") || x.equals("Tráng miệng")) {
                                                listTrua.add(food);
                                            }
                                            if (x.equals("Ăn tối") || x.toLowerCase().equals("Tráng miệng")) {
                                                listToi.add(food);
                                            }
                                        }

                                    } catch (Exception ex) {
                                        Log.d("Error GetList", ex.getMessage());
                                    }

                                }
                            } else {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    if (document.getData().get("nameFood").toString().toLowerCase().contains(myContext.edtSearchSubNav.getText())) {
                                        String decription = document.getData().get("decription").toString();
                                        ArrayList<String> formatly = (ArrayList) document.getData().get("formatly");
                                        ArrayList<String> illness = (ArrayList) document.getData().get("illness");
                                        String image = document.getData().get("image").toString();
                                        String link = document.getData().get("link").toString();
                                        ArrayList<String> material = (ArrayList) document.getData().get("material");
                                        String nameFood = document.getData().get("nameFood").toString();

                                        ArrayList<String> region = (ArrayList) document.getData().get("region");

                                        ArrayList<String> session = (ArrayList) document.getData().get("session");
                                        double rating;
                                        if (mapRating.get(document.getId()) != null){
                                            rating = mapRating.get(document.getId());
                                        }
                                        else rating = 0.0;


                                        food food = new food(document.getId(),decription, formatly, illness, image, link, material, nameFood, rating, region, session);
                                        listFullData.add(food);
                                        Log.d(TAG, document.getId() + " => " + document.getData());

                                        try {
                                            for (String x : formatly) {
                                                if (x.equals("Điểm tâm") || x.equals("Tráng miệng")) {
                                                    listSang.add(food);
                                                }
                                                if (x.equals("Ăn trưa") || x.equals("Tráng miệng")) {
                                                    listTrua.add(food);
                                                }
                                                if (x.equals("Ăn tối") || x.equals("Tráng miệng")) {
                                                    listToi.add(food);
                                                }
                                            }

                                        } catch (Exception ex) {
                                            Log.d("Error GetList", ex.getMessage());
                                        }


                                    }
                                }
                            }

                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        //insertDataFood();
        getListRating();
        super.onCreate(savedInstanceState);
    }


    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        listFullData = new ArrayList<>();
        listSang = new ArrayList<>();
        listTrua = new ArrayList<>();
        listToi = new ArrayList<>();
        myContext = (MainActivity)getContext();
        //insertDataFood();
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);

        textView = view.findViewById(R.id.textView);
        textView1 = view.findViewById(R.id.textView1);
        textView2 = view.findViewById(R.id.textView2);

        textView.setText("Buổi Sáng");
        textView1.setText("Buổi Trưa");
        textView2.setText("Buổi Tối");

        recyclerView = view.findViewById(R.id.fragment_container_recyclerView);
        params = recyclerView.getLayoutParams();
        //paramBuoiSang = txtBuoiSang.getLayoutParams();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mLayoutManager.scrollToPosition(0);//Thiết lập phần tử mặc định nếu muốn
        recyclerView.setHasFixedSize(true);//Mượt hơn nếu k cập nhập gì
        recyclerView.setLayoutManager(mLayoutManager);


        recyclerView1 = view.findViewById(R.id.fragment_container_recyclerView1);
        params1 = recyclerView1.getLayoutParams();
        //paramBuoiTrua = txtBuoiTrua.getLayoutParams();
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mLayoutManager.scrollToPosition(0);//Thiết lập phần tử mặc định nếu muốn
        recyclerView1.setHasFixedSize(true);//Mượt hơn nếu k cập nhập gì
        recyclerView1.setLayoutManager(mLayoutManager1);

        recyclerView2 = view.findViewById(R.id.fragment_container_recyclerView2);
        params2 = recyclerView2.getLayoutParams();
        //paramBuoiTrua = txtBuoiTrua.getLayoutParams();
        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        mLayoutManager.scrollToPosition(0);//Thiết lập phần tử mặc định nếu muốn
        recyclerView2.setHasFixedSize(true);//Mượt hơn nếu k cập nhập gì
        recyclerView2.setLayoutManager(mLayoutManager2);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        new Thread() {
            @Override
            public void run() {
                try {
                    this.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getData1();
            }
        }.start();



        foodRecyclerViewAdapter = new FoodRecyclerViewAdapter(getContext(), listSang, listFullData);
        foodRecyclerViewAdapter1 = new FoodRecyclerViewAdapter(getContext(), listTrua, listFullData);
        foodRecyclerViewAdapter2 = new FoodRecyclerViewAdapter(getContext(), listToi, listFullData);
        recyclerView.setAdapter(foodRecyclerViewAdapter);
        recyclerView1.setAdapter(foodRecyclerViewAdapter1);
        recyclerView2.setAdapter(foodRecyclerViewAdapter2);
    }
}
