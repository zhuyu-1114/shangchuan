<%--
  Created by IntelliJ IDEA.
  User: 朱瑜
  Date: 2020/11/10
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form>
      <p>
        <label for="pwd">用户名∶</label>
        <input type="password" id="user" name="user"/>
      </p>
      <p>
        <label for="pwd">密为∶</label>
        <input type="password" id="pwd" name="pwd">
      </p>
      <p>
        <label for="phone">电话∶</label>
        <input type="text" id="phone" name="phone"></p>
      <p>
        <label for="validCode">验证码∶</label>
        <input type="text" id="validCode" name="validCode"><input type="button" value="获取验证码"/>
      </p>
      <p>
        <input type="submit" value="注册"></p>
    </form>
  </body>
</html>
