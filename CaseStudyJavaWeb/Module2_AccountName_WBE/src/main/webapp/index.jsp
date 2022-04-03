<%--
  Created by IntelliJ IDEA.
  User: hongson
  Date: 30/03/2022
  Time: 12:56 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Furama Resort Danang</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;1,100;1,300;1,400;1,500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./assets/font/fontawesome-free-6.1.1-web/css/all.min.css">
    <link rel="stylesheet" href="./assets/css/main.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  </head>
  <body>
      <div class="header">
        <div class="logo-with-name">
          <div class="logo">
            <img src="./assets/img/logo.png" alt="logo" width="60px">
          </div>
          <div class="user">
            <span class="username">Nguyen Van A</span>
          </div>
        </div>

        <div class="hearder__navbar">
          <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="navbar-container collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                  <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="">Home</a>
                  </li>
                  <li class="nav-item">
                    <a id="employee" class="nav-link" href="/employee">Employee</a>
                  </li>
                  <li class="nav-item">
                    <a id="customer" class="nav-link" href="/customer">Customer</a>
                  </li>
                  <li class="nav-item">
                    <a id="service" class="nav-link" href="/service">Service</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">Contract</a>
                  </li>
                </ul>
                <form class="nav-search d-flex">
                  <i class="nav-search-icon fa-solid fa-magnifying-glass"></i>
                  <input class="nav-search-input form-control me-2" type="search" placeholder="Search" aria-label="Search">
                </form>
              </div>
            </div>
          </nav>
        </div>
      </div>

    <script src="./assets/js/main.js"></script>
  </body>
</html>
