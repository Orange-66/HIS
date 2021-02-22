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

import com.alibaba.fastjson.JSON;
import com.his.entity.Case;
import com.his.entity.Receipt;
import com.his.entity.Register;
import com.his.service.CaseService;
import com.his.service.ChargeService;
import com.his.service.RegisterService;
import com.his.service.RegtableService;

@Controller
public class MemberCancelController
{
	@Autowired
	private CaseService caseService;
	
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private ChargeService chargeService;
	
	@Autowired
	private RegtableService regtableService;
	
	/**
	 * 返回控制页面方法
	 * @return
	 */
	@RequestMapping("/member-cancel")
	public String memberCancel(Model model, ModelMap modelMap)
	{
		System.out.println("跳转至member-cancel页面...");
		
        return "member-cancel";
	}
	
	@RequestMapping("/member-cancel/searchRegister")
	@ResponseBody
	public List<Register> searchRegister(@RequestBody String body, Model model)
	{
		System.out.println("member-cancel页面searchRegister方法执行...");

		@SuppressWarnings("rawtypes")
		Map maps = (Map)JSON.parse(body);
		
		System.out.println("!");
		System.out.println(maps.get("caseID"));
		System.out.println("!");
		
		String caseID = (String) maps.get("caseID");
		
		List<Register> registerList = registerService.searchToday(caseID);

		System.out.println(registerList);

        return registerList;
	}
	
	@RequestMapping("/member-cancel/searchPatient")
	@ResponseBody
	public Case searchPatient(@RequestBody String body)
	{
		System.out.println("member-cancel页面searchPatient方法执行...");

		@SuppressWarnings("rawtypes")
		Map maps = (Map)JSON.parse(body);

		System.out.println("!");
		System.out.println(maps.get("caseID"));
		System.out.println("!");
		
		Case caseItem = caseService.searchByCaseID((String) maps.get("caseID"));

		if(caseItem == null)
		{
			return new Case();
		}
		else
		{
			return caseItem;
		}
	}
	
	@RequestMapping("/member-cancel/cancelRegister")
	@ResponseBody
	public List<Register> cancelRegister(@RequestBody String body)
	{
		System.out.println("member-cancel页面cancelRegister方法执行...");
		
		@SuppressWarnings("rawtypes")
		Map maps = (Map)JSON.parse(body);
		
		System.out.println("jah:"+ maps);
		
		String caseID = (String)maps.get("caseID");
		String registerID = (String)maps.get("registerID");
		
		//将挂号表格中的挂号状态进行更改--
		registerService.cancelRegister(registerID);
		System.out.println("将挂号表格中的挂号状态进行更改--步骤完成！--记得取消注释");
		
		//获得一个空的发票项目
		String receiptNumber = Integer.toString(chargeService.createEmptyItem());
		System.out.println("receiptNumber："+receiptNumber);
		System.out.println("获得一个空的发票项目--步骤完成！");
		
		//用该发票号填充原发票项目的冲红发票位置
		Receipt receiptItem = chargeService.addRefundID(registerID, "3", "40", receiptNumber);
		System.out.println("receiptItem："+receiptItem);
		System.out.println("用该发票号填充原发票项目的冲红发票位置--步骤完成！");
		
		//利用原发票项目的信息填充冲红发票内容
		chargeService.insertRefund(receiptItem, receiptNumber);
		System.out.println("利用原发票项目的信息填充冲红发票内容--步骤完成！");
		
		String date = (String)maps.get("currentTime");
		String docID = (String)maps.get("docid");
		String regType = (String)maps.get("regType");
		regtableService.cancelATicket(date, docID, regType);
		
		List<Register> registerList = registerService.searchToday(caseID);
		
        return registerList;
	}
}
