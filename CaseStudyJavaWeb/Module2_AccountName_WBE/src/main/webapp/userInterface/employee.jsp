<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hongson
  Date: 31/03/2022
  Time: 8:24 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Employee Management</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;1,100;1,300;1,400;1,500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/assets/css/main.css">
    <link rel="stylesheet" href="/assets/font/fontawesome-free-6.1.1-web/css/all.min.css">
</head>
<body>
    <jsp:include page="/index.jsp" />

    <div class="container main-container">
            <div class="row">
                <div class="col-2">
                    <div class="sidebar">
                        <ul id="employee-menu" class="sidebar__list">
                            <li class="sidebar__item">
                                <a id="show-Employee-List" href="#" class="sidebar__link">Display employee list</a>
                            </li>
                            <li class="sidebar__item">
                                <a id="add-employee" href="#" class="sidebar__link">Add new employee</a>
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="col-10">
<%--                    Add employee--%>
                    <div id="add-employee-form" class="add-employee d-none">
                        <form action="/employee?action=add" method="post">
                            <div class="row">
                                <div class="col-6">
                                    <input type="text" name="employeeID" class="form-control" placeholder="Employee ID">
                                    <input type="text" name="name" class="form-control" placeholder="Name">
                                    <input type="date" name="dob" class="form-control" placeholder="Date of Birth">
                                    <%--                            <input type="text" name="gender" class="form-control" placeholder="Gender">--%>
                                    <div class="row">
                                        <div class="col-6">
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="gender" value="false" id="flexRadioDefault1">
                                                <label class="form-check-label" for="flexRadioDefault1">
                                                    Female
                                                </label>
                                            </div>
                                        </div>
                                        <div class="col-6">
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="gender" value="true" id="flexRadioDefault2" checked>
                                                <label class="form-check-label" for="flexRadioDefault2">
                                                    Male
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <input type="text" name="idCard" class="form-control" placeholder="ID Card">
                                    <input type="text" name="phone" class="form-control" placeholder="Phone number">
                                </div>

                                <div class="col-6">
                                    <input type="text" name="email" class="form-control" placeholder="Email">
                                    <input type="text" name="address" class="form-control" placeholder="Address">
                                    <select name="educationDegree" class="form-select" aria-label="Education Degree">
                                        <option selected>Education Degree</option>
                                        <option value="1">Intermediate</option>
                                        <option value="2">Colleges</option>
                                        <option value="3">University</option>
                                        <option value="4">Graduate</option>
                                    </select>
                                    <select name="position" class="form-select" aria-label="Position">
                                        <option selected>Position</option>
                                        <option value="1">Receptionist</option>
                                        <option value="2">Staff</option>
                                        <option value="3">Expert</option>
                                        <option value="4">Supervisor</option>
                                        <option value="5">Manager</option>
                                        <option value="6">President</option>
                                    </select>
                                    <select name="division" class="form-select" aria-label="Division">
                                        <option selected>Division</option>
                                        <option value="1">Sale – Marketing</option>
                                        <option value="2">Administrative</option>
                                        <option value="3">Staff</option>
                                        <option value="4">Management</option>
                                    </select>
                                    <input type="text" name="salary" class="form-control" placeholder="Salary">
                                    <input type="text" name="username" class="form-control" placeholder="Username">
                                    <button type="submit" class="submit-btn btn btn-primary">Submit</button>
                                </div>
                            </div>
                        </form>
                    </div>
