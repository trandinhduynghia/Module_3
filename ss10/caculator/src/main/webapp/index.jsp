<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/14/2022
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Caculator</title>
  </head>
  <body>
  <h1>Simple Caculator</h1>
  <form method="post" action="/calculate">
  <fieldset>
    <legend>Caculator</legend>
    <table>
      <tr>
        <td>First operand: </td>
        <td><input name="first-operand" type="text"></td>
      </tr>
      <tr>
        <td>Opearator: </td>
        <td>
          <select name="opearator">
            <option value="+">addition</option>
            <option value="-">suctraction</option>
            <option value="*">multiplication</option>
            <option value="/">divition</option>
            <option value="...">...</option>
          </select>
        </td>
      </tr>
      <tr>
        <td>Second operand: </td>
        <td><input name="second-operand" type="text"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Calculate"></td>
      </tr>
    </table>
  </fieldset>
  </form>
  </body>
</html>
