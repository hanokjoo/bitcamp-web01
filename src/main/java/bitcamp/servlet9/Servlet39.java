/* 주제: HttpSession 보관소
 * => HttpSession 객체를 사용하려 할 때 해당 객체가 없으면 새로 생성한다.
 *    그리고 그 세션 아이디를 쿠키로 웹 브라우저에게 맡긴다.
 * => 웹 브라우저가 웹 서버로부터 세션 아이디를 받으면,
 *    다음에 해당 웹 서버에 요청할 때마다 세션아이디를 쿠키로 보낸다.
 * => 웹 서버는 클라이언트가 보낸 세션 아이디로 해당 HttpSession 객체를 찾는다.
 */
package bitcamp.servlet9;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet/servlet39")
public class Servlet39 extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    // 웹 브라우저가 세션 아이디를 쿠키로 보내지 않았으면,
    // 새로 HttpSession 객체를 만들어 리턴한다.
    // 만약 웹 브라우저가 세션 아이디를 보냈으면,
    // 해당 HttpSession 객체를 찾아 리턴한다.
    HttpSession session = request.getSession();
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.printf("세션 아이디: %s<br>\n", session.getId());
    
    Calendar cal = Calendar.getInstance();
    cal.setTimeInMillis(session.getCreationTime());
    out.printf("세션 생성시간: %s:%s:%s\n", 
        cal.get(Calendar.HOUR),
        cal.get(Calendar.MINUTE),
        cal.get(Calendar.SECOND));
  }
}

/* getSession()을 호출할 때,
 * 다음과 같이 요청 헤더의 쿠키 데이터에 세션 아이디가 없으면 웹 서버는 새 HttpSession 객체를 만든다.
  --------------------------------------------------------
  GET /bitcamp-web01/servlet/servlet39 HTTP/1.1
  Host: localhost:8080
  Connection: keep-alive
  Upgrade-Insecure-Requests: 1
  User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36
  Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*...
  Accept-Encoding: gzip, deflate, sdch, br
  Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4
  -----------------------------------------------------------
  
 * 클라이언트에게 응답할 때 새로 만든 세션 HttpSession 객체의 아이디를 다음과 같이 쿠키로 보낸다.
  -----------------------------------------------------------
  HTTP/1.1 200 OK
  Server: Apache-Coyote/1.1
  Set-Cookie: JSESSIONID=4E4B1579BAF7CED9A294BD20F4C266E5; Path=/bitcamp-web01; HttpOnly
  Content-Type: text/html;charset=UTF-8
  Content-Length: 80
  Date: Fri, 23 Dec 2016 06:53:42 GMT
  -----------------------------------------------------------
 */

/* getSession()을 호출할 때,
 * 다음과 같이 요청 헤더의 쿠키 데이터에 세션 아이디가 있으면 
 * 웹 서버는 그 아이디에 해당하는 HttpSession 객체를 찾는다.
  --------------------------------------------------------
  GET /bitcamp-web01/servlet/servlet39 HTTP/1.1
  Host: localhost:8080
  Connection: keep-alive
  Cache-Control: max-age=0
  Upgrade-Insecure-Requests: 1
  User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36
  Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*...
  Accept-Encoding: gzip, deflate, sdch, br
  Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4
  Cookie: JSESSIONID=4E4B1579BAF7CED9A294BD20F4C266E5
  -----------------------------------------------------------
  
  * 기존 HttpSession 객체를 사용한 경우에는 이미 클라이언트에게 세션 아이디를 보냈다는 의미이므로
  * 응답할 때 세션 아이디를 쿠키로 다시 보내지 않는다.
  -----------------------------------------------------------
  HTTP/1.1 200 OK
  Server: Apache-Coyote/1.1
  Content-Type: text/html;charset=UTF-8
  Content-Length: 84
  Date: Fri, 23 Dec 2016 06:54:20 GMT
  -----------------------------------------------------------
 */
