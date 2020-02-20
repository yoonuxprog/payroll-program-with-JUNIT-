import java.util.InputMismatchException;
import java.util.Scanner;

public class payroll_method {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int emp_id = 0;
		System.out.print("Enter an employee_ID: ");
		emp_id = input.nextInt();
		while (!Get_ID(emp_id)) {
			
			System.out.print(" invalid ID ! ");
			System.out.print("Enter an employee_ID: ");
			emp_id = input.nextInt();
		}
		
		System.out.println("employemeent type: P or F ");
		
		String employment_type = input.next();
		employment_type = employment_type.toUpperCase();
		
		while(!getEmploymentType(employment_type))
		{
			System.out.println("invalid employee type");
			System.out.println("employemeent type: P or F ");
			employment_type = input.next();
			
		}
		
		    
	        float current_rate;
	        float  min_rate, max_rate;
	        float salary= 0;
	        float hours_worked;
	        float additional_hours = 0;
	        float total_hours = 0;
	        if (employment_type.equals("P")){
	        	min_rate = 30;
	        	max_rate = 45;
	        	float max_hour = 60; 
	        	
	        
	        	System.out.println("please enter RATE between 30.00 to 45.00 inclusive ?");
	        	current_rate = input.nextFloat();
	        	while(!get_Rate (current_rate,min_rate,max_rate ))
	        	{
	        		System.out.println("invalid");
	        		System.out.println("please enter RATE between 30.00 to 45.00 inclusive ?");
		        	current_rate = input.nextFloat();
	        	}
	        	
	        
	        	System.out.println("enter hours_worked between 15 or 60 inclusive ");
             	hours_worked = input.nextInt();
             	while (get_hours(hours_worked, max_hour) != hours_worked)
             	{
             		System.out.println("invalid");
             		System.out.println("enter hours_worked between 15 or 60 inclusive ");
                 	hours_worked = input.nextInt();
             	}
             	if (hours_worked < 40) {
             		total_hours += hours_worked;
             	}
             	else {
             		additional_hours = get_add_hours(hours_worked);
             		System.out.println("additional hours : " + additional_hours);
             		total_hours = 40 + additional_hours ;	
             	}
             	
             	salary = get_salary(total_hours,current_rate, additional_hours);
             	System.out.println ("salary : " + salary);	
	        	
	        }
	        if(employment_type.equals("F")) {
	        	min_rate = 45;
	        	max_rate = 60;
	        	float max_hour = 40;
	        	System.out.println("please enter RATE between 45 to 60 inclusive ?");
	        	current_rate = input.nextFloat();
	        	while(!get_Rate (current_rate,min_rate,max_rate ))
	        	{
	        		System.out.println("invalid");
	        		System.out.println("please enter RATE between 30.00 to 45.00 inclusive ?");
		        	current_rate = input.nextFloat();
	        	}
	        	System.out.println("enter hours_worked between 15 or 40 inclusive ");
	        	hours_worked = input.nextInt();
	        	while (get_hours(hours_worked, max_hour) != hours_worked)
             	{
             		System.out.println("invalid");
             		System.out.println("enter hours_worked between 15 or 60 inclusive ");
                 	hours_worked = input.nextInt();
             	}
	        	total_hours += hours_worked;
	        	salary = get_salary(total_hours,current_rate, additional_hours);
	        	System.out.println ("salary : " + salary);	
	        	
	        }
	        System.out.println("employee ID : "+ emp_id  + "  employment type : " + employment_type + "   " + total_hours + " hour/s  " +"$"+ salary );
	       
		

	}
	
	public static boolean Get_ID (int employee_ID) {
	            if (String.valueOf(employee_ID).length() != 6) {
	            		return false;
	            	}
	            else {
	            	return true;
	            }
	}
	
	
	static boolean get_Rate(float rate,float min, float max) {
		if (rate < min || rate > max) {
   		 return false;	}
		else {
			return true;
		}
		
		
	  }
	
	static float get_hours (float hours, float max_hour) {
		if(hours>=15 && hours<=max_hour) 
			{return hours;}
		else
		{
			throw new RuntimeException();
		}
	}
	
	static float get_add_hours(float hours) {
		float additional_hour = hours % 40;
		return additional_hour;	
	}
	
	static float get_salary(float hours, float current_rate, float add_hours) {
		float salary = 0;
		if (hours > 40) {
			salary = (40 * current_rate) + (add_hours * 60);	
		}
		else {
			salary = hours * current_rate;
		}	
		return salary;	
	}
	
	public static boolean getEmploymentType(String employment_type)
	{
		employment_type = employment_type.toUpperCase();
		
		if (!employment_type.equals("P") && !employment_type.equals("F")  )
    	{  
    		return false;
    	} else {
    		return true;
    	}
		
		
	}

}
