package com.his.service;

import java.util.List;

import org.springframework.ui.Model;

import com.his.entity.Register;

public interface RegisterService
{
	/**
	 * 添加挂号项目
	 * @param caseID
	 * @param newNote
	 * @param docID
	 * @param depID
	 * @param levID
	 * @param chargeID
	 * @param chargeType
	 * @param price
	 * @param settlement
	 * @param regType
	 * @return
	 */
	boolean addRegister(String caseID,String newNote,String docID,String depID,String levID, String chargeID, String chargeType, String price, String settlement, Integer receiptNumber, String regType, String appointDate);
	
	/**
	 * 查找当日该caseID的挂号记录
	 * @param caseID
	 * @return
	 */
	List<Register> searchToday(String caseID);
	
	/**
	 * 取消挂号项目
	 * @param registerID
	 */
	void cancelRegister(String registerID);
	
	/**
	 * 找出医生所治疗的当前的所有患者
	 * @param docID
	 * @return
	 */
	List<Register> ownPatientToday(Integer docID);
	
	/**
	 * 将患者列表中的患者进行区分
	 * @param patientQueue
	 * @param model
	 */
	void distinguishPatient(List<Register> patientQueue, Model model);
	
	/**
	 * 病人就医
	 * @param registerID
	 */
	void inTreatment(String registerID);
	
	Register isRepeat(String caseID, String depID, String docID);
}
