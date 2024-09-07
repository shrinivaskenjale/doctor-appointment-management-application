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
    <form class="form" action="/admin/edit-appointment/${appointment.getId()}" method="post">
      <h2>Edit Appointment</h2>


      <div class="form-control">
        <c:set var="statuses" value='${["Pending","Cancelled","Completed"]}' />
        <label for="status">Status</label>
        <select name="status" id="status">
            <c:forEach items="${statuses}" var="s">
                <option value="${s}" <c:if test="${appointment.getStatus() eq s}">selected</c:if> >${s}</option>
            </c:forEach>
            
        </select>
      </div>
      <div class="form-control">
        <label for="remarks">Remarks</label>
        <textarea name="remarks" id="remarks">${appointment.getRemarks()}</textarea>
      </div>


      <div class="form-buttons">
        <a href="/admin/appointment-list" class="btn">Cancel</a>
        <button type="submit" class="btn">Save</button>
      </div>
    </form>
  </body>
</html>
