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

    <form class="form" action="/patient/register" method="post">
      <h2>Register Patient</h2>
      <div class="form-control">
        <label for="full-name">Full Name</label>
        <input type="text" name="fullName" id="full-name" />
        <ul class="form-control-errors">
          <c:forEach items="${errors.getFieldErrors('fullName')}" var="error">
            <li><small>${error.defaultMessage}</small></li>
          </c:forEach>
        </ul>
      </div>
      <div class="form-control">
        <label for="email">Email</label>
        <input type="email" name="email" id="email" />
        <ul class="form-control-errors">
          <c:forEach items="${errors.getFieldErrors('email')}" var="error">
            <li><small>${error.defaultMessage}</small></li>
          </c:forEach>
        </ul>
      </div>
      <div class="form-control">
        <label for="password">Password</label>
        <input type="password" name="password" id="password" />
        <ul class="form-control-errors">
          <c:forEach items="${errors.getFieldErrors('password')}" var="error">
            <li><small>${error.defaultMessage}</small></li>
          </c:forEach>
        </ul>
      </div>
      <div class="form-control">
        <label for="mobile">Mobile No.</label>
        <input
          type="text"
          minlength="10"
          maxlength="10"
          name="mobileNumber"
          id="mobile"
        />
        <ul class="form-control-errors">
          <c:forEach
            items="${errors.getFieldErrors('mobileNumber')}"
            var="error"
          >
            <li><small>${error.defaultMessage}</small></li>
          </c:forEach>
        </ul>
      </div>
      <div class="form-control">
        <label for="gender">Gender</label>
        <select name="gender" id="gender">
          <option value="Male">Male</option>
          <option value="Female">Female</option>
          <option value="Other">Other</option>
        </select>
        <ul class="form-control-errors">
          <c:forEach items="${errors.getFieldErrors('gender')}" var="error">
            <li><small>${error.defaultMessage}</small></li>
          </c:forEach>
        </ul>
      </div>
      <div class="form-control">
        <label for="dob">Date of Birth</label>
        <input type="date" name="dob" id="dob" />
        <ul class="form-control-errors">
          <c:forEach items="${errors.getFieldErrors('dob')}" var="error">
            <li><small>${error.defaultMessage}</small></li>
          </c:forEach>
        </ul>
      </div>
      <div class="form-control">
        <label for="address">Address</label>
        <textarea name="address" id="address" cols="30" rows="10"></textarea>
        <ul class="form-control-errors">
          <c:forEach items="${errors.getFieldErrors('address')}" var="error">
            <li><small>${error.defaultMessage}</small></li>
          </c:forEach>
        </ul>
      </div>
      <div class="form-buttons">
        <button type="submit" class="btn">Register</button>
      </div>
    </form>
  </body>
</html>
