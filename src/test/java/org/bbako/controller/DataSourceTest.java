package org.bbako.controller;

import java.sql.Connection;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.bbako.domain.BoardVO;
import org.bbako.domain.MemberVO;
import org.bbako.persistence.BoardDAO;
import org.bbako.persistence.MemberDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DataSourceTest {
	
	@Inject
	private DataSource ds;
	
	@Inject
	private SqlSessionFactory sqlf;
	
	@Inject
	private MemberDAO memberDao;
	
	@Inject
	private BoardDAO boardDao;
	
	@Test
	public void test1() throws Exception{
		Connection con = ds.getConnection();
		System.out.println(con);
	}
	
	@Test
	public void TestSes() {
		
		SqlSession session = sqlf.openSession();
		System.out.println("!!!!");
		System.out.println(session);
	}
	
	@Test
	public void time() {
		System.out.println("1111111");
		String a = memberDao.getTime();
		System.out.println(a);
	}
	
	@Test
	public void testDao() {
		MemberVO vo = new MemberVO();
		vo.setUserid("user02");
		vo.setUserpw("user02");
		vo.setUsername("username02");
		vo.setEmail("aaa1@g.com");
		
		memberDao.insertMember(vo);
	}
	
	@Test
	public void testDao2() {
		BoardVO vo = new BoardVO();
		
		vo.setTitle("title");
		vo.setContent("³»¿ë!!");
		vo.setWriter("writer2");
		
		
		boardDao.create(vo);
	}
	
	
	@Test
	public void list() throws Exception {
		
		List<BoardVO> list = boardDao.readAll();
		
		System.out.println("1111111");
		
	}
	
	

}
