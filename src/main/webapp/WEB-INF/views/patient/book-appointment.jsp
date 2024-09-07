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
    <form class="form" action="/patient/book-appointment" method="post">
      <h2>Book an Appointment</h2>
      <div class="form-control">
        <label for="doctor">Doctor</label>
        <select name="doctorId" id="doctor">
          <c:forEach items="${doctors}" var="doctor">
            <option value="${doctor.getId()}">
              ${ doctor.getFullName() } - ${ doctor.getSpecialization() }
            </option>
          </c:forEach>
        </select>
        <ul class="form-control-errors">
          <c:forEach items="${errors.getFieldErrors('doctorId')}" var="error">
            <li><small>${error.defaultMessage}</small></li>
          </c:forEach>
        </ul>
      </div>
      <div class="form-control">
        <label for="date">Date</label>
        <input type="date" name="date" id="date" />
        <ul class="form-control-errors">
          <c:forEach items="${errors.getFieldErrors('date')}" var="error">
            <li><small>${error.defaultMessage}</small></li>
          </c:forEach>
        </ul>
      </div>
      <div class="form-control">
        <label for="description">Description</label>
        <textarea
          name="description"
          id="description"
          cols="30"
          rows="10"
        ></textarea>
      </div>
      <div class="form-buttons">
        <button type="submit" class="btn">Book Appointment</button>
      </div>
    </form>
  </body>
</html>
