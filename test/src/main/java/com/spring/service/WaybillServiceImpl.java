package com.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.domain.Criteria;
import com.spring.domain.SearchCriteria;
import com.spring.domain.WaybillVO;
import com.spring.persistence.WaybillDAO;

@Service
public class WaybillServiceImpl implements WaybillService {
	
	@Inject
	private WaybillDAO dao;
	
	@Override
	public void regist(WaybillVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.insertWaybill(vo);
	}

	@Override
	public WaybillVO read(int wb_num) throws Exception {
		// TODO Auto-generated method stub
		return dao.readWaybill(wb_num);
	}

	@Override
	public void modify(WaybillVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.updateWaybill(vo);
	}

	@Override
	public void remove(int wb_num) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteWaybill(wb_num);
	}

	@Override
	public List<WaybillVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public List<WaybillVO> listCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.countPaging(cri);
	}

	@Override
	public List<WaybillVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSearchCount(cri);
	}

}
