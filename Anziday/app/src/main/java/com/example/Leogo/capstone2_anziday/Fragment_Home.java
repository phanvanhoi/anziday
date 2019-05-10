package com.example.Leogo.capstone2_anziday;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    private FirebaseFirestore db;
    private MainActivity myContext;
    Bundle bundle = null;

    public void insertDataFood() {
        db = FirebaseFirestore.getInstance();
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
        Heo1.put("formatly", Arrays.asList("Ăn trưa","Ăn tối"));
        Heo1.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        Heo1.put("image", "heo1");
        Heo1.put("link", "https://heo1.html");
        Heo1.put("material", Arrays.asList("Ma1", "Ma2"));
        Heo1.put("nameFood", "Thịt heo chiên xóc tỏi trưa");
        Heo1.put("rating", 4.7);
        Heo1.put("region", Arrays.asList("Miền Trung"));
        Heo1.put("session", Arrays.asList("Mùa Mưa"));
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
        Heo2.put("formatly", Arrays.asList("Ăn trưa","Ăn tối"));
        Heo2.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        Heo2.put("image", "heo2");
        Heo2.put("link", "link ne");
        Heo2.put("material", Arrays.asList("Ma1", "Ma2"));
        Heo2.put("nameFood", "Thịt heo hầm cà rốt");
        Heo2.put("rating", 4.7);
        Heo2.put("region", Arrays.asList("Miền Trung"));
        Heo2.put("session", Arrays.asList("Mùa Mưa"));
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
        Heo3.put("formatly", Arrays.asList("Ăn trưa","Ăn tối"));
        Heo3.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        Heo3.put("image", "heo3");
        Heo3.put("link", "link ne");
        Heo3.put("material", Arrays.asList("Ma1", "Ma2"));
        Heo3.put("nameFood", "Thịt heo bọc sả chiên giòn");
        Heo3.put("rating", 4.7);
        Heo3.put("region", Arrays.asList("Miền Trung"));
        Heo3.put("session", Arrays.asList("Mùa Mưa"));
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
        Heo4.put("formatly", Arrays.asList("Ăn trưa","Ăn tối"));
        Heo4.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        Heo4.put("image", "heo4");
        Heo4.put("link", "link ne");
        Heo4.put("material", Arrays.asList("Ma1", "Ma2"));
        Heo4.put("nameFood", "Thịt heo rang muối ớt");
        Heo4.put("rating", 4.7);
        Heo4.put("region", Arrays.asList("Miền Trung"));
        Heo4.put("session", Arrays.asList("Mùa Mưa"));
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
        Heo5.put("formatly", Arrays.asList("Ăn trưa","Ăn tối"));
        Heo5.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        Heo5.put("image", "heo5");
        Heo5.put("link", "link ne");
        Heo5.put("material", Arrays.asList("Ma1", "Ma2"));
        Heo5.put("nameFood", "Thịt heo kho mắm ruốc");
        Heo5.put("rating", 4.7);
        Heo5.put("region", Arrays.asList("Miền Trung"));
        Heo5.put("session", Arrays.asList("Mùa Mưa"));
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
        Heo6.put("formatly", Arrays.asList("Ăn trưa","Ăn tối"));
        Heo6.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        Heo6.put("image", "heo6");
        Heo6.put("link", "link ne");
        Heo6.put("material", Arrays.asList("Ma1", "Ma2"));
        Heo6.put("nameFood", "Thịt heo kho tàu");
        Heo6.put("rating", 4.7);
        Heo6.put("region", Arrays.asList("Miền Trung"));
        Heo6.put("session", Arrays.asList("Mùa Mưa"));
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
        Heo7.put("formatly", Arrays.asList("Ăn trưa","Ăn tối"));
        Heo7.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        Heo7.put("image", "heo7");
        Heo7.put("link", "link ne");
        Heo7.put("material", Arrays.asList("Ma1", "Ma2"));
        Heo7.put("nameFood", "Thịt heo cuộn măng hầm");
        Heo7.put("rating", 4.7);
        Heo7.put("region", Arrays.asList("Miền Trung"));
        Heo7.put("session", Arrays.asList("Mùa Mưa"));
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
        Heo8.put("formatly", Arrays.asList("Ăn trưa","Ăn tối"));
        Heo8.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        Heo8.put("image", "heo8");
        Heo8.put("link", "link ne");
        Heo8.put("material", Arrays.asList("Ma1", "Ma2"));
        Heo8.put("nameFood", "Thịt heo kho củ cải trắng");
        Heo8.put("rating", 4.7);
        Heo8.put("region", Arrays.asList("Miền Trung"));
        Heo8.put("session", Arrays.asList("Mùa Mưa"));
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
        Heo9.put("formatly", Arrays.asList("Ăn trưa","Ăn tối"));
        Heo9.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        Heo9.put("image", "heo9");
        Heo9.put("link", "link ne");
        Heo9.put("material", Arrays.asList("Ma1", "Ma2"));
        Heo9.put("nameFood", "Thịt heo xào lăn");
        Heo9.put("rating", 4.7);
        Heo9.put("region", Arrays.asList("Miền Trung"));
        Heo9.put("session", Arrays.asList("Mùa Mưa"));
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
        Heo10.put("formatly", Arrays.asList("Ăn trưa","Ăn tối"));
        Heo10.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        Heo10.put("image", "heo10");
        Heo10.put("link", "link ne");
        Heo10.put("material", Arrays.asList("Ma1", "Ma2"));
        Heo10.put("nameFood", "Thịt heo kho gừng");
        Heo10.put("rating", 4.7);
        Heo10.put("region", Arrays.asList("Miền Trung"));
        Heo10.put("session", Arrays.asList("Mùa Mưa"));
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
        Heo11.put("formatly", Arrays.asList("Ăn trưa","Ăn tối"));
        Heo11.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        Heo11.put("image", "heo11");
        Heo11.put("link", "link ne");
        Heo11.put("material", Arrays.asList("Ma1", "Ma2"));
        Heo11.put("nameFood", "Thịt heo xào chua ngọt");
        Heo11.put("rating", 4.7);
        Heo11.put("region", Arrays.asList("Miền Trung"));
        Heo11.put("session", Arrays.asList("Mùa Mưa"));
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
        Heo12.put("formatly", Arrays.asList("Ăn trưa","Ăn tối"));
        Heo12.put("illness", Arrays.asList("béo phì", "gout","cao huyết áp","tim mạch"));
        Heo12.put("image", "heo12");
        Heo12.put("link", "link ne");
        Heo12.put("material", Arrays.asList("Ma1", "Ma2"));
        Heo12.put("nameFood", "Thịt heo giả cầy");
        Heo12.put("rating", 4.7);
        Heo12.put("region", Arrays.asList("Miền Trung"));
        Heo12.put("session", Arrays.asList("Mùa Mưa"));
        foods.document("Heo12").set(Heo12);

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


        // Create a query against the collection.
        //Query query = foods.whereEqualTo("formatly", "Bữa Trưa"); //Lấy thuộc tính formatly có bữa tối

    }

    public void addNewDocument(Map<String, food> newDocument) {
        db.collection("foods")
                .add(newDocument)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
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
        outState.putParcelableArrayList("listAdap", listAdap);
        outState.putParcelableArrayList("listFullData", listFullData);
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
                                    DecimalFormat df = new DecimalFormat("#.0");
                                    double value = (mapRating.get(document.getData().get("foodID").toString()) +
                                            Double.parseDouble(document.getData().get("pointRate").toString())) / 2;
                                    value =Double.parseDouble(df.format(value));
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        bundle = getArguments();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        new Thread() {
            @Override
            public void run() {
                try {
                    this.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getData1();
            }
        }.start();

        myContext = (MainActivity) getContext();
        myContext.createRecycleView(listFullData, listTrua, listToi, listFullData);
        myContext.addControl();
    }
}
