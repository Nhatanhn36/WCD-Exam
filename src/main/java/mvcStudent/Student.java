package mvcStudent;

public class Student {
    private int studentID;
    private String studentName;
    private String email;
    private int age;
    private String grade;
    private Double examScore;

    public Student(int studentID, String studentName, String email, int age, String grade, Double examScore){
        super();
        this.studentID = studentID;
        this.studentName = studentName;
        this.email = email;
        this.age = age;
        this.grade = grade;
        this.examScore = examScore;
    }

    public int getStudentID(){
        return studentID;
    }

    public void setStudentID(int studentID){
        this.studentID = studentID;
    }

    public String getStudentName(){
        return studentName;
    }
    public void setStudentName(String studentName){
        this.studentName = studentName;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }

    public String getGrade(){
        return grade;
    }
    public void setGrade(String grade){
        this.grade = grade;
    }

    public Double getExamScore(){
        return examScore;
    }
    public void setExamScore(Double examScore){
        this.examScore = examScore;
    }
}
