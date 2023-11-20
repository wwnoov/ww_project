package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
  private static final long serialVersionUID =1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("message","Hello Servlet..!!");
    req.getRequestDispatcher("/12Servlet/HelloServlet.jsp").forward(req,resp);
  }
}
