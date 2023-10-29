import java.util.ArrayList;
/**
Mybatis를 사용하려면 크게 4가지를 정의해야 한다.
쿼리문을 정의한 mapper.xml 파일
Mapper.xml를 java코드에서 실행시키는 Mapper Class or interface (Mapper.java)
쿼리의 결과데이터를 담는 중간 매개 Class (보통 VO)
위의 3개의 위치를 알려주는 설정
 

Interface를 이용하여 사용하는 방식.
Mapper.xml 과 Mapper.java를 연결해주는 방식은 NameSpace와 각 쿼리문의 id의 조합임.
쿼리문의 id의 값은 Mapper.java에서 인터페이스로 만들어 놓은 메소드명과 일치해야함.
*/
public interface BoardMapper {
    // BoardMapper.xml 를 위한 인터페이스
    public ArrayList<BoardVO> getBoard();
    public void insertBoard(BoardVO boardVO);
    public ArrayList<BoardVO> readBoard(int bno);
    public void updateBoard(BoardVO boardVO);
    public void deleteBoard(int bno);
    public void clearBoard();
}
