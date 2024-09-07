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
    <main>
      <div class="container">
        <div class="container-center">
          <h2 class="section-title">My Appointments</h2>
          <ul class="grid-list appointment-list">
            <c:forEach items="${appointments}" var="appointment">
              <li class="grid-list-item appointment-item">
                <p>Doctor: Dr. ${appointment.getDoctor().getFullName()}</p>
                <p>Date: ${appointment.getDate()}</p>
                <p>Status: ${appointment.getStatus()}</p>
                <p>Remarks: <i>${appointment.getRemarks()}</i></p>
                <c:if test="${appointment.getStatus() ne 'Cancelled'}">
                  <div class="button-group">
                    <form
                      action="/patient/cancel-appointment/${appointment.getId()}"
                      method="post"
                    >
                      <button type="submit" class="btn">Cancel</button>
                    </form>
                  </div>
                </c:if>
              </li>
            </c:forEach>
          </ul>
        </div>
      </div>
    </main>
  </body>
</html>
