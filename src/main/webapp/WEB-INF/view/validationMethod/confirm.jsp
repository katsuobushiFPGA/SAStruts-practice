<%@page pageEncoding="UTF-8"%>
<html>
<body>
<s:form>
<table>
 <tr>
   <th>ID : </th>
   <td>${f:h(id) } </td>
 </tr>
 <tr>
   <th>名前 : </th>
   <td> ${f:h(name) }</td>
 </tr>
</table>
<input type="submit" name="complete" value="登録" />
<input type="button" value="戻る" onClick="history.back()" />
</s:form>
</body>
</html>