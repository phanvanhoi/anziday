package com.example.Leogo.capstone2_anziday.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Leogo.capstone2_anziday.MainActivity;
import com.example.Leogo.capstone2_anziday.Models.food;
import com.example.Leogo.capstone2_anziday.R;

import java.util.List;

public class FoodRecyclerViewAdapter extends RecyclerView.Adapter<FoodRecyclerViewAdapter.ViewHolder> {

    /**
     * Lớp nắm giữ cấu trúc view
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private View itemview;
        private Button detail_button;
        private ImageView imageView_food;
        private TextView textView_foodName;
        RatingBar ratingBar;

        ViewHolder(View itemView) {
            super(itemView);
            detail_button = itemView.findViewById(R.id.detail_button);
            imageView_food = itemView.findViewById(R.id.imageView_food);
            textView_foodName = itemView.findViewById(R.id.textView_foodName);
            ratingBar = itemView.findViewById(R.id.ratingBar);

            //Xử lý khi nút Chi tiết được bấm
            detail_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), " Demo function", Toast.LENGTH_SHORT).show();
                }
            });
            itemview = itemView;
        }
    }


    //Dữ liệu hiện thị là danh sách sinh viên
    private List<food> mfood;
    // Lưu Context để dễ dàng truy cập
    private Context mContext;
    private List<food> foodListFullData;

    public FoodRecyclerViewAdapter(){

    }

    public FoodRecyclerViewAdapter(Context mContext, List<food> _food, List<food> foodListFullData) {
        this.mContext = mContext;
        this.mfood = _food;
        this.foodListFullData = foodListFullData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mContext = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);

        // Nạp layout cho View biểu diễn phần tử
        View foodView = inflater.inflate(R.layout.item_food_cycle,
                viewGroup, false);

        return new ViewHolder(foodView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final food getFoodIndex = mfood.get(i);
        viewHolder.textView_foodName.setText(getFoodIndex.getNameFood());
        viewHolder.detail_button.setText("Detail");
        viewHolder.ratingBar.setRating(Float.parseFloat(getFoodIndex.getRating()+""));
        viewHolder.ratingBar.setIsIndicator(true);
        int imageId = mContext.getResources().getIdentifier( ""+getFoodIndex.getImage() , "drawable", mContext.getApplicationContext().getPackageName());
        viewHolder.imageView_food.setImageResource(imageId);

        viewHolder.itemview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(), getFoodIndex.getNameFood(), Toast.LENGTH_SHORT).show();
                MainActivity mainActivity = (MainActivity) mContext;
                mainActivity.detailFood(getFoodFullData(getFoodIndex.getNameFood()));
            }
        });
    }

    private food getFoodFullData(String nameFood){
        food food = new food();
        for(food food1: foodListFullData){
            if (food1.getNameFood().equals(nameFood)){
                food = food1;
                break;
            }
        }
        return food;
    }

    @Override
    public int getItemCount() {
        return mfood.size();
    }


}
