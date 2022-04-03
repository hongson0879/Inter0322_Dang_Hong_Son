<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hongson
  Date: 30/03/2022
  Time: 2:17 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Customer Management</title>
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
                        <ul id="customer-menu" class="sidebar__list">
                            <li class="sidebar__item">
                                <a id="show-Customer-List" href="#" class="sidebar__link">Display customer list</a>
                            </li>
                            <li class="sidebar__item">
                                <a id="add-customer" href="#" class="sidebar__link">Add new customer</a>
                            </li>
                        </ul>
                    </div>
                </div>

                <div class="col-10">
<%--                    Add customer--%>
                    <div id="add-customer-form" class="add-customer d-none">
                        <form action="/customer?action=add" method="post">
                            <div class="row">
                                <div class="col-6">
                                    <input type="text" name="customerID" class="form-control" placeholder="Customer ID">
                                    <input type="text" name="name" class="form-control" placeholder="Name">
                                    <input type="date" name="dob" class="form-control" placeholder="Date of Birth">
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
                                </div>

                                <div class="col-6">
                                    <input type="text" name="phone" class="form-control" placeholder="Phone number">
                                    <input type="text" name="email" class="form-control" placeholder="Email">
                                    <select name="type" class="form-select" aria-label="Default select example">
                                        <option selected>Type of customer</option>
                                        <option value="1">Diamond</option>
                                        <option value="2">Platinum</option>
                                        <option value="3">Gold</option>
                                        <option value="4">Silver</option>
                                        <option value="5">Member</option>
                                    </select>
                                    <input type="text" name="address" class="form-control" placeholder="Address">
                                </div>
                            </div>
                            <button type="submit" class="submit-btn btn btn-primary">Submit</button>
                        </form>
                    </div>
<%--                    End add customer--%>

<%--                    List customer--%>
                    <div id="customer-list" class="customer-list">
                        <table class="table">
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
                                <th class="text-center">Type</th>
                                <th class="text-center">Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="customer" items="${customerList}">
                                <tr>
                                    <td>${customer.personalID}</td>
                                    <td>${customer.name}</td>
                                    <td>${customer.dOB}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${customer.gender == false}">Female</c:when>
                                            <c:when test="${customer.gender == true}">Male</c:when>
                                        </c:choose>
                                    </td>
                                    <td>${customer.idCard}</td>
                                    <td>${customer.phoneNumber}</td>
                                    <td>${customer.email}</td>
                                    <td>${customer.address}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${customer.type == 1}">Diamond</c:when>
                                            <c:when test="${customer.type == 2}">Platinium</c:when>
                                            <c:when test="${customer.type == 3}">Gold</c:when>
                                            <c:when test="${customer.type == 4}">Silver</c:when>
                                            <c:when test="${customer.type == 5}">Member</c:when>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <div class="btn-action">
                                            <button onclick="onDelete(${customer.personalID})" type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#modelDeleteId">
                                                Delete
                                            </button>

                                            <button onclick="onUpdate(${customer.personalID})" type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#modelUpdateId">
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
<%--                    End list customer--%>
                </div>
            </div>
        </div>

    <!-- Modal -->
    <div class="modal fade" id="modelDeleteId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Delete customer</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="/customer?action=delete" method="post">
                    <input type="hidden" name="id" id="idCustomerDel">
                    <div class="modal-body">
                        Do you want to delete this field?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary " data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Confirm</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="modal fade" id="modelUpdateId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Edit customer</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="/customer?action=update" method="post">
                    <input type="hidden" name="id" id="idCustomerUpdate">
                    <div class="modal-body">
                        <div class="update-customer">
                            <div class="row">
                                <div class="col-6">
                                    <input type="text" name="customerID" class="form-control" placeholder="Customer ID">
                                    <input type="text" name="name" class="form-control" placeholder="Name">
                                    <input type="date" name="dob" class="form-control" placeholder="Date of Birth">
                                    <div class="row">
                                        <div class="col-6">
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="gender" value="false" >
                                                <label class="form-check-label" for="flexRadioDefault1">
                                                    Female
                                                </label>
                                            </div>
                                        </div>
                                        <div class="col-6">
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="gender" value="true"  checked>
                                                <label class="form-check-label" for="flexRadioDefault2">
                                                    Male
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <input type="text" name="idCard" class="form-control" placeholder="ID Card">
                                </div>

                                <div class="col-6">
                                    <input type="text" name="phone" class="form-control" placeholder="Phone number">
                                    <input type="text" name="email" class="form-control" placeholder="Email">
                                    <select name="type" class="form-select" aria-label="Default select example">
                                        <option selected>Type of customer</option>
                                        <option value="1">Diamond</option>
                                        <option value="2">Platinium</option>
                                        <option value="3">Gold</option>
                                        <option value="4">Silver</option>
                                        <option value="5">Member</option>
                                    </select>
                                    <input type="text" name="address" class="form-control" placeholder="Address">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Save</button>
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
        function onDelete(idCustomerDel) {
            document.getElementById("idCustomerDel").value = idCustomerDel;
        }

        function  onUpdate(idCustomerUpdate) {
            document.getElementById("idCustomerUpdate").value = idCustomerUpdate;
        }
    </script>
</body>
</html>
