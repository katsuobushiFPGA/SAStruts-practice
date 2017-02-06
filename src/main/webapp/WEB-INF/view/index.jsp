<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Dolteng Auto Generated</title>
</head>
<body>
<h1>Hello World!</h1>
<p> Message : ${message} </p>
<p> Message.property : ${mapMsg.property} </p>
<p> List : ${listMsg[0]} </p>
<p> Map : ${mapMsg['key']} </p>
<p> 演算 1 + 2 : ${1 + 2} </p>
<c:if test="${empty searchResult}">
検索結果は０件です。
</c:if>
<c:if test="${!empty searchResult}">
<ul>
  <c:forEach items="${searchResult}" var="item">
     <li>${f:h(item)}</li>
  </c:forEach>
</ul>
</c:if>

<html:errors/>
<s:form>
<input type="text" name = "arg0" /> +
<input type="text" name = "arg1" /> = ${ans}
<input type="submit" name="calc" value="計算"/>
</s:form>
</body>
</html>