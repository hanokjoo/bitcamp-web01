/* 주제: HttpServlet 클래스 상속
 */
package bitcamp.servlet4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/servlet27/list")
public class Servlet27_list extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF8");
    PrintWriter out = response.getWriter();
    
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java89db", "java89", "1111");  
        
      stmt = con.prepareStatement("select uid, pwd, name, email from ex_students");
      rs = stmt.executeQuery();

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>학생 관리-목록</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>학생 정보</h1>");
      out.println("<a href='../servlet27_form.html'>추가</a><br>");
      out.println("<table border='1'>");
      out.println("<tr>");
      out.println("  <th>아이디</th><th>암호</th><th>이름</th><th>이메일</th>");
      out.println("</tr>");
      
      while (rs.next()) {
        out.println("<tr>");
        out.printf("  <td><a href='view?userId=%s'>%1$s</a></td><td>%s</td><td>%s</td><td>%s</td>\n",
            rs.getString("uid"),
            rs.getString("pwd"),
            rs.getString("name"),
            rs.getString("email"));
        out.println("</tr>");
      }
      
      out.println("</table>");
      out.println("</body>");
      out.println("</html>");
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
}








