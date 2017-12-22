package com.spring.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.domain.WaybillVO;

@Repository
public class WaybillDAOImpl implements WaybillDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.spring.mapper.WaybillMapper";
	
	

	@Override
	public void insertWaybill(WaybillVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insertWaybill", vo);
	}

	@Override
	public WaybillVO readWaybill(int wb_num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".readWaybill", wb_num);
	}

	@Override
	public void updateWaybill(WaybillVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".updateWaybill", vo);
	}

	@Override
	public void deleteWaybill(int wb_num) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".deleteWaybill", wb_num);
	}

	@Override
	public List<WaybillVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listAll");
	}

}
