package com.spring.service;

import java.util.List;

import com.spring.domain.Criteria;
import com.spring.domain.WaybillVO;

public interface WaybillService {
	
	public void regist(WaybillVO vo) throws Exception;
	
	public WaybillVO read(int wb_num) throws Exception;
	
	public void modify(WaybillVO vo) throws Exception;
	
	public void remove(int wb_num) throws Exception;
	
	public List<WaybillVO> listAll() throws Exception;
	
	public List<WaybillVO> listCriteria(Criteria cri) throws Exception;
	
	public int listCountCriteria(Criteria cri) throws Exception;

}
