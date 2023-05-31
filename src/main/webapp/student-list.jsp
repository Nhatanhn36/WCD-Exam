<%@ page import="mvcStudent.Student" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students List</title>

</head>

<body>
<style>
    body{
        font-family: Arial, sans-serif;
        margin: 20px;
    }
    h1{
        color: red;
        text-align: center;
    }
    table{
        width: 100%;
        border-collapse: collapse;
    }

    th,td{
        padding: 10px;
        text-align: left;
        border-bottom: 1px solid #ccc;

    }

    tr:nth-child(even){
        background-color: #f2f2f2;

    }
    tr:hover{
        background-color: #e0e0e0;
    }

    .button{
        display: inline-block;
        background-color: #4CAF50;
        color: white;
        padding: 8px 16px;
        text-decoration: none;
        border-radius: 4px;
        transition: background-color 0.3s;
    }
    .button-delete{
        display: inline-block;
        background-color: red;
        color: white;
        padding: 8px 16px;
        text-decoration: none;
        border-radius: 4px;
        transition: background-color 0.3s;
    }
    .button:hover{
        background-color: #45a049;
    }
    .add-button{
        margin-bottom: 10px;
    }

    .image{
        width: 200px;
        height: 200px;
        object-fit: cover;
        border: 1px solid #ccc;
        border-radius: 5px;
        overflow: hidden;

    }
    form{
        margin-left: 1150px;
    }
    p{
        margin-left: 1150px;
    }
    .input1{
        color: #cccccc;
        height: 35px;
        border-radius: 4px;
    }

</style>
<h1>Students List</h1>
<a class="button add-button" href="student?action=new">Add New Student</a>

<table>
    <tr>
        <th>ID</th>
        <th>Student Name</th>
        <th>Email</th>
        <th>Age</th>
        <th>Exam Score</th>
        <th>Grade</th>
        <th>Action</th>
    </tr>
    <c:forEach var="student" items="${studentList}">
        <tr>
            <td>${student.studentID}</td>
            <td>${student.studentName}</td>
            <td>${student.email}</td>
            <td>${student.age}</td>
            <td>${student.examScore}</td>
            <td>${student.grade}</td>
            <td>
                <a class="button" href="student?action=edit&studentID=${student.studentID}">Edit</a>
                <a class="button-delete"  href="student?action=delete&studentID=${student.studentID}" onclick="return confirm('Are you sure delete this student ?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>



</body>
</html>
