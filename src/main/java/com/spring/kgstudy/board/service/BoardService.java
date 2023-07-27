package com.spring.kgstudy.board.service;

import java.util.List;


import com.spring.kgstudy.board.vo.BoardVO;
import com.spring.kgstudy.common.vo.Criteria;

public interface BoardService {

	List<BoardVO> getList(Criteria cri) throws Exception;
	public void register(BoardVO vo);
	public BoardVO get(int board_id);
	public void modify(BoardVO vo);
	public void remove(int board_id);
	public void replyProcess(BoardVO vo);
	public int totalCount(Criteria cri);
}
