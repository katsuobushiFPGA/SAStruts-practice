<%@page pageEncoding="UTF-8"%>
<html>
<body>
<c:choose>
  <c:when test="${empId >= 30}">empId : 30以上  <br/> <c:out value="${empId}"/></c:when>
  <c:when test="${empId >= 20}">empId : 20 < 30 <br/> <c:out value="${empId}"/></c:when>
  <c:when test="${empId >= 10}">empId : 10 < 20 <br/> <c:out value="${empId}"/></c:when>
  <c:otherwise>empId : 10以下 <c:out value="${empId}"/> </c:otherwise>
</c:choose>


</body>
</html>