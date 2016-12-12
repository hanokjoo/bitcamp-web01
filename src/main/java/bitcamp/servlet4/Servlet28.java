/* 주제: POST 요청에서 한글이 깨지는 이유
 * => 사용자가 입력한 데이터 ---> Servlet ---> getParameter("파라미터명") ---> 데이터
 * => getParameter()는 클라이언트가 보낸 값이 ISO-8859-1 방식으로 인코딩 되었다고 간주한다.
 *    그래서 입력한 데이터가 모두 영어라고 간주하고 무조건 2바이트로 만들어 리턴한다. 
 */
package bitcamp.servlet4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/servlet28")
public class Servlet28 extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    String data1 = request.getParameter("data1");
    for (int i = 0; i < data1.length(); i++) {
      out.printf("[%c]-%x\n", data1.charAt(i), (int)data1.charAt(i));
    }
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    // 클라이언트에서 보낸 데이터가 어떤 형식으로 인코딩 되었는지 먼저 설정한다.
    request.setCharacterEncoding("UTF-8");
    String data1 = request.getParameter("data1");
    for (int i = 0; i < data1.length(); i++) {
      out.printf("[%c]-%x\n", data1.charAt(i), (int)data1.charAt(i));
    }
  }
}
