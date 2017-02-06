<%@page pageEncoding="UTF-8"%>
<html>
<body>
<s:form>
<html:select property="selectFileName" value="${fn:length(fileList)}">
<c:forEach var="obj" items="${fileList}" varStatus="status">
<html:option value="${obj}">${obj}</html:option>
</c:forEach>
</html:select>

<input type="submit" name="download" value="ダウンロード" />
</s:form>
</body>
</html>