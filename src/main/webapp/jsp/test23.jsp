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

<%-- c:if 태그
=> 조건이 참이면 내용(시작태그와 끝태그 사이에 있는 것) 부분을 실행한다.
--%>

<c:set var="name" value="홍길동"/>

<c:if test="${name != null}"> name이 있다.</c:if>,
<c:if test="${not empty name}"> name이 있다.</c:if>
<c:if test="${!empty name}"> name이 있다.</c:if>
<c:if test="${empty name2}"> name2가 없다.</c:if>

--------------------------------------------------
<%-- 실행 결과를 보관소에 저장할 수 있다. --%>
<c:if test="${name != null}" var="result1" scope="page"/>
<c:if test="${name2 != null}" var="result2" scope="page"/>

result1: ${pageScope.result1}
result2: ${pageScope.result2}