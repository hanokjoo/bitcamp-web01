/* 주제: ServletContextAttributeListener 테스트
 */
package bitcamp.servlet7;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 이 서블릿은 다른 서블릿들이 사용할 값을 준비하는 역할이기 때문에 service() 메서드는 구현하지 않는다.
@WebServlet("/servlet/servlet35")
public class Servlet35 extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.getServletContext().setAttribute("name", "홍길동");
    this.getServletContext().setAttribute("age", 20);
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("Servlet35");
  }
}
