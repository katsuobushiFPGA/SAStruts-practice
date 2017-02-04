<%@page pageEncoding="UTF-8"%>
<html>
<body>
値 : ${f:h(name) } <br/>
値 : ${f:h(age) } <br/>
<c:forEach var="obj" items="${products}" varStatus="status">
  名前：<c:out value="${obj}"/><br>
  index：<c:out value="${status.index}"/><br>
</c:forEach>
<input type="button" value="戻る" onClick="history.back()">
</body>
</html>