<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

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
    <form class="form" action="/admin/register-doctor" method="post">
      <h2>Register Doctor</h2>
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
        <label for="mobile">Mobile No.</label>
        <input
          type="text"
          minlength="10"
          maxlength="10"
          id="mobile"
          name="mobileNumber"
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
        <c:set var="genders" value='${["Male","Female","Other"]}' />
        <label for="gender">Gender</label>
        <select name="gender" id="gender">
          <c:forEach items="${genders}" var="g">
            <option value="${g}">${g}</option>
          </c:forEach>
        </select>
        <ul class="form-control-errors">
          <c:forEach items="${errors.getFieldErrors('gender')}" var="error">
            <li><small>${error.defaultMessage}</small></li>
          </c:forEach>
        </ul>
      </div>
      <div class="form-control">
        <c:set
          var="specializations"
          value='${["Cardiology","Orthopedics","Neurology","Pediatrics","Oncology","Dermatology","Psychiatry","Gynecology","Gastroenterology"]}'
        />
        <label for="specialization">Specialization</label>
        <select name="specialization" id="specialization">
          <c:forEach items="${specializations}" var="s">
            <option value="${s}">${s}</option>
          </c:forEach>
        </select>
        <ul class="form-control-errors">
          <c:forEach
            items="${errors.getFieldErrors('specialization')}"
            var="error"
          >
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
