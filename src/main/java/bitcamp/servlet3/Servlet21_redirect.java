/* 주제: HttpServletResponse 사용 - 페이지 이동 기법
 * => HTTP 프로토콜의 응답을 다루는 기능이 들어있다. 
 * => Redirect
 */
package bitcamp.servlet3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/servlet21_redirect")
public class Servlet21_redirect extends GenericServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
    
    // 파라미터 객체를 사용하기 전에 원래의 타입으로 형변환 한 후 사용한다.
    HttpServletRequest request = (HttpServletRequest)req;
    HttpServletResponse response = (HttpServletResponse)resp;
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter(); 
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    
    out.println("<title>servlet20</title>");
    out.println("</head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>servelt21_refresh2</title>");
    out.println("</head>");
    out.println("<body>");
    for (int i = 0; i < 2000; i++) {
      out.println("<p>5초 후에 카카오 홈페이지로 이동합니다.</p>");
    }
    out.println("</body>");
    out.println("</html>");

    // Redirect 응답하기
    // => 응답 헤더의 상태 값을 xxx로 응답한다.
    // => 출력 버퍼에 저장된 내용을 모두 버린다.
    // => 즉 클라이언트로 콘텐츠를 출력하지 않는다.
    // => 당연히 웹브라우저는 아무런 내용도 받지 않았으므로 아무것도 출력하지 않는다.
    // => 아무것도 출력하는 것없이 다른 페이지로 이동하고 싶다면 리다이렉트를 사용하라.
    response.sendRedirect("http://www.daum.net");
  }

}
