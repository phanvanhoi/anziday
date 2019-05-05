package com.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.bean.InforMedic;
import com.bean.Medic;
import com.bean.Prescrip;

public class PrescripManagementForm extends ActionForm{
	public String getAddictname() {
		return addictname;
	}
	public void setAddictname(String addictname) {
		this.addictname = addictname;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	private String addictname;
	private String birthday;
	private String prescripid;
	private String addictsid;
	private String startdate;
	private String enddate;
	private String status;
	private String inforMedicid;
	private String medicid;
	private String numpertime;
	private String guideline;
	private List<Prescrip> listpre;
	private List<InforMedic> listinformedic;
	private List<Medic> listmedic;
	public List<Medic> getListmedic() {
		return listmedic;
	}
	public void setListmedic(List<Medic> listmedic) {
		this.listmedic = listmedic;
	}
	public String getPrescripid() {
		return prescripid;
	}
	public void setPrescripid(String prescripid) {
		this.prescripid = prescripid;
	}
	public String getAddictsid() {
		return addictsid;
	}
	public void setAddictsid(String addictsid) {
		this.addictsid = addictsid;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInforMedicid() {
		return inforMedicid;
	}
	public void setInforMedicid(String inforMedicid) {
		this.inforMedicid = inforMedicid;
	}
	public String getMedicid() {
		return medicid;
	}
	public void setMedicid(String medicid) {
		this.medicid = medicid;
	}
	public String getNumpertime() {
		return numpertime;
	}
	public void setNumpertime(String numpertime) {
		this.numpertime = numpertime;
	}
	public String getGuideline() {
		return guideline;
	}
	public void setGuideline(String guideline) {
		this.guideline = guideline;
	}
	public List<Prescrip> getListpre() {
		return listpre;
	}
	public void setListpre(List<Prescrip> listpre) {
		this.listpre = listpre;
	}
	public List<InforMedic> getListinformedic() {
		return listinformedic;
	}
	public void setListinformedic(List<InforMedic> listinformedic) {
		this.listinformedic = listinformedic;
	}

}
