package com.spring.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.domain.WaybillVO;
import com.spring.persistence.WaybillDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class WaybillDAOTest {

	@Inject
	private WaybillDAO dao;
	
	@Test
	public void testInsertWaybill() throws Exception {
		WaybillVO vo = new WaybillVO();
		
		vo.setOrder_num(3);
		vo.setSender("서장훈");
		vo.setReceiver("박명수");
		vo.setQuantity(3);
		vo.setP_name("핸드폰");
		vo.setC_point("강북집하장");
		vo.setS_point("강북우체국");
		vo.setAddress("서울시 강동구 암사동");
		
		dao.insertWaybill(vo);
	}
	
	@Test
	public void testRead() throws Exception {
		System.out.println(dao.readWaybill(1));
	}
	
	@Test
	public void testUpdate() throws Exception {
		WaybillVO vo = new WaybillVO();
		vo.setWb_num(1);
		vo.setReceiver("원빈");
		vo.setP_name("책");
		vo.setQuantity(2);
		vo.setAddress("부산시 강서구");
		
		dao.updateWaybill(vo);
	}
	
	@Test
	public void testDelete()throws Exception{
		dao.deleteWaybill(2);
	}
}
