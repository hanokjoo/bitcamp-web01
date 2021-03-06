/* 주제: 쿠키 받기
 * => 쿠키를 보낸 URL과 같은 경로에 소속되어 있다면 쿠키를 받을 수 있다.
 * => 예)
 *    보낸 URL: /bitcamp-web01/servlet/servlet37
 *    받을 URL: /bitcamp_web01/servlet/servlet37_2
*/
package bitcamp.servlet8;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/servlet38_2")
public class Servlet38_2 extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    // 요청 헤더에 포함된 쿠키 데이터 꺼내기
    Cookie[] cookies = request.getCookies();
    HashMap<String, String> cookieMap = new HashMap<String, String>();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        cookieMap.put(cookie.getName(), cookie.getValue());
      }
    }
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("Servlet38_2");
    // URL 인코딩하여 저장했다면 꺼낼 때 직접 디코딩해야 한다.
    out.printf("value5=%s\n", cookieMap.get("value5"));
    out.printf("value6=%s\n", cookieMap.get("value6"));
    out.printf("value7=%s\n", cookieMap.get("value7"));
  }
}
