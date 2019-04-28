package com.example.Leogo.capstone2_anziday;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Fragment_Detail_Profile extends Fragment {

    Button btnLogout,btnUpdate;
    TextView txtAddress, txtUserName,txtDiung,txtIllness,txtGroupPerson,txtFullname ;
    User user;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String USERNAME_KEY = "user";
    String PASS_KEY = "pass";
    String userName,pass,name,location,illness,diung,groupPerson;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_detail_profile,container,false);

        //anh xa
        txtUserName = (TextView) view.findViewById(R.id.txtUserName);
        txtAddress = (TextView) view.findViewById(R.id.txtAddress);
        txtFullname = (TextView) view.findViewById(R.id.txtName);
        txtDiung = (TextView) view.findViewById(R.id.txtDiUng);
        txtIllness = (TextView) view.findViewById(R.id.txtBenhAn);
        txtGroupPerson = (TextView) view.findViewById(R.id.txtNhomnguoi);

        btnLogout = (Button) view.findViewById(R.id.btnLogout);
        btnUpdate = (Button) view.findViewById(R.id.btnUpdate);


        final Bundle bundle = getArguments();
        //Kiểm tra user từ fragment_profile gửi qua có hay không
        if(bundle != null){
            user = bundle.getParcelable("user");
            userName = user.getUserName();
            pass = user.getPassWord();
            name = user.getFullName();
            location = user.getAddress();
            illness = user.getIllness();
            diung = user.getAllergy();
            groupPerson = user.getGroupPerson();
            setData();
        }else{
            sharedPreferences = getActivity().getSharedPreferences("login",getContext().MODE_PRIVATE);
            userName = sharedPreferences.getString(USERNAME_KEY,"");
            pass = sharedPreferences.getString(PASS_KEY,"");
        }
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getActivity().getSharedPreferences("login",getContext().MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Intent intent = new Intent(getActivity(),MainActivity.class);
                getActivity().startActivity(intent);
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Gửi qua activity update
                Bundle bundle = new Bundle();
                bundle.putParcelable("UpdateAcc",user);
                Intent intent = new Intent(getActivity(),UpdateUserActivity.class);
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
            }
        });
        return view;
    }
    public void setData(){
        txtUserName.setText(userName);
        txtFullname.setText(name);
        txtIllness.setText(illness);
        txtDiung.setText(diung);
        txtGroupPerson.setText(groupPerson);
        txtAddress.setText(location);
    }

    //check user từ database nếu có thì giữ login không có thì out login
}
