package com.his.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSON;
import com.his.entity.Drug;
import com.his.entity.Pmoudle;
import com.his.entity.User;
import com.his.service.CaseresumeService;
import com.his.service.DrugItemService;
import com.his.service.DrugService;
import com.his.service.PmoudleService;
import com.his.service.PrescriptionService;
import com.his.service.RegisterService;

@Controller
@SessionAttributes(value= {"drugList", "pmoudleList", "user"})
public class SystemBaseController
{
	@Autowired
	private CaseresumeService caseresumeService;
	
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private DrugService drugService;
	
	@Autowired
	private PmoudleService pmoudleService;
	
	@Autowired
	private PrescriptionService prescriptionService;
	
	@Autowired
	private DrugItemService drugItemService;
	
	/**
	 * 返回控制页面方法
	 * @return
	 */
	@RequestMapping("/system-base")
	public String systemBase(Model model)
	{
		drugService.displayAll(model);
		pmoudleService.displayAll(model);
		
        return "system-base";
	}
	
	/**
	 * 保存病例首页信息
	 */
	@RequestMapping("system-base/save")
	@ResponseBody
	public int save(@RequestBody String body)
	{
		System.out.println("system-base页面save方法执行...");

		@SuppressWarnings("rawtypes")
		Map maps = (Map)JSON.parse(body);
		
		String registerID = (String) maps.get("registerID");
		String mainSuit = (String) maps.get("mainSuit");
		String HPI = (String) maps.get("HPI");
		String SHP = (String) maps.get("SHP");
		String PS = (String) maps.get("PS");
		String allergies = (String) maps.get("allergies");
		String examination = (String) maps.get("examination");

		caseresumeService.saveMainSuit(registerID, mainSuit, HPI, SHP, PS, allergies, examination);
		
		registerService.inTreatment(registerID);
		
		return 0;
	}
	/**
	 * 保存病例首页信息
	 */
	@RequestMapping("system-base/searchDrug")
	@ResponseBody
	public List<Drug> searchDrug(@RequestBody String body, ModelMap modelMap)
	{
		System.out.println("system-base页面searchDrug方法执行...");

		@SuppressWarnings("rawtypes")
		Map maps = (Map)JSON.parse(body);
		
		String searchText = (String) maps.get("searchText");
		
		
		@SuppressWarnings("unchecked")
		List<Drug> drugList = (List<Drug>)modelMap.get("drugList");
		
		List<Drug> currentDrugList = new ArrayList<>();
		for(Drug d : drugList)
		{
			if(d.getManemonicCode().indexOf(searchText) != -1 || d.getDrugName().indexOf(searchText) != -1)
			{
				currentDrugList.add(d);
			}
		}
		
		return currentDrugList;
	}
	
	/**
	 * 保存病例首页信息
	 */
	@RequestMapping("system-base/searchPmoudle")
	@ResponseBody
	public List<Pmoudle> searchPmoudle(@RequestBody String body, ModelMap modelMap)
	{
		System.out.println("system-base页面searchPmoudle方法执行...");

		@SuppressWarnings("rawtypes")
		Map maps = (Map)JSON.parse(body);
		
		String searchText = (String) maps.get("searchText");
		
		@SuppressWarnings("unchecked")
		List<Pmoudle> pmoudleList = (List<Pmoudle>)modelMap.get("pmoudleList");
		
		List<Pmoudle> currentPmoudleList = new ArrayList<>();
		for(Pmoudle p : pmoudleList)
		{
			if(p.getMoudleName().indexOf(searchText) != -1)
			{
				currentPmoudleList.add(p);
			}
		}
		
		return currentPmoudleList;
	}
	
	/**
	 * 保存病例首页信息
	 */
	@RequestMapping("system-base/getDrugList")
	@ResponseBody
	public List<Drug> getDrugList(ModelMap modelMap)
	{
		@SuppressWarnings("unchecked")
		List<Drug> drugList = (List<Drug>)modelMap.get("drugList");
		
		return drugList;
	}
	
	/**
	 * 保存病例首页信息
	 */
	@RequestMapping("system-base/pickPmoudle")
	@ResponseBody
	public List<Drug> pickPmoudle(@RequestBody String body)
	{
		@SuppressWarnings("rawtypes")
		Map maps = (Map)JSON.parse(body);
		
		String pPrescriptID = (String)maps.get("pPrescriptID");
		List<Drug> pmoudleList = pmoudleService.getPmoudle(pPrescriptID);
		return pmoudleList;
	}
	
	/**
	 * 保存病例首页信息
	 */
	@RequestMapping("system-base/getPmoudleList")
	@ResponseBody
	public List<Pmoudle> getPmoudleList(ModelMap modelMap)
	{
		@SuppressWarnings("unchecked")
		List<Pmoudle> pmoudleList = (List<Pmoudle>)modelMap.get("pmoudleList");
		
		return pmoudleList;
	}
	
	/**
	 * 保存病例首页信息
	 */
	@RequestMapping("system-base/savePrescription")
	@ResponseBody
	public int savePrescription(@RequestBody String body, ModelMap modelMap)
	{
		System.out.println("system-base页面savePrescription方法执行...");

		@SuppressWarnings("rawtypes")
		Map maps = (Map)JSON.parse(body);
		
		String registerID = (String) maps.get("registerID");
		System.out.println(maps);
		
		List<Drug> prescriptionList = new ArrayList<>();

		for(int i = 0; i < (maps.size() - 1) / 2; i++)
		{
			String number = (String) maps.get("number[" + i + "]");
			String drugID = (String) maps.get("drugID[" + i + "]");
			Drug drugItem = new Drug();
			drugItem.setNumber(number);
			drugItem.setDrugID(drugID);
			prescriptionList.add(drugItem);
		}
		
		
		
		User user = (User)modelMap.get("user");
		String docID = Integer.toString(user.getUserID());
		//获得当前时间
		Date date = new Date();   
		Timestamp currentTime = new Timestamp(date.getTime());
		
		//在prescription列表中添加项目,绑定registerID 返回相应处方号
		String prescriptionID = prescriptionService.maxPrescripID();
		prescriptionService.addPrescription(prescriptionID, registerID, currentTime);
		
		//在drugItem中加入所有药物
		drugItemService.addPrescription(prescriptionID, prescriptionList, currentTime, docID);
		
		//即为就诊
		registerService.inTreatment(registerID);
		
		return 0;
	}
}
