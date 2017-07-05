package in.sv.algorithms;

public class Fibonacci {
	
	/** Dynamic Programming */
	
	public static void main(String args[]){
		
		int result  = getFibonacci(9);
		
		System.out.println("Result :" + result);
		
	}


	public static int getFibonacci(int n) {
		
		int[] fib = new int[n+1];

		if (n <= 1) {

			return n;
		} else {

			fib[0] = 0;
			System.out.println(fib[0]);
			fib[1] = 1;
			System.out.println(fib[1]);
			
			for (int i=2; i<=n; i++){
				fib[i] = fib[i-1] + fib[i-2];
				System.out.println(fib[i]);
			}
			
			return fib[n];
			
		}

	}

}
