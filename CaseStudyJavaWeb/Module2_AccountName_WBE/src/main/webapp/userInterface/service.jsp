<%--
  Created by IntelliJ IDEA.
  User: hongson
  Date: 01/04/2022
  Time: 1:43 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Service</title>
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
<div class="app">
    <jsp:include page="/index.jsp"/>
    <div class="container main-container">
        <div class="row">
            <div class="col-2">
                <div class="sidebar">
                    <ul id="service-menu" class="sidebar__list">
                        <li class="sidebar__item">
                            <a id="show-Service-List" href="#" class="sidebar__link">Display service list</a>
                        </li>
                        <li class="sidebar__item">
                            <a id="add-service" href="#" class="sidebar__link">Add new service</a>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="col-10">
                <div id="add-service-form" class="add-service d-none">
                    <form action="/service?action=add" method="post">
                        <div class="row">
                            <select id="serviceType" name="serviceType" class="form-select" aria-label="Service type">
                                <option selected>Service type</option>
                                <option value="1">Villa</option>
                                <option value="2">House</option>
                                <option value="3">Room</option>
                            </select>
                            <input type="text" name="serviceID" class="form-control" placeholder="Service ID">
                            <input type="text" name="name" class="form-control" placeholder="Name">
                            <input type="text" name="area" class="form-control" placeholder="Area">
                            <input type="text" name="serviceCost" class="form-control" placeholder="Service cost">
                            <input type="text" name="serviceMaxPeople" class="form-control" placeholder="Service max people">
                            <select  name="rentType" class="form-select" aria-label="Rent type">
                                <option selected>Rent type</option>
                                <option value="1">year</option>
                                <option value="2">month</option>
                                <option value="3">day</option>
                                <option value="4">hour</option>
                            </select>
                            <input id="standard" type="text" name="standard" class="form-control" placeholder="Standard room">
                            <input id="descriptionOtherConvenience" type="text" name="descriptionOtherConvenience" class="form-control" placeholder="Description Other Convenience">
                            <input id="poolArea" type="text" name="poolArea" class="form-control" placeholder="Pool Area">
                            <input id="numberOfFloors" type="text" name="numberOfFloors" class="form-control" placeholder="Number of floors">
                            <button type="submit" class="submit-btn btn btn-primary">Submit</button>
                        </div>
                    </form>
                </div>

                <div id="service-list" class=""></div>
            </div>
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
</script>
</body>
</html>
