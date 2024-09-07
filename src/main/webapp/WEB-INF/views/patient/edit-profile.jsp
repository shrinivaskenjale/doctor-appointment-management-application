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
    <form class="form" action="/patient/edit-profile" method="post">
      <h2>Update Profile</h2>
      <div class="form-control">
        <label for="full-name">Full Name</label>
        <input
          type="text"
          name="fullName"
          id="full-name"
          value="${patient.getFullName()}"
        />
        <ul class="form-control-errors">
          <c:forEach items="${errors.getFieldErrors('fullName')}" var="error">
            <li><small>${error.defaultMessage}</small></li>
          </c:forEach>
        </ul>
      </div>
      <div class="form-control">
        <label for="email">Email</label>
        <input
          type="email"
          name="email"
          id="email"
          value="${patient.getEmail()}"
        />
        <ul class="form-control-errors">
          <c:forEach items="${errors.getFieldErrors('email')}" var="error">
            <li><small>${error.defaultMessage}</small></li>
          </c:forEach>
        </ul>
      </div>
      <!-- <div class="form-control">
        <label for="">Password</label>
        <input type="password" name="password" />
      </div> -->
      <div class="form-control">
        <label for="mobile">Mobile No.</label>
        <input
          type="text"
          minlength="10"
          maxlength="10"
          id="mobile"
          name="mobileNumber"
          value="${patient.getMobileNumber()}"
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
      <!-- <div class="form-control">
        <label for="">Gender</label>
        <select name="gender" id="">
          <option value="Male">Male</option>
          <option value="Female">Female</option>
          <option value="Other">Other</option>
        </select>
      </div> -->
      <!-- <div class="form-control">
        <label for="">Date of Birth</label>
        <input type="date" name="dob" id="" />
      </div> -->
      <div class="form-control">
        <label for="address">Address</label>
        <textarea name="address" id="address" cols="30" rows="10">
${patient.getAddress()}</textarea
        >
        <ul class="form-control-errors">
          <c:forEach items="${errors.getFieldErrors('address')}" var="error">
            <li><small>${error.defaultMessage}</small></li>
          </c:forEach>
        </ul>
      </div>
      <input type="hidden" name="id" value="${patient.getId()}" />
      <div class="form-buttons">
        <button type="submit" class="btn">Save</button>
      </div>
    </form>
  </body>
</html>
