package com.his.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.his.entity.Drug;
import com.his.entity.Pmoudle;

public interface PmoudleDao 
{
	/**
	 * 返回所有项目
	 * @return
	 */
	List<Pmoudle> selectAll();
	
	/**
	 * 
	 * @param PrescriptID
	 */
	List<Drug> getPmoudleList(@Param("pPrescriptID") String pPrescriptID);
}
