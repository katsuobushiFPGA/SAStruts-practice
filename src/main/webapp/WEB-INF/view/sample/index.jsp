<%@page pageEncoding="UTF-8"%>
<html>
<body>
<%-- Strutsのタグで表示 --%>
<bean:write name="message"/>
<br/>

<%--JSTLのタグで表示 --%>
<c:out value="${message}" />
<br/>

<%-- ELで表示 --%>
${f:h(message)}
<br/>

</body>
</html>