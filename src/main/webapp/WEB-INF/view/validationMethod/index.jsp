<%@page pageEncoding="UTF-8"%>
<html>
<body>
<s:form method="POST">
<table>
 <tr>
   <th>ID : </th>
   <td><input type="text" name="id" value="${id}" /> </td>
   <td><html:errors property="id" /></td>
 </tr>
 <tr>
   <th>名前 : </th>
   <td><input type="text" name="name" value="${name}" /> </td>
   <td><html:errors property="name" /></td>
 </tr>
</table>
<input type="submit" name="confirm" value="登録する" />
<input type="submit" name="reset" value="リセット" />
</s:form>
</body>
</html>