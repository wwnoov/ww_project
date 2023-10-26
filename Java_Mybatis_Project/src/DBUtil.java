import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;


public class DBUtil {


	String url = "jdbc:mariadb://127.0.0.1:3306/java_final";
	String user = "root";
	String pass = "12345";
	SqlSessionFactory sqlSessionFactory;


	public void init(){
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);

			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		} catch (Exception e) {
			System.out.println("MyBatis 설정 파일 가져오는 중 문제 발생!!");
			e.printStackTrace();
		}

	}


	public void insertBoard(String btitle, String bcontent, String bwriter) {
		SqlSession session = sqlSessionFactory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		BoardVO boardVO = new BoardVO(btitle, bcontent, bwriter);
		mapper.insertBoard(boardVO);


		session.commit();
	}


	public ArrayList<BoardVO> getBoard(){
		SqlSession session = sqlSessionFactory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		ArrayList<BoardVO> boardVOList = mapper.getBoard();

		return boardVOList;
	}

	public ArrayList<BoardVO> readBoard(int bno){
		SqlSession session = sqlSessionFactory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		ArrayList<BoardVO> boardVOList = mapper.readBoard(bno);

		return boardVOList;
	}

	public void updateBoard(int bno, String btitle, String bcontent, String bwriter){
		SqlSession session = sqlSessionFactory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		BoardVO boardVO = new BoardVO(bno, btitle, bcontent, bwriter);
		mapper.updateBoard(boardVO);

		session.commit();
	}

	public void deleteBoard(int bno) {
		SqlSession session = sqlSessionFactory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		mapper.deleteBoard(bno);

		session.commit();
	}

	public void clearBoard(){
		SqlSession session = sqlSessionFactory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		mapper.clearBoard();

		session.commit();
	}


	public void homeBoard(){
		System.out.println();
		System.out.println("[게시판 목록]");
		System.out.println("-----------------------------------------------------------------");
		System.out.printf("%-6s%-15s%-15s%-40s\n", "no", "title", "writer", "date");
		System.out.println("-----------------------------------------------------------------");
	}

	public void mainMenu(){
		System.out.println("-----------------------------------------------------------------");
		System.out.println("메인 메뉴 : 1.create | 2.read | 3.clear | 4.exit");
		System.out.print("메뉴 선택 : ");
	}


	public void okSubMenu(){
		System.out.println("-----------------------------------------------------------------");
		System.out.println("보조 메뉴 : 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택 : ");
	}


	public void readSubMenu(){
		System.out.println("-----------------------------------------------------------------");
		System.out.println("보조 메뉴 : 1.Update | 2.Delete | 3.List");
		System.out.print("메뉴 선택 : ");
	}


	public void exit(){
		System.out.println();
		System.out.println("게시판 기능을 종료합니다.");
		System.exit(0);
	}


	public void printWebView(ArrayList<BoardVO> boardVOList) {

		for(int i = 0; i < boardVOList.size(); i++) {

			System.out.printf("%-6s%-15s%-15s%-40s\n",
					boardVOList.get(i).getBno(),
					boardVOList.get(i).getBtitle(),
					boardVOList.get(i).getBwriter(),
					boardVOList.get(i).getBdate());

		}
	}

	public void readBnoBoard(ArrayList<BoardVO> boardVOList){
			System.out.println("#######################################");
			System.out.println("번호: " + boardVOList.get(0).getBno());
			System.out.println("제목: " + boardVOList.get(0).getBtitle());
			System.out.println("내용: " + boardVOList.get(0).getBcontent());
			System.out.println("작성자: " + boardVOList.get(0).getBwriter());
			System.out.println("날짜: " + boardVOList.get(0).getBdate());
			System.out.println("#######################################");
	}
}
