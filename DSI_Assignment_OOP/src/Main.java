import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int menu=0;
		
		//create an instance of student class
		Student student = new Student();
		
	    while(true) {
	    	
	    	//create another instance of student class
			Student current_student = new Student();
	    	
	    if(menu==6) {
	    	System.out.println("Exited");
	    	break;
	    }
	    
		//Menu
		System.out.println("Menu :");
		System.out.println("1 to Add Student");
		System.out.println("2 to Edit Student");
		System.out.println("3 to Delete Student");
		System.out.println("4 to See Student Individually");
		System.out.println("5 to See Overall Info");
		System.out.println("6 to Exit");
		
		//take a input for selecting menu 
		System.out.println("Enter Your Choice : ");
		Scanner scn=new Scanner(System.in);
		menu=scn.nextInt();
		
		if(menu==1) {
			//add a student
			System.out.println("Choose a Class :");
			System.out.println("8 to Add Student in Class Eight");
			System.out.println("9 to Add Student in Class Nine");
			System.out.println("10 to Add Student in Class Ten");
			
			System.out.println("Enter Your Choice : ");
			String students_class = scn.next();
			
			System.out.println("Sudent's Name : ");
			String name = scn.next();
			
			System.out.println("Subects [Math English Bangla] : ");
			boolean subjects[]= new boolean[3];
			
			for(int subject=0; subject<3; subject++) {
				 subjects[subject] = scn.nextBoolean();	
			}
			
			current_student.addStudent( name, students_class, subjects);
			student.students.add(current_student);
		}
		
		if(menu == 2)
		{
			//edit student
			System.out.println("Enter Student's Name to Edit : ");
			String name = scn.next();
			
			System.out.println("Obtained Number : ");
			int obtained_mark = scn.nextInt();
			
			System.out.println("Total Days Taught : ");
			int total_days_taught = scn.nextInt();
			
			student.editSturdent(name, total_days_taught, obtained_mark);
			
		}
		
		if(menu == 3) {
			//delete student
			if(!student.students.isEmpty()) {
				System.out.println("Enter Student's Name to Delete : ");
				String name = scn.next();
				
				student.deleteStudent(name);
			}
			else System.out.println("No Student In the List");
			
		 }
		
			
		
			
		if(menu == 4 )
		{
			//see Student's individual Info
			System.out.println("Choose an Option : ");
			System.out.println("1 to Specific class : ");
			System.out.println("2 to Specific student : ");
			
			System.out.println("Enter Your Choice : ");
		    int choice = scn.nextInt();
		    
		    if(choice == 1) {
		    	//see all student's Info of a specific class
		    	System.out.println("Choose a Class :");
				System.out.println("8 to Add Student in Class Eight");
				System.out.println("9 to Add Student in Class Nine");
				System.out.println("10 to Add Student in Class Ten");
					
				System.out.println("Enter Your Choice of Class : ");
			    String see_class = scn.next();
				
			    if(student.students.isEmpty()) System.out.println("No student In the List");
			    else student.seeStudentIndividually(see_class);
		    }
		    else {
		    	//See Specific student's Info
		    	System.out.println("Enter Student's Name : ");
		    	String name = scn.next();
		    	
		    	System.out.println("Choose a Class :");
				System.out.println("8 to Add Student in Class Eight");
				System.out.println("9 to Add Student in Class Nine");
				System.out.println("10 to Add Student in Class Ten");
					
				System.out.println("Enter Your Choice of Class : ");
			    String see_class = scn.next();
			    
			    if(student.students.isEmpty()) System.out.println("No student In the List");
			    else student.seeStudentIndividually(name, see_class);
			    
		    }
		    
		}
		
		if(menu == 5)
	    {
	    	//see overall Info
			if(student.students.isEmpty()) System.out.println("No student In the List");
			else student.seeOverallInfo();
	    }
		
	}
	   

 }

}
