package in.sv.algorithms;

public class LCM {
	
	public static int getLCM(int[] a){
		
		int result = a[0];
		
		for (int i=1; i<a.length;i++){
			
			result = getLCM(a[i], result);
			
		}
		
		return result;
		
	}

	public static int getLCM(int a, int b){
		
		int result = (a * b) / GCD.getGCD(a, b);
		
		return result;
		
	}
	
	public static void main(String[] args){
		
		int[] a = {4,6,2};
		
		System.out.println(getLCM(a));
		
		System.out.println(getLCM(4,6));
		
	}
	
}
