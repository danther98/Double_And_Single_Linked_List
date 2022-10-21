
public class DoubleLinkedList<T>  {
	
	
	
	int courseCount=0;
  public class Node<T>{
	  Node<T> previous;
	  Node<T> next;
    
	  Course data;
        //making nodes
	  public Node(Course data){
	      this(data, null, null);
	  }

	  public Node(Course data, Node<T> previous, Node<T> next){
	      this.data = data;
	      this.previous = previous;
	      this.next = next;
        
	  }

    
  }
  

  //Represent the head and tail of the doubly linked list  
  Node head, tail,studHead= null;  

public int courseCount(){//method to get coursecount
    return courseCount;
}
  public Course add(Course course) {  
    //Create a new node  
   
    Node newNode = new Node(course);  
    
    if(searchKey(course)){
        System.out.println("Course is already added");
        return course;
    }else{
      System.out.println("** Course addNODE IS CALLED **");
    courseCount++;
   
    //If list is empty  
    if(head == null) {  
        //Both head and tail will point to newNode  
        head = tail = newNode;  
        //head's previous will point to null  
        head.previous = null;  
        //tail's next will point to null, as it is the last node of the list  
        tail.next = null;  
    }  
    else {  
        //newNode will be added after tail such that tail's next will point to newNode  
        tail.next = newNode;  
        //newNode's previous will point to tail  
        newNode.previous = tail;  
        //newNode will become new tail  
        tail = newNode;  
        //As it is last node, tail's next will point to null  
        tail.next = null;  
    }
    return course;
}  

  }
  //displayCourseNode() will print out the nodes 
  public void displayCourseNode() {  
    int i =0;
      //Node current will point to head  
      Node current = head;  
      if(head == null) {  
          System.out.println("List is empty");
          return;  
      }  
      

      while(current != null) {  
          //Prints each node by incrementing the pointer.  
i++;
          
          System.out.println();
            System.out.println(" --Course Name: "+current.data.courseName);
            System.out.println(" ---Course Number: "+current.data.courseNumber);
            System.out.println("----Student count is: "+makeDoublyLists.displaystudentdata(current.data.courseNumber));
            System.out.println();
          //  System.out.println("Course Node data is:"+current.data.courseName+" --- Course Number:"+current.data.courseNumber);
          current = current.next;  
      }  
  }

 
 
 


public boolean searchKey(Course course)//method to search for course and check if already present in list
{
    // Get first node
    Node front = this.head;
    // Get last node
    Node rear = this.tail;
    while (front != null && rear != null)
    {
        if (front.data.courseNumber.equals(course.courseNumber) || rear.data.courseNumber.equals(course.courseNumber)){
        
            // When node key exists
            return true;
        }
        if (front == rear || front.next == rear){
        
            // When get middle nodes
            return false;
        }
        // Visit to right node
        front = front.next;
        // Visit to left node
        rear = rear.previous;
    }
    // Empty Linked List
    return false;
}

public int findPos(String course)//finding Node that contains course number data and returning index of the node that contains
{int i=0;//To find Node index
    // Get first node
    Node front = this.head;
    // Get last node
    Node rear = this.tail;
    while (front != null && rear != null)
    {
        if (front.data.courseNumber.equals(course) || rear.data.courseNumber.equals(course)){
        
            // When node key exists
            return i;
        }
        if (front == rear || front.next == rear){
        
            // When get middle nodes
            return 0;
        }
        // Visit to right node
        front = front.next;
        i++;
        // Visit to left node
        rear = rear.previous;
    }
    // Empty Linked List
    return -1;
}
    public Node get(int i){//retreiving node based on position 
        Node front=this.head;
        
        for(int w=0;w<i;w++){
            front=front.next;
        }
        return front;
    }

  public void deleteNode(int position)//deleting node from index given 
    {
        courseCount--;
        if (head == null)
            return;
        Node temp = head;
        if (position == 0)
        {
            head = temp.next;  
            return;
        }
        for (int i=0; temp!=null && i<position-1; i++)
            temp = temp.next;
        if (temp == null || temp.next == null)
            return;
        Node next1 = temp.next.next;
 
        temp.next = next1;  
    }

    public int size(){//returns size in int
        int length=0;
        Node temp = head;
        for(temp = head; temp!=null; temp=temp.next){
    
            length++;
        }
        return length;
    }
    public Course get1(int index)//returns course from given index
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
 
    
    }
    public void replace(Course element, int index) {//replaces course at given index with element
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
}
  
    

