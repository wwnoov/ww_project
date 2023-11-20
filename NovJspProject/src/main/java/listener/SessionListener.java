package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

  private int sessionCount;

  @Override
  public void sessionCreated(HttpSessionEvent se) {
    sessionCount++;
    System.out.println("[리스너]세션 생성:"+ se.getSession().getId());
    System.out.println("[리스너]세션카운트:"+ this.sessionCount);
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
    sessionCount--;
    System.out.println("[리스너]세션 소멸:"+ se.getSession().getId());
    System.out.println("[리스너]세션카운트:"+ this.sessionCount);
  }
}