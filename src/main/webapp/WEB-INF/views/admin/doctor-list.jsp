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
            <h2 class="section-title">Doctor List</h2>
            <ul class="grid-list doctor-list">
             
             
              <c:forEach items="${doctors}" var="doctor">
                <li class="grid-list-item doctor-item">
                  <h3>Dr ${doctor.getFullName()}</h3>
                  <h4>${doctor.getSpecialization()}</h4>
                  <p>${doctor.getEmail()}</p>
                  <p>${doctor.getMobileNumber()}</p>
                  <div class="button-group">
                    <form action="/admin/delete-doctor" method="post">
                      <input type="hidden" name="doctorId" value="${doctor.getId()}">
                      <button class="btn" type="submit">Delete</button>
                    </form>
                    <a class="btn" href="/admin/edit-doctor/${doctor.getId()}">Edit</a>
                  </div>
                </li>
              </c:forEach>


            </ul>
          </div>
        </div>
      </main>
  </body>

  </html>