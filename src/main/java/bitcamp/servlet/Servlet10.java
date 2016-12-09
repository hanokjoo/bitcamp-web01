package bitcamp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet10")
public class Servlet10 extends GenericServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.printf("getScheme(): %s\n", request.getScheme());
    out.printf("getProtocol(): %s\n", request.getProtocol());
    out.printf("getServerName(): %s\n", request.getServerName());
    out.printf("getRemoteAddr(): %s\n", request.getRemoteAddr());
    out.printf("getRemotePort(): %s\n", request.getRemotePort());
  }

}
