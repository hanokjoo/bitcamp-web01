/* 주제: 필터테스트
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
@WebServlet("/servlet/servlet34")
public class Servlet34 extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("Servlet34.service()");
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("Servlet34");
  }
}
