package com.his.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Caseresume implements Serializable
{
	private Integer registerID;
	private String mainSuit;
	private String HPI;
	private String SHP;
	private String PS;
	private String allergies;
	private String examination;
	private String preDiagnosis;
	private String recommend;
	private String subInformation;
	private String obInformation;
	private String diseID;
	private String programme;
	private String finalDiagnostic;
	private Integer settleState;
	
	public Caseresume() {
		super();
		this.registerID = null;
		this.mainSuit = "";
		HPI = "";
		SHP = "";
		PS = "";
		this.allergies = "";
		this.examination = "";
		this.preDiagnosis = "";
		this.recommend = "";
		this.subInformation = "";
		this.obInformation = "";
		this.diseID = "";
		this.programme = "";
		this.finalDiagnostic = "";
		this.settleState = null;
	}
	
	public Integer getRegisterID() {
		return registerID;
	}
	public void setRegisterID(Integer registerID) {
		this.registerID = registerID;
	}
	public String getMainSuit() {
		return mainSuit;
	}
	public void setMainSuit(String mainSuit) {
		this.mainSuit = mainSuit;
	}
	public String getHPI() {
		return HPI;
	}
	public void setHPI(String hPI) {
		HPI = hPI;
	}
	public String getSHP() {
		return SHP;
	}
	public void setSHP(String sHP) {
		SHP = sHP;
	}
	public String getPS() {
		return PS;
	}
	public void setPS(String pS) {
		PS = pS;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	public String getExamination() {
		return examination;
	}
	public void setExamination(String examination) {
		this.examination = examination;
	}
	public String getPreDiagnosis() {
		return preDiagnosis;
	}
	public void setPreDiagnosis(String preDiagnosis) {
		this.preDiagnosis = preDiagnosis;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public String getSubInformation() {
		return subInformation;
	}
	public void setSubInformation(String subInformation) {
		this.subInformation = subInformation;
	}
	public String getObInformation() {
		return obInformation;
	}
	public void setObInformation(String obInformation) {
		this.obInformation = obInformation;
	}
	public String getDiseID() {
		return diseID;
	}
	public void setDiseID(String diseID) {
		this.diseID = diseID;
	}
	public String getProgramme() {
		return programme;
	}
	public void setProgramme(String programme) {
		this.programme = programme;
	}
	public String getFinalDiagnostic() {
		return finalDiagnostic;
	}
	public void setFinalDiagnostic(String finalDiagnostic) {
		this.finalDiagnostic = finalDiagnostic;
	}
	public Integer getSettleState() {
		return settleState;
	}
	public void setSettleState(Integer settleState) {
		this.settleState = settleState;
	}
	@Override
	public String toString() {
		return "Caseresume [registerID=" + registerID + ", mainSuit=" + mainSuit + ", HPI=" + HPI + ", SHP=" + SHP
				+ ", PS=" + PS + ", allergies=" + allergies + ", examination=" + examination + ", preDiagnosis="
				+ preDiagnosis + ", recommend=" + recommend + ", subInformation=" + subInformation + ", obInformation="
				+ obInformation + ", diseID=" + diseID + ", programme=" + programme + ", finalDiagnostic="
				+ finalDiagnostic + ", settleState=" + settleState + "]";
	}
}