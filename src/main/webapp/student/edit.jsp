<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 10/12/2022
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sửa học viên</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <style>
        body {
            color: #566787;
            background: #f7f5f2;
        }
        .container {
            margin-top: 50px;
            margin-left: 285px;
        }
        .btn-primary {
            background: #40b2cd;
            border-color: white;
        }
        .btn-primary hover {
            background: #068cac;
            border-color: white;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-9">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col-md-12">
                            <h4>Sửa học viên</h4>
                            <hr>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <form method="post" action="/students?action=edit">
                                <c:if test="${student != null}">
                                    <input type="hidden" name="id" value="<c:out value='${student.id}' />"/>
                                </c:if>
                                <div class="form-group row">
                                    <label for="username" class="col-4 col-form-label">Họ tên*</label>
                                    <div class="col-8">
                                        <input id="username" value="${student.name}" name="name" placeholder="name" class="form-control here" required="required" type="text">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="name" class="col-4 col-form-label">Ngày sinh</label>
                                    <div class="col-8">
                                        <input id="name" value="${student.dateOfBirth}" name="dateOfBirth" placeholder="First Name" class="form-control here" type="date">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="address" class="col-4 col-form-label">Địa chỉ</label>
                                    <div class="col-8">
                                        <input id="address" value="${student.address}" name="address" placeholder="Address" class="form-control here" type="text">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="email" class="col-4 col-form-label">Email*</label>
                                    <div class="col-8">
                                        <input id="email" value="${student.email}" name="email" placeholder="Email" class="form-control here" required="required" type="text">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="phone" class="col-4 col-form-label">Liên hệ*</label>
                                    <div class="col-8">
                                        <input id="phone" value="${student.phone}" name="phone" placeholder="Phone Number" class="form-control here" type="text">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="select" class="col-4 col-form-label">Lớp*</label>
                                    <div class="col-8">
                                        <select id="select" name="classroom_id" class="custom-select">
                                            <c:forEach var="classroom" items="${classes}">
                                                <option value="${classroom.class_id}">${classroom.class_name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="offset-4 col-8">
                                        <button name="submit" type="submit" class="btn btn-primary">Lưu</button>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="offset-4 col-8">
                                        <p>
                                            <c:if test="${message != null}">
                                                <span>${message}</span>
                                            </c:if>
                                        </p>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="offset-4 col-8">
                                        <a href="/students" class="btn btn-primary">Trở về</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
