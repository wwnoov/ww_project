import java.util.ArrayList;
import java.util.Scanner;

public class AddrApp {

  public static void main(String[] args) {
	 	// DBUtil 클래스의 인스턴스를 생성하여 데이터베이스 작업을 수행합니다.
		DBUtil db = new DBUtil();
		db.init();
		// 사용자 입력을 콘솔에서 읽기 위한 Scanner 객체를 생성합니다.
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("명령어를 입력해주세요 : ");
			// 사용자 입력 명령어를 읽습니다.
			String cmd = scan.nextLine();
			
			if(cmd.equals("exit")) {
				// 사용자가 "exit"를 입력하면 프로그램 루프를 종료하고 애플리케이션을 종료합니다.
				break;
			} else if(cmd.equals("add")) {
				// 사용자가 "add"를 입력하면 주소록 항목을 추가하도록 요청합니다.
				System.out.println("========= 주소록 등록 =========");
				System.out.print("이름 : ");
				String name = scan.nextLine();
				System.out.print("주소 : ");
				String address = scan.nextLine();
				System.out.print("전화번호 : ");
				String phone = scan.nextLine();
				// DBUtil 클래스의 insertAddress 메서드를 호출하여 주소를 데이터베이스에 추가합니다.
				db.insertAddress(name, address, phone);
				
				System.out.println("주소록 등록 완료.");
				System.out.println("============================");
				
			} else if(cmd.equals("list")) {
				// 사용자가 "list"를 입력하면 데이터베이스에서 주소 목록을 가져와 출력합니다.
				ArrayList<Addr> addrList = db.getAddresses();
				WebView wv = new WebView();
				// WebView 클래스의 printAddr 메서드를 호출하여 주소 목록을 출력합니다.
				wv.printAddr(addrList);
				
				
			} else if(cmd.equals("update")) {
				// 사용자가 "update"를 입력하면 수정할 주소록을 지정하고 새로운 세부 정보를 입력하도록 요청합니다.
				System.out.print("몇번 주소록을 수정하시겠습니까 : ");
				int id = Integer.parseInt(scan.nextLine()); 
				System.out.println("========= 주소록 수정 =========");
				System.out.print("이름 : ");
				String name = scan.nextLine();
				System.out.print("주소 : ");
				String address = scan.nextLine();
				System.out.print("전화번호 : ");
				String phone = scan.nextLine();

				// DBUtil 클래스의 updateAddress 메서드를 호출하여 지정된 주소록을 업데이트합니다.
				db.updateAddress(id, name, address, phone);
				
				System.out.println("주소록 수정 완료.");
				System.out.println("============================");
				
			} else if(cmd.equals("delete")) {
				// 사용자가 "delete"를 입력하면 삭제할 주소록을 지정하고 데이터베이스에서 제거합니다.
				System.out.print("몇번 주소록을 삭제하시겠습니까 : ");
				int id = Integer.parseInt(scan.nextLine());
				// DBUtil 클래스의 deleteAddress 메서드를 호출하여 지정된 주소록을 삭제합니다.
				db.deleteAddress(id);
				System.out.println(id + "번 주소록이 삭제되었습니다.");
				System.out.println("==============================");
			}
		}	
	}
}
