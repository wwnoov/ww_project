import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;


public class DBUtil {

	// 데이터베이스 연결 및 MyBatis 구성을 위한 인스턴스 변수를 정의합니다.
	String url = "jdbc:mariadb://127.0.0.1:3306/java_final";
	String user = "root";
	String pass = "12345";
	SqlSessionFactory sqlSessionFactory;

	// MyBatis 구성을 초기화합니다.
	public void init(){
		try {
			// "mybatis-config.xml"에서 MyBatis 구성을 로드합니다 (경로 설정 유의할것)
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			// 데이터베이스 상호 작용을 위한 SqlSessionFactory를 구축합니다.
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		} catch (Exception e) {
			System.out.println("MyBatis 설정 파일 가져오는 중 문제 발생!!");
			e.printStackTrace();
		}

	}

	// 새로운 게시글을 데이터베이스에 삽입합니다.
	public void insertBoard(String btitle, String bcontent, String bwriter) {
		SqlSession session = sqlSessionFactory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		BoardVO boardVO = new BoardVO(btitle, bcontent, bwriter);
		mapper.insertBoard(boardVO);


		session.commit();
	}

	// 데이터베이스에서 게시글 목록을 가져옵니다
	public ArrayList<BoardVO> getBoard(){
		SqlSession session = sqlSessionFactory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		ArrayList<BoardVO> boardVOList = mapper.getBoard();

		return boardVOList;
	}
	// 게시글을 읽어옵니다.
	public ArrayList<BoardVO> readBoard(int bno){
		SqlSession session = sqlSessionFactory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		ArrayList<BoardVO> boardVOList = mapper.readBoard(bno);

		return boardVOList;
	}
	// 게시글을 업데이트합니다.
	public void updateBoard(int bno, String btitle, String bcontent, String bwriter){
		SqlSession session = sqlSessionFactory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		BoardVO boardVO = new BoardVO(bno, btitle, bcontent, bwriter);
		mapper.updateBoard(boardVO);

		session.commit();
	}
	// 게시글을 삭제합니다.
	public void deleteBoard(int bno) {
		SqlSession session = sqlSessionFactory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		mapper.deleteBoard(bno);

		session.commit();
	}
	// 목록을 삭제합니다.
	public void clearBoard(){
		SqlSession session = sqlSessionFactory.openSession();
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		mapper.clearBoard();

		session.commit();
	}

	// 게시판 목록을 출력하기 위한 메서드
	public void homeBoard(){
		System.out.println();
		System.out.println("[게시판 목록]");
		System.out.println("-----------------------------------------------------------------");
		System.out.printf("%-6s%-15s%-15s%-40s\n", "no", "title", "writer", "date");
		System.out.println("-----------------------------------------------------------------");
	}
	// 메인 메뉴를 출력하기 위한 메서드
	public void mainMenu(){
		System.out.println("-----------------------------------------------------------------");
		System.out.println("메인 메뉴 : 1.create | 2.read | 3.clear | 4.exit");
		System.out.print("메뉴 선택 : ");
	}

	// 보조 메뉴 - Ok 또는 Cancel을 출력하기 위한 메서드
	public void okSubMenu(){
		System.out.println("-----------------------------------------------------------------");
		System.out.println("보조 메뉴 : 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택 : ");
	}
	// 읽기 서브 메뉴 - 업데이트, 삭제 또는 목록을 출력하기 위한 메서드
	public void readSubMenu(){
		System.out.println("-----------------------------------------------------------------");
		System.out.println("보조 메뉴 : 1.Update | 2.Delete | 3.List");
		System.out.print("메뉴 선택 : ");
	}

	// 프로그램 종료 메서드
	public void exit(){
		System.out.println();
		System.out.println("게시판 기능을 종료합니다.");
		System.exit(0);
	}

	// 게시글 목록을 화면에 출력하는 메서드
	public void printWebView(ArrayList<BoardVO> boardVOList) {

		for(int i = 0; i < boardVOList.size(); i++) {

			System.out.printf("%-6s%-15s%-15s%-40s\n",
					boardVOList.get(i).getBno(),
					boardVOList.get(i).getBtitle(),
					boardVOList.get(i).getBwriter(),
					boardVOList.get(i).getBdate());

		}
	}
	// 특정 게시글을 출력하는 메서드
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
