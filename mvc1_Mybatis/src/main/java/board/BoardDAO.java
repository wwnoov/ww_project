package board;

import java.util.List;
import java.util.Map;

import mybatis.factory.MyBatisSessionFactory;
import mybatis.mapper.BoardMapper;
import org.apache.ibatis.session.SqlSession;


public class BoardDAO {

public List<BoardDTO> selectListPage(Map<String, Object> map) {
    SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
    BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
    List<BoardDTO> result = mapper.selectListPage(map);
    sqlSession.close();
    return result;
    }
public BoardDTO selectView(String idx) {
     SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
     BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
     BoardDTO dto = mapper.selectView(idx);
     sqlSession.close();
     return dto;
    }
}

