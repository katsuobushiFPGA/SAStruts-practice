<%@page pageEncoding="UTF-8"%>
<html>
<body>
<html:errors/>
<s:form method="POST">
<select name="products" multiple>
	<option value="S2Container">S2Container</option>
	<option value="SAStruts">SAStruts</option>
	<option value="S2JDBC">S2JDBC</option>
</select>
<s:submit property="confirm" value="登録する"/>
</s:form>
</body>
</html>