package kr.co.chunjae.service;

import kr.co.chunjae.dto.BoardDTO;
import kr.co.chunjae.dto.CommentDTO;
import kr.co.chunjae.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public void save(CommentDTO commentDTO) {
        commentRepository.save(commentDTO);
    }

    public List<CommentDTO> findAll(Long boardId) {
        return commentRepository.findAll(boardId);
    }

    public CommentDTO findByComment(Long id) {
        return commentRepository.findByComment(id);
    }
    public void update(CommentDTO commentDTO) {
        commentRepository.update(commentDTO);
    }

    public void delete(Long id) {
        commentRepository.delete(id);
    }

}
