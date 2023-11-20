package membership;

import common.JDBConnect;

import java.sql.SQLException;

public class MemberDAO extends JDBConnect {
  // 명시한 데이터 베이스로의 연결이 완료된 MemberDAO 객체를 생성합니다.
  public MemberDAO(String driver, String url, String id, String pwd){
    super(driver, url, id, pwd);
  }

  // 명시한 아이디 / 패스워드와 일치하는 회원 정보를 반환합니다.
  public MemberDTO getMemberDTO(String uid,String upass){
    MemberDTO dto = new MemberDTO(); // 회원정보 DTO 객체 생성
    String query = "SELECT * FROM member WHERE id =? AND pass =?"; //쿼리문

    try {
      //쿼리실행
      psmt = con.prepareStatement(query); //동적쿼리문 준비
      psmt.setString(1,uid); // 쿼리문 첫번째 인파라미터에 값 설정
      psmt.setString(2,upass); // 쿼리문 두번째 인파라미터에 값 설정
      rs = psmt.executeQuery(); //쿼리문실행

      //결과처리
      if (rs.next()){
        //쿼리 결과로 얻은 회원 정보를 DTO객체에 저장
        dto.setId(rs.getString("id"));
        dto.setPass(rs.getString("PASS"));
        dto.setName(rs.getString(3));
        dto.setRegidate(rs.getString(4));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return dto; //DTO겍체 반환
  }
}
