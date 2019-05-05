package com.common;

import com.bean.Addict;
import com.bean.Room;
import com.bean.TreatmentArea;

public class RanDomObject {
	Random rd = new Random();
	Random rdid = new Random(Random.STR_LOWER_CASE);
	
	public Addict randomAddict() {
		String x = rd.createRandomDate(1990, 2019)+"";
		String date;
		//date= x.substring(0,4) +"-"+ x.substring(5,7)+"-"+x.substring(8, 10) ;
		return new Addict(rdid.next(4), rd.autoHoTen()+"",x, rd.randomGender(), rd.autoTinh(), rdid.next(4), rd.autoHoTen()+"", rd.randomMoiQuanHe(), rd.soDienThoai(10),rd.autoTinh(), rd.randomRoomID(), rd.autoHoTen());
	}
	
	/*public Room ramdomRoom() {
		return new Room(rdid.next(4), treatmentid, numberofbeds, area)
	}*/
	
	public TreatmentArea randomTreatmentArea() {
		return new TreatmentArea(rdid.next(4), rd.randomKhuVucDieuTri(), rd.randommoTaKhuVucDieuTri());
	}
	
	public static void main(String[] args) {
		RanDomObject a = new RanDomObject();
		System.out.println(a.randomAddict());
		TreatmentArea ax = a.randomTreatmentArea();
		System.out.println(ax.getTreatmentid() + ax.getTreatmentname() + ax.getDescription() );
	}
}
