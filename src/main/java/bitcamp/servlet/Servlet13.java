package bitcamp.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet13")
public class Servlet13 extends GenericServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    
    try {
      File file = new File("C:/Users/BitCamp/Desktop/강동원.jpg");
      FileInputStream in = new FileInputStream(file);
      
      response.setContentType("image/jpeg");
      PrintWriter out = response.getWriter();

      int b = 0;
      while ((b = in.read()) != -1) {
        out.write(b);
      }
      out.flush();
      out.close();
      in.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
