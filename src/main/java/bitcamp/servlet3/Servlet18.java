/* 주제: GET 요청과 POST 요청의 차이점
 * => 아래의 주석을 참고하라.
 * => 테스트는 /servlet/servlet18.html 을 실행하라.
 */
package bitcamp.servlet3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet/servlet18")
public class Servlet18 extends GenericServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter(); 
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>servlet18</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>파라미터 값</h1>");
    out.printf("data1=%s<br>\n", request.getParameter("data1"));
    out.printf("data2=%s<br>\n", request.getParameter("data2"));
    out.printf("data3=%s<br>\n", request.getParameter("data3"));
    out.println("</body>");
    out.println("</html>");

  }

}