<%--                    End add employee--%>

                    <div id="employee-list" class="">
                        <table class="table table-success table-striped table-sm">
                            <thead>
                            <tr>
                                <th class="text-center">ID</th>
                                <th class="text-center">Name</th>
                                <th class="text-center">DOB</th>
                                <th class="text-center">Gender</th>
                                <th class="text-center">ID Card</th>
                                <th class="text-center">Phone number</th>
                                <th class="text-center">Email</th>
                                <th class="text-center">Address</th>
                                <th class="text-center">Position</th>
                                <th class="text-center">Division</th>
                                <th class="text-center">Education Degree</th>
                                <th class="text-center">Salary</th>
                                <th class="text-center">Username</th>
                                <th class="text-center">Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="employee" items="${employeeList}">
                                <tr>
                                    <td>${employee.personalID}</td>
                                    <td>${employee.name}</td>
                                    <td>${employee.dOB}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${employee.gender == false}">Female</c:when>
                                            <c:when test="${employee.gender == true}">Male</c:when>
                                        </c:choose>
                                    </td>
                                    <td>${employee.idCard}</td>
                                    <td>${employee.phoneNumber}</td>
                                    <td class="text-truncate">${employee.email}</td>
                                    <td class="text-truncate">${employee.address}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${employee.position == 1}">Receptionist</c:when>
                                            <c:when test="${employee.position == 2}">Staff</c:when>
                                            <c:when test="${employee.position == 3}">Expert</c:when>
                                            <c:when test="${employee.position == 4}">Supervisor</c:when>
                                            <c:when test="${employee.position == 5}">Manager</c:when>
                                            <c:when test="${employee.position == 6}">President</c:when>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${employee.educationDegree == 1}">Sale – Marketing</c:when>
                                            <c:when test="${employee.educationDegree == 2}">Administrative</c:when>
                                            <c:when test="${employee.educationDegree == 3}">Staff</c:when>
                                            <c:when test="${employee.educationDegree == 4}">Management</c:when>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${employee.division == 1}">Intermediate</c:when>
                                            <c:when test="${employee.division == 2}">Colleges</c:when>
                                            <c:when test="${employee.division == 3}">University</c:when>
                                            <c:when test="${employee.division == 4}">Graduate</c:when>
                                        </c:choose>
                                    </td>
                                    <td>${employee.salary}</td>
                                    <td>${employee.username}</td>
                                    <td>
                                        <div class="btn-action">
                                            <button onclick="onDelete(${employee.personalID})" type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#modelDeleteId">
                                                Delete
                                            </button>

                                            <button onclick="onUpdate(${employee.personalID})" type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#modelUpdateId">
                                                Edit
                                            </button>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                        <div class="list-pagination">
                            <nav aria-label="Page navigation example">
                                <ul class="pagination">
                                    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    <!-- Modal -->
    <div class="modal fade" id="modelDeleteId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Delete employee</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="/employee?action=delete" method="post">
                    <input type="hidden" name="id" id="idEmployeeDel">
                    <div class="modal-body">
                        Do you want to delete this field?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary " data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary ">Confirm</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="modal fade" id="modelUpdateId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Edit employee</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="/employee?action=update" method="post">
                    <input type="hidden" name="id" id="idEmployeeUpdate">
                    <div class="modal-body">
                        <div class="update-employee">
                            <div class="row">
                                <div class="col-6">
                                    <input type="text" name="employeeID" class="form-control" placeholder="Employee ID">
                                    <input type="text" name="name" class="form-control" placeholder="Name">
                                    <input type="date" name="dob" class="form-control" placeholder="Date of Birth">
                                    <div class="row">
                                        <div class="col-6">
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="gender" value="false">
                                                <label class="form-check-label" for="flexRadioDefault1">
                                                    Female
                                                </label>
                                            </div>
                                        </div>
                                        <div class="col-6">
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="gender" value="true" checked>
                                                <label class="form-check-label" for="flexRadioDefault2">
                                                    Male
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <input type="text" name="idCard" class="form-control" placeholder="ID Card">
                                    <input type="text" name="phone" class="form-control" placeholder="Phone number">
                                </div>
                                <div class="col-6">
                                    <input type="text" name="email" class="form-control" placeholder="Email">
                                    <input type="text" name="address" class="form-control" placeholder="Address">

                                    <select name="educationDegree" class="form-select col-12" aria-label="Education Degree">
                                        <option selected>Education Degree</option>
                                        <option value="1">Intermediate</option>
                                        <option value="2">Colleges</option>
                                        <option value="3">University</option>
                                        <option value="4">Graduate</option>
                                    </select>

                                    <select name="position" class="form-select col-12" aria-label="Position">
                                        <option selected>Position</option>
                                        <option value="1">Receptionist</option>
                                        <option value="2">Staff</option>
                                        <option value="3">Expert</option>
                                        <option value="4">Supervisor</option>
                                        <option value="5">Manager</option>
                                        <option value="6">President</option>
                                    </select>
                                    <select name="division" class="form-select col-12" aria-label="Division">
                                        <option selected>Division</option>
                                        <option value="1">Sale – Marketing</option>
                                        <option value="2">Administrative</option>
                                        <option value="3">Staff</option>
                                        <option value="4">Management</option>
                                    </select>

                                    <input type="text" name="salary" class="form-control" placeholder="Salary">
                                    <input type="text" name="username" class="form-control" placeholder="Username">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="row">
                            <div class="col-6">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            </div>
                            <div class="col-6">
                                <button type="submit" class="btn btn-primary">Save</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

<script src="/assets/js/main.js"></script>

    <script>
        function onDelete(idEmployeeDel) {
            document.getElementById("idEmployeeDel").value = idEmployeeDel;
        }

        function  onUpdate(idEmployeeUpdate) {
            document.getElementById("idEmployeeUpdate").value = idEmployeeUpdate;
        }
    </script>
</body>
</html>
