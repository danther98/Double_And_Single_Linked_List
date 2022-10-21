


public class Course  extends DoubleLinkedList{
	
//CS 3363,Organization of Programming Languages,

	//creating course constructors
	public String courseNumber;
   public  String courseName;
	public Integer studentCount;
	public String header;
	public Student student;
	public String getCourseNumber() {//returns course number
		return courseNumber;
	}
	public void setCourseNumber(String courseNumber) {//sets course number
		this.courseNumber = courseNumber;
	}
	public  String getCourseName() {//returns course name
		return courseName;
	}
	public void setCourseName(String courseName) {//sets course name
		this.courseName = courseName;
	}
	public Integer getStudentCount() {//returns student count
		return studentCount;
	}
	public void setStudentCount(Integer studentCount) {//sets student count
		this.studentCount = studentCount;
	}
	
   public void setHeader(String header){ //sets header
	this.header=header;
   }
   
   }

		
	
	
