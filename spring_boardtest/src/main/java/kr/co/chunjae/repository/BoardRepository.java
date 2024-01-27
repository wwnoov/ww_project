package kr.co.chunjae.repository;

import kr.co.chunjae.dto.BoardDTO;

import java.util.List;
import java.util.Map;

public interface BoardRepository {

  public int save(BoardDTO boardDTO);

  public List<BoardDTO> findAll();

  public BoardDTO findById(Long id);

  public void updateHits(Long id);

  public void delete(Long id);

  public void update(BoardDTO boardDTO);

  public List<BoardDTO> pagingList(Map<String, Integer> pagingParams) ;

  public int boardCount();
}
