<%@page pageEncoding="UTF-8"%>
<html>
<body>
<s:form>
値 : ${f:h(userId) } <br/>
値 : ${f:h(userName) } <br/>
<input type="submit" name="register" value="登録" />
</s:form>
</body>
</html>