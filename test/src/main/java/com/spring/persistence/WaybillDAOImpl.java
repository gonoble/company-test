package com.spring.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.domain.Criteria;
import com.spring.domain.SearchCriteria;
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

	@Override
	public List<WaybillVO> listPage(int page) throws Exception {
		// TODO Auto-generated method stub
		if(page <= 0) {
			page = 1;
		}
		page = (page - 1) * 10;
		return sqlSession.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<WaybillVO> listCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".countPaging", cri);
	}

	@Override
	public List<WaybillVO> listSearch(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".listSearchCount", cri);
	}

}
