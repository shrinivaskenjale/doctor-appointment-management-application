<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<header class="header">
  <div class="header-center">Health+ Clinic</div>
</header>
<c:set var="role" value="${sessionScope.role}" />
<nav>
  <ul>
    <li><a href="/">Home</a></li>
    <c:if test="${empty role}">
      <li><a href="/admin/login">Login Admin</a></li>
      <li><a href="/patient/login">Login Patient</a></li>
      <li><a href="/patient/register">Register Patient</a></li>
    </c:if>
    <c:if test="${ role eq 'admin'}">
      <li><a href="/admin/doctor-list">Doctor List</a></li>
      <li><a href="/admin/register-doctor">Register Doctor</a></li>
      <li><a href="/admin/appointment-list">Appointment List</a></li>
    </c:if>
    <c:if test="${role eq 'patient'}">
      <li><a href="/patient/my-appointments">My Appointments</a></li>
      <li><a href="/patient/book-appointment">Book Appointment</a></li>
      <li><a href="/patient/edit-profile">Edit Profile</a></li>
    </c:if>
    <c:if test="${not empty role}">
      <li>
        <form action="/logout" method="post">
          <button class="logout-btn" type="submit">Logout</button>
        </form>
      </li>
    </c:if>
  </ul>
</nav>
