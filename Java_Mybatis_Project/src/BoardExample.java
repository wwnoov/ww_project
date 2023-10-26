import java.util.ArrayList;
import java.util.Scanner;


public class BoardExample {

	public static void main(String[] args) {
		// DBUtil 객체 생성
		DBUtil db = new DBUtil();
		// WebView를 위한 DBUtil 객체 생성
		DBUtil WebView = new DBUtil();
		// 사용자 입력을 위한 Scanner 객체 생성
		Scanner scan = new Scanner(System.in);

		// 데이터베이스 초기화
		db.init();
		// 게시판 헤더 출력
		db.homeBoard();
		// 초기 게시글 리스트를 가져와서 출력
		ArrayList<BoardVO> boardList = db.getBoard();
		WebView.printWebView(boardList);
		// 메인 메뉴 출력
		db.mainMenu();


		while(true) {
			// 사용자 입력을 받음
			String cmd = scan.nextLine();
			// 4를 입력하면 프로그램 종료
			if (cmd.equals("4")) {
				db.exit();

			}
			// 1을 입력하면 게시글 작성
			else if (cmd.equals("1")) {
				System.out.println("[새 게시물 입력]");
				System.out.print("제목: ");

				String btitle = scan.nextLine();
				System.out.print("내용: ");

				String bcontent = scan.nextLine();
				System.out.print("작성자: ");

				String bwriter = scan.nextLine();

				// 게시물 등록/취소 서브 메뉴 출력
				db.okSubMenu();

				String createSubMenuNo = scan.nextLine();


				switch (createSubMenuNo) {
					case "1":
						// 게시물 등록
						db.insertBoard(btitle, bcontent, bwriter);
						System.out.println("[게시물 등록 완료]");
						break;

					case "2":
						System.out.println("[게시물 등록 취소]");
						break;
				}

				// 업데이트된 게시글 리스트를 가져와서 출력
				boardList = db.getBoard();
				db.homeBoard();
				WebView.printWebView(boardList);
				db.mainMenu();

			}
			// 2를 입력하면 게시물 읽기, 수정, 삭제 서브 메뉴 출력
			else if(cmd.equals("2")){
				System.out.println("[게시물 읽기]");
				System.out.print("bno: ");

				int bno = Integer.parseInt(scan.nextLine());
				boardList = db.readBoard(bno);
				db.readBnoBoard(boardList);
				// 읽기 서브 메뉴 출력
				db.readSubMenu();

				String readSubMenuNo = scan.nextLine();

				switch (readSubMenuNo){

					case "1" :
						System.out.println("[수정 내용 입력]");
						System.out.print("제목 : ");

						String btitle = scan.nextLine();
						System.out.print("내용 : ");

						String bcontent = scan.nextLine();
						System.out.print("작성자 : ");

						String bwriter = scan.nextLine();

						// 게시물 수정/취소 서브 메뉴 출력
						db.okSubMenu();

						String createSubMenuNo = scan.nextLine();

						switch (createSubMenuNo) {

							case "1":
								// 게시물 수정
								db.updateBoard(bno, btitle, bcontent, bwriter);
								System.out.println("[게시물 수정 완료]");
								break;

							case "2":

								System.out.println("[게시물 수정 취소]");
								break;
						}
						break;

					case "2" :
						System.out.println("정말로 " + bno + "번째 게시물을 삭제하시겠습니까?");
						// 삭제 서브 메뉴 출력
						db.okSubMenu();

						String deleteSubMenuNo = scan.nextLine();
						switch (deleteSubMenuNo) {

							case "1":
								// 게시물 삭제
								db.deleteBoard(bno);
								System.out.println(bno + "번째 게시물 삭제 완료");
								break;

							case "2":
								System.out.println("게시물 삭제 취소");
								break;
						}

						break;

					case "3" :
						break;
				}
				// 업데이트된 게시글 리스트를 가져와서 출력
				boardList = db.getBoard();
				db.homeBoard();
				WebView.printWebView(boardList);
				db.mainMenu();

			}
			// 3을 입력하면 게시판 전체 삭제
			else if (cmd.equals("3")) {
				// 게시판 전체 삭제 서브 메뉴 출력
				db.okSubMenu();
				String createSubMenuNo = scan.nextLine();
				switch (createSubMenuNo) {

					case "1":
						// 게시판 전체 삭제
						db.clearBoard();
						System.out.println("[게시물 전체 삭제 완료]");
						break;

					case "2":
						System.out.println("[게시물 전체 삭제 취소]");
						break;
				}
				// 업데이트된 게시글 리스트를 가져와서 출력
				boardList = db.getBoard();
				WebView.printWebView(boardList);
				db.mainMenu();
			}
		}
	}
}