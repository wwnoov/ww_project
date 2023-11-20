package filter;

import membership.MemberDAO;
import membership.MemberDTO;
import utils.JSFunction;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName="LoginFilter", urlPatterns="/15FilterListener/LoginFilter.jsp")
public class LoginFilter implements Filter {

  // 회원 정보를 얻어오기 위해 필요한 데이터베이스 접속 정보
  String oracleDriver, oracleURL, oracleId, oraclePwd;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    ServletContext application = filterConfig.getServletContext();

    oracleDriver = application.getInitParameter("OracleDriver");
    oracleURL = application.getInitParameter("OracleURL");
    oracleId = application.getInitParameter("OracleId");
    oraclePwd = application.getInitParameter("OraclePwd");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
                       FilterChain chain)
          throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest)request;
    HttpServletResponse resp = (HttpServletResponse)response;
    HttpSession session = req.getSession();

    String method = req.getMethod();
    if(method.equals("POST")) {
      //getParameter() 메서드는 req, request 둘다 사용가능함.
      String user_id = req.getParameter("user_id");
      String user_pw = req.getParameter("user_pw");

      MemberDAO dao = new MemberDAO(oracleDriver, oracleURL, oracleId, oraclePwd);
      MemberDTO memberDTO = dao.getMemberDTO(user_id, user_pw);
      dao.close();

      if (memberDTO.getId() != null) {
        session.setAttribute("UserId", memberDTO.getId());
        session.setAttribute("UserName", memberDTO.getName());

        String backUrl = req.getParameter("backUrl");
        if(backUrl!=null && !backUrl.equals("")) {
          JSFunction.alertLocation(resp, "로그인 전 요청한 페이지로 이동합니다.", backUrl);
          return;
        }
        else {
          resp.sendRedirect("../15FilterListener/LoginFilter.jsp");
        }
      }
      else {
        req.setAttribute("LoginErrMsg", "로그인에 실패했습니다.");
        req.getRequestDispatcher("../15FilterListener/LoginFilter.jsp")
                .forward(req, resp);
      }
    }
    else if(method.equals("GET")) {
      String mode = req.getParameter("mode");
      if(mode!=null && mode.equals("logout")) {
        session.invalidate();
      }
    }
    chain.doFilter(request, response);
  }
}