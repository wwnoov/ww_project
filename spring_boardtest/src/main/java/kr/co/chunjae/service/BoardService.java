package kr.co.chunjae.service;

import kr.co.chunjae.dto.BoardDTO;
import kr.co.chunjae.dto.PageDTO;

import java.util.List;

public interface BoardService {

  public int save(BoardDTO boardDTO) ;

  public List<BoardDTO> findAll();

  public BoardDTO findById(Long id) ;

  public void updateHits(Long id);

  public void delete(Long id);

  public void update(BoardDTO boardDTO);

  public List<BoardDTO> pagingList(int page) ;

  public PageDTO pagingParam(int page) ;
}
