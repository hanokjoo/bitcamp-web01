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

<%-- c:remove 태그의 삭제 동작 확인 --%>

<c:set var="name" value="홍길동"/>
<c:set var="name" value="임꺽정" scope="request"/>
<c:set var="name" value="유관순" scope="session"/>
<c:set var="name" value="안중근" scope="application"/>

${pageScope.name},${requestScope.name},${sessionScope.name},${applicationScope.name}
---------------------------

<%-- 특정 보관소의 값만 제거하고 싶다면, 명확히 보관소를 지정하라! --%>
<c:remove var="name" scope="request"/>
${pageScope.name},${requestScope.name},${sessionScope.name},${applicationScope.name}
---------------------------

<%-- 만약 scope를 지정하지 않는ㄷ면 모든 보관소를 뒤져 해당 이름으로 저장된 값을 제거한다. --%>
<c:remove var="name"/>
${pageScope.name},${requestScope.name},${sessionScope.name},${applicationScope.name}
