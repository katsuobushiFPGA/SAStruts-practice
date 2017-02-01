<%@page pageEncoding="UTF-8"%>
<html>
<body>
<html:errors/>
<s:form method="POST">
 番号もどうぞ!
 お名前をどうぞ！
 <input type="number" name = "number" />
 <html:text property ="name" />
 <s:submit property="echo" value="送信" />
 </s:form>
</body>
</html>