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
import android.view.ViewGroup.LayoutParams;

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

public class Fragment_Home extends Fragment {
    private final String TAG = "CHECK";
    private ArrayList<food> listAdap;
    private ArrayList<food> listFullData;
    private ArrayList<food> listSang;
    private ArrayList<food> listTrua;
    private ArrayList<food> listToi;
    private RecyclerView recyclerView;
    private RecyclerView recyclerView1;
    LayoutParams params;
    LayoutParams params1;
    FoodRecyclerViewImageAdapter foodRecyclerViewImageAdapter;
    FoodRecyclerViewAdapter foodRecyclerViewAdapter;

    private FirebaseFirestore db;
    private MainActivity myContext;
    Bundle bundle = null;

    public void insertDataFood() {
        db = FirebaseFirestore.getInstance();


        //-------------------------------------Start material------------------------------
        Map<String, Object> matirial = new HashMap<>();
        matirial.put("groupPerson", Arrays.asList("Tim mạch","Tiểu đường"));
        matirial.put("illness", Arrays.asList("","Gan Nhiễm Mỡ"));
        matirial.put("name","Mỡ heo");
        db.collection("matirial").document("idmatirial0").set(matirial);

        Map<String, Object> matirial1 = new HashMap<>();
        matirial1.put("groupPerson", Arrays.asList("Tim mạch","Tiểu đường"));
        matirial1.put("illness", Arrays.asList("","Bị Sởi"));
        matirial1.put("name","Gà ");
        db.collection("matirial").document("idmatirial1").set(matirial1);

        Map<String, Object> matirial2 = new HashMap<>();
        matirial2.put("groupPerson", Arrays.asList("Tim mạch","Tiểu đường"));
        matirial2.put("illness", Arrays.asList("Dị Ứng Da",""));
        matirial2.put("name","Phẩm Màu");
        db.collection("matirial").document("idmatirial2").set(matirial2);

        Map<String, Object> matirial3 = new HashMap<>();
        matirial3.put("groupPerson", Arrays.asList("Tim mạch","Tiểu đường"));
        matirial3.put("illness", Arrays.asList("Nứt Nẻ",""));
        matirial3.put("name","Bạc Hà ");
        db.collection("matirial").document("idmatirial3").set(matirial3);

        Map<String, Object> matirial4 = new HashMap<>();
        matirial4.put("groupPerson", Arrays.asList("Tim mạch","Tiểu đường"));
        matirial4.put("illness", Arrays.asList("Tim mạch","Tiểu đường"));
        matirial4.put("name","Đường ");
        db.collection("matirial").document("idmatirial4").set(matirial4);

        Map<String, Object> matirial5 = new HashMap<>();
        matirial5.put("groupPerson", Arrays.asList("Tim mạch",""));
        matirial5.put("illness", Arrays.asList("Béo Phì",""));
        matirial5.put("name","Cá Mè ");
        db.collection("matirial").document("idmatirial5").set(matirial5);

        Map<String, Object> matirial6 = new HashMap<>();
        matirial6.put("groupPerson", Arrays.asList("Tim mạch","Tiểu đường"));
        matirial6.put("illness", Arrays.asList("Tim mạch","Gan Nhiễm Mỡ"));
        matirial6.put("name","Thịt Chó");
        db.collection("matirial").document("idmatirial6").set(matirial6);

        Map<String, Object> matirial7 = new HashMap<>();
        matirial7.put("groupPerson", Arrays.asList("Tim mạch",""));
        matirial7.put("illness", Arrays.asList("Bệnh Sáng Khuẩn",""));
        matirial7.put("name","Huyết Heo");
        db.collection("matirial").document("idmatirial7").set(matirial7);

        Map<String, Object> matirial8 = new HashMap<>();
        matirial8.put("groupPerson", Arrays.asList("Tim mạch","Tiểu đường"));
        matirial8.put("illness", Arrays.asList("Béo Phì",""));
        matirial8.put("name","Cá Chim");
        db.collection("matirial").document("idmatirial8").set(matirial8);

        Map<String, Object> matirial9 = new HashMap<>();
        matirial9.put("groupPerson", Arrays.asList("Tim mạch","Tiểu đường"));
        matirial9.put("illness", Arrays.asList("Ho Lao",""));
        matirial9.put("name","Rau Cải Ngòng");
        db.collection("matirial").document("idmatirial9").set(matirial9);

        Map<String, Object> matirial10 = new HashMap<>();
        matirial10.put("groupPerson", Arrays.asList("Tim mạch","Tiểu đường"));
        matirial10.put("illness", Arrays.asList("","Hen xuyễn"));
        matirial10.put("name","Búp Xú ");
        db.collection("matirial").document("idmatirial10").set(matirial10);

        Map<String, Object> matirial11 = new HashMap<>();
        matirial11.put("groupPerson", Arrays.asList("Tim mạch","Tiểu đường"));
        matirial11.put("illness", Arrays.asList("","Béo Phì"));
        matirial11.put("name","Bào Ngư");
        db.collection("matirial").document("idmatirial11").set(matirial11);

        Map<String, Object> matirial12 = new HashMap<>();
        matirial12.put("groupPerson", Arrays.asList("Tim mạch","Tiểu đường"));
        matirial12.put("illness", Arrays.asList("","Tiểu Đường"));
        matirial12.put("name","Thit heo ");
        db.collection("matirial").document("idmatirial12").set(matirial12);

        Map<String, Object> matirial13 = new HashMap<>();
        matirial13.put("groupPerson", Arrays.asList("Tim mạch","Tiểu đường"));
        matirial13.put("illness", Arrays.asList("","Huyết Áp"));
        matirial13.put("name","Thit Bò ");
        db.collection("matirial").document("idmatirial13").set(matirial13);

        Map<String, Object> matirial14 = new HashMap<>();
        matirial14.put("groupPerson", Arrays.asList("Tim mạch","Tiểu đường"));
        matirial14.put("illness", Arrays.asList(" Tim Mạch",""));
        matirial14.put("name","Hat Lạc ");
        db.collection("matirial").document("idmatirial14").set(matirial14);

        Map<String, Object> matirial15 = new HashMap<>();
        matirial15.put("groupPerson", Arrays.asList("Tim mạch",""));
        matirial15.put("illness", Arrays.asList(" ","Sáng Khuẩn "));
        matirial15.put("name","Mía ");
        db.collection("matirial").document("idmatirial15").set(matirial15);

        Map<String, Object> matirial16 = new HashMap<>();
        matirial16.put("groupPerson", Arrays.asList("","Tiểu đường"));
        matirial16.put("illness", Arrays.asList("Đường Ruột "," "));
        matirial16.put("name","Chả Cá ");
        db.collection("matirial").document("idmatirial16").set(matirial16);

        Map<String, Object> matirial17 = new HashMap<>();
        matirial17.put("groupPerson", Arrays.asList("Tim mạch","Tiểu đường"));
        matirial17.put("illness", Arrays.asList("Tim Mạch"," "));
        matirial17.put("name","Hành Tây ");
        db.collection("matirial").document("idmatirial17").set(matirial17);

        Map<String, Object> matirial18 = new HashMap<>();
        matirial18.put("groupPerson", Arrays.asList("Tim mạch",""));
        matirial18.put("illness", Arrays.asList("Đâu Đầu"," "));
        matirial18.put("name","Nước Dừa ");
        db.collection("matirial").document("idmatirial18").set(matirial18);

        Map<String, Object> matirial19 = new HashMap<>();
        matirial19.put("groupPerson", Arrays.asList("","Tiểu đường"));
        matirial19.put("illness", Arrays.asList("Sáng Khuẩn"," "));
        matirial19.put("name","Lòng Heo ");
        db.collection("matirial").document("idmatirial19").set(matirial19);

        Map<String, Object> matirial20 = new HashMap<>();
        matirial20.put("groupPerson", Arrays.asList("Tim mạch","Tiểu đường"));
        matirial20.put("illness", Arrays.asList("Tim Mạch"," "));
        matirial20.put("name","Rau Ram ");
        db.collection("matirial").document("idmatirial20").set(matirial20);

        Map<String, Object> matirial21 = new HashMap<>();
        matirial21.put("groupPerson", Arrays.asList("Tim mạch",""));
        matirial21.put("illness", Arrays.asList("Lông Ben"," "));
        matirial21.put("name","Trứng Vịt Lộn ");
        db.collection("matirial").document("idmatirial21").set(matirial21);

        Map<String, Object> matirial22 = new HashMap<>();
        matirial22.put("groupPerson", Arrays.asList("Tim mạch",""));
        matirial22.put("illness", Arrays.asList("","Béo Phì "));
        matirial22.put("name","Kem ");
        db.collection("matirial").document("idmatirial22").set(matirial22);

        Map<String, Object> matirial23 = new HashMap<>();
        matirial23.put("groupPerson", Arrays.asList("Tim mạch",""));
        matirial23.put("illness", Arrays.asList(" Đau Bụng","Béo Phì"));
        matirial23.put("name"," sữa");
        db.collection("matirial").document("idmatirial23").set(matirial23);

        Map<String, Object> matirial24 = new HashMap<>();
        matirial24.put("groupPerson", Arrays.asList("Tim mạch",""));
        matirial24.put("illness", Arrays.asList(" Mỡ Nhiễm Máu","Beo Phì"));
        matirial24.put("name"," Bơ");
        db.collection("matirial").document("idmatirial24").set(matirial24);

        Map<String, Object> matirial25 = new HashMap<>();
        matirial25.put("groupPerson", Arrays.asList("Tim mạch",""));
        matirial25.put("illness", Arrays.asList("Sốt","Ho"));
        matirial25.put("name"," Vú Sữa");
        db.collection("matirial").document("idmatirial25").set(matirial25);

        Map<String, Object> matirial26 = new HashMap<>();
        matirial26.put("groupPerson", Arrays.asList("","Tiểu Đường"));
        matirial26.put("illness", Arrays.asList(" Sốt","Trúng Gió"));
        matirial26.put("name"," Cồn ");
        db.collection("matirial").document("idmatirial26").set(matirial26);

        Map<String, Object> matirial27 = new HashMap<>();
        matirial27.put("groupPerson", Arrays.asList("Tim Mạch","Tiểu Đường"));
        matirial27.put("illness", Arrays.asList(" Tiêu Chảy","Ngộ Đọc Thực Phẩm"));
        matirial27.put("name"," Rau Má ");
        db.collection("matirial").document("idmatirial27").set(matirial27);

        Map<String, Object> matirial28 = new HashMap<>();
        matirial28.put("groupPerson", Arrays.asList("Tim Mạch","Tiểu Đường"));
        matirial28.put("illness", Arrays.asList(" Tiêu Chảy","Ngộ Đọc Thực Phẩm"));
        matirial28.put("name"," Đu Đủ ");
        db.collection("matirial").document("idmatirial28").set(matirial28);

        Map<String, Object> matirial29 = new HashMap<>();
        matirial29.put("groupPerson", Arrays.asList("Tim Mạch",""));
        matirial29.put("illness", Arrays.asList(" Tiêu Chảy"," Béo Phì"));
        matirial29.put("name"," Thịt Vit ");
        db.collection("matirial").document("idmatirial29").set(matirial29);

        Map<String, Object> matirial30 = new HashMap<>();
        matirial30.put("groupPerson", Arrays.asList("Tim Mạch"," Tiểu Đường"));
        matirial30.put("illness", Arrays.asList(" Tiêu Chảy",""));
        matirial30.put("name"," Cà Chua ");
        db.collection("matirial").document("idmatirial30").set(matirial30);



        //-----------------------------end material-----------------------------
        CollectionReference foods = db.collection("foods");
        Map<String, Object> Heo1 = new HashMap<>();
        Heo1.put("decription", "Nguyên liệu:\n" +
                "\n" +
                "500g thịt ba chỉ\n" +
                "100g bột bắp\n" +
                "Nước mắm\n" +
                "Nước ép tỏi\n" +
                "Tỏi phi\n" +
                "Đường, tiêu\n\n"+
                "Cách làm:\n" +
                "\n" +
                "Mẹo lựa thịt heo ngon\n" +
                "\n" +
                "Thịt ba chỉ chị em lựa miếng ngon không quá mỡ, cũng không quá nạc, miếng thịt ngon thường bên ngoài sẽ có lớp màng khô, phần bên trong sẽ săn lại, mặt cắt thịt thường có màu hồng sáng, mềm mại.\n" +
                "\n" +
                "Bước 1:  Chị em rửa sạch với muối để khử mùi hôi, rửa lại với nước, sau đó thái sợi miếng vừa ăn.\n" +
                "\n" +
                "Ướp thịt với 3 thìa cà phê nước mắm, 1 thìa đường, ½ thìa tiêu, 1 thìa bột bắp, sau đó dùng bao tay trộn đều, ướp trong 15 phút để thịt thấm gia vị.\n" +
                "\n" +
                "Bước 2: Chiên vàng giòn phần thịt đã ướp, sau đó cho ra dĩa có giấy thấm dầu để giúp thịt không bị quá ngậy.\n" +
                "\n" +
                "Bước 3: Thịt chiên xong chị em đem xóc đều với tỏi phi sẵn trước đó, dọn ra dĩa, trang trí thêm một ít xà lách và dưa leo tỉa hoa để món ăn thêm bắt mắt.");
        Heo1.put("formatly", Arrays.asList("Ăn tối"));
        Heo1.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        Heo1.put("image", "heo1");
        Heo1.put("link", "https://heo1.html");
        Heo1.put("material", Arrays.asList("Ma1", "Ma2"));
        Heo1.put("nameFood", "Thịt heo chiên xóc tỏi trưa");
        Heo1.put("rating", 4.7);
        Heo1.put("region", Arrays.asList("Miền Trung"));
        Heo1.put("session", Arrays.asList("Mùa Mưa"));
        Heo1.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("Heo1").set(Heo1);


        Map<String, Object> Heo2 = new HashMap<>();
        Heo2.put("decription", "Nguyên liệu:\n" +
                "\n" +
                "400g thịt ba chỉ\n" +
                "1 củ cà rốt\n" +
                "1 lát gừng\n" +
                "Hành lá\n" +
                "2 tép tỏi\n" +
                "Nước màu, nước mắm, hoa hồi\n\n" +
                "Cách làm:\n" +
                "\n" +
                "Bước 1: Thịt ba chỉ rửa sạch, thái miếng vừa ăn.\n" +
                "\n" +
                "Gừng chị em cạo vỏ, thái lát, hành lá bỏ rể, rửa sạch, thái nhỏ phần đầu hành, tỏi bóc vỏ, thái nhỏ.\n" +
                "\n" +
                "Cà rốt gọt vỏ thái miếng dày 1cm, có thể tỉa hoa để món ăn thêm đẹp mắt.\n" +
                "\n" +
                "Bước 2: Luộc thịt cùng ½ củ gừng và hoa hồi để giảm mùi hôi và giúp thịt thơm ngon hơn.\n" +
                "\n" +
                "Sau khi thịt sôi, vớt ra để ráo và rửa lại lần 2 với nước sạch, để ráo\n" +
                "\n" +
                "Sau đó cho thịt vào chảo chống dính bật bếp đến khi thịt vàng cạnh thì tắt bếp\n" +
                "\n" +
                "Tiếp theo cho ít nước màu và nước mắm vào đảo đều để thịt lên màu, nước màu sôi thì chị em cho hành, tỏi, gừng và cà rốt vào đảo 5 phút.\n" +
                "\n" +
                "Cho ít nước vào xăm xắm thịt đun to lửa đến khi thịt sôi thì giảm dần, để lửat riu riu trong 40 phút, đến khi thấy thịt mềm, cạn còn ⅓ nước thì nêm gia vị vừa miệng là hoàn thành.");
        Heo2.put("formatly", Arrays.asList("Ăn trưa"));
        Heo2.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        Heo2.put("image", "heo2");
        Heo2.put("link", "link ne");
        Heo2.put("material", Arrays.asList("Ma1", "Ma2"));
        Heo2.put("nameFood", "Thịt heo hầm cà rốt");
        Heo2.put("rating", 4.7);
        Heo2.put("region", Arrays.asList("Miền Trung"));
        Heo2.put("session", Arrays.asList("Mùa Mưa"));
        Heo2.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("Heo2").set(Heo2);


        Map<String, Object> Heo3 = new HashMap<>();
        Heo3.put("decription", "Nguyên liệu:\n" +
                "\n" +
                "300g thịt lợn xay nhuyễn\n" +
                "2 củ hành khô\n" +
                "1 củ tỏi\n" +
                "8-10 cây sả\n" +
                "1 thìa cà phê tiêu\n" +
                "1 thìa cà phê đường\n" +
                "Dầu ăn\n" +
                "1 thìa nước mắm\n" +
                "1 thìa bột năng\n" +
                "Một ít bột ngọt ( nếu cần)\n" +
                "Cách làm:\n" +
                "\n" +
                "Bước 1: Sả chị em rửa sạch, cắt phần gốc, lá già, băm nhỏ 1-2 củ, phần còn lại để khúc dài sau đó đập giập nhẹ để món ăn thơm và dậy mùi hơn.\n" +
                "\n" +
                "Hành khô chị em bóc vỏ và băm nhuyễn.\n" +
                "\n" +
                "Bước 2:  Thịt xay chị em cho vào tô thêm ít hành, tỏi, sả băm cùng gia vị ( đường, hạt nêm, nước mắm, tiêu, bột năng, 1 thìa dầu ăn), dùng bao tay trộn đều và ướp thịt trong 20 phút để thấm gia vị.\n" +
                "\n" +
                "Bước 3: Chị em tiến hành nặn chả bằng cách xúc 1 thìa thịt lên cho vào lòng bàn tay rồi dàn mỏng, sau đó đặt 1 cây sả vào giữa, gói thịt lại cho chặt tay đến khi thịt bám vào quanh cây sả là được, cứ như thế làm đến hết ( lưu ý không nên nặn chả quá to sẽ khó chín khi chiên)\n" +
                "\n" +
                "Bước 4: Cho dầu vào chảo chiên vàng đều các cây chả, sau đó vớt ra để ráo dầu, bày ra dĩa, thêm ít rau ngò trang trí.\n" +
                "\n" +
                "Món này có thể ăn với cơm, bún chấm cùng tương ớt hoặc nước mắm đều ngọt tuyệt đấy nhé!");
        Heo3.put("formatly", Arrays.asList("Ăn tối"));
        Heo3.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        Heo3.put("image", "heo3");
        Heo3.put("link", "link ne");
        Heo3.put("material", Arrays.asList("Ma1", "Ma2"));
        Heo3.put("nameFood", "Thịt heo bọc sả chiên giòn");
        Heo3.put("rating", 4.7);
        Heo3.put("region", Arrays.asList("Miền Trung"));
        Heo3.put("session", Arrays.asList("Mùa Mưa"));
        Heo3.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("Heo3").set(Heo3);


        Map<String, Object> Heo4 = new HashMap<>();
        Heo4.put("decription", "Nguyên liệu:\n" +
                "\n" +
                "250g thịt ba chỉ\n" +
                "30g tỏi băm\n" +
                "1 củ sả băm\n" +
                "30g ớt băm ( ớt đỏ và ớt xanh)\n" +
                "Muối, hạt nêm\n" +
                "Cách làm:\n" +
                "\n" +
                "Bước 1:  Để làm món thịt heo rang muối ớt ngon, chị em nên lựa loại ba chỉ heo hơi mỡ tí xíu, \n sau đó rửa sạch, thái khúc vừa ăn ( đừng thái quá mỏng khi chiên thịt sẽ co rúm lại), để ráo.\n" +
                "\n" +
                "Bước 2: Chị em cho thịt vào chảo rang đến khi thịt ra mỡ, hơi vàng và thịt săn lại thì cho tỏi băm\n vào đảo đều từ 2-3 phút thì cho tiếp sả và ớt băm vào, lúc này nên để lửa riu riu nhỏ, cho thêm ít\n muối và hạt nêm đảo đều đến khi thịt thấm gia vị thì tắt bếp, dọn ra dĩa.");
        Heo4.put("formatly", Arrays.asList("Ăn trưa"));
        Heo4.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        Heo4.put("image", "heo4");
        Heo4.put("link", "link ne");
        Heo4.put("material", Arrays.asList("Ma1", "Ma2"));
        Heo4.put("nameFood", "Thịt heo rang muối ớt");
        Heo4.put("rating", 4.7);
        Heo4.put("region", Arrays.asList("Miền Trung"));
        Heo4.put("session", Arrays.asList("Mùa Mưa"));
        Heo4.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("Heo4").set(Heo4);

        Map<String, Object> Heo5 = new HashMap<>();
        Heo5.put("decription", "Nguyên liệu:\n" +
                "\n" +
                "200g thịt ba chỉ\n" +
                "45g mắm ruốc\n" +
                "4 cây sả băm nhỏ\n" +
                "1 củ hành khô băm nhỏ\n" +
                "2 quả ớt tươi băm nhỏ\n" +
                "Đường\n" +
                "Cách làm:\n" +
                "\n" +
                "Bước 1: Đối với món thịt heo kho mắm ruốc chị em nên chọn phần thịt ba chỉ hơi nạc một xíu để món ăn ngon hơn.Sau đó rửa sạch thịt, cắt khúc vừa ăn là được\n" +
                "\n" +
                "Bước 2: Pha mắm ruốc với 2 thìa nước sôi, khuấy đều, để mắm ruốc sạch hơn chị em nên ray lạ, sau đó cho mắm ruốc ra chén.\n" +
                "\n" +
                "Bước 3: Thêm 2 thìa đường vào chén mắm ruốc rồi khuấy tan\n" +
                "\n" +
                "Bước 4: Phi thơm hành khô trong chảo dầu, sau đó cho thêm sả băm vào đảo đều, tiếp đó cho thịt vào xào cùng đến khi thịt săn thì cho mắm ruốc vào cùng ớt, kho đến khi nồi thịt sốt keo lại là được.");
        Heo5.put("formatly", Arrays.asList("Ăn trưa"));
        Heo5.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        Heo5.put("image", "heo5");
        Heo5.put("link", "link ne");
        Heo5.put("material", Arrays.asList("Ma1", "Ma2"));
        Heo5.put("nameFood", "Thịt heo kho mắm ruốc");
        Heo5.put("rating", 4.7);
        Heo5.put("region", Arrays.asList("Miền Trung"));
        Heo5.put("session", Arrays.asList("Mùa Mưa"));
        Heo5.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("Heo5").set(Heo5);

        Map<String, Object> Heo6 = new HashMap<>();
        Heo6.put("decription", "Nguyên liệu:\n" +
                "\n" +
                "500g thịt ba chỉ ( hoặc thịt chân giò)\n" +
                "3 củ hành khô\n" +
                "1 củ tỏi\n" +
                "1 quả dừa tươi\n" +
                "10 quả trứng cút ( 3-4 quả trứng gà)\n" +
                "Hành lá\n" +
                "Đường nâu\n" +
                "Nước hàng kho thịt\n" +
                "Muối\n" +
                "Nước mắm, mì chính, dầu ăn, hạt tiêu\n" +
                "Cách làm\n" +
                "\n" +
                "Bước 1: Sơ chế nguyên liệu\n" +
                "\n" +
                "Thịt ba chỉ chị em lựa miếng không quá nạc khi nấu sẽ bị khô, nên chọn miếng có phần mỡ khi nấu thịt sẽ mềm và ngon ngậy hơn.\n" +
                "\n" +
                "Mua về, chị em rửa sạch, có thể ngâm với nước muối loãng từ 3-5 phút để thịt sạch và đỡ mùi hơn, sau đó để ráo.\n" +
                "\n" +
                "Hành khô bóc vỏ, băm nhỏ, hành lá rửa sạch, cắt khúc. Dừa bổ lấy nước, cùi dừa thái lát mỏng cho ra bát.\n" +
                "\n" +
                "Bước 2: Ướp thịt với ít hành khô băm, 1 thìa mì chính, 2 thìa nước mắm, 2 thìa dầu ăn, 1 thìa hạt tiêu trong 30 phút để thịt thấm gia vị.\n" +
                "\n" +
                "Bước 3: Luộc trứng ( có thể cho thêm ít muối, dấm để trứng nhanh chín và dễ bóc sau khi luộc). Trứng chín, vớt ra, bóc vỏ và cho ra bát riêng.\n" +
                "\n" +
                "Bước 4: Chị em tiến hành thắng nước hàng ( có thể mua ngoài chợ nhưng tự làm sẽ an toàn và ngon hơn nhiều).\n" +
                "\n" +
                "Cho 3 thìa đường nâu vào chảo, 4 thìa nước và khuấy đều. Cho chảo đường lên bếp, để lửa vừa, nấu đến khi đường sôi và chuyển sang màu nâu cánh gián, nước sánh lại thì tắt bếp, đổ ra bát riêng.\n" +
                "\n" +
                "Bước 5: Cho 2 thìa dầu vào nồi, phi thơm với phần tỏi băm còn lại, cho thêm ½ thìa nước mắm đến món ăn đậm vị.Trút thịt đã ướp vào nồi cùng cùi dừa đảo đều đến khi thịt săn lại thì cho 2 thìa nước hàng vào đảo cùng.\n" +
                "\n" +
                "Đổ nước dừa tươi vào xâm xấp mặt thịt là được, vặn lửa to để nồi thịt sôi, sau đó vặn nhỏ để thịt kho chín mềm. Trong quá trình kho bạn không nên đậy vụng để thịt chín mềm và không bị nát, có thể hớt phần bọt trên để thịt kho trong hơn và có vị thanh.\n" +
                "\n" +
                "Để lửa riu riu kho trong 30 phút, nước cạn có thể cho thêm phần nước dừa vào, nêm nếm gia vị vừa ăn đến khi thịt chuyển sang màu nâu đỏ thì cho trứng cút vào, nấu thêm 2-3 phút nữa thì tắt bếp.\n" +
                "\n" +
                "Cho thịt ra dĩa, rưới phần nước kho thịt nâu óng sóng sánh lên để thêm hấp dẫn, cùng 1 ít cọng rau mùi, ớt đỏ để thêm bắt mắt.");
        Heo6.put("formatly", Arrays.asList("Ăn tối"));
        Heo6.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        Heo6.put("image", "heo6");
        Heo6.put("link", "link ne");
        Heo6.put("material", Arrays.asList("Ma1", "Ma2"));
        Heo6.put("nameFood", "Thịt heo kho tàu");
        Heo6.put("rating", 4.7);
        Heo6.put("region", Arrays.asList("Miền Trung"));
        Heo6.put("session", Arrays.asList("Mùa Mưa"));
        Heo6.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("Heo6").set(Heo6);


        Map<String, Object> Heo7 = new HashMap<>();
        Heo7.put("decription", "Nguyên liệu:\n" +
                "\n" +
                "6 dải thịt heo thái mỏng\n" +
                "1 cây măng\n" +
                "1 hộp nấm ngọc chấm xám\n" +
                "2 nhánh hành lá\n" +
                "Bột bắp, dầu hào, gia vị\n" +
                "Cách làm:\n" +
                "\n" +
                "Bước 1: Măng chị em gọt vỏ, luộc chín và vớt ra ngâm với nước lạnh. Sau đó thái miếng nhỏ hình chữ nhật.\n" +
                "\n" +
                "Nấm ngâm với muối rồi rửa sạch, bỏ gốc.\n" +
                "\n" +
                "Hành lá rửa sạch cắt khúc\n" +
                "\n" +
                "Bước 2: Trải từng miéng thịt lên khay phẳng, rắc một chút bột bắp và gia vị, xếp lần lượt măng, nấm, hành lá vào cuộn tròn.\n" +
                "\n" +
                "Bước 3: Cho ít dầu vào chảo, đặt từng miếng thịt cuộn vào và chiên vàng đều.\n" +
                "\n" +
                "Bước 4: Hòa tan bột bắp và dầu hào vào 1 chén nhỏ rồi đổ vào chảo riêng đun tới khi sôi hơi sánh lại là được.\n" +
                "\n" +
                "Bước 5: Xếp từng phần thịt cuộn đã chiên chín ra dĩa, rưới sốt lên trên là xong.");
        Heo7.put("formatly", Arrays.asList("Ăn tối"));
        Heo7.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        Heo7.put("image", "heo7");
        Heo7.put("link", "link ne");
        Heo7.put("material", Arrays.asList("Ma1", "Ma2"));
        Heo7.put("nameFood", "Thịt heo cuộn măng hầm");
        Heo7.put("rating", 4.7);
        Heo7.put("region", Arrays.asList("Miền Trung"));
        Heo7.put("session", Arrays.asList("Mùa Mưa"));
        Heo7.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("Heo7").set(Heo7);

        Map<String, Object> Heo8 = new HashMap<>();
        Heo8.put("decription", "Nguyên liệu:\n" +
                "\n" +
                "400g thịt ba chỉ\n" +
                "2 củ cải trắng\n" +
                "1 muỗng đường\n" +
                "Hành khô, nước nắm, hạt nêm\n" +
                "1 trái ớt\n" +
                "Hành lá\n" +
                "Cách làm:\n" +
                "\n" +
                "Bước 1: Thịt ba chỉ nên lựa loại da mỏng, mỡ trắng, giòn, sau đó rửa sạch với nước muối loãng để thịt sạch hơn và để ráo.\n" +
                "\n" +
                "Cắt thịt thành từng miếng dày vừa ăn ướp với ít nước mắm, hạt nêm, mì chính, tiêu, hành khô đập giập trong 30 phút để thịt thấm gia vị.\n" +
                "\n" +
                "Bước 2: Trong khi đợi thịt thấm gia vị chị em làm nước màu bằng cách cho đường vào chảo nhỏ, đun đến khi đường chuyển sang màu nâu thì cho thêm ít nước đến khi sền sệt là được.\n" +
                "\n" +
                "Bước 3: Củ cải gọt vỏ, rửa sạch, thái khoanh vừa ăn, sau đó xốc với ít muối, sau đó cho vào cùng thịt ướp trong 15 phút,\n" +
                "\n" +
                "Bước 4: Cho thịt và củ cải vào nồi bật lửa vừa phải đến khi thịt hơi săn thì thêm ít nước vừa ngập thịt và củ cải là được.\n" +
                "\n" +
                "Sau đó đun sôi lần 2 thì nêm nếm gia vị vừa ăn, để lửa riu riu tới khi thịt và củ cải mềm, thêm ít ớt sừng để tăng vị cay nếu thích.");
        Heo8.put("formatly", Arrays.asList("Ăn trưa"));
        Heo8.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        Heo8.put("image", "heo8");
        Heo8.put("link", "link ne");
        Heo8.put("material", Arrays.asList("Ma1", "Ma2"));
        Heo8.put("nameFood", "Thịt heo kho củ cải trắng");
        Heo8.put("rating", 4.7);
        Heo8.put("region", Arrays.asList("Miền Trung"));
        Heo8.put("session", Arrays.asList("Mùa Mưa"));
        Heo8.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("Heo8").set(Heo8);

        Map<String, Object> Heo9 = new HashMap<>();
        Heo9.put("decription", "Nguyên liệu:\n" +
                "\n" +
                "300g thịt ba chỉ ( chọn thịt có nạc, mỡ và bì)\n" +
                "4 củ sả\n" +
                "2 quả ớt\n" +
                "1 củ tỏi\n" +
                "1 củ hành khô\n" +
                "Muối, hạt tiêu, dầu ăn, dầu hào\n" +
                "Cách làm:\n" +
                "\n" +
                "Bước 1: Thịt ba chỉ chị em rửa sạch, để ráo và thái miếng mỏng hoặc to vừa ăn.\n" +
                "\n" +
                "Sả bóc lớp ngoài, thái chéo mỏng\n" +
                "\n" +
                "Ớt rửa sạch, bổ dọc bỏ hạt và thái chéo mỏng\n" +
                "\n" +
                "Tỏi, hành bóc vỏ băm nhuyễn\n" +
                "\n" +
                "Uớp thịt với ít sả, ớt, 1 thìa dầu hào, 1 thìa muối, 1 thìa hạt tiêu trong 20 phút để thịt thấm gia vị.\n" +
                "\n" +
                "Bước 2: Phi thơm tỏi, cho thịt vào xào đều đến khi thịt hơi săn thì thêm ít muối vừa ăn thì tắt bếp, dọn ra dĩa với ít hành, ngò để món ăn thêm đẹp mắt.");
        Heo9.put("formatly", Arrays.asList("Ăn tối"));
        Heo9.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        Heo9.put("image", "heo9");
        Heo9.put("link", "link ne");
        Heo9.put("material", Arrays.asList("Ma1", "Ma2"));
        Heo9.put("nameFood", "Thịt heo xào lăn");
        Heo9.put("rating", 4.7);
        Heo9.put("region", Arrays.asList("Miền Trung"));
        Heo9.put("session", Arrays.asList("Mùa Mưa"));
        Heo9.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("Heo9").set(Heo9);

        Map<String, Object> Heo10 = new HashMap<>();
        Heo10.put("decription", "Nguyên liệu:\n" +
                "\n" +
                "500g thịt ba chỉ ngon\n" +
                "1 củ gừng, hành khô, ớt mau\n" +
                "Đường, bột canh, nước mắm, hạt tiêu\n" +
                "Cách làm:\n" +
                "\n" +
                "Bước 1: Ba chỉ chị em chọn phần không bị long, phần mỡ và nạc ngang nhau, sát muối quanh thân thịt, trần qua nuóc nóng thật sạch, sau đó thái từng miếng tầm 3cm.\n" +
                "\n" +
                "Ướp thịt với ít đường, nước mắm trong 30 phút để thịt thấm gia vị.\n" +
                "\n" +
                "Bước 2: Gừng chị em cạo sạch vỏ, rửa sạch với nước và thái mỏng.\n" +
                "\n" +
                "Phi thơm dầu với hành tím, gừng, cho thịt vào xào cùng thêm ít ớt màu đảo đều để thịt thấm gia vị, đậy nắp vung để nước thịt chảy ra, đun đến khi cạn, phần mỡ hòa với đường tạo thành màu nâu cánh gián là được.\n" +
                "\n" +
                "Món thịt heo kho gừng thích hợp ăn cùng cơm nóng trong những ngày se lạnh, mưa sẽ vô cùng ngon.");
        Heo10.put("formatly", Arrays.asList("Ăn tối"));
        Heo10.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        Heo10.put("image", "heo10");
        Heo10.put("link", "link ne");
        Heo10.put("material", Arrays.asList("Ma1", "Ma2"));
        Heo10.put("nameFood", "Thịt heo kho gừng");
        Heo10.put("rating", 4.7);
        Heo10.put("region", Arrays.asList("Miền Trung"));
        Heo10.put("session", Arrays.asList("Mùa Mưa"));
        Heo10.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("Heo10").set(Heo10);


        Map<String, Object> Heo11 = new HashMap<>();
        Heo11.put("decription", "Nguyên liệu:\n" +
                "\n" +
                "300g thịt heo\n" +
                "Gừng, trứng gà, ớt chuông, thơm, cà rốt, hành tây\n" +
                "Sốt cà chua, bột mì, bột nở, giấm gạo\n" +
                "Dầu hào, bột khoai tây, dầu ăn, nước tương, đường, muối\n" +
                "Cách làm:\n" +
                "\n" +
                "Bước 1: Trước tiên thịt heo rửa sạch, cắt thành những viên nhỏ vừa ăn. Ướp thịt với 1 muỗng nước tương, 1 muỗng dầu hào, ¼  muỗng nước gừng khoảng 30 phút.\n" +
                "\n" +
                "Bước 2: Ta làm nước sốt chua ngọt trong khi thịt đang ướp, gồm 1 chén nước, nửa chén giấm gạo, 3 muỗng đường, 2 muỗng bột khoai tây, ¼ muỗng muối. Nấu hỗn hợp này trên bếp cho tới khi nước sốt sền sệt lại là tắt bếp.\n" +
                "\n" +
                "Bước 3: Trộn bột mì và bột khoai tây theo tỉ lệ 2:1 cùng nửa muỗng bột nở, cho thêm nước vào đánh đều tay cho thành hơi lỏng. Đập trứng ra tô đánh tan lòng đỏ rồi đổ chung vào hỗn hợp bột đánh đều một lần nữa, nếu bị đặc thì cứ cho thêm nước vào để lỏng ra.\n" +
                "\n" +
                "Bước 4: Đun nóng với lửa vừa lượng dầu ngập đáy chảo, thịt heo nhúng qua bột và dầu ăn rồi cho vào chảo chiên vàng hai mặt rồi vớt ra. Sau thịt thì chiên ớt chuông, hành tây, thơm, cà rốt đã cắt nhỏ và đảo cho chín tới là vớt ra.\n" +
                "\n" +
                "Bước 5: Cho cả thịt và rau củ đã chiên vào chung với nước sốt, nấu nhỏ lửa cho tới khi thịt và rau đều ngấm sốt thì tắt bếp, dọn ra dĩa.");
        Heo11.put("formatly", Arrays.asList("Ăn trưa"));
        Heo11.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        Heo11.put("image", "heo11");
        Heo11.put("link", "link ne");
        Heo11.put("material", Arrays.asList("Ma1", "Ma2"));
        Heo11.put("nameFood", "Thịt heo xào chua ngọt");
        Heo11.put("rating", 4.7);
        Heo11.put("region", Arrays.asList("Miền Trung"));
        Heo11.put("session", Arrays.asList("Mùa Mưa"));
        Heo11.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("Heo11").set(Heo11);


        Map<String, Object> Heo12 = new HashMap<>();
        Heo12.put("decription", "Nguyên liệu:\n" +
                "\n" +
                "500g chân giò heo hoặc thịt ba chỉ\n" +
                "Củ riềng, nghệ tươi, sả, ớt\n" +
                "Mẻ, mắm tôm\n" +
                "Muối, nước mắm, bột ngọt, hạt nêm\n"+
                "Cách làm:\n" +
                "\n" +
                "Bước 1: Củ riềng, sả, ớt rửa sạch rồi cắt nhỏ hoặc thái lát. Nghệ gọt vỏ rồi giã nát để lấy nước.\n" +
                "\n" +
                "Bước 2: Thịt heo rửa sạch, đem nướng cho xém phần da một tí. Sau đó đem rửa lại và cắt thành từng miếng nhỏ. Nếu nấu bằng chân giò, dùng rơm thui vàng chân giò hoặc cho vào lò vi sóng nướng sao cho vàng. Sau khi nướng xong cũng đem rửa sạch, cạo cháy và chặt thành từng miếng vừa ăn.\n" +
                "\n" +
                "Bước 3: Ướp thịt đã cắt nhỏ với riềng đã xay nhuyễn, mẻ, mắm tôm, nước nghệ, bột ngọt, ớt, hạt nêm trong khoảng 30 phút.\n" +
                "\n" +
                "Bước 4: Đun nóng dầu trong nồi, cho thịt đã ướp vào đảo đều cho tới khi thịt hơi săn lại. Tiếp theo cho khoảng ⅔ nước ngập thịt rồi cho lửa nhỏ nấu tới khi thịt chín mềm là tắt bếp.");
        Heo12.put("formatly", Arrays.asList("Ăn tối"));
        Heo12.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        Heo12.put("image", "heo12");
        Heo12.put("link", "link ne");
        Heo12.put("material", Arrays.asList("Ma1", "Ma2"));
        Heo12.put("nameFood", "Thịt heo giả cầy");
        Heo12.put("rating", 4.7);
        Heo12.put("region", Arrays.asList("Miền Trung"));
        Heo12.put("session", Arrays.asList("Mùa Mưa"));
        Heo12.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("Heo12").set(Heo12);


        // Rau củ

        Map<String, Object> rau1 = new HashMap<>();
        rau1.put("decription", "Chuẩn bị:\n" +
                "\n" +
                "Rau củ quả ưa thích (cà rốt, rau xanh, súp lơ, đậu bắp…)\n" +
                "Nguyên liệu làm kho quẹt gồm:\n" +
                "\n" +
                "400g thịt ba chỉ\n" +
                "50g tôm nõn khô\n" +
                "2 củ hành khô\n" +
                "Vài nhánh tỏi, 1 quả ớt, 2 nhánh hành lá\n" +
                "1 thìa đường, 2 thìa nước mắm, hạt tiêu, 1 thìa tương ớt\n"+
                "Cách làm:\n" +
                "\n" +
                "Đối với rau củ quả, sau khi sơ chế sạch, làm kho quẹt xong, luộc chín cho vào tô nước đá tầm 1-2 phút để tăng độ giòn, sau đó cho ra dĩa vừa nóng ăn sẽ ngon hơn.\n" +
                "\n" +
                "Đối với nước kho quẹt:\n" +
                "\n" +
                "Bước 1: Thịt ba chỉ sau khi mua về, rửa sạch, để ráo nước, lạng bỏ phần bì rồi thái thành từng miếng hình hạt vừa nhỏ.\n" +
                "\n" +
                "Bước 2: Tôm khô rửa sạch, ngâm 10 phút trong nước cho mềm rồi vớt ra để ráo nước, hành khô và tỏi băm nhỏ, hành lá thái nhỏ, ớt thái miếng vát chéo.\n" +
                "\n" +
                "Bước 3: Cho thịt vào chảo xào cho ra bớt mỡ, đến khi thịt xém vàng thì vớt ra dĩa. Lấy bớt phần dầu, sau đó bật bếp cho dầu nóng lại thì thêm hành với tỏi vào phi thơm, cho tôm khô xào sơ qua đến khi dậy mùi thì cho nước mắm, đường, hạt nêm, ớt tương vào đảo đều.\n" +
                "\n" +
                "Bước 4: Tiếp đó cho phần thịt ba chỉ vào rồi thêm ít nước xâm xấp mặt thịt rồi đậy vung đun đến khi thịt sôi lại thì hạ nhỏ lửa.\n" +
                "\n" +
                "Khi thịt chín mềm, nước sốt sền sệt thì nêm nếm lại cho vừa miệng rồi tắt bếp. Chị em có thể rắc thêm ít tiêu và hành lá cho món ăn thêm đẹp mắt và thơm ngon.");
        rau1.put("formatly", Arrays.asList("Ăn trưa"));
        rau1.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        rau1.put("image", "rau1");
        rau1.put("link", "link ne");
        rau1.put("material", Arrays.asList("Ma1", "Ma2"));
        rau1.put("nameFood", "Rau củ luộc kho quẹt");
        rau1.put("rating", 4.7);
        rau1.put("region", Arrays.asList("Miền Trung"));
        rau1.put("session", Arrays.asList("Mùa Mưa"));
        rau1.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("rau1").set(rau1);


        Map<String, Object> rau2 = new HashMap<>();
        rau2.put("decription", "Chuẩn bị:\n" +
                "\n" +
                "450g cải ngồng, tước sạch phần thân và lá già, rửa sạch, để ráo (tùy lượng ăn)\n" +
                "15ml dầu ăn\n" +
                "3-4 tép tỏi tùy thích\n" +
                "1 nhúm muối\n" +
                "Vài giọt dầu mè\n"+
                "Cách làm:\n" +
                "\n" +
                "Bước 1: Cải ngồng sơ chế xong để ráo, tỏi đập dập.\n" +
                "\n" +
                "Bước 2: Cho nước sôi vào nồi sôi, sau đó thêm ít muối và vài giọt dầu mè, tiến hành chần sơ qua cải ngồng trong 1 phút (nên nhúng phần thân trước 30 phút, sau đó mới cho lá vào, bí kíp này giúp cải ngồng luôn xanh khi xào).\n" +
                "\n" +
                "Bước 3: Cho cải ra chậu nước đá trong 1-2 phút thì vớt ra để ráo.\n" +
                "\n" +
                "Bước 4: Cho dầu vào chảo, phi thơm vàng tỏi, cho rau vào xào với lửa lớn, nêm thêm ít muối và vài giọt dầu mè đảo đều đến khi rau chín thì tắt bếp.");
        rau2.put("formatly", Arrays.asList("Ăn tối"));
        rau2.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        rau2.put("image", "rau2");
        rau2.put("link", "link ne");
        rau2.put("material", Arrays.asList("Ma1", "Ma2"));
        rau2.put("nameFood", "Cải ngồng xào tỏi xanh giòn");
        rau2.put("rating", 4.7);
        rau2.put("region", Arrays.asList("Miền Trung"));
        rau2.put("session", Arrays.asList("Mùa Mưa"));
        rau2.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("rau2").set(rau2);


        Map<String, Object> rau3 = new HashMap<>();
        rau3.put("decription", "Chuẩn bị:\n" +
                "\n" +
                "150g thịt bò mềm\n" +
                "1 bó rau khoai ngon tươi\n" +
                "30g lạc\n" +
                "2-3 củ hành khô\n" +
                "1 củ tỏi\n" +
                "1 trái ớt\n" +
                "4-5 trái quất\n" +
                "1 trái chanh\n" +
                "Gia vị (muối, đường, bột nêm, nước mắm, dầu ăn…)\n"+
                "Cách làm:\n" +
                "\n" +
                "Bước 1: Rau lang nhặt lấy phần lá, bỏ cọng, lá già, sau đó ngâm với nước muối từ 3-5 phút, rửa sạch và để ráo.\n" +
                "\n" +
                "Bước 2: Thịt bò lựa loại mềm, nếu có gân lọc bỏ gân, màng, rửa sạch, thái mỏng, để ráo.\n" +
                "\n" +
                "Hành khô bóc vỏ thái lát mỏng, tỏi đập dập, băm nhỏ, ớt thái nhỏ.\n" +
                "\n" +
                "Ướp thịt bò với ít hạt nêm, tiêu và ⅓ chỗ tỏi vừa băm ở trên, trộn đều để trong 15 phút cho bò thấm.\n" +
                "\n" +
                "Bước 3: Lạc rang chín, xa bỏ vỏ, sau đó giã dập.\n" +
                "\n" +
                "Bước 4: Cho nước vào nồi luộc chín với ít muối, sau khi luộc, bạn dùng đũa tãi đều cho rau nguội và giữ được độ xanh ngon.\n" +
                "\n" +
                "Bước 5: Pha nước trộn gỏi gồm: 1 thìa nước mắm, 2 thìa đường, 1 thìa nước cốt chanh hoặc quất, khuấy cho đường tan rồi cho ớt và ½ phần tỏi còn lại vào.\n" +
                "\n" +
                "Bước 6: Cho chảo lên bếp, chảo nóng cho dầu vào phi thơm với hành, sau đó vớt ra để riêng, cho phần tỏi băm còn lại vào phi thơm. Cho thịt bò vào đảo nhanh tay, bò chín là được.\n" +
                "\n" +
                "Bước 7: Cho rau vào tô lớn, cho nước trộn gỏi vào, nêm nếm vừa ăn. Cho bò ở trên cùng, đảo đều tay, cuối cùng cho lạc rang, hành phi vào là hoàn thành.");
        rau3.put("formatly", Arrays.asList("Điểm tâm","Ăn tối"));
        rau3.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        rau3.put("image", "rau3");
        rau3.put("link", "link ne");
        rau3.put("material", Arrays.asList("Ma1", "Ma2"));
        rau3.put("nameFood", "Nộm rau lang thịt bò");
        rau3.put("rating", 4.7);
        rau3.put("region", Arrays.asList("Miền Trung"));
        rau3.put("session", Arrays.asList("Mùa Mưa"));
        rau3.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("rau3").set(rau3);


        Map<String, Object> rau4 = new HashMap<>();
        rau4.put("decription", "Chuẩn bị:\n" +
                "\n" +
                "100g mì Ý ống hoặc mì Udon Hakubaku đều được\n" +
                "½ quả ớt chuông đỏ hoặc cam\n" +
                "1 trái dưa leo\n" +
                "200g cà chua bi hoặc cà chua cherry\n" +
                "3 lát thịt nguội\n" +
                "1- 2 khoanh dứa tươi\n" +
                "¼ củ hành tây\n"+
                "Cách làm:\n" +
                "\n" +
                "Bước 1: Làm phần sốt gồm: 30g sốt mayonnaise, 30g kem chua, 30g nước dứa ép, 5g đường, 2 nhánh tỏi bằm và chút tiêu.\n" +
                "\n" +
                "Bước 2: Tất cả các nguyên liệu rửa sạch, thái miếng vừa ăn.\n" +
                "\n" +
                "Với mỳ thì bạn luộc chín, xả qua nước.\n" +
                "\n" +
                "Bước 3: Mỳ chín cho tất cả vào tô lớn, cho phần sốt vào trộn đều, nêm nếm vừa ăn là được.\n" +
                "\n" +
                "Để món này thêm ngon bạn nên cho vào ngăn mát tủ lạnh từ 1-2h để có vị giòn.");
        rau4.put("formatly", Arrays.asList("Điểm tâm","Ăn tối"));
        rau4.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        rau4.put("image", "rau4");
        rau4.put("link", "link ne");
        rau4.put("material", Arrays.asList("Ma1", "Ma2"));
        rau4.put("nameFood", "Salad Hawaii");
        rau4.put("rating", 4.7);
        rau4.put("region", Arrays.asList("Miền Trung"));
        rau4.put("session", Arrays.asList("Mùa Mưa"));
        rau4.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("rau4").set(rau4);


        Map<String, Object> rau5 = new HashMap<>();
        rau5.put("decription", "Chuẩn bị:\n" +
                "\n" +
                "100g mì Ý ống hoặc mì Udon Hakubaku đều được\n" +
                "½ quả ớt chuông đỏ hoặc cam\n" +
                "1 trái dưa leo\n" +
                "200g cà chua bi hoặc cà chua cherry\n" +
                "3 lát thịt nguội\n" +
                "1- 2 khoanh dứa tươi\n" +
                "¼ củ hành tây\n"+
                "Cách làm:\n" +
                "\n" +
                "Bước 1: Làm phần sốt gồm: 30g sốt mayonnaise, 30g kem chua, 30g nước dứa ép, 5g đường, 2 nhánh tỏi bằm và chút tiêu.\n" +
                "\n" +
                "Bước 2: Tất cả các nguyên liệu rửa sạch, thái miếng vừa ăn.\n" +
                "\n" +
                "Với mỳ thì bạn luộc chín, xả qua nước.\n" +
                "\n" +
                "Bước 3: Mỳ chín cho tất cả vào tô lớn, cho phần sốt vào trộn đều, nêm nếm vừa ăn là được.\n" +
                "\n" +
                "Để món này thêm ngon bạn nên cho vào ngăn mát tủ lạnh từ 1-2h để có vị giòn.");
        rau5.put("formatly", Arrays.asList("Điểm tâm","Ăn tối"));
        rau5.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        rau5.put("image", "rau5");
        rau5.put("link", "link ne");
        rau5.put("material", Arrays.asList("Ma1", "Ma2"));
        rau5.put("nameFood", "Cải bó xôi xào tỏi");
        rau5.put("rating", 4.7);
        rau5.put("region", Arrays.asList("Miền Trung"));
        rau5.put("session", Arrays.asList("Mùa Mưa"));
        rau5.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("rau5").set(rau5);


        Map<String, Object> rau6 = new HashMap<>();
        rau6.put("decription", "Chuẩn bị:\n" +
                "\n" +
                "4-5 củ khoai tây\n" +
                "4 thìa hành tây, 3 thìa ớt chuông xanh, 3 thìa cà rốt xắt hạt lựu, 2 thìa rau mùi tây băm nhỏ.\n" +
                "Dầu ăn, muối, tiêu\n" +
                "Nước sốt cà chua\n" +
                "Nguyên liệu làm bột (140g bột mì, 140g bột chiên xù, 1 quả trứng, ít muối, tiêu)\n"+
                "Cách làm:\n" +
                "\n" +
                "Bước 1: Cho ít dầu ăn vào chảo, dầu nóng, cho phần hành tây, ớt chuông, cà rốt vào xào chín.\n" +
                "\n" +
                "Bước 2: Khoai tây luộc chín, nghiền nhuyễn, trộn với mùi tây và hỗn hợp vừa xào, nêm thêm ít muối, tiêu rồi hòa quyện.\n" +
                "\n" +
                "Bước 3: Chia khoai thành nhiều phần bằng nhau sau đó vo tròn lại, lăn qua bột mì, trứng đánh tan và cuối cùng là bột chiên xù.\n" +
                "\n" +
                "Bước 4: Cho dầu vào chảo và tiến hành chiên xù các viên khoai tây.\n" +
                "\n" +
                "Món này ăn kèm với nước sốt cà chua sẽ vô cùng bắt bài.");
        rau6.put("formatly", Arrays.asList("Điểm tâm","Ăn tối"));
        rau6.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        rau6.put("image", "rau6");
        rau6.put("link", "link ne");
        rau6.put("material", Arrays.asList("Ma1", "Ma2"));
        rau6.put("nameFood", "Chả viên rau củ");
        rau6.put("rating", 4.7);
        rau6.put("region", Arrays.asList("Miền Trung"));
        rau6.put("session", Arrays.asList("Mùa Mưa"));
        rau6.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("rau6").set(rau6);


        Map<String, Object> rau7 = new HashMap<>();
        rau7.put("decription", "Chuẩn bị:\n" +
                "\n" +
                "300g bông cải xanh\n" +
                "200g cà rốt\n" +
                "500g xương má heo\n" +
                "Vài lát gừng\n" +
                "Hành, ngò\n" +
                "Gia vị (muối, hạt nêm, tiêu…)\n" +
                "Cách làm:\n" +
                "\n" +
                "Bước 1: Xương heo sau khi mua về bạn rửa sạch, chặt thành miếng nhỏ vừa ăn, ngâm trong 15 phút với ít muối và gừng, rửa lại cho sạch và để ráo.\n" +
                "\n" +
                "Bước 2: Cà rốt bào vỏ, tỉa hình mà bạn thích để món ăn thêm đẹp mắt. Bông cải rửa sạch, thái miếng vừa ăn.\n" +
                "\n" +
                "Bước 3: Hầm xương heo với 1.5 lít nước sôi trong 30 phút, trong lúc hầm nên vớt phần bọt đen để nước dùng trong. Sau đó cho cà rốt vào hầm cùng.\n" +
                "\n" +
                "Bước 4: Sau khi cà rốt chín, xương mềm thì cho bông cải vào nấu trong 10 phút, nêm nếm gia vị vừa ăn là được.\n" +
                "\n" +
                "Cho canh ra tô rắc thêm hành ngò ");
        rau7.put("formatly", Arrays.asList("Ăn trưa","Ăn tối"));
        rau7.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        rau7.put("image", "rau7");
        rau7.put("link", "link ne");
        rau7.put("material", Arrays.asList("Ma1", "Ma2"));
        rau7.put("nameFood", "Canh bông cải xanh");
        rau7.put("rating", 4.7);
        rau7.put("region", Arrays.asList("Miền Trung"));
        rau7.put("session", Arrays.asList("Mùa Mưa"));
        rau7.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("rau7").set(rau7);


        Map<String, Object> rau8 = new HashMap<>();
        rau8.put("decription", "Chuẩn bị:\n" +
                "\n" +
                "1 bông cải xanh cỡ nhỏ hoặc vừa\n" +
                "1 củ cà rốt\n" +
                "3 - 4 củ cải đỏ\n" +
                "1 nắm hạnh nhân rang chín, đập dập hoặc xắt lát\n" +
                "1 nắm vừng trắng\n" +
                "Sốt trộn salad: 30ml dầu vừng, 30ml dầu ăn, 40ml giấm táo, 30ml nước tương, 40ml mật ong, 2 nhánh tỏi đập dập. 1 mẩu gừng băm nhỏ, ½ muỗng cà phê ớt bột.\n "+
                "Cách làm:\n" +
                "\n" +
                "Bước 1: Sơ chế các nguyên liệu\n" +
                "\n" +
                "Bông cải cắt thành miếng vừa ăn, rửa sạch và để ráo.\n" +
                "Củ cải đỏ rửa sạch, thái lát mỏng\n" +
                "Cà rốt nạo vỏ, cắt hình que 3cm\n" +
                "Bông cải xanh cắt nhỏ, rửa sạch, chần qua nước sôi trong 2 phút rồi để ráo.\n" +
                "Bước 2: Cho tất cả vào bát to trộn đều với nước sốt, bọc găng và cho vào ngăn mát tủ lạnh từ 30 phút đến 1h đồng hồ trước khi ăn để thêm hấp dẫn nha.");
        rau8.put("formatly", Arrays.asList("Ăn trưa","Ăn tối"));
        rau8.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        rau8.put("image", "rau8");
        rau8.put("link", "link ne");
        rau8.put("material", Arrays.asList("Ma1", "Ma2"));
        rau8.put("nameFood", "Salad bông cải xanh");
        rau8.put("rating", 4.7);
        rau8.put("region", Arrays.asList("Miền Trung"));
        rau8.put("session", Arrays.asList("Mùa Mưa"));
        rau8.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("rau8").set(rau8);

        Map<String, Object> rau9 = new HashMap<>();
        rau9.put("decription", "Chuẩn bị:\n" +
                "\n" +
                "1 bắp ngô ngọt\n" +
                "10g bơ nhạt\n" +
                "1 thìa súp nước tương\n" +
                "ít hạt tiêu\n"+
                "Cách làm:\n" +
                "\n" +
                "Bước 1: Ngô rửa sạch, tách hạt, để ở nhiệt độ phòng cho mềm\n" +
                "\n" +
                "Bước 2: Cho bơ vào chảo đun chảy, sau đó cho ngô vào đảo đều.\n" +
                "\n" +
                "Tiếp tục cho nước tương vào đảo đều, thêm nốt phần bơ còn lại đến khi bơ tan và quyện với ngô.\n" +
                "\n" +
                "Bước 3: Rắc thêm ít hạt tiêu là có thể thưởng thức.");
        rau9.put("formatly", Arrays.asList("Ăn trưa","Ăn tối"));
        rau9.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        rau9.put("image", "rau9");
        rau9.put("link", "link ne");
        rau9.put("material", Arrays.asList("Ma1", "Ma2"));
        rau9.put("nameFood", "Ngô xào lạ miệng");
        rau9.put("rating", 4.7);
        rau9.put("region", Arrays.asList("Miền Trung"));
        rau9.put("session", Arrays.asList("Mùa Mưa"));
        rau9.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("rau9").set(rau9);


        Map<String, Object> rau10 = new HashMap<>();
        rau10.put("decription", "Chuẩn bị:\n" +
                "\n" +
                "250g cải thìa, rửa sạch thái miếng vừa ăn\n" +
                "2 thìa dầu thực vật\n" +
                "4 cái nấm (hương, đông cô, mỡ tùy chọn)\n" +
                "3 nhánh tỏi băm nhỏ\n" +
                "½ thìa cà phê muối\n"+
                "Cách làm:\n" +
                "\n" +
                "Bước 1: Cho dầu vào nồi phi thơm với tỏi, xào sơ qua nấm\n" +
                "\n" +
                "Bước 2: Giữ lửa lớn, cho tiếp cải thìa đã sơ chế vào xào nhanh tay, nêm thêm ít muối là hoàn thành.\n" +
                "\n" +
                "Với cách chế biến này bạn sẽ không cần quá nhiều gia vị mà vẫn thưởng thức được vị ngon ngọt tự nhiên của rau và nấm.");
        rau10.put("formatly", Arrays.asList("Ăn trưa"));
        rau10.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        rau10.put("image", "rau10");
        rau10.put("link", "link ne");
        rau10.put("material", Arrays.asList("Ma1", "Ma2"));
        rau10.put("nameFood", "Cải thìa xào nấm");
        rau10.put("rating", 4.7);
        rau10.put("region", Arrays.asList("Miền Trung"));
        rau10.put("session", Arrays.asList("Mùa Mưa"));
        rau10.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("rau10").set(rau10);


        Map<String, Object> rau11 = new HashMap<>();
        rau11.put("decription", "Chuẩn bị:\n" +
                "\n" +
                "250g cải thìa, rửa sạch thái miếng vừa ăn\n" +
                "2 thìa dầu thực vật\n" +
                "4 cái nấm (hương, đông cô, mỡ tùy chọn)\n" +
                "3 nhánh tỏi băm nhỏ\n" +
                "½ thìa cà phê muối\n"+
                "Cách làm:\n" +
                "\n" +
                "Bước 1: Cho dầu vào nồi phi thơm với tỏi, xào sơ qua nấm\n" +
                "\n" +
                "Bước 2: Giữ lửa lớn, cho tiếp cải thìa đã sơ chế vào xào nhanh tay, nêm thêm ít muối là hoàn thành.\n" +
                "\n" +
                "Với cách chế biến này bạn sẽ không cần quá nhiều gia vị mà vẫn thưởng thức được vị ngon ngọt tự nhiên của rau và nấm.");
        rau11.put("formatly", Arrays.asList("Ăn tối"));
        rau11.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        rau11.put("image", "rau11");
        rau11.put("link", "link ne");
        rau11.put("material", Arrays.asList("Ma1", "Ma2"));
        rau11.put("nameFood", "Rau cần muối xổi");
        rau11.put("rating", 4.7);
        rau11.put("region", Arrays.asList("Miền Trung"));
        rau11.put("session", Arrays.asList("Mùa Mưa"));
        rau11.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("rau11").set(rau11);


        Map<String, Object> rau12 = new HashMap<>();
        rau12.put("decription", "Chuẩn bị:\n" +
                "\n" +
                "250g cải thìa, rửa sạch thái miếng vừa ăn\n" +
                "2 thìa dầu thực vật\n" +
                "4 cái nấm (hương, đông cô, mỡ tùy chọn)\n" +
                "3 nhánh tỏi băm nhỏ\n" +
                "½ thìa cà phê muối\n"+
                "Cách làm:\n" +
                "\n" +
                "Bước 1: Cho dầu vào nồi phi thơm với tỏi, xào sơ qua nấm\n" +
                "\n" +
                "Bước 2: Giữ lửa lớn, cho tiếp cải thìa đã sơ chế vào xào nhanh tay, nêm thêm ít muối là hoàn thành.\n" +
                "\n" +
                "Với cách chế biến này bạn sẽ không cần quá nhiều gia vị mà vẫn thưởng thức được vị ngon ngọt tự nhiên của rau và nấm.");
        rau12.put("formatly", Arrays.asList("Ăn trưa"));
        rau12.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        rau12.put("image", "rau12");
        rau12.put("link", "link ne");
        rau12.put("material", Arrays.asList("Ma1", "Ma2"));
        rau12.put("nameFood", "Canh hầm rau củ");
        rau12.put("rating", 4.7);
        rau12.put("region", Arrays.asList("Miền Trung"));
        rau12.put("session", Arrays.asList("Mùa Mưa"));
        rau12.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("rau12").set(rau12);

        Map<String, Object> rau13 = new HashMap<>();
        rau13.put("decription", "Chuẩn bị:\n" +
                "\n" +
                "250g cải thìa, rửa sạch thái miếng vừa ăn\n" +
                "2 thìa dầu thực vật\n" +
                "4 cái nấm (hương, đông cô, mỡ tùy chọn)\n" +
                "3 nhánh tỏi băm nhỏ\n" +
                "½ thìa cà phê muối\n"+
                "Cách làm:\n" +
                "\n" +
                "Bước 1: Cho dầu vào nồi phi thơm với tỏi, xào sơ qua nấm\n" +
                "\n" +
                "Bước 2: Giữ lửa lớn, cho tiếp cải thìa đã sơ chế vào xào nhanh tay, nêm thêm ít muối là hoàn thành.\n" +
                "\n" +
                "Với cách chế biến này bạn sẽ không cần quá nhiều gia vị mà vẫn thưởng thức được vị ngon ngọt tự nhiên của rau và nấm.");
        rau13.put("formatly", Arrays.asList("Ăn trưa"));
        rau13.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        rau13.put("image", "rau13");
        rau13.put("link", "link ne");
        rau13.put("material", Arrays.asList("Ma1", "Ma2"));
        rau13.put("nameFood", "Món cà tím xào");
        rau13.put("rating", 4.7);
        rau13.put("region", Arrays.asList("Miền Trung"));
        rau13.put("session", Arrays.asList("Mùa Mưa"));
        rau13.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("rau13").set(rau13);


        Map<String, Object> rau14 = new HashMap<>();
        rau14.put("decription", "Chuẩn bị:\n" +
                "\n" +
                "250g cải thìa, rửa sạch thái miếng vừa ăn\n" +
                "2 thìa dầu thực vật\n" +
                "4 cái nấm (hương, đông cô, mỡ tùy chọn)\n" +
                "3 nhánh tỏi băm nhỏ\n" +
                "½ thìa cà phê muối\n"+
                "Cách làm:\n" +
                "\n" +
                "Bước 1: Cho dầu vào nồi phi thơm với tỏi, xào sơ qua nấm\n" +
                "\n" +
                "Bước 2: Giữ lửa lớn, cho tiếp cải thìa đã sơ chế vào xào nhanh tay, nêm thêm ít muối là hoàn thành.\n" +
                "\n" +
                "Với cách chế biến này bạn sẽ không cần quá nhiều gia vị mà vẫn thưởng thức được vị ngon ngọt tự nhiên của rau và nấm.");
        rau14.put("formatly", Arrays.asList("Ăn tối"));
        rau14.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        rau14.put("image", "rau14");
        rau14.put("link", "link ne");
        rau14.put("material", Arrays.asList("Ma1", "Ma2"));
        rau14.put("nameFood", "Cải thảo xào giấm");
        rau14.put("rating", 4.7);
        rau14.put("region", Arrays.asList("Miền Trung"));
        rau14.put("session", Arrays.asList("Mùa Mưa"));
        rau14.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("rau14").set(rau14);


        Map<String, Object> rau15 = new HashMap<>();
        rau15.put("decription", "Chuẩn bị:\n" +
                "\n" +
                "250g cải thìa, rửa sạch thái miếng vừa ăn\n" +
                "2 thìa dầu thực vật\n" +
                "4 cái nấm (hương, đông cô, mỡ tùy chọn)\n" +
                "3 nhánh tỏi băm nhỏ\n" +
                "½ thìa cà phê muối\n"+
                "Cách làm:\n" +
                "\n" +
                "Bước 1: Cho dầu vào nồi phi thơm với tỏi, xào sơ qua nấm\n" +
                "\n" +
                "Bước 2: Giữ lửa lớn, cho tiếp cải thìa đã sơ chế vào xào nhanh tay, nêm thêm ít muối là hoàn thành.\n" +
                "\n" +
                "Với cách chế biến này bạn sẽ không cần quá nhiều gia vị mà vẫn thưởng thức được vị ngon ngọt tự nhiên của rau và nấm.");
        rau15.put("formatly", Arrays.asList("Ăn trưa"));
        rau15.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        rau15.put("image", "rau15");
        rau15.put("link", "link ne");
        rau15.put("material", Arrays.asList("Ma1", "Ma2"));
        rau15.put("nameFood", "Cải thảo luộc kiểu mới");
        rau15.put("rating", 4.7);
        rau15.put("region", Arrays.asList("Miền Trung"));
        rau15.put("session", Arrays.asList("Mùa Mưa"));
        rau15.put("groupPerson",Arrays.asList("Tăng cân"));
        foods.document("rau15").set(rau15);










        CollectionReference rating = db.collection("rating");

        Map<String, Object> rating1 = new HashMap<>();
        rating1.put("user", "chung123");
        rating1.put("foodID", "Heo2");
        rating1.put("pointRate", 4);
        rating.document("rating1").set(rating1);

        Map<String, Object> rating2 = new HashMap<>();
        rating2.put("user", "duc123");
        rating2.put("foodID", "Heo2");
        rating2.put("pointRate", 5);
        rating.document("rating2").set(rating2);

        Map<String, Object> rating3 = new HashMap<>();
        rating3.put("user", "hoi123");
        rating3.put("foodID", "Heo2");
        rating3.put("pointRate", 5);
        rating.document("rating3").set(rating3);

        Map<String, Object> rating4 = new HashMap<>();
        rating4.put("user", "hoipv");
        rating4.put("foodID", "Heo2");
        rating4.put("pointRate", 5);
        rating.document("rating4").set(rating4);


        Map<String, Object> rating5 = new HashMap<>();
        rating5.put("user", "hungnk");
        rating5.put("foodID", "Heo2");
        rating5.put("pointRate", 4);
        rating.document("rating2").set(rating5);

        Map<String, Object> rating6 = new HashMap<>();
        rating6.put("user", "nghiatnh1");
        rating6.put("foodID", "Heo2");
        rating6.put("pointRate", 1);
        rating.document("rating6").set(rating6);

        Map<String, Object> rating7 = new HashMap<>();
        rating7.put("user", "phuc123");
        rating7.put("foodID", "Heo2");
        rating7.put("pointRate", 5);
        rating.document("rating7").set(rating7);

        Map<String, Object> rating8 = new HashMap<>();
        rating8.put("user", "duc123");
        rating8.put("foodID", "Heo2");
        rating8.put("pointRate", 2);
        rating.document("rating8").set(rating8);

        Map<String, Object> rating9 = new HashMap<>();
        rating9.put("user", "son123");
        rating9.put("foodID", "Heo2");
        rating9.put("pointRate", 4);
        rating.document("rating9").set(rating9);

        Map<String, Object> rating10 = new HashMap<>();
        rating10.put("user", "tuyen123");
        rating10.put("foodID", "Heo2");
        rating10.put("pointRate", 3);
        rating.document("rating10").set(rating10);

        //-------------------------------------Start Raiting-------------------------------
        //Anvn01,HanhT01,HungTH01,nghiatnh1,tritcm
        //Heo7, Heo1, rau10, rau9, rau12, Heo2

        Map<String, Object> ratingAnvn01H7 = new HashMap<>();
        ratingAnvn01H7.put("user", "Anvn01");
        ratingAnvn01H7.put("foodID", "Heo7");
        ratingAnvn01H7.put("pointRate", 1);
        rating.document("ratingAnvn01H7").set(ratingAnvn01H7);

        Map<String, Object> ratingAnvn01H1 = new HashMap<>();
        ratingAnvn01H1.put("user", "Anvn01");
        ratingAnvn01H1.put("foodID", "Heo1");
        ratingAnvn01H1.put("pointRate", 5);
        rating.document("ratingAnvn01H1").set(ratingAnvn01H1);

        Map<String, Object> ratingAnvn01r10 = new HashMap<>();
        ratingAnvn01r10.put("user", "Anvn01");
        ratingAnvn01r10.put("foodID", "rau10");
        ratingAnvn01r10.put("pointRate", 4);
        rating.document("ratingAnvn01r10").set(ratingAnvn01r10);

        Map<String, Object> ratingAnvn01r12 = new HashMap<>();
        ratingAnvn01r12.put("user", "Anvn01");
        ratingAnvn01r12.put("foodID", "rau12");
        ratingAnvn01r12.put("pointRate", 3);
        rating.document("ratingAnvn01r12").set(ratingAnvn01r12);


        //HanhT01,HungTH01,nghiatnh1,tritcm
        //Heo7, Heo1, rau10, rau9, rau12, Heo2
        Map<String, Object> ratingHanhT01H2 = new HashMap<>();
        ratingHanhT01H2.put("user", "HanhT01");
        ratingHanhT01H2.put("foodID", "Heo2");
        ratingHanhT01H2.put("pointRate", 4);
        rating.document("ratingHanhT01H2").set(ratingHanhT01H2);

        Map<String, Object> ratingHanhT01H7 = new HashMap<>();
        ratingHanhT01H7.put("user", "HanhT01");
        ratingHanhT01H7.put("foodID", "Heo7");
        ratingHanhT01H7.put("pointRate", 5);
        rating.document("ratingHanhT01H7").set(ratingHanhT01H7);

        Map<String, Object> ratingHanhT01r10 = new HashMap<>();
        ratingHanhT01r10.put("user", "HanhT01");
        ratingHanhT01r10.put("foodID", "rau10");
        ratingHanhT01r10.put("pointRate", 4);
        rating.document("ratingHanhT01r10").set(ratingHanhT01r10);

        Map<String, Object> ratingHanhT01r9 = new HashMap<>();
        ratingHanhT01r9.put("user", "HanhT01");
        ratingHanhT01r9.put("foodID", "rau9");
        ratingHanhT01r9.put("pointRate", 5);
        rating.document("ratingHanhT01r9").set(ratingHanhT01r9);

        Map<String, Object> ratingHanhT01r12 = new HashMap<>();
        ratingHanhT01r12.put("user", "HanhT01");
        ratingHanhT01r12.put("foodID", "Heo2");
        ratingHanhT01r12.put("pointRate", 1);
        rating.document("ratingHanhT01r12").set(ratingHanhT01r12);

        Map<String, Object> ratingHanhT01H1 = new HashMap<>();
        ratingHanhT01H1.put("user", "HanhT01");
        ratingHanhT01H1.put("foodID", "Heo1");
        ratingHanhT01H1.put("pointRate", 2);
        rating.document("ratingHanhT01H1").set(ratingHanhT01H1);



        //HungTH01,nghiatnh1,tritcm
        //Heo7, Heo1, rau10, rau9, rau12, Heo2

        Map<String, Object> ratingHungTH01H7 = new HashMap<>();
        ratingHungTH01H7.put("user", "HungTH01");
        ratingHungTH01H7.put("foodID", "Heo7");
        ratingHungTH01H7.put("pointRate", 5);
        rating.document("ratingHungTH01H7").set(ratingHungTH01H7);

        Map<String, Object> ratingHungTH01r10 = new HashMap<>();
        ratingHungTH01r10.put("user", "HungTH01");
        ratingHungTH01r10.put("foodID", "rau10");
        ratingHungTH01r10.put("pointRate", 4);
        rating.document("ratingHungTH01r10").set(ratingHungTH01r10);

        Map<String, Object> ratingHungTH01rau9 = new HashMap<>();
        ratingHungTH01rau9.put("user", "HungTH01");
        ratingHungTH01rau9.put("foodID", "rau9");
        ratingHungTH01rau9.put("pointRate", 2);
        rating.document("ratingHungTH01rau9").set(ratingHungTH01rau9);

        Map<String, Object> ratingHungTH01r12 = new HashMap<>();
        ratingHungTH01r12.put("user", "HungTH01");
        ratingHungTH01r12.put("foodID", "rau12");
        ratingHungTH01r12.put("pointRate", 4);
        rating.document("ratingHungTH01r12").set(ratingHungTH01r12);

        Map<String, Object> ratingHungTH01H2 = new HashMap<>();
        ratingHungTH01H2.put("user", "HungTH01");
        ratingHungTH01H2.put("foodID", "Heo2");
        ratingHungTH01H2.put("pointRate", 3);
        rating.document("ratingHungTH01H2").set(ratingHungTH01H2);



        //nghiatnh1,tritcm
        //Heo7, Heo1, rau10, rau9, rau12, Heo2

        Map<String, Object> ratingnghiatnh1H7 = new HashMap<>();
        ratingnghiatnh1H7.put("user", "nghiatnh1");
        ratingnghiatnh1H7.put("foodID", "Heo7");
        ratingnghiatnh1H7.put("pointRate", 5);
        rating.document("ratingnghiatnh1H7").set(ratingnghiatnh1H7);

        Map<String, Object> ratingnghiatnh1H1 = new HashMap<>();
        ratingnghiatnh1H1.put("user", "nghiatnh1");
        ratingnghiatnh1H1.put("foodID", "Heo1");
        ratingnghiatnh1H1.put("pointRate", 1);
        rating.document("ratingnghiatnh1H1").set(ratingnghiatnh1H1);

        Map<String, Object> ratingnghiatnh1r10 = new HashMap<>();
        ratingnghiatnh1r10.put("user", "nghiatnh1");
        ratingnghiatnh1r10.put("foodID", "rau10");
        ratingnghiatnh1r10.put("pointRate", 3);
        rating.document("ratingnghiatnh1r10").set(ratingnghiatnh1r10);

        Map<String, Object> ratingnghiatnh1r9 = new HashMap<>();
        ratingnghiatnh1r9.put("user", "nghiatnh1");
        ratingnghiatnh1r9.put("foodID", "rau9");
        ratingnghiatnh1r9.put("pointRate", 4);
        rating.document("ratingnghiatnh1r9").set(ratingnghiatnh1r9);

        //tritcm
        //Heo7, Heo1, rau10, rau9, rau12, Heo2

        Map<String, Object> ratingtritcmH7 = new HashMap<>();
        ratingtritcmH7.put("user", "tritcm");
        ratingtritcmH7.put("foodID", "Heo7");
        ratingtritcmH7.put("pointRate", 2);
        rating.document("ratingtritcmH7").set(ratingtritcmH7);

        Map<String, Object> ratingtritcmH1 = new HashMap<>();
        ratingtritcmH1.put("user", "tritcm");
        ratingtritcmH1.put("foodID", "Heo1");
        ratingtritcmH1.put("pointRate", 1);
        rating.document("ratingtritcmH1").set(ratingtritcmH1);

        Map<String, Object> ratingtritcmr10 = new HashMap<>();
        ratingtritcmr10.put("user", "tritcm");
        ratingtritcmr10.put("foodID", "rau10");
        ratingtritcmr10.put("pointRate", 5);
        rating.document("ratingtritcmr10").set(ratingtritcmr10);

        Map<String, Object> ratingtritcmrau9 = new HashMap<>();
        ratingtritcmrau9.put("user", "tritcm");
        ratingtritcmrau9.put("foodID", "rau9");
        ratingtritcmrau9.put("pointRate", 4);
        rating.document("ratingtritcmrau9").set(ratingtritcmrau9);

        Map<String, Object> ratingtritcmr12 = new HashMap<>();
        ratingtritcmr12.put("user", "tritcm");
        ratingtritcmr12.put("foodID", "rau9");
        ratingtritcmr12.put("pointRate", 2);
        rating.document("ratingtritcmr12").set(ratingtritcmr12);



        //hungnk
        //Heo7, Heo1, rau10, rau9, rau12, Heo2
        Map<String, Object> ratinghungnkH7 = new HashMap<>();
        ratinghungnkH7.put("user", "hungnk");
        ratinghungnkH7.put("foodID", "Heo7");
        ratinghungnkH7.put("pointRate", 2);
        rating.document("ratinghungnkH7").set(ratinghungnkH7);

        Map<String, Object> ratinghungnkH1 = new HashMap<>();
        ratinghungnkH1.put("user", "hungnk");
        ratinghungnkH1.put("foodID", "Heo1");
        ratinghungnkH1.put("pointRate", 1);
        rating.document("ratinghungnkH1").set(ratinghungnkH1);

        Map<String, Object> ratinghungnkr10 = new HashMap<>();
        ratinghungnkr10.put("user", "hungnk");
        ratinghungnkr10.put("foodID", "rau10");
        ratinghungnkr10.put("pointRate", 5);
        rating.document("ratinghungnkr10").set(ratinghungnkr10);

        Map<String, Object> ratinghungnkr9 = new HashMap<>();
        ratinghungnkr9.put("user", "hungnk");
        ratinghungnkr9.put("foodID", "rau9");
        ratinghungnkr9.put("pointRate", 4);
        rating.document("ratinghungnkr9").set(ratinghungnkr9);

        //-------------------------------------End Raiting--------------------------------


        // Create a query against the collection.
        //Query query = foods.whereEqualTo("formatly", "Bữa Trưa"); //Lấy thuộc tính formatly có bữa tối

    }

    public void addNewDocument(Map<String, food> newDocument) {
        db.collection("foods")
                .add(newDocument)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        //Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //Log.w(TAG, "Error adding document", e);
                    }
                });
    }

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
                            if (bundle == null) {
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


                                    listAdap.add(new food(nameFood, image, rating));
                                    food food = new food(document.getId(),decription, formatly, illness, image, link, material, nameFood, rating, region, session);
                                    listFullData.add(food);
                                    //Log.d(TAG, document.getId() + " => " + document.getData());

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
                                    String keySearch = bundle.getString("keySearch");
                                    if (document.getData().get("nameFood").toString().toLowerCase().contains(keySearch.toLowerCase())) {

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


                                        listAdap.add(new food(nameFood, image, rating));
                                        food food = new food(document.getId(),decription, formatly, illness, image, link, material, nameFood, rating, region, session);
                                        listFullData.add(food);
                                        //Log.d(TAG, document.getId() + " => " + document.getData());

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
        insertDataFood();
        getListRating();
        super.onCreate(savedInstanceState);
    }


    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        listAdap = new ArrayList<>();
        listFullData = new ArrayList<>();
        listSang = new ArrayList<>();
        listTrua = new ArrayList<>();
        listToi = new ArrayList<>();
        //insertDataFood();
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        bundle = getArguments();

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
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mLayoutManager.scrollToPosition(0);//Thiết lập phần tử mặc định nếu muốn
        recyclerView1.setHasFixedSize(true);//Mượt hơn nếu k cập nhập gì
        recyclerView1.setLayoutManager(mLayoutManager1);

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



        foodRecyclerViewImageAdapter = new FoodRecyclerViewImageAdapter(getContext(), listFullData, listFullData);
        foodRecyclerViewAdapter = new FoodRecyclerViewAdapter(getContext(), listFullData, listFullData);
        recyclerView.setAdapter(foodRecyclerViewImageAdapter);
        recyclerView1.setAdapter(foodRecyclerViewAdapter);
    }
}
