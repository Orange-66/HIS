package com.his.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.his.entity.Charge;
import com.his.entity.Drug;
import com.his.service.ChargeService;
import com.his.service.DrugItemService;

@Controller
public class DrugDistributeController {
	
	@Autowired
	private ChargeService chargeService;
	
	@Autowired
	private DrugItemService drugItemService;
	/**
	 * 返回控制页面方法
	 * @return
	 */
	@RequestMapping("/drug-distribute")
	public String drugDistribute()
	{
        return "drug-distribute";
	}
	
	@RequestMapping("/drug-distribute/searchDrug")
	@ResponseBody
	public List<Charge> searchDrug(@RequestBody String body)
	{
		System.out.println("article-list页面searchItem方法执行...");

		@SuppressWarnings("rawtypes")
		Map maps = (Map)JSON.parse(body);
		
		String caseID = (String) maps.get("caseID");
		List<Charge> tempList = chargeService.distributeByCaseID(caseID);
		List<Charge> chargeList = new ArrayList<>();
		for(Charge c : tempList)
		{
			if(c.getItemState().equals("2"))
			{
				chargeList.add(c);
			}
		}
		
        return chargeList;
	}
	
	@RequestMapping("/drug-distribute/submit")
	@ResponseBody
	public int submit(@RequestBody String body)
	{
		System.out.println("article-list页面submit方法执行...");

		@SuppressWarnings("rawtypes")
		Map maps = (Map)JSON.parse(body);
		
		System.out.println(maps);
		
		List<Drug> prescriptionList = new ArrayList<>();

		for(int i = 0; i < maps.size(); i++)
		{
			String itemID = (String) maps.get("itemID[" + i + "]");

			
			Drug drugItem = new Drug();
			drugItem.setItemID(itemID);
			prescriptionList.add(drugItem);
		}

		//将所有药物的状态改为2
		drugItemService.changeState(prescriptionList, "3");

		
        return 0;
	}
}
