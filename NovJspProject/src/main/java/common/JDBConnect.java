package common;

import javax.servlet.ServletContext;
import java.sql.*;

public class JDBConnect {
  public Connection con;
  public Statement stmt;
  public PreparedStatement psmt;
  public ResultSet rs;

  // 기본 생성자
  public JDBConnect(){
    try {
      // JDBC 드라이버 로드
      Class.forName("com.mysql.jdbc.Driver");
      // DB에 연결
      String url ="jdbc:mysql://localhost:3306/mytestone";
      String id = "root";
      String pwd = "12345";
      con = DriverManager.getConnection(url, id, pwd);
      System.out.println("DB 연결 성공(기본 생성자)");
    }
    catch (Exception e){
      e.printStackTrace();
    }
  }

  // 두번째 생성자
  public JDBConnect(String driver,String url, String id, String pwd){
    try {
      // JDBC 드라이버 로드
      Class.forName(driver);
      // DB에 연결
      con = DriverManager.getConnection(url, id, pwd);
      System.out.println("DB 연결 성공(인수 생성자1)");
    }
    catch (Exception e){
      e.printStackTrace();
    }
  }
  // 세번째 생성자
  public JDBConnect(ServletContext application) {
    try {
      // JDBC 드라이버 로드
      String driver = application.getInitParameter("MySQL_Driver");
      Class.forName(driver);

      // DB에 연결
      String url = application.getInitParameter("MySQL_URL");
      String id = application.getInitParameter("MySQL_Id");
      String pwd = application.getInitParameter("MySQL_Pwd");
      con = DriverManager.getConnection(url, id, pwd);

      System.out.println("DB 연결 성공(인수 생성자 2)");
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  //연결 해제 (자원 반납)
  public void close(){
    try {
      if (rs != null) rs.close();
      if (stmt != null) stmt.close();
      if (psmt != null) psmt.close();
      if (con != null) con.close();

      System.out.println("JDBC 자원 해제");
    }
    catch (Exception e){
      e.printStackTrace();
    }
  }
}
