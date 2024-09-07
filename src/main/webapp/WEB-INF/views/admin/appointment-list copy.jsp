<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
          <h2 class="section-title">Appointment List</h2>
          <ul class="grid-list appointment-list">
            <c:forEach items="${appointments}" var="appointment">
              <li class="grid-list-item appointment-item">
                <p>Patient: ${appointment.getPatient().getFullName()}</p>
                <p>Doctor: Dr. ${appointment.getDoctor().getFullName()}</p>
                <p>Date: ${appointment.getDate()}</p>
                <p>Status: ${appointment.getStatus()}</p>
                <div class="button-group">
                  <a
                    class="btn"
                    href="/admin/edit-appointment/${appointment.getId()}"
                    >Edit</a
                  >
                </div>
              </li>
            </c:forEach>
          </ul>
        </div>
      </div>
    </main>
  </body>
</html>
