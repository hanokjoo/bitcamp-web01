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

<%-- c:remove 태그
=> 보관소에 저장된 값 제거하기
=> 주요 속성
var : 변수명
scope : 값이 저장된 보관소. 기본이 PageContext이다.
        page | request | session | application
--%>

<c:set var="name1" value="홍길동"/>
<c:set var="name2" value="임꺽정" scope="request"/>
<c:set var="name3" value="유관순" scope="session"/>
<c:set var="name4" value="안중근" scope="application"/>

${name1},${name2},${name3},${name4}
---------------------------

<c:remove var="name1"/>
${name1},${name2},${name3},${name4}
---------------------------

<%--scope을 지정하지 않으면 다음 순서대로 찾아서 제거한다.
모든 보관소를 뒤져서 해당 이름으로 저장된 값을 찾아 제거한다. --%>
<c:remove var="name2"/>
${name1},${name2},${name3},${name4}
---------------------------

<c:remove var="name3"/>
${name1},${name2},${name3},${name4}
---------------------------

<c:remove var="name4"/>
${name1},${name2},${name3},${name4}
---------------------------