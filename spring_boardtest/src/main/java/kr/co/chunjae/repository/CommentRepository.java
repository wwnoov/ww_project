package kr.co.chunjae.repository;

import kr.co.chunjae.dto.CommentDTO;

import java.util.List;

public interface CommentRepository {

  public CommentDTO findByComment(Long id);

  public void save(CommentDTO commentDTO);

  public List<CommentDTO> findAll(Long boardId);

  public void delete(Long id);

  public void update(CommentDTO commentDTO);
}
