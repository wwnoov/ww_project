package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionAttrListener implements HttpSessionAttributeListener {

  @Override
  public void attributeAdded(HttpSessionBindingEvent se) {
    System.out.println("[리스너]세션 속성 추가:"+se.getName()+"="+se.getValue());
  }

  @Override
  public void attributeRemoved(HttpSessionBindingEvent se) {
    System.out.println("[리스너]세션 속성 제거:"+se.getName()+"="+se.getValue());
  }

  @Override
  public void attributeReplaced(HttpSessionBindingEvent se) {
    System.out.println("[리스너]세션 속성 변경:"+se.getName()+"="+se.getValue());
  }
}