package kr.co.chunjae.repository;

import kr.co.chunjae.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository {

    private final SqlSessionTemplate sql;
    @Override
    public int save(BoardDTO boardDTO) {
        return sql.insert("Board.save", boardDTO);
    }
    @Override
    public List<BoardDTO> findAll() {
        return sql.selectList("Board.findAll");
    }
    @Override
    public BoardDTO findById(Long id) {
        return sql.selectOne("Board.findById", id);
    }
    @Override
    public void updateHits(Long id) {
        sql.update("Board.updateHits", id);
    }
    @Override
    public void delete(Long id) {
        sql.delete("Board.delete", id);
    }
    @Override
    public void update(BoardDTO boardDTO) {
        sql.update("Board.update", boardDTO);
    }
    @Override
    public List<BoardDTO> pagingList(Map<String, Integer> pagingParams) {
        return sql.selectList("Board.pagingList", pagingParams);
    }
    @Override
    public int boardCount() {
        return sql.selectOne("Board.boardCount");
    }
}