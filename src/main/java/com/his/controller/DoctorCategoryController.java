package com.his.controller;

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
import com.his.entity.Caseresume;
import com.his.entity.Register;
import com.his.entity.User;
import com.his.service.CaseresumeService;
import com.his.service.RegisterService;

@Controller
@SessionAttributes(value= {"user"})
public class DoctorCategoryController {
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private CaseresumeService caseresumeService;
	/**
	 * 返回控制页面方法
	 * @return
	 */
	@RequestMapping("/doctor-category")
	public String doctorCategory(Model model, ModelMap modelMap)
	{
		System.out.println("doctorCategory页面跳转...");
		
		User user = (User)modelMap.get("user");
		Integer docID = user.getUserID();
		
		List<Register> patientQueue = registerService.ownPatientToday(docID);
		
		registerService.distinguishPatient(patientQueue, model);
		
        return "doctor-category";
	}
	
	@RequestMapping("/doctor-category/pickPatient")
	@ResponseBody
	public Caseresume pickPatient(@RequestBody String body, Model model)
	{
		System.out.println("doctorCategory页面pickPatient方法执行...");
		
		@SuppressWarnings("rawtypes")
		Map maps = (Map)JSON.parse(body);
		
		String registerID = (String) maps.get("registerID");
				
		model.addAttribute("currentRegisterID", registerID);
		
		Caseresume Item = caseresumeService.searchByRegisterID(registerID);
		
		System.out.println(Item);
		
		if(Item == null)
		{
			Item = new Caseresume();
		}
		
		return Item;
	}
}
