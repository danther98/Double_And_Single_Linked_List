import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;





import java.util.Scanner;
import java.util.concurrent.TimeUnit;




public class makeDoublyLists {    
	
		static DoubleLinkedList courseList = new DoubleLinkedList();//double linked list to store course data
		   static SingleLinkedList studentList= new SingleLinkedList(); //singly linked list to store student data
			static Header header=new Header();//header object to hold total amount of courses,students, and head and tail of double linked list 
			static SingleLinkedList updatedClassList=new SingleLinkedList();//Single linked list to hold students when students have been deleted
			static SingleLinkedList studentsInCourse = new SingleLinkedList();//Single linked list to hold students when searched by course number
			static boolean flag=false;//flag to tell display student list which list to use, changes when deleting student
			static int studentcount=-1;//student count
			static boolean loadFlag=false;//flag to tell if data has been loaded
	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
	       
		displayMenu();//calling menu display command
		 int menuOption= scan.nextInt();
		 menuChoice(menuOption);   //taking user input into menu option switch
   
    }

	
	
	
public static void readInputData() {
		
		   BufferedReader bfReader = null;
		   
			
			//reading input file
				try {
					bfReader = new BufferedReader (new FileReader("C:\\Users\\danth\\Desktop\\Fall 2022\\Data Structures and Algorithm Analysis CS3353\\inputFile.txt"));


				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
		    
		   
		   
			
		    String strCurrentLine;
		    String[] fields;
		    
		    
		    
		    try {
				while((strCurrentLine = bfReader.readLine()) != null) {
				  System.out.println("new line is:"+strCurrentLine);
				  studentcount ++;
				  System.out.println("---->>> LINE COUNT IS:"+studentcount);
				  
				  //reading full line in 
				  String inputLine=strCurrentLine;
				  //splitting line into String array 
				  fields=inputLine.split(",");//splitting input into fields for easier assignment
				  
				  if(fields.length == 6) {
					  System.out.println("---->>> Header Line Detected <<<<---");
					  fields[0]=fields[0].replace("\u00a0","");
					  System.out.println("field0 is:"+fields[0]);
					  System.out.println("field1 is:"+fields[1]);
					  System.out.println("field2 is:"+fields[2]);
					  System.out.println("field3 is:"+fields[3]);
					  System.out.println("field4 is:"+fields[4]);
					
					
				  }else {
						  
					  Student student = new Student();//creating student object
					Course course = new Course();//creating course object
					  fields[0]=fields[0].replace("\u00a0","");//getting rid of unknown UTF16 chars
					  System.out.println("field0 is:"+fields[0]);
					  System.out.println("field1 is:"+fields[1]);
					  course.setCourseNumber(fields[0]);//setting fields
					  course.setCourseName(fields[1]);
					  student.setCourseNumberIdentity(fields[0]);

					
					 
					 
					 
						
						
					
						
					  
					  //because the data has a comma separating the First from last name in an element that is also separated by commas
					  //cleaning text input up
					  
						  System.out.println("field2 is:"+fields[2].replaceAll("\"", "")+fields[3].replaceAll("\"", ""));//get rid of those double quotes also using the replaceAll. 
					  
						 
						  
						  
					  student.setLastName(fields[2].replaceAll("\"", ""));
					  student.setFirstName(fields[3].replaceAll("\"", ""));
					  System.out.println("field4 is:"+fields[4]);
					  student.setStudentNumber(fields[4]);//setting student ID
					  
					  System.out.println("field5 is:"+fields[5]);
					  student.setEmail(fields[5]);//setting student Email
					  
					  
					  String field6 = fields[6];
					  if(field6.substring(0,1).equalsIgnoreCase("\"")) {
						  System.out.println("field6 is:"+fields[6].replaceAll("\"", "")+","+fields[7].replaceAll("\"", ""));//get rid of those double quotes also using the replaceAll. 
					  }else {
						  System.out.println("field6 is:"+fields[6]);
					  }
					  
					  student.setAddress(fields[6].replaceAll("\"", ""));//setting student address
					 

					 studentList.add(student);//add students to single linked list
					 courseList.add(course);//add course to doubly linked list
					
				loadFlag=true;//setting read flag to true so it will not run again
					  	studentList.searchKey(fields[0]);
					 }
					}
			
					
			
				}
			
			
			 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("\033\143");//clear screen
			System.out.println("Data read successful");
			System.out.println("Please Wait...");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
displayMenu();//calling menu

		}
public static SingleLinkedList searchStudentsInCourse(String courseNum){//returns single Linked list holding students that have the coursenum
	Student temp=new Student();
	
	String coursenum=courseNum.replaceAll("\\s+","");
	studentsInCourse=studentList.searchKey(coursenum);



for(int i=0;i<studentsInCourse.size();i++){//sorting students to correct order

	for(int j=i+1;j<studentsInCourse.size();j++){

 if(studentsInCourse.get(i).firstName.compareTo(studentsInCourse.get(j).firstName)>0){

		temp=studentsInCourse.get(i);
		studentsInCourse.replace(studentsInCourse.get(j),i );
		studentsInCourse.replace(temp,j);  
 }
	}
}
flag=false;
return studentsInCourse;

}
public static void displayStudentInfo(SingleLinkedList studentsInCourse){ //prints student information, if list has been un-altered it uses that, if it has been it uses altered list
	
if(flag==false){
//formatting student information columns
System.out.printf("%-20s","Student ID");
System.out.printf("%-35s","Student Name");
System.out.printf("%-50s","Student Email");
System.out.printf("%s %n","Student Address");
System.out.println();
//printing student data with formatting
for(int t =0; t<studentsInCourse.size();t++){
	
	
	System.out.printf("%-20s",studentsInCourse.get(t).studentNumber);
	System.out.printf("%-35s",studentsInCourse.get(t).firstName+","+studentsInCourse.get(t).lastName);
	System.out.printf("%-50s",studentsInCourse.get(t).email);
	System.out.printf("%s %n",studentsInCourse.get(t).address);
}
}else{
	System.out.printf("%-20s","Student ID");
System.out.printf("%-35s","Student Name");
System.out.printf("%-50s","Student Email");
System.out.printf("%s %n","Student Address");
System.out.println();
//printing student data with formatting
for(int t =0; t<updatedClassList.size();t++){
	
	
	System.out.printf("%-20s",updatedClassList.get(t).studentNumber);
	System.out.printf("%-35s",updatedClassList.get(t).firstName+","+updatedClassList.get(t).lastName);
	System.out.printf("%-50s",updatedClassList.get(t).email);
	System.out.printf("%s %n",updatedClassList.get(t).address);
}
}
 return;
	

}
public static void displayCourse(DoubleLinkedList courseList){
	Course temp=new Course();
	for(int i=0;i<courseList.size();i++){//sorting courses to correct order

		for(int j=i+1;j<courseList.size();j++){
	
	 if(courseList.get1(i).courseName.compareTo(courseList.get1(j).courseName)>0){
	
			temp=courseList.get1(i);
			courseList.replace(courseList.get1(j),i );
			courseList.replace(temp,j);  
	 }
		}
	}
	System.out.printf("%-20s","Course Number");
System.out.printf("%-65s","Course Name");
System.out.printf("%-40s","Amount of students in course");
System.out.println();

System.out.println();
//printing course data with formatting
for(int t =0; t<courseList.size();t++){
	
	
	System.out.printf("%-20s",courseList.get1(t).courseNumber);
	System.out.printf("%-75s",courseList.get1(t).courseName);
	System.out.printf("%-10d %n",makeDoublyLists.displaystudentdata(courseList.get(t).data.courseNumber));
	
}
}
public static int displaystudentdata(String courseNum){//returns number of students enrolled in specific course number
	
	
	
studentsInCourse=(studentList.searchKey(courseNum));
int studentInCourseCount=studentsInCourse.size();//size function returns size of single linked list int
return studentInCourseCount;
}
public static void deleteCourse(String course){ //delete specific Node 
		int pos=(courseList.findPos(course));
		courseList.get(pos);
		courseList.deleteNode(pos);

	}

public static void deleteStudent(String studentID,String classNum){//deletes student based on student ID and class number
	//studentcount--;//subtracts from student count
	

	studentList.delete(studentID);
	updatedClassList=studentList;//updates class list 
	//updatedClassList.delete(studentID);//removes student
	//studentcount--;
flag=true;
}
public static void transferStudent(String studentName,String courseToDrop,String courseToAdd){//changes student from one course to other
	studentList.searchStudentName(studentName);
	studentList.swapCourse(studentList.searchStudentName(studentName), courseToDrop, courseToAdd);
}






public static void addCourse(){//creates new course number and adds to list
	Course courseNew = new Course();//creating course object
	Scanner mscan=new Scanner(System.in);
    System.out.println();
    System.out.print("Enter the new course to add with no spaces: ");
    String courseNum=mscan.next();
    System.out.println();
    System.out.print("Enter the new course name for "+courseNum+" :");
    String courseName=mscan.next();
	courseNew.setCourseNumber(courseNum);
	courseNew.setCourseName(courseName);
	courseList.add(courseNew);
}
public static void addStudenttoCourse(){//create new student and add to list
	Student student=new Student();
	Scanner mscan=new Scanner(System.in);
System.out.print("Enter the course number the student wants to enroll to with no spaces: ");
String courseNumtoAddStudent=mscan.next();
System.out.println();
System.out.print("Enter student's first name: ");
String studentfirstName=mscan.next();
System.out.print("Enter student's last name: ");
String studentlastName=mscan.next();
System.out.println("Enter the Students Email");
String studentEmail=mscan.next();
System.out.println();
System.out.print("Enter the student's ID: ");
String studentIDtoAdd=mscan.next();
System.out.println();
System.out.print("Enter the student's emergency contact address: ");
String studentEmergency=mscan.next();
System.out.println();
student.setCourseNumberIdentity(courseNumtoAddStudent);
student.setFirstName(studentfirstName);
student.setLastName(studentlastName);
student.setEmail(studentEmail);
student.setStudentNumber(studentIDtoAdd);
student.setAddress(studentEmergency);

studentList.add(student);
}

public static void displayHeader(){//displays header information
	header.settotalStudentCount(studentList.getStudentCount());//updating information each time it is called
	header.setcourseCount(courseList.courseCount());
	System.out.println("Summary of record: ");
	System.out.println("total course count "+header.courseCount);
	System.out.println("total student count "+header.totalStudentCount);
}


public static void displayMenu(){ //print menu options
	System.out.print("\033\143");
	
    System.out.println();
System.out.println("+--------------------+");
System.out.println("|"+"   ---Main Menu---  "+"|");
System.out.println("+--------------------+");
System.out.println();
System.out.println("Select Menu Option Below");
System.out.println();
System.out.println("1. Read input data");
System.out.println("2. Delete a course");
System.out.println("3. Insert a new course");
System.out.println("4. Delete a student");
System.out.println("5. Insert a new student");
System.out.println("6. Transfer a student from one course to another");
System.out.println("7. Display course list");
System.out.println("8. Display student list");
System.out.println("9. Exit");
System.out.println();
displayHeader();
Scanner mscan=new Scanner(System.in);
int choice=mscan.nextInt();
menuChoice(choice);
}
public static void menuChoice(int menuOption)//menu choice from user input, calls related functions for each
{
    
   
    switch(menuOption){//switch from user input
        case 1://Need to run input command
        System.out.println("You chose "+menuOption);
		if(loadFlag==false){
        readInputData();
		
		}else{
			System.out.println("Cannot Load data again");
			System.out.println("Returning to menu");
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			displayMenu();
		}
            break;
        case 2:
        System.out.println("You chose "+menuOption);
        deleteMenu();
            break;
        case 3:
        System.out.println("You chose "+menuOption);
        addCourseMenu();
            break;
        case 4:
        System.out.println("You chose "+menuOption);
        deleteStudentMenu();
            break;
        case 5:
        System.out.println("You chose "+menuOption);
		addStudent();
            break;
        case 6:
        System.out.println("You chose "+menuOption);
		transferStudent();
            break;
        case 7: 
        System.out.println("You chose "+menuOption);
		courseList();
            break;
        case 8:
        System.out.println("You chose "+menuOption);
		studentEnrolled();
            break;
        case 9:
        System.out.println("Good-Bye!");
		System.exit(0);
            break;
        default: 
       
    }

}

public static void deleteMenu(){//delete menu
    System.out.print("\033\143");
	
    System.out.println();
    System.out.println("+-----------------------------+");
    System.out.println("|"+"   ---Delete Course Menu---  "+"|");
    System.out.println("+-----------------------------+");
    System.out.println();
    Scanner dscan=new Scanner(System.in);
    System.out.print("Enter Course with no spaces to delete: ");
    String deleteCourse=dscan.next();
	deleteCourse(deleteCourse);


    displayHeader();
	String temp=dscan.next();
	if(!(temp.isEmpty())){
		displayMenu();
	}
    //Need total num of courses to update
    //need total Student to update
    
}
public static void addCourseMenu(){//add course menu
    System.out.print("\033\143");
    System.out.println("+--------------------------+");
    System.out.println("|"+"   ---Add Course Menu---  "+"|");
    System.out.println("+--------------------------+");
   addCourse();
    displayHeader();
	Scanner mscan=new Scanner(System.in);
    System.out.println("Type any key, then enter to return to main menu");
	String temp=mscan.next();
	if(!(temp.isEmpty())){
		displayMenu();
	}
  
    //Need total num of courses to update
}
public static void deleteStudentMenu(){//delete student menu
    System.out.print("\033\143");
    System.out.println("+------------------------------+");
    System.out.println("|"+"   ---Delete Student Menu---  "+"|");
    System.out.println("+------------------------------+");
    Scanner mscan=new Scanner(System.in);
    System.out.println();
    System.out.print("Enter student ID to delete: ");
    String studentID=mscan.next();
	
    System.out.println();
    System.out.print("Enter course number from which student is to be dropped from with no spaces: ");
    String courseNumtoDelete=mscan.next();
	deleteStudent(studentID,courseNumtoDelete);
	searchStudentsInCourse(courseNumtoDelete);
   displayHeader();


	System.out.println("Type any key, then enter to return to main menu");
	String temp=mscan.next();
	if(!(temp.isEmpty())){
		displayMenu();
	}

}
public static void addStudent(){//add student menu
System.out.print("\033\143");
System.out.println("+---------------------------+");
System.out.println("|"+"   ---Add Student Menu---  "+"|");
System.out.println("+---------------------------+");
Scanner mscan=new Scanner(System.in);
System.out.println();
addStudenttoCourse();
displayHeader();
System.out.println("Type any key, then enter to return to main menu");
String temp=mscan.next();
if(!(temp.isEmpty())){
	displayMenu();
}
}
public static void studentEnrolled(){//student list menu 
	System.out.print("\033\143");
System.out.println("+----------------------------+");
System.out.println("|"+"   ---Show Student Menu---  "+"|");
System.out.println("+----------------------------+");
System.out.println();
	System.out.println("Enter course number with no spaces");
	Scanner mscan=new Scanner(System.in);
	String couseNumbersearch=mscan.nextLine();
	System.out.println();
	System.out.println("Students enrolled in "+couseNumbersearch);
	System.out.println("------------------------------------------------------");

	displayStudentInfo(searchStudentsInCourse(couseNumbersearch));
	System.out.println();
	System.out.println("Type any key, then enter to return to main menu");
	String temp=mscan.next();
	if(!(temp.isEmpty())){
		displayMenu();
	}
}
public static void transferStudent(){//transfer student menu
	System.out.print("\033\143");
System.out.println("+--------------------------------+");
System.out.println("|"+"   ---Transfer Student Menu---  "+"|");
System.out.println("+--------------------------------+");
Scanner mscan=new Scanner(System.in);
System.out.println();
System.out.println("Enter the Student's name: ");
String studentName=mscan.nextLine();
System.out.println("Enter the course number with no spaces the student wants to drop from: ");
String courseStudentDrop=mscan.next();
System.out.println();
System.out.print("Enter course number with no spaces the student wants to enroll to");
String courseStudentAdd=mscan.next();
transferStudent(studentName, courseStudentDrop, courseStudentAdd);
System.out.println("Type any key, then enter to return to main menu");
String temp=mscan.next();
if(!(temp.isEmpty())){
	displayMenu();
}
System.out.println();
displayHeader();
}
public static void courseList(){//displays courses and student count enrolled
	System.out.print("\033\143");
System.out.println("+---------------------------+");
System.out.println("|"+"   ---Course List Menu---  "+"|");
System.out.println("+---------------------------+");

System.out.println();
System.out.println("The list of courses registered are as follows:");

displayCourse(courseList);
System.out.println();
System.out.println();
System.out.println("Type any key, then enter to return to main menu");
Scanner mscan=new Scanner(System.in);
	String temp=mscan.next();
	if(!(temp.isEmpty())){
		displayMenu();
	}
}
}
