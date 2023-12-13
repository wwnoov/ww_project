package mvcboard;


import mybatis.factory.MyBatisSessionFactory;
import mybatis.mapper.MVCBoardMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MVCBoardDAO {

  // 검색 조건에 맞는 게시물의 개수를 반환합니다.
  public int selectCount(Map<String, Object> map) {
    SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
    MVCBoardMapper mapper = sqlSession.getMapper(MVCBoardMapper.class);
    int result = mapper.selectCount(map);
    sqlSession.close();
    return result;
  }
  public List<MVCBoardDTO> selectListPage(Map<String, Object> map) {
    SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
    MVCBoardMapper mapper = sqlSession.getMapper(MVCBoardMapper.class);
    List<MVCBoardDTO> result = mapper.selectListPage(map);
    sqlSession.close();
    return result;
  }


  // 검색 조건에 맞는 게시물 목록을 반환합니다(페이징 기능 지원).
  public List<MVCBoardDTO> selectListPageWithPaging(Map<String, Object> map) {
    SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
    MVCBoardMapper mapper = sqlSession.getMapper(MVCBoardMapper.class);
    List<MVCBoardDTO> result = mapper.selectListPageWithPaging(map);
    sqlSession.close();
    return result;
  }

  // 게시글 데이터를 받아 DB에 추가합니다(파일 업로드 지원).
  public int insertWrite(MVCBoardDTO dto) {
    SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
    MVCBoardMapper mapper = sqlSession.getMapper(MVCBoardMapper.class);
    int result = mapper.insertWrite(dto);
    if (result == 1) {
      sqlSession.commit();
      System.out.println("새로운 mvcboard 저장 성공");
    } else {
      System.out.println("새로운 mvcboard 저장 실패");
    }
    sqlSession.close();
    return result;
  }

  // 주어진 일련번호에 해당하는 게시물을 DTO에 담아 반환합니다.
  public MVCBoardDTO selectView(String idx) {
    SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
    MVCBoardMapper mapper = sqlSession.getMapper(MVCBoardMapper.class);
    MVCBoardDTO dto = mapper.selectView(idx);
    sqlSession.close();
    return dto;
  }

  // 주어진 일련번호에 해당하는 게시물의 조회수를 1 증가시킵니다.
  public void updateVisitCount(String idx) {
    SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
    MVCBoardMapper mapper = sqlSession.getMapper(MVCBoardMapper.class);
    int result = mapper.updateVisitCount(idx);
    if (result == 1) {
      sqlSession.commit();
    } else {
      System.out.println("조회수 증가 중 오류 발생");
    }
    sqlSession.close();
  }
  // 다운로드 횟수를 1 증가시킵니다.

  public void downCountPlus(String idx) {
    SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
    MVCBoardMapper mapper = sqlSession.getMapper(MVCBoardMapper.class);
    int result = mapper.downCountPlus(idx);
    if (result == 1) {
      sqlSession.commit();
    } else {
      System.out.println("다운로드 횟수 1증가 중 오류 발생");
    }
    sqlSession.close();
  }


  // 입력한 비밀번호가 지정한 일련번호의 게시물의 비밀번호와 일치하는지 확인합니다.
  public boolean confirmPassword(String pass, String idx) {
    Map<String, String> map = new HashMap<>();
    map.put("pass", pass);
    map.put("idx", idx);
    SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
    MVCBoardMapper mapper = sqlSession.getMapper(MVCBoardMapper.class);
    int result = mapper.confirmPassword(map);
    if (result == 1) {
      return true;
    } else {
      System.out.println("비밀번호 확인 중 오류 발생...");
      return false;
    }
  }

  // 지정한 일련번호의 게시물을 삭제합니다.
  public int deletePost(String idx) {
    SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
    MVCBoardMapper mapper = sqlSession.getMapper(MVCBoardMapper.class);
    int result = mapper.deletePost(idx);
    if (result == 1) {
      sqlSession.commit();
    } else {
      System.out.println("board 삭제 중 오류 발생...");
    }
    return result;
  }

  // 게시글 데이터를 받아 DB에 저장되어 있던 내용을 갱신합니다(파일 업로드 지원).
  public int updatePost(MVCBoardDTO dto) {
    SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
    MVCBoardMapper mapper = sqlSession.getMapper(MVCBoardMapper.class);
    int result = mapper.updatePost(dto);
    if (result == 1) {
      sqlSession.commit();
    } else {
      System.out.println("board update 중 오류 발생...");
    }
    sqlSession.commit();
    return result;
  }
}