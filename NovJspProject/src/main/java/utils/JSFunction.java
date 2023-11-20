package utils;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
import java.io.PrintWriter;

public class JSFunction {

  // 메세지 알림창을 띄운 후 명시한 URL로 이동합니다.
  public static void alertLocation(HttpServletResponse resp,String msg, String url) {
    try {
      resp.setContentType("text/html; charset=utf-8");
      PrintWriter writer = resp.getWriter();
      String script =""
                  +"<script>"
                  +"  alert('"+msg+"');"
                  +"  location.hrf='"+url+"';"
                  +"</script>";
      writer.println(script);
    } catch (Exception e) {}
  }


    // 메세지 알림창을 띄운 후 이전 페이지로 돌아갑니다.
    public static void alertBack(HttpServletResponse resp,String msg) {
      try {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        String script =""
                +"<script>"
                +"  alert('"+msg+"');"
                +"  history.back();"
                +"</script>";
        writer.println(script);
      } catch (Exception e) {}
    }
  }