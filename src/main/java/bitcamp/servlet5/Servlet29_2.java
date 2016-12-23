/* 주제: 포워드(forward)
 */
package bitcamp.servlet5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/servlet29_2")
public class Servlet29_2 extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("서블릿 2");
    
    String submenuNo = request.getParameter("submenuNo");
    
    // 메뉴 번호가 있을 경우 해당 번호의 서블릿으로 실행을 위임한다.
    if ("s1".equals(submenuNo)) {
      RequestDispatcher rd = request.getRequestDispatcher("/servlet/servlet29_2_1");
      rd.forward(request, response);
//      System.out.println("s1 돌아온다"); // servlet29_2가 실행을 끝내고 돌아온다면 출력될것이다.
      return;
    
    } else if ("s2".equals(submenuNo)) {
      RequestDispatcher rd = request.getRequestDispatcher("/servlet/servlet29_2_2");
      rd.forward(request, response);
//      System.out.println("s2 돌아온다"); // servlet29_3가 실행을 끝내고 돌아온다면 출력될것이다.
      return;
    }
  }
}
