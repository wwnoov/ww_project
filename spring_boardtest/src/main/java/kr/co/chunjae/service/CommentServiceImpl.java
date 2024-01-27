package kr.co.chunjae.service;

import kr.co.chunjae.dto.CommentDTO;
import kr.co.chunjae.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;

    @Override
    public void save(CommentDTO commentDTO) {
        commentRepository.save(commentDTO);
    }
    @Override
    public List<CommentDTO> findAll(Long boardId) {
        return commentRepository.findAll(boardId);
    }
    @Override
    public CommentDTO findByComment(Long id) {
        return commentRepository.findByComment(id);
    }
    @Override
    public void update(CommentDTO commentDTO) {
        commentRepository.update(commentDTO);
    }
    @Override
    public void delete(Long id) {
        commentRepository.delete(id);
    }

}
