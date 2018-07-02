package org.bbako.persistence;

import java.util.List;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.bbako.domain.BoardVO;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.bbako.mapper.BoardMapper";

	@Override
	public void create(BoardVO vo) {
		sqlSession.insert(namespace+".create", vo);
	}

	@Override
	public List<BoardVO> readAll() {
		return sqlSession.selectList(namespace+".readAll");
	}

	@Override
	public BoardVO read(BoardVO vo) {
		return sqlSession.selectOne(namespace+".read", vo);
	}

	@Override
	public void update(BoardVO vo) {
		sqlSession.update(namespace+".update", vo);
	}

	@Override
	public void delete(BoardVO vo) {
		sqlSession.delete(namespace+".delete", vo);
	}


}
