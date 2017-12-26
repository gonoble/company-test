package com.spring.persistence;

import java.util.List;

import com.spring.domain.Criteria;
import com.spring.domain.WaybillVO;

public interface WaybillDAO {
	
	public void insertWaybill(WaybillVO vo)throws Exception;
	
	public WaybillVO readWaybill(int wb_num)throws Exception;
	
	public void updateWaybill(WaybillVO vo) throws Exception;
	
	public void deleteWaybill (int wb_num) throws Exception;
	
	public List<WaybillVO> listAll() throws Exception;
	
	public List<WaybillVO> listPage(int page) throws Exception;
	
	public List<WaybillVO> listCriteria(Criteria cri) throws Exception;
	
	public int countPaging(Criteria cri)throws Exception;
}
