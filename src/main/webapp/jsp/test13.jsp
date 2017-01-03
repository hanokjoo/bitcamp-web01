<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java"
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>

<%-- Map에서 값을 꺼내는 방법 --%>
<%
Map<String,String> names = new HashMap<>();
names.put("s01", "홍길동");
names.put("s02", "임꺽정");
names.put("s0 3", "유관순");
names.put("s04", "안중근");
names.put("s0 $.$;", "윤봉길");
pageContext.setAttribute("names", names); 
%>

<%-- 값을 꺼내는 것은 배열과 같다. --%>
${names.s01},
${names["s02"]},
${names['s0 3']},
${names.s04},
${names['s0 $.$;']}