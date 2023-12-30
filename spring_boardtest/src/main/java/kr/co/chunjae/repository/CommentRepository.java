package kr.co.chunjae.repository;

import kr.co.chunjae.dto.BoardDTO;
import kr.co.chunjae.dto.CommentDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final SqlSessionTemplate sql;

    public CommentDTO findByComment(Long id) {
        return sql.selectOne("Comment.findByComment", id);
    }

    public void save(CommentDTO commentDTO) {
        sql.insert("Comment.save", commentDTO);
    }

    public List<CommentDTO> findAll(Long boardId) {
        return sql.selectList("Comment.findAll", boardId);
    }

    public void delete(Long id) {
        sql.delete("Comment.delete", id);
    }

    public void update(CommentDTO commentDTO) {
        sql.update("Comment.update", commentDTO);
    }
}
