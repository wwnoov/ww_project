import java.util.ArrayList;
import java.util.Scanner;


public class BoardExample {

	public static void main(String[] args) {


		DBUtil db = new DBUtil();
		DBUtil WebView = new DBUtil();
		Scanner scan = new Scanner(System.in);


		db.init();

		db.homeBoard();

		ArrayList<BoardVO> boardList = db.getBoard();
		WebView.printWebView(boardList);

		db.mainMenu();


		while(true) {

			String cmd = scan.nextLine();

			if (cmd.equals("4")) {
				db.exit();


			}

			else if (cmd.equals("1")) {
				System.out.println("[새 게시물 입력]");
				System.out.print("제목: ");

				String btitle = scan.nextLine();
				System.out.print("내용: ");

				String bcontent = scan.nextLine();
				System.out.print("작성자: ");

				String bwriter = scan.nextLine();


				db.okSubMenu();


				String createSubMenuNo = scan.nextLine();


				switch (createSubMenuNo) {
					case "1":

						db.insertBoard(btitle, bcontent, bwriter);
						System.out.println("[게시물 등록 완료]");
						break;

					case "2":
						System.out.println("[게시물 등록 취소]");
						break;
				}


				boardList = db.getBoard();


				db.homeBoard();


				WebView.printWebView(boardList);

				db.mainMenu();

			} 

			else if(cmd.equals("2")){
				System.out.println("[게시물 읽기]");
				System.out.print("bno: ");


				int bno = Integer.parseInt(scan.nextLine());

				boardList = db.readBoard(bno);

				db.readBnoBoard(boardList);


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


						db.okSubMenu();

						String createSubMenuNo = scan.nextLine();

						switch (createSubMenuNo) {

							case "1":

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

						db.okSubMenu();

						String deleteSubMenuNo = scan.nextLine();
						switch (deleteSubMenuNo) {

							case "1":

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

				boardList = db.getBoard();

				db.homeBoard();

				WebView.printWebView(boardList);

				db.mainMenu();

			}

			else if (cmd.equals("3")) {

				db.okSubMenu();

				String createSubMenuNo = scan.nextLine();

				switch (createSubMenuNo) {

					case "1":

						db.clearBoard();
						System.out.println("[게시물 전체 삭제 완료]");
						break;

					case "2":
						System.out.println("[게시물 전체 삭제 취소]");
						break;
				}

				boardList = db.getBoard();


				WebView.printWebView(boardList);

				db.mainMenu();
			}
		}
	}
}