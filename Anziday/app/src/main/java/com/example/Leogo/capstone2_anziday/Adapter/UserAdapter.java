package com.example.Leogo.capstone2_anziday.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.Leogo.capstone2_anziday.Models.user;
import com.example.Leogo.capstone2_anziday.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends ArrayAdapter<user> {
    private Activity context;
    private List<user> listUser;
    GridView gridView;

    private TextView textView;
    private DatabaseReference myRef;
    private ArrayAdapter<String> adapter;
    private final String TAG = "CHECK";
    private ArrayList<String> listAdap;
    public UserAdapter(Activity context, List<user> listUser){
        super(context, R.layout.fragment_home, listUser);
        this.context = context;
        this.listUser = listUser;
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_home,null, true);
        //gridView = view.findViewById(R.id.gridView_listFood);
        user user = listUser.get(position);
        getDataFirebase();
        return view;

    }

    public void getDataFirebase(){
        listAdap = new ArrayList<>();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("user");
        textView.setText("da vao");
        listAdap.add("okok");
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    textView.setText("ok ");
                    for (DataSnapshot data : dataSnapshot.getChildren()){
                        listAdap.add(data.child("fullName").getValue().toString());
                        listAdap.add(data.child("passWord").getValue().toString());
                        listAdap.add(data.child("userName").getValue().toString());
                    }
                }
                else {
                    textView.setText("Loi roi");
                }
                listAdap.add("ok ổn rồi");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_list_item_1,listAdap);
        gridView.setAdapter(adapter);
    }
}
