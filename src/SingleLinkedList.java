
public class SingleLinkedList {
    
    static int studentCount;
    public class Node<T>{
        Node<T> next;
        Student data;
        

        public Node (Student data){
            this(data,null);

        }
        public Node(Student data, Node<T> next){//creating student nodes with one traverse direction 
            this.data=data;
            this.next=next;
        }
    }

   Node head, tail=null;

public Student getStudentFromList(String studentID){//returns student from given student id
    Node front = this.head;
    // Get last node
    Node rear = this.tail;
    while (front != null && rear != null)
    {
     
        if (front.data.studentNumber.equals(studentID)) {
        
            // When node key exists
        return front.data;         
        }
    
       
        // Visit to right node
        front = front.next;
        // Visit to left node
        
    }
    // Empty Linked List
    return front.data;
   
}
void deleteNode(String key)//deletes node that contains string key
{
    // Store head node
    Node temp = head, prev = null;

    // If head node itself holds the key to be deleted
    if (temp != null && temp.data.studentNumber.equals(key))
    {
        head = temp.next; // Changed head
        return;
    }
}

   public void addStudentNode(Student data){//adds student to single linked list
    Node newNode=new Node(data);
   // System.out.println("**Student addNode IS CALLED **");
    //Checks if the list is empty    
    if(head == null) {    
        //If list is empty, both head and tail will point to new node    
        head = tail = newNode;

            
    }
    else{
        tail.next=newNode;
        tail=newNode;
        }    
    }
    public void displayStudentNode(){//displays student nodes
        Node current = head;

        if(head==null){
            System.out.println("List is empty");
            return;
        }

        while(current != null){
            System.out.println("Student Node data is:"+" --- Student name is:"+current.data.firstName+current.data.lastName+" --- Student ID is:"+current.data.studentNumber+" --- Student Email is:"+current.data.email+" --- Student Address is:"+current.data.address);
            current=current.next;
        }
    }
    
    public Student add(Student student) {  //Adds student object to 
        //Create a new node  
       
        Node newNode = new Node(student);  
       
       
        
  studentCount++;
    //Checks if the list is empty    
    if(head == null) {    
        //If list is empty, both head and tail will point to new node    
        head = tail = newNode;
    }
    else{
        tail.next=newNode;
        tail=newNode;
        }    
        
        return student;
    } 
     public int getStudentCount(){
        return studentCount;
     }


    public SingleLinkedList searchKey(String courseNum) //searches through single linked list and finds students that are registered to given course number
    { SingleLinkedList studentsInCourse=new SingleLinkedList();
        // Get first node
        Node front = this.head;
        // Get last node
        Node rear = this.tail;
        while (front != null && rear != null)
        {
         
            if (front.data.studentCourseID.equals(courseNum) ){
            
                // When node key exists
                studentsInCourse.addStudentNode(front.data);
                
            }
        
            if (front == rear || front.next == rear){
            
                // When get middle nodes
                return studentsInCourse;//returning student list for select course student data
            }
            // Visit to right node
            front = front.next;
            // Visit to left node
            
        }
        // Empty Linked List
        return studentsInCourse;
       
    }
   
    public int size(){ //returns size of student list
        int length=0;
        Node temp = head;
        for(temp = head; temp!=null; temp=temp.next){
    
            length++;
        }
        return length;
    }
     public Student get(int index)//gets student at given index
    {
        Node current = head;
        int count = 0; /* index of Node we are
                          currently looking at */
        while (current != null)
        {
            if (count == index)
                return current.data;
            count++;
            current = current.next;
        }
        return null;
 
        /* if we get to this line, the caller was asking
        for a non-existent element so we assert fail */
       
    }
    public void replace(Student element, int index) {//replaces student at index with element
        Node cursor = head;
        Node prev = null;

        while (cursor != null && index >= 0) {
            index--;
            prev = cursor;
            cursor = cursor.next;
        }

        

        if (prev != null)
            prev.data = element;

        
    }
    public void delete (String studentID) {//searches for student from student ID and deletes 
        Node current = this.head;
        Node before;
       studentCount--;
        //if is the first element
        if (current.data.studentNumber.equals(studentID)) {
            this.head = current.next;
          
            return;     //ending the method
        }
    
        
        before = current;
    
        //while there are elements in the list
        while ((current = current.next) != null) {
    
            //if is the current element
            if (current.data.studentNumber.equals(studentID)) {
                before.next = current.next;
                
                return;     //endind the method 
            }
    
            before = current;
        }
    
        //it isnt in the list
    }
    public Student searchStudentName(String StudentName) //returns student with given student name
    { 
        // Get first node
        Node front = this.head;
        // Get last node
        Node rear = this.tail;
        while (front != null && rear != null)
        {
         String name=front.data.firstName+" "+front.data.lastName;
         String process=name.replaceAll("\\s+",""); //removes spaces
         String procesStudentName=StudentName.replaceAll("\\s+","");
            if (process.equals(procesStudentName) ){
            
                // When node key exists
                return front.data;
                
            }
        
            if (front == rear || front.next == rear){
            
                // When get middle nodes
                return null;//returning student list for select course student data
            }
            // Visit to right node
            front = front.next;
            // Visit to left node
            
        }
        // Empty Linked List
        return null;
       
    }
    public Student swapCourse(Student student,String courseToDrop,String courseToAdd)//swaps course number for given student
    { 
       
        student.setCourseNumberIdentity(courseToAdd);
        return student;
       
    }
}
