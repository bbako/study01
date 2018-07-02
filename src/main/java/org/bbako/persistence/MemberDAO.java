package org.bbako.persistence;

import java.util.List;

import org.bbako.domain.MemberVO;

public interface MemberDAO {
	
	public String getTime();
	
	public void insertMember(MemberVO vo);
	
	public List<MemberVO> readMember(String userid);

	public MemberVO readWithPW(String userid, String userpw);

	


}
