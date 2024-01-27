package kr.co.chunjae.service;

import kr.co.chunjae.dto.CommentDTO;

import java.util.List;

public interface CommentService {

  public void save(CommentDTO commentDTO);
  public List<CommentDTO> findAll(Long boardId);
  public CommentDTO findByComment(Long id);
  public void update(CommentDTO commentDTO);
  public void delete(Long id);
}

