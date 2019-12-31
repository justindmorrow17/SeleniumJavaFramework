package demo;

public class ExceptionHandlingDemo {
	
	public static void main(String[] args) {
				
		try {
			System.out.println("Hello World....!");
			int i = 1/0;
			System.out.println("\n Completed");
		} catch(Exception exp) {
			System.out.println("I am inside the catch block");
			System.out.println("Message is: "+ exp.getMessage());
			System.out.println("Cause is: "+ exp.getCause());
		} finally {
			System.out.println("I am inside finally block");
		}
		
	}

}
