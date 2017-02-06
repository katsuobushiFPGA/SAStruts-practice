<%@page pageEncoding="UTF-8"%>
<html>
<body>
<s:form method="POST" enctype="multipart/form-data">
  <html:errors/>
  <html:file property="file" />
  <html:submit property="upload" value="アップロード" />
</s:form>
</body>
</html>