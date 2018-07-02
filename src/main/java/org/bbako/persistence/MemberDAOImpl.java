package org.bbako.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.bbako.domain.MemberVO;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.bbako.mapper.MemberMapper"; 

	@Override
	public String getTime() {
		
		return sqlSession.selectOne(namespace+".getTime");
	}

	@Override
	public void insertMember(MemberVO vo) {
		
		sqlSession.insert(namespace+".insertMember", vo);
	}

	@Override
	public List<MemberVO> readMember(String userid) {

		return sqlSession.selectList(namespace+".readMember", userid);
	}

	@Override
	public MemberVO readWithPW(String userid, String userpw) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid",userid);
		paramMap.put("userpw",userpw);
		
		return sqlSession.selectOne(namespace+".readWithPW", paramMap);
	}

}
