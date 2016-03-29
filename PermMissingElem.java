
public class PermMissingElem {

	/**
	 * A zero-indexed array A consisting of N different integers is given. 
	 * The array contains integers in the range [1..(N + 1)], 
	 * which means that exactly one element is missing.
	 * 
	 */
	public int solution(int[] A) {
		int n = A.length+1;
		int sum = 0;
		for(int i = 0; i < A.length; i++) {
			sum += A[i];
		}
		// x = sum - n*(n+1)/2;
		return n*(n+1)/2 - sum;
	}
	
	public static void main(String[] args) {
		PermMissingElem sol = new PermMissingElem();
		int A[] = new int[] { 1, 3, 4, 5, 6 };
		long time1 = System.currentTimeMillis();
		int result = sol.solution(A);
		long time2 = System.currentTimeMillis();
		System.out.format("Answer is %d, time %dms\n", result, time2-time1);
	}

}
