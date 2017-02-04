<%@page pageEncoding="UTF-8"%>
<html>
<body>
<html:errors/>
<s:form method="POST">
name : <input type="text" name="name" />
age : <input type="text" name="age" />
<select name="products" multiple>
	<option value="S2Container">S2Container</option>
	<option value="SAStruts">SAStruts</option>
	<option value="S2JDBC">S2JDBC</option>>
</select>
<input type="submit" name="confirm" value="登録する" />
<input type="submit" name="reset" value="リセット" />
</s:form>
</body>
</html>