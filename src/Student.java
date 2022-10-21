import java.io.Serializable;

public class Student implements Serializable {
	//"Julia Mulligan, Madalynn ",A755513,mjmulligan@okstate.edu,"752 Essex Ave.Oklahoma City, OK 73114"
	//constructors for student object, "studentCourseID" is class number for given student used in searching for students from course number
	String firstName;
	String lastName;
	String studentNumber;
	String email;
	String address;
	String studentCourseID;

	public String getFirstName(){return firstName;}
	public void setFirstName(String firstName){this.firstName=firstName;}

	public String getLastName(){return lastName;}
	public void setLastName(String lastName){this.lastName=lastName;}


	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCourseNumberIdentity(String studentCourseID){
		this.studentCourseID=studentCourseID;
	}
	public String getCourseNumberIdentity(){
		return studentCourseID;
	}
	
}
