/* 주제: 파일 업로드 처리
 * => HTML 폼
 *    - POST 요청이어야 한다.
 *    - 인코딩 타입이 멀티파트 방식이어야 한다.
 *    예) <form action='servlet41' method="POST" enctype="multipart/form-data">
 *    
 * => 멀티파트 방식으로 데이터를 전송하는 경우 HTTP 요청 형식 예)
 *    POST /bitcamp-web01/servlet/servlet41 HTTP/1.1
      Host: localhost:8080
      Connection: keep-alive
      Content-Length: 90089
      Cache-Control: max-age=0
      Origin: http://localhost:8080
      Upgrade-Insecure-Requests: 1
      User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36
      Content-Type: multipart/form-data; boundary=----WebKitFormBoundaryVJdkh23kLmD0Eaeg
      Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*...
      Referer: http://localhost:8080/bitcamp-web01/servlet/servlet41_form.html
      Accept-Encoding: gzip, deflate, br
      Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4
      
      ------WebKitFormBoundaryVJdkh23kLmD0Eaeg
      Content-Disposition: form-data; name="userId"
      
      aaa
      ------WebKitFormBoundaryVJdkh23kLmD0Eaeg
      Content-Disposition: form-data; name="password"
      
      1111
      ------WebKitFormBoundaryVJdkh23kLmD0Eaeg
      Content-Disposition: form-data; name="name"
      
      ccc
      ------WebKitFormBoundaryVJdkh23kLmD0Eaeg
      Content-Disposition: form-data; name="photo"; filename="12.jpg"
      Content-Type: image/jpeg
      
      바이너리데이터...
      ------WebKitFormBoundaryVJdkh23kLmD0Eaeg--
      
 => 멀티파트 형식으로 데이터를 보낸경우에는,
    서버쪽에서 getParameter() 메서드로 값을 꺼낼 수 없다.
    멀티파트를 분석하여 값을 꺼내야 한다.
    안타깝게도 서블릿에 API는 멀티파트 값을 꺼내는 메서드를 제공하지 않는다.
    외부 라이브러리 도움을 받아서 처리해야 한다.
    어떤 라이브러리? https://commons.apache.org/proper/commons-fileupload/
 */
package bitcamp.servlet10;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/servlet/servlet42")
public class Servlet42 extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    // 멀티파트 형식에는 다음 문자집합 처리가 소용없다.
    //request.setCharacterEncoding("UTF-8");
    
    // 멀티파트 형식 데이터인지 여부 확인
    if (!ServletFileUpload.isMultipartContent(request)) {
      throw new ServletException("멀티파트 형식이 아닙니다.");
    }
    
    // 클라이언트가 보낸 데이터를 저장할 객체 준비
    // => HDD에 저장할 거라면, 다음 객체를 생성하라
    DiskFileItemFactory itemFactory = new DiskFileItemFactory();
    
    //멀티파트 데이터를 분석 처리할 객체 준비
    // => 이 때 생성자 파라미터 값으로 데이터 저장을 처리하는 공장을 넘겨야 한다.
    ServletFileUpload uploadHandler = new ServletFileUpload(itemFactory);
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    // 요청 데이터의 분석을 실행한다.
    try {
      // 리턴값: 멀티파트를 분석하여 그 결과를 목록으로 리턴한다.
      List<FileItem> items = uploadHandler.parseRequest(request);
      
      for (FileItem item : items) {
        if (item.isFormField()) { // 일반 폼 항목이면,
          out.printf("%s=%s\n", item.getFieldName(), item.getString("UTF-8"));
        } else { // 파일이면
          out.printf("%s=%s\n", item.getFieldName(), item.getName());
          
          // 임시 저장소에 있는 파일을 지정된 폴더로 옮긴다.
          // => 임의 폴더에 저장하기
          item.write(new File("C:/Users/BitCamp/git/bitcamp-web01/temp/" + item.getName()));
        }
      }
      
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}