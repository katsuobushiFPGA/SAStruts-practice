<%@page pageEncoding="UTF-8"%>
<html>
<body>
<s:form>
値: ${f:h(message)} でよろしいですか?
<br/>
<input type="hidden" name="message" value= ${f:h(message)} />
<input type="submit" name="register" value="登録する">
</s:form>
</body>
</html>