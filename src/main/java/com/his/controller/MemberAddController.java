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
import com.his.dto.RegisteInfo;
import com.his.entity.Case;
import com.his.entity.Register;
import com.his.entity.User;
import com.his.service.CaseService;
import com.his.service.ChargeService;
import com.his.service.RegisterService;
import com.his.service.RegtableService;
import com.his.service.UserService;


@Controller
@SessionAttributes(value= {"user", "receiptNumber", "doctorList"})
public class MemberAddController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ChargeService chargeService;
	
	@Autowired
	private CaseService caseService;
	
	@Autowired
	private RegtableService regtableService;
	
	@Autowired
	private RegisterService registerService;
	
	/**
	 * 返回控制页面方法
	 * @return
	 */
	@RequestMapping("/member-add")
	public String memberAdd(Model model, ModelMap modelMap)
	{
		System.out.println("跳转至member-add页面...");
		
		List<Map<String, Object>> doctorList = userService.searchDoctor("1", "81");
		
		if(modelMap.get("receiptNumber") == null || (Integer)modelMap.get("receiptNumber") == -1)//判断操作者是否持有发票号
		{
			Integer receiptNumber = createReceiptNumber();//获取发票号
			System.out.println("当前发票号"+receiptNumber+"被当前操作员持有");
			model.addAttribute("receiptNumber", receiptNumber);//当前发票号被当前操作员持有
		}
		else
		{
			System.out.println("当前操作员持有的发票号还未被使用！");
		}
		
		model.addAttribute("doctorList", doctorList);
		
        return "member-add";
	}
	
	//生成发牌号
	public Integer createReceiptNumber()
	{
		System.out.println("生成发票号...");
		Integer receiptNumber = chargeService.createEmptyItem();
		return receiptNumber;
	}
	
	
	/**
	 * 搜索该病历号的病人
	 * @return
	 */
	@RequestMapping("/member-add/searchByCaseID")
	@ResponseBody
	public Case searchByCaseID(@RequestBody String body)
	{
		System.out.println("member-add页面searchByCaseID方法执行...");

		@SuppressWarnings("rawtypes")
		Map maps = (Map)JSON.parse(body);

		System.out.println("!");
		System.out.println(maps.get("caseID"));
		System.out.println("!");
		
		Case caseItem = caseService.searchByCaseID((String) maps.get("caseID"));

		if(caseItem == null)
		{
			return null;
		}
		else
		{
			return caseItem;
		}
        
	}
	
	/**
	 * 生成新病历号
	 * @return
	 */
	@RequestMapping("/member-add/newCaseID")
	@ResponseBody
	public String newCaseID()
	{
		System.out.println("member-add页面newCaseID方法执行...");
		
		String newCaseID = caseService.newCaseID();
		
		return newCaseID;
	}
	
	/**
	 * 取消新病历号
	 * @return
	 */
	@RequestMapping("/member-add/cancelNewCaseID")
	@ResponseBody
	public String cancelNewCaseID(@RequestBody String caseID)
	{
		System.out.println("member-add页面cancelNewCaseID方法执行...");
		
		@SuppressWarnings("rawtypes")
		Map maps = (Map)JSON.parse(caseID);

		System.out.println("!");
		System.out.println(maps.get("caseID"));
		System.out.println("!");
		
		caseID = (String)maps.get("caseID");
		
		caseService.cancelNewCaseID(caseID);

		return caseID;
	}
	
	/**
	 * 查找剩余票数
	 * @return
	 */
	@RequestMapping("/member-add/searchRemain")
	@ResponseBody
	public String searchRemain(@RequestBody String body)
	{
		System.out.println("member-add页面searchRemain方法执行...");
		
		@SuppressWarnings("rawtypes")
		Map maps = (Map)JSON.parse(body);
		
		String appointmentDate = (String)maps.get("appointmentDate");
		String period = (String)maps.get("period");
		//String department = (String)maps.get("department");
		String doctor = (String)maps.get("doctor");
		
		System.out.println("!");
		System.out.println("appointmentDate:" + appointmentDate);
		System.out.println("period:" + period);
		//System.out.println("department:" + department);
		System.out.println("doctor:" + doctor);
		System.out.println("!");
		
		String number = regtableService.searchRemain(appointmentDate, period, doctor);
		
		System.out.println(number);
		
		number = (null == number) ? JSON.toJSONString("无") : number;
		System.out.println(number);
		return number;
	}
	
	/**
	 * 查找符合条件的所有医生
	 * @return
	 */
	@RequestMapping("/member-add/searchDoctor")
	@ResponseBody
	public List<Map<String, Object>> searchDoctor(@RequestBody String body, Model model)
	{
		System.out.println("member-add页面searchDoctor方法执行...");
		
		@SuppressWarnings("rawtypes")
		Map maps = (Map)JSON.parse(body);
		
		String depID = (String)maps.get("department");
		String titleID = (String)maps.get("doctorType");


		System.out.println("!");
		System.out.println("department:" + depID);
		System.out.println("doctorType:" + titleID);
		System.out.println("!");
		
		List<Map<String, Object>> doctorList = userService.searchDoctor(depID, titleID);
		
		System.out.print(doctorList);
		
		return doctorList;
	}
	
	@RequestMapping("/member-add/isRepeat")
	@ResponseBody
	public int isRepeat(@RequestBody String body)
	{
		System.out.println("member-add页面searchDoctor方法执行...");
		
		@SuppressWarnings("rawtypes")
		Map maps = (Map)JSON.parse(body);
		
		String depID = (String)maps.get("department");
		String docID = (String)maps.get("doctor");
		String caseID = (String)maps.get("caseID");
		
		Register register = registerService.isRepeat(caseID, depID, docID);
		
		if(register == null) {
			System.out.println("没重复！");
			return 1;
		}
		else {
			System.out.println(register);
			if(register.getRegistState() == 4 || register.getRegistState() == 3)
			{
				System.out.println("没重复了！");
				return 1;
			}
			else
			{
				System.out.println("重复了！");
				return 0;
			}
			
		}
	}
	
	
	
	/**
	 * 提交挂号信息
	 * @return
	 */
	@RequestMapping("/member-add/submit")
	@ResponseBody
	public int submit(@RequestBody RegisteInfo registeInfo, ModelMap modelMap, Model model)
	{
		System.out.println("member-add页面sumbit方法执行...");
		
		int flag = 0;
		
		//@SuppressWarnings("rawtypes")
		//Map maps = (Map)JSON.parse(body);
		
		String caseID = registeInfo.getCaseID();
		boolean newCase = registeInfo.isNewCase();
		//System.out.println((boolean)maps.get("modifyCase")+"__"+newCase);
		if(newCase || registeInfo.isModifyCase())
		{
			String name = registeInfo.getName();
			String gender = registeInfo.getGender();
			String patientID = registeInfo.getPatientID();
			String birthday = registeInfo.getBirthday();
			String age = registeInfo.getAge();
			String ageUnit = registeInfo.getAgeUnit();
			String address = registeInfo.getAddress();
			System.out.println("member-add页面submit方法执行:"+caseID+name+gender+patientID+ birthday+ age+ ageUnit+ address);
			try {
				caseService.modifyCase(caseID, name, gender, patientID, birthday, age, ageUnit, address);
			}
			catch(Exception e){
				flag = -1;
			}
		}
		
		String date = registeInfo.getAppointmentDate();
		String regType = registeInfo.getPeriod();
		String depID = registeInfo.getDepartment();
		String levID = registeInfo.getDoctorType();
		String docID = registeInfo.getDoctor();
		//String remain = (String)maps.get("remain");
		
		String settlement = registeInfo.getSettlement();
		String price = registeInfo.getAmount();
		String chargeType = registeInfo.getChargeType();
		String newNote = registeInfo.getNewNote();
		
		User user = (User) modelMap.get("user");
		String userID = Integer.toString(user.getUserID());
		
		Integer receiptNumebr = (Integer)modelMap.get("receiptNumber");
		
		//挂号--添加挂号项目
		try {
			registerService.addRegister(caseID, newNote, docID, depID, levID, userID, chargeType, price, settlement, receiptNumebr, regType, date);
			regtableService.useATicket(date, docID, regType);
			model.addAttribute("receiptNumber", -1);
		}
		catch(Exception e) {
			flag = -1;
		}


		//return registerResult && regtableResult;
		return flag;
	}
	
}
