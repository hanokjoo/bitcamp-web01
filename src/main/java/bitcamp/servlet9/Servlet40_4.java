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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet/servlet40_4")
public class Servlet40_4 extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    // 세션에 데이터 보관된 데이터 꺼내기
    HttpSession session = request.getSession();
    String name = (String)session.getAttribute("name");
    String email = (String)session.getAttribute("email");
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.printf("name: %s\n", name);
    out.printf("email: %s\n", email);
    out.printf("tel: %s\n", request.getParameter("tel"));
  }
}