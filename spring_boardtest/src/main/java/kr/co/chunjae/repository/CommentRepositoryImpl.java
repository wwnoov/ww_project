package kr.co.chunjae.repository;

import kr.co.chunjae.dto.CommentDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository{

    private final SqlSessionTemplate sql;


    @Override
    public CommentDTO findByComment(Long id) {
        return sql.selectOne("Comment.findByComment", id);
    }
    @Override
    public void save(CommentDTO commentDTO) {
        sql.insert("Comment.save", commentDTO);
    }
    @Override
    public List<CommentDTO> findAll(Long boardId) {
        return sql.selectList("Comment.findAll", boardId);
    }
    @Override
    public void delete(Long id) {
        sql.delete("Comment.delete", id);
    }
    @Override
    public void update(CommentDTO commentDTO) {
        sql.update("Comment.update", commentDTO);
    }
}
