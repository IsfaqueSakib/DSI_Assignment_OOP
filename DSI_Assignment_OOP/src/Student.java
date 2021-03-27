import java.util.ArrayList;

public class Student {

	
	String students_class, name;
	boolean subjects[];
	int total_days_taught, total_earning, total_exams;
	double avg_marks;
	
	ArrayList<Student> students=new ArrayList<Student>();
	
	void addStudent(String name, String student_class, boolean[] subjects) {
	
		this.name = name;
		this.students_class = student_class;
		this.subjects = subjects;
		this.avg_marks = 0;
		this.total_days_taught = 0;
		this.total_earning = 0;
		this.total_exams = 0;
		
	}
	
	void seeStudentIndividually(String  st_class) {
		
		System.out.println("Name			Total Earning			Average Marks");
		
		for(Student student : students) {
			if(student.students_class.equals(st_class)) 
				System.out.println(student.name+"			"+ student.total_earning +"				"+student.avg_marks);
				
			
		}
		
	}
	
	void seeStudentIndividually(String  name, String st_class) {
		
		System.out.println("Name		Class		Subjects		Average Marks		Total Days Taught		Total Earnings");
		
		for(Student student : students) {
			if(student.name.equals(name) && student.students_class.equals(st_class)) 
				System.out.print(student.name+"		"+ student.students_class +"		");
				
				for(int i=0; i<3; i++) {
					if(i==0 && student.subjects[i]==true) System.out.print("Math, ");
					if(i==1 && student.subjects[i]==true) System.out.print("English, ");
					if(i==2 && student.subjects[i]==true) System.out.print("Bangla");
				}
			
				System.out.println("		"+student.avg_marks+"			"+student.total_days_taught+"				"+student.total_earning);
				
			
		}
		
	}
	
	void editSturdent(String name, int total_days_taught, int mark)
	{
		boolean student_exists=false;
		for(Student student : students) {
			if(student.name.equals(name)) {
				student_exists=true;
				student.total_days_taught=total_days_taught;
				student.total_exams = student.total_exams+1;
				student.avg_marks = (avg_marks*(student.total_exams-1) + mark)/student.total_exams;
				
				int count=0;
				for(int i=0; i<3; i++) {
					if(student.subjects[i]==true) count++;
				}
				
				student.total_earning = total_days_taught*count;
			}
				
		}
		if(student_exists) System.out.println(name+"'s Info Have Been Edited Successfully");
		else System.out.println("Student Named "+name+" Not Found");
	}
	
	void deleteStudent(String del_name)
	{
		for(Student student : students) {
			if(student.name.equals(del_name)) {
				students.remove(student);
				System.out.println(del_name+"'s Info have been Deleted");
				break;
			}
				
		}
	}
	
	void seeOverallInfo()
	{
		int total_days_taught_allClass = calculateByClass("8", "Days_Taught")+calculateByClass("9", "Days_Taught")+calculateByClass("10", "Days_Taught");
		System.out.println("Total Days Taught Across All Classes : "+total_days_taught_allClass);
		
		System.out.println("Individual days taught in each class : ");
		System.out.println("			Class 8			Class 9			Class 10");
		System.out.println("			"+calculateByClass("8", "Days_Taught")+"			"+calculateByClass("9", "Days_Taught")+"			"+calculateByClass("10", "Days_Taught"));
		
		int total_earning_allClass = calculateByClass("8", "Earning")+calculateByClass("9", "Earning")+calculateByClass("10", "Earning");
		System.out.println("Total earnings : "+total_earning_allClass);
		
		System.out.println("Individual earnings of each class : ");
		System.out.println("			Class 8			Class 9			Class 10");
		System.out.println("			"+calculateByClass("8", "Earning")+"			"+calculateByClass("9", "Earning")+"			"+calculateByClass("10", "Earning"));
		
	}
	
	int calculateByClass(String st_class, String property) {
		
		int total_earning_by_class=0, total_days_taught_by_class=0;
		
		for(Student student : students) {
			
			if(student.students_class.equals(st_class)) {
				
				total_days_taught_by_class = total_days_taught_by_class+student.total_days_taught;
				total_earning_by_class = total_earning_by_class+student.total_earning;
			}
				
		}
		
		if(property.equals("Earning")) return total_earning_by_class;
		else if(property.equals("Days_Taught")) return total_days_taught_by_class;
		
		return 0;
	}
	
}
