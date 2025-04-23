package practice;

public class GenericMethodsPractice {
	
	public static void main(String[] args) { //Calling function/Caller function
		
		//hard coding
//		int a = 20;
//		int b = 30;
//		int c = a+b;
//		System.out.println(c);
		
		int sum = add(20,40);
		System.out.println(sum);
		
		System.out.println(add(sum,78));
		System.out.println(add(100,sum));
		

	}
	
	public static int add(int a , int b) //Called Function - generic
	{
		int c = a+b; //logic
		return c;
	}

}
