<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="/style.css" />
  </head>
  <body>
    <%@ include file="../header.jsp" %>
    <form class="form" action="/admin/login" method="post">
      <h2>Admin Login</h2>
      <c:if test="${not empty loginError}">
        <p class="general-error"><small>${loginError}</small></p>
      </c:if>
      <div class="form-control">
        <label for="email">Email</label>
        <input type="email" name="email" id="email" value="admin@test.com" />
        <ul class="form-control-errors">
          <c:forEach items="${errors.getFieldErrors('email')}" var="error">
            <li><small>${error.defaultMessage}</small></li>
          </c:forEach>
        </ul>
      </div>
      <div class="form-control">
        <label for="password">Password</label>
        <input type="password" name="password" id="password" value="admin" />
        <ul class="form-control-errors">
          <c:forEach items="${errors.getFieldErrors('password')}" var="error">
            <li><small>${error.defaultMessage}</small></li>
          </c:forEach>
        </ul>
      </div>
      <div class="form-buttons">
        <button type="submit" class="btn">Login</button>
      </div>
    </form>
  </body>
</html>
