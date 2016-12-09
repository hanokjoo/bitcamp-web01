package bitcamp.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet02")
public class Servlet02 implements Servlet {

  public Servlet02() {
    System.out.println("servlet02()");
  }
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    System.out.println("Servlet02.init()");
  }

  @Override
  public ServletConfig getServletConfig() {
    System.out.println("Servlet02.getServletConfig()");
    return null;
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    System.out.println("Servlet02.service()");
  }

  @Override
  public String getServletInfo() {
    System.out.println("Servlet02.getServletInfo()");
    return null;
  }

  @Override
  public void destroy() {
    System.out.println("Servlet02.destroy()");
  }

}
