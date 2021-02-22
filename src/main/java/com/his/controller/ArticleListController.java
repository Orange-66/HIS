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
import com.his.entity.Charge;
import com.his.entity.Drug;
import com.his.entity.User;
import com.his.service.ChargeService;
import com.his.service.DrugItemService;


@Controller
@SessionAttributes(value= {"user", "receiptNumber"})
public class ArticleListController 
{
	@Autowired
	private ChargeService chargeService;
	
	@Autowired
	private DrugItemService drugItemService;
	
	/**
	 * 返回控制页面方法
	 * @return
	 */
	@RequestMapping("/article-list")
	public String articleList()
	{
        return "article-list";
	}
	
	@RequestMapping("/article-list/searchItem")
	@ResponseBody
	public List<Charge> searchItem(@RequestBody String body)
	{
		System.out.println("article-list页面searchItem方法执行...");

		@SuppressWarnings("rawtypes")
		Map maps = (Map)JSON.parse(body);
		
		String caseID = (String) maps.get("caseID");
		List<Charge> tempList = chargeService.checkOutByCaseID(caseID);
		List<Charge> chargeList = new ArrayList<>();
		for(Charge c : tempList)
		{
			if(c.getItemState().equals("1"))
			{
				chargeList.add(c);
			}
		}
		
        return chargeList;
	}
	
	@RequestMapping("/article-list/submit")
	@ResponseBody
	public int submit(@RequestBody String body, ModelMap modelMap, Model model)
	{
		System.out.println("article-list页面submit方法执行...");

		@SuppressWarnings("rawtypes")
		Map maps = (Map)JSON.parse(body);
		
		String caseID = (String) maps.get("caseID");
		String chargeType = (String) maps.get("chargeType");
		System.out.println(maps);
		
		List<Drug> prescriptionList = new ArrayList<>();

		for(int i = 0; i < (maps.size() - 2) / 3; i++)
		{
			String itemID = (String) maps.get("itemID[" + i + "]");
			String price = (String) maps.get("price[" + i + "]");
			String number = (String) maps.get("number[" + i + "]");
			
			Drug drugItem = new Drug();
			drugItem.setNumber(number);
			drugItem.setItemID(itemID);
			drugItem.setPrice(price);
			prescriptionList.add(drugItem);
		}

		User user = (User)modelMap.get("user");
		String chargeID = Integer.toString(user.getUserID());
		
		String receiptNumber = Integer.toString((Integer)modelMap.get("receiptNumber"));
		
		//获得当前时间
		Date date = new Date();   
		Timestamp currentTime = new Timestamp(date.getTime());
		
		//发票表中登记
		chargeService.addDrugItems(receiptNumber, prescriptionList, currentTime, chargeID, chargeType, caseID);
		
		//将所有药物的状态改为2
		drugItemService.changeState(prescriptionList, "2");
		
		//更换发票号
		model.addAttribute("receiptNumber", chargeService.createEmptyItem());
		
        return 0;
	}
}
