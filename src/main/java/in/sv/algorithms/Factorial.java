package in.sv.algorithms;

public class Factorial {
	
	/** Dynamic Programming */
	
	public static void main(String[] args){
		
		int result = getFactorial(5);
		
		System.out.println(result);
		
	}

	public static int getFactorial(int n){
		
		int[] fact = new int[n+1];
		
		if (n <= 1){
			
			return 1;
			
		}else{
			
			fact[n] = n*getFactorial(n-1);
			
			return fact[n];
			
		}
		
		
	}
	
}
