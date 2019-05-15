package com.example.Leogo.capstone2_anziday;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.Matrix2f;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.Leogo.capstone2_anziday.Adapter.FoodRecyclerViewAdapter;
import com.example.Leogo.capstone2_anziday.Models.Rating;
import com.example.Leogo.capstone2_anziday.Models.food;
import com.example.Leogo.capstone2_anziday.Models.user;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;

import java.nio.DoubleBuffer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public class Fragment_Suggests extends Fragment {


    public Fragment_Suggests() {
        // Required empty public constructor
    }

    FirebaseFirestore db;
    Bundle bundle;

    // TODO: Rename and change types and number of parameters
    public static Fragment_Suggests newInstance() {
        Fragment_Suggests fragment = new Fragment_Suggests();
        return fragment;
    }

    private DatabaseReference mDatabase;
    private List<User> userList = null;
    private List<Rating> ratingList;

    private List<User> getAllUserList;
    private List<food> getAllFoodList;
    private ArrayList<food> listFoods;
    private List<List<Double>> listRoot;
    List<Double> giatriTB;
    private int index;
    private String matrix2d[][];
    double[][] arrRangting;
    PearsonsCorrelation pearsonsCorrelation;
    private final String TAG = "CHECK";
    private ArrayList<food> listSang;
    private ArrayList<food> listTrua;
    private ArrayList<food> listToi;
    private User user;

    private RecyclerView recyclerView;
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    ViewGroup.LayoutParams params;
    ViewGroup.LayoutParams params1;
    ViewGroup.LayoutParams params2;
    FoodRecyclerViewAdapter foodRecyclerViewAdapter;
    FoodRecyclerViewAdapter foodRecyclerViewAdapter1;
    FoodRecyclerViewAdapter foodRecyclerViewAdapter2;

    private TextView textView;
    private TextView textView1;
    private TextView textView2;
    private ArrayList<food> listFoodTest;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        userList = new ArrayList<>();
        giatriTB = new ArrayList<>();
        ratingList = new ArrayList<>();
        listRoot = new ArrayList<>();
        pearsonsCorrelation = new PearsonsCorrelation();
        db = FirebaseFirestore.getInstance();
        getAllFoods();
        getTableRating();
        getAllFromFireStore(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        User user = new User();
                        user.setUserName(document.getId().toString());
                        user.setFullName(document.get("fullName").toString());
                        user.setDateBirth(document.get("dateBirth").toString());
                        user.setIllness(document.get("illness").toString());
                        user.setGroupPerson(document.get("groupPerson").toString());
                        user.setAllergy(document.get("allergy").toString());
                        user.setAddress(document.get("address").toString());
                        userList.add(user);
                        Log.d("yes", document.getId() + " => " + document.get("fullName"));
                        Log.d("vluemao", userList.toString());
                    }

                } else {
                    Log.d("no", "Error getting documents: ", task.getException());
                }
            }
        });
        getListRating();
        //User user = bundle.getParcelable("user");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bundle = getArguments();
        listFoods = new ArrayList<>();
        listSang = new ArrayList<>();
        listTrua = new ArrayList<>();
        listToi = new ArrayList<>();
        listFoodTest = new ArrayList<>();
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


        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                      /*  if(userList.get(0).getUserName().equals("duc123")) {
                            User user = userList.get(0);
                        }
                        Log.d("boolean",userList.get(1).getUserName());*/
                    }
                });
                if (bundle != null) {
                    user = bundle.getParcelable("user");
                    createMatrix(user);
                    getRatingInTableRating();
                    getArrRantingInMatrix();
                    outArr(matrix2d);
                    getArrRanting();
                    outDouble(arrRangting);
                    repalceValueNullInItem();
                    getAverageOfUser();
                    StandardizeData();
                    repalceValue0InMatrix();
                    showEvaluate(listRoot);
                    SimpleCC(USERKNN());
                    showEvaluate(evaluateItem());
                    returnArrRantingItemByUser();
                    outArr(matrix2d);
                    for (Map.Entry<String, Double> doubleEntry : sortgetDataItem(user).entrySet()) {
                        Log.d("IDFood: ", doubleEntry.getKey() + doubleEntry.getValue());

                    }
                    for (String s : getListFoodRating(user)) {
                        Log.d("getIDfood: ", s);
                    }
                }
            }
        }.start();
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


        foodRecyclerViewAdapter = new FoodRecyclerViewAdapter(getContext(), listSang, listSang);
        foodRecyclerViewAdapter1 = new FoodRecyclerViewAdapter(getContext(), listTrua, listTrua);
        foodRecyclerViewAdapter2 = new FoodRecyclerViewAdapter(getContext(), listToi, listToi);
        recyclerView.setAdapter(foodRecyclerViewAdapter);
        recyclerView1.setAdapter(foodRecyclerViewAdapter1);
        recyclerView2.setAdapter(foodRecyclerViewAdapter2);
        Log.d("CheckListRecommend", listFoodTest.size() + "");
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
                            //Log.d(TAG, "Error getting documents: ", task.getException());
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
                            for (Map.Entry<String, Double> x1 : sortgetDataItem(user).entrySet()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    if (document.getId().equals(x1.getKey())) {
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

                                        food food = new food(document.getId(), decription, formatly, illness, image, link, material, nameFood, rating, region, session);

                                        Log.d("CaNgay", x1.getKey() + rating);
                                        try {
                                            for (String x : formatly) {
                                                if (x.equals("Điểm tâm") || x.equals("Tráng miệng")) {
                                                    listSang.add(food);
                                                    Log.d("BuoiSang", x1.getKey() + rating);
                                                }
                                                if (x.equals("Ăn trưa") || x.equals("Tráng miệng")) {
                                                    listTrua.add(food);
                                                    Log.d("BuoiTrua", x1.getKey() + rating);
                                                }
                                                if (x.equals("Ăn tối") || x.equals("Tráng miệng")) {
                                                    listToi.add(food);
                                                    Log.d("BuoiToi", x1.getKey() + rating);
                                                }
                                            }

                                        } catch (Exception ex) {
                                            Log.d("Error GetList", ex.getMessage());
                                        }
                                        listFoodTest.add(food);
                                    }
                                }
                            }

                            Log.d("CheckListRecommend", listFoodTest.size() + "");
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }


    private void createMatrix(User user) {
        getAllUserList = this.getAllUser(user);
        getAllFoodList = this.getListFoodOfAllUser(user);
        matrix2d = new String[getAllUserList.size() + 1][getAllFoodList.size() + 1];
        for (int i = 0; i < matrix2d.length - 1; i++) {
            matrix2d[i + 1][0] = getAllUserList.get(i).getUserName();
        }
        for (int i = 0; i < matrix2d[0].length - 1; i++) {
            matrix2d[0][i + 1] = getAllFoodList.get(i).getFoodID();
        }
        for (int i = 1; i < matrix2d.length; i++) {
            for (int j = 1; j < matrix2d[0].length; j++) {
                matrix2d[i][j] = "0";
            }
        }
    }

    private void getRatingInTableRating() {
        List<Rating> ratings = new ArrayList<>();
        for (User user : getAllUserList) {
            for (Rating rating : ratingList) {
                if (rating.getUser().equals(user.getUserName())) {
                    ratings.add(rating);
                }
            }
        }
        ratingList = ratings;
    }

    public String[][] getArrRantingInMatrix() {

        for (Rating ranting : ratingList) {
            int indexItem = 1;
            int indexUser = 1;

            System.out.println(ranting.getUser());
            System.out.println(ranting.getFoodID());
            for (int i = 0; i < getAllUserList.size() - 1; i++) {
                String value = ranting.getUser();
                if (!matrix2d[i + 1][0].equals(ranting.getUser())) {
                    indexUser++;
                } else
                    break;
            }
            for (int i = 0; i < getAllFoodList.size() - 1; i++) {
                if (!matrix2d[0][i + 1].equals(ranting.getFoodID())) {
                    indexItem++;
                } else
                    break;
            }
            matrix2d[indexUser][indexItem] = String.valueOf(ranting.getPointRate());
            System.out.println(matrix2d[indexUser][indexItem]);

        }
        return matrix2d;
    }

    public double[][] getArrRanting() {
        arrRangting = new double[getAllUserList.size()][getAllFoodList.size()];
        for (int i = 0; i < arrRangting.length; i++) {
            for (int j = 0; j < arrRangting[i].length; j++) {
                arrRangting[i][j] = Double.valueOf(matrix2d[i + 1][j + 1]);
            }
        }
        return arrRangting;
    }

    private void repalceValueNullInItem() {
        List<Double> listAssign;
        for (double[] array : arrRangting) {
            listAssign = new ArrayList<>();
            for (double value : array) {
                listAssign.add(value);
            }
            for (Double double1 : listAssign) {
                if (double1 == 0)
                    listAssign.set(listAssign.indexOf(double1), null);
            }
            listRoot.add(listAssign);
        }
    }

    private void getAverageOfUser() {
        for (List<Double> getElement : this.listRoot) {
            int count = 0;
            double Sum = 0.0;
            for (Double getValue : getElement) {
                if (getValue != null) {
                    Sum += getValue;
                    count++;
                }
            }
            giatriTB.add((double) (Sum / count));
        }
    }

    private void StandardizeData() {
        for (List<Double> ListParent : this.listRoot) {
            for (Double valueElement : ListParent) {
                if (valueElement != null) {
                    int index = ListParent.indexOf(valueElement);
                    ListParent.set(index, valueElement - giatriTB.get(this.listRoot.indexOf(ListParent)));
                }
            }
        }
    }

    private void repalceValue0InMatrix() {
        for (List<Double> ListParent : this.listRoot) {
            for (Double valueElement : ListParent) {
                if (valueElement == null) {
                    int index = ListParent.indexOf(valueElement);
                    ListParent.set(index, 0.0);
                }
            }
        }
    }

    private List<List<Double>> USERKNN() {
        List<Double> listCorrelation = null;
        List<List<Double>> listNewValue = new ArrayList<List<Double>>();
        for (List<Double> getListU : this.listRoot) {
            double r = 0;
            double getArrU1[] = new double[getListU.size()];
            for (int i = 0; i < getListU.size(); i++) {
                getArrU1[i] = getListU.get(i);
            }
            listCorrelation = new ArrayList<Double>();
            for (List<Double> listPartInList : this.listRoot) {
                double getArrU2[] = new double[listPartInList.size()];
                for (int i = 0; i < listPartInList.size(); i++) {
                    getArrU2[i] = listPartInList.get(i);
                }
                r = pearsonsCorrelation.correlation(getArrU1, getArrU2);
                listCorrelation.add(r);
            }
            listNewValue.add(listCorrelation);
        }
        return listNewValue;
    }

    private void SimpleCC(List<List<Double>> listes) {
        System.out.println("He so tuong quan: ");
        for (int i = 0; i < listes.size(); i++) {
            for (int j = 0; j < listes.get(0).size(); j++) {
                System.out.format("%10.5" + "f", listes.get(i).get(j));
            }
            System.out.println();
        }
    }

    private List<List<Double>> evaluateItem() {
        List<List<Double>> listValue = this.USERKNN();
        List<List<Double>> listNewValue = new ArrayList<List<Double>>();

        List<Double> listEvaluateofUser = null;
        int indexInEleCorrespond = 0;
        // vi tri nguoi dung u de danh gia len cac san pham con thieu
        int index = 0;
        for (List<Double> getElement : listValue) {
            listEvaluateofUser = new ArrayList<Double>();
            indexInEleCorrespond = 0;
            for (double getvalueU : this.listRoot.get(index)) {
                double Sx = 0;
                double Sy = 0;
                double S = 0;
                if (getvalueU == 0) {
                    int indexEleCorrespond = 0;
                    for (double valueCorrespond : getElement) {
                        if (indexEleCorrespond != index) {
                            if (valueCorrespond >= 0.4) {
                                double valueItemCorrespond = (double) this.listRoot.get(indexEleCorrespond)
                                        .get(indexInEleCorrespond);
                                double giatriTBItem = (double) giatriTB.get(indexEleCorrespond);
                                Sx = Sx + valueCorrespond * (valueItemCorrespond == 0 ? 0 : valueItemCorrespond);
                                Sy = Sy + valueCorrespond;
                            }
                        }
                        indexEleCorrespond++;
                    }
                    S = (double) (giatriTB.get(index) + (float) (Sx / Sy));
                } else {
                    S = (double) getvalueU + giatriTB.get(index);
                }
                listEvaluateofUser.add(S);
                indexInEleCorrespond++;
            }
            listNewValue.add(listEvaluateofUser);
            index++;
        }
        return listNewValue;
    }

    private void showEvaluate(List<List<Double>> listes) {
        for (int i = 0; i < listes.size(); i++) {
            for (int j = 0; j < listes.get(0).size(); j++) {
                System.out.format("%10.2" + "f", listes.get(i).get(j));
            }
            System.out.println();
        }
    }

    public String[][] returnArrRantingItemByUser() {
        DecimalFormat df2 = new DecimalFormat("#.##");
        List<List<Double>> listDanhgia = this.evaluateItem();
        for (int i = 1; i < getAllUserList.size() + 1; i++) {
            for (int j = 1; j < getAllFoodList.size() + 1; j++) {
                matrix2d[i][j] = df2.format(listDanhgia.get(i - 1).get(j - 1));
            }
        }
        return matrix2d;
    }

    public Map<String, Double> getDataItem(User user) {
        int index = 1;
        Map<String, Double> map = new HashMap<String, Double>();
        for (int i = 1; i < matrix2d.length; i++) {
            if (matrix2d[i][0].equals(user.getUserName())) break;
            index++;
        }
        for (int i = 1; i < matrix2d[0].length; i++) {
            map.put(matrix2d[0][i], Double.valueOf(matrix2d[index][i]));
        }
        return map;
    }

    public Map<String, Double> sortgetDataItem(User user) {
        List<Map.Entry<String, Double>> list =
                new LinkedList<>(this.getDataItem(user).entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return (o2.getValue()).compareTo(o1.getValue());

            }
        });
        Map<String, Double> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Double> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    public List<String> getListFoodRating(User user) {
        List<String> strings = new ArrayList<>();
        for (Map.Entry<String, Double> doubleEntry : this.sortgetDataItem(user).entrySet()) {
            strings.add(doubleEntry.getKey());
        }
        return strings;
    }

    private void outDouble(double[][] arr) {
        // TODO Auto-generated method stub
        System.out.println("Mảng vừa nhập: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.format("%8s\t", arr[i][j]);
            }
            System.out.println();
        }
    }

    public void outArr(String[][] arr) {
        System.out.println("Mảng vừa nhập: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.format("         %17s\t", arr[i][j]);
            }
            System.out.println();
        }
    }

    public void getAllFromFireStore(OnCompleteListener<QuerySnapshot> listener) {
        db.collection("users").get().addOnCompleteListener(listener);
    }

    public void getAllFoods() {
        db.collection("foods")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                food Objfood = new food();
                                Objfood.setFoodID(document.getId());
                                Objfood.setDecription(document.get("decription").toString());
                                Objfood.setFormatly((ArrayList) document.get("formatly"));
                                Objfood.setIllness((ArrayList) document.get("illness"));
                                Objfood.setImage(document.get("image").toString());
                                Objfood.setLink(document.get("link").toString());
                                Objfood.setMaterial((ArrayList) document.get("material"));
                                Objfood.setNameFood(document.get("nameFood").toString());
                                Objfood.setRegion((ArrayList) document.get("region"));
                                Objfood.setSession((ArrayList) document.get("session"));
                                listFoods.add(Objfood);
                                Log.d("illness", document.getId() + " => " + document.getData().get("illness") + "\n" + listFoods.toString());
                            }
                        } else {
                            Log.d("no", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }


    //lay tat ca food phu hoc voi nguoi dung
    public List<food> getListFoodOfUser(User user) {
        List<food> listFood = new ArrayList<>();
        String[] illness = user.getIllness().split(",");
        for (food foods : this.listFoods) {
            int count = 0;
            for (String value : illness) {
                if (!foods.getIllness().contains(value))
                    count++;
                else
                    break;
            }
            if (count != illness.length)
                listFood.add(foods);
        }
        return listFood;
    }

    private User checkedUser(String[] illness, User user) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String string : user.getIllness().split(",")) {
            map.put(string, 1);
        }
        for (String value : illness) {
            if (map.containsKey(value)) {
                return user;
            }
        }
        return null;
    }

    private List<User> getAllUser(User user) {
        List<User> listusers = new ArrayList<>();
        for (User valueUser : this.userList) {
            String group[] = user.getIllness().split(",");
            User userofList = this.checkedUser(group, valueUser);
            if (userofList != null)
                listusers.add(userofList);
        }
        return listusers;
    }

    private List<food> getListFoodOfAllUser(User user) {
        List<food> foodList = new ArrayList<>();
        Map<String, food> listFoodMap = new HashMap<>();
        for (food valuefood : this.getListFoodOfUser(user)) {
            listFoodMap.put(valuefood.getFoodID(), valuefood);
        }
        List<User> userList = this.getAllUser(user);
        for (User user1 : userList) {
            if (!user.getUserName().equals(user1.getUserName())) {
                List<food> foodUser = this.getListFoodOfUser(user1);
                for (food foods : foodUser) {
                    if (!listFoodMap.containsKey(foods.getFoodID()))
                        listFoodMap.put(foods.getFoodID(), foods);
                }
            }
        }
        for (Map.Entry<String, food> stringfoodEntry : listFoodMap.entrySet()) {
            foodList.add(stringfoodEntry.getValue());
        }
        return foodList;
    }

    public void getTableRating() {
        db.collection("rating")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Rating rating = new Rating();
                                rating.setPointRate(Double.parseDouble(document.get("pointRate").toString()));
                                rating.setFoodID(document.get("foodID").toString());
                                rating.setUser(document.get("user").toString());
                                ratingList.add(rating);
                                Log.d("rating", document.get("pointRate") + " => " + "\n" + ratingList.toString());
                            }
                        } else {
                            Log.d("no", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }
}
