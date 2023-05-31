<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Form</title>
    <style>
        body{
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            color: #333;
        }

        form {
            width: 300px;
            margin-top: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"]{
            width: 100%;
            padding: 5px;
            margin-bottom: 10px;
        }

        input[type="submit"],a.button{
            display: inline-block;
            background-color: #4CAF50;
            color: white;
            padding: 8px 16px;
            text-decoration: none;
            border-radius: 4px;
            transition: background-color 0.3s;

        }
        input[type="submit"]:hover, a.button:hover{
            background-color: #45a049;
        }
        a.button{
            margin-left: 5px;
        }
    </style>
</head>
<body>
<h1>Student Form</h1>

<c:choose>
    <c:when test="${empty student.studentID}">
        <form method="POST" action="student?action=create">
            <label for="studentName">Student Name:</label>
            <input type="text" id="studentName" name="studentName"  required>
            <br> <br>
            <label for="email">Email :</label>
            <input type="text" id="email" name="email" required>
            <br><br>
            <label for="age">Age :</label>
            <input type="text" id="age" name="age" required>
            <br> <br>
            <label for="examScore">Exam Score :</label>
            <input type="text" id="examScore" name="examScore" required>
            <br><br>
            <lable for="grade" >Grade: </lable>
            <input type="text" id="grade" name="grade" required>
            <br><br>
            <input type="submit" value="Create">
            <a class="button" href="student">Cancel</a>
        </form>
    </c:when>
    <c:otherwise>
        <form method="POST" action="student?action=update">
            <input type="hidden" name="studentID" value="${student.studentID}">
            <label for="studentName">student Name:</label>
            <input type="text" id="studentName" name="studentName" value="${student.studentName}">
            <br> <br>
            
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" value="${student.email}">
            <br><br>

            <label  for="age">Age</label>
            <input type="text" id="age" name="age" value="${student.age}">
            <br> <br>

            <label for="examScore">Exam Score</label>
            <input type="text" id="examScore" name="examScore" value="${student.examScore}">
            <br><br>

            <lable for="grade">Grade: </lable>
            <input type="text" id="grade" name="grade" value="${student.grade}">
            <br><br>

            <input type="submit" value="Update">
            <a class="button" href="student">Cancel</a>
        </form>

        <form method="POST" action="student?action=delete">
            <input type="hidden" name="studentID" value="${student.studentID}">
            <input class="button" type="submit" value="Delete">

        </form>
    </c:otherwise>
</c:choose>
</body>
</html>
