package com.bean;

public class ThongTinDatLich {
	private String madatlich;
	private String makh;
	private String manhataomau;
	private String ngaygiodat;
	private String noidungyeucau;
	private String trangthai;
	private String thanhtien;
	public String getMadatlich() {
		return madatlich;
	}
	public void setMadatlich(String madatlich) {
		this.madatlich = madatlich;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public String getManhataomau() {
		return manhataomau;
	}
	public void setManhataomau(String manhataomau) {
		this.manhataomau = manhataomau;
	}
	public String getNgaygiodat() {
		return ngaygiodat;
	}
	public void setNgaygiodat(String ngaygiodat) {
		this.ngaygiodat = ngaygiodat;
	}
	public String getNoidungyeucau() {
		return noidungyeucau;
	}
	public void setNoidungyeucau(String noidungyeucau) {
		this.noidungyeucau = noidungyeucau;
	}
	public ThongTinDatLich(String madatlich, String makh, String manhataomau, String ngaygiodat, String noidungyeucau,
			String trangthai, String thanhtien) {
		super();
		this.madatlich = madatlich;
		this.makh = makh;
		this.manhataomau = manhataomau;
		this.ngaygiodat = ngaygiodat;
		this.noidungyeucau = noidungyeucau;
		this.trangthai = trangthai;
		this.thanhtien = thanhtien;
	}
	@Override
	public String toString() {
		return  madatlich+"\t"+ makh+"\t"+ manhataomau+"\t"+ ngaygiodat+"\t"+ noidungyeucau+"\t"+trangthai+"\t"+ thanhtien+"\n";
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public String getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(String thanhtien) {
		this.thanhtien = thanhtien;
	}
	
}
