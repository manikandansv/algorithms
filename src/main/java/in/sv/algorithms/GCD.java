package in.sv.algorithms;

public class GCD {

	public static int getGCD(int[] a){
		 
		int result = a[0]; 
		
		for (int i=1; i< a.length; i++){
			
			result = getGCD(a[i], result);
			
		}
		
		
		return result;
		
	}
	
	static int getGCD(int a, int b){
		
		if (b == 0){
			
			return a;
			
		}
		
		return getGCD(b, a % b);
		
	}
	
	public static void main(String args[]){
		
		int a[] = {2,4,6,0};
		
		int gcd = getGCD(24, 40);
		
		System.out.println(getGCD(a));
		
		System.out.println(gcd);
		
	}
	
}
