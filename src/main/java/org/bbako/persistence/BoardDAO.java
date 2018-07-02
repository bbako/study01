package org.bbako.persistence;

import java.util.List;

import org.bbako.domain.BoardVO;

public interface BoardDAO {
	
	public void create(BoardVO vo);
	public List<BoardVO> readAll()throws Exception;
	public BoardVO read(BoardVO vo);
	public void update(BoardVO vo);
	public void delete(BoardVO vo);
	
	

}
