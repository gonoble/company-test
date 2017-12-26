package com.spring.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.domain.Criteria;
import com.spring.domain.WaybillVO;
import com.spring.persistence.WaybillDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class WaybillDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(WaybillController.class);
	
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
	
	@Test
	public void testListPage() throws Exception {
		int page = 2;
		
		List<WaybillVO> list = dao.listPage(page);
		
		for (WaybillVO waybillVO : list) {
			logger.info(waybillVO.getWb_num() + ":" + waybillVO.getSender());
		}
	}
	
	@Test
	public void testCriteria() throws Exception {
		Criteria cri = new Criteria();
		cri.setPage(3);
		cri.setPerPageNum(10);
		
		List<WaybillVO> list = dao.listCriteria(cri);
		
		for (WaybillVO waybillVO : list) {
			logger.info(waybillVO.getWb_num() + ":" + waybillVO.getSender());
		}
	}
	
	@Test
	public void testURI()throws Exception{
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
										.path("/waybill/read")
										.queryParam("wb_num", 12)
										.queryParam("perPageNum", 10)
										.build();
		
		logger.info("/waybill/read?wb_num=12&perPageNum=10");
		logger.info(uriComponents.toString());
	}
	
	
}
