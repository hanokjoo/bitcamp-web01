<%@page import="java.util.ArrayList"%>
<%@ page language="java"
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<%--JSP 확장 태그(JSP Standard Tag Library; JSTL)
=> JSP 라이브러리에 기본으로 포함되어 있지 않다.
=> JSTL 규격에 맞추어 개발된 구현체를 별도로 다운로드 받아야 한다.
   - build.gradle 파일에 JSTL 라이브러리 포함
=> JSP 페이지에서 이 라이브러리를 사용하려면 taglib 지시어를 이용하여 임포트해야 한다.
   - <%@ taglib uri="JSTL 라이브러리 네임스페이스" prefix="별명/접두어"%>
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- c:set 태그
=> 보관소에 저장할 변수 선언
=> 주요 속성
var : 변수명
value : 값
scope : 값을 저장할 보관소. 기본이 PageContext이다.
        page | request | session | application
--%>

<c:set var="name" value="홍길동"/>

${pageScope.name},
${requestScope.name},
${sessionScope.name},
${applicationScope.name},

---------------------------
<c:set var="name2" scope="request">임꺽정</c:set>
${pageScope.name2},
${requestScope.name2},
${sessionScope.name2},
${applicationScope.name2}
