package common;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBConnPool {
  public Connection con;
  public Statement stmt;
  public PreparedStatement psmt;
  public ResultSet rs;

public JDBConnPool() {
        try {
        // 커넥션 풀(DataSource) 얻기
        Context initCtx = new InitialContext();
        Context ctx = (Context)initCtx.lookup("java:comp/env");
        DataSource source = (DataSource)ctx.lookup("jdbc/mytestone");

        // 커넥션 풀을 통해 연결 얻기
        con = source.getConnection();

        System.out.println("DB 커넥션 풀 연결 성공");
        }
        catch (Exception e) {
        System.out.println("DB 커넥션 풀 연결 실패");
        e.printStackTrace();
        }
        }

// 연결 해제(자원 반납)
public void close() {
        try {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (psmt != null) psmt.close();
        if (con != null) con.close();  // 자동으로 커넥션 풀로 반납됨

        System.out.println("DB 커넥션 풀 자원 반납");
        }
        catch (Exception e) {
        e.printStackTrace();
        }
        }
        }