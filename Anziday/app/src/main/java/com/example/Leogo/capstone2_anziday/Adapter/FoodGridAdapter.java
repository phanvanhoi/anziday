package com.example.Leogo.capstone2_anziday.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Leogo.capstone2_anziday.Models.food;
import com.example.Leogo.capstone2_anziday.R;

import java.util.List;

public class FoodGridAdapter extends BaseAdapter {
    private List<food> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public FoodGridAdapter(Context aContext,  List<food> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        ImageView imageView_food;
        TextView textView_foodName;
        TextView textView_Rating;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_food, null);
            holder = new ViewHolder();
            holder.imageView_food = convertView.findViewById(R.id.imageView_food);
            holder.textView_foodName =  convertView.findViewById(R.id.textView_foodName);
            holder.textView_Rating =  convertView.findViewById(R.id.textView_Rating);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        food food = this.listData.get(position);
        holder.textView_foodName.setText(food.getNameFood());
        holder.textView_Rating.setText("Rating: " + food.getRating());

        int imageId = this.getMipmapResIdByName(food.getImage());

        holder.imageView_food.setImageResource(imageId);

        return convertView;
    }

    // Tìm ID của Image ứng với tên của ảnh (Trong thư mục mipmap).
    public int getMipmapResIdByName(String resName)  {

        // Trả về 0 nếu không tìm thấy.
        int resID = this.context.getResources().getIdentifier( ""+resName , "drawable", context.getApplicationContext().getPackageName());

        Log.i("CustomGridView", "Res Name: "+ resName +"==> Res ID = "+ resID);
        return resID;
    }


}
