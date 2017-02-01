<%@page pageEncoding="UTF-8"%>
<html>
<body>
<html:errors/>
<s:form method="POST">
値 : <input type="text" name="message" />
<s:submit property="confirm" value="登録する"/>
<input type="submit" name="confirm" value="登録する" />
</s:form>
</body>
</html>