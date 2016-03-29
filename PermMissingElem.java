/**
 * This is my solution to the Codility PermMissingElem problem.
 * https://codility.com/programmers/task/perm_missing_elem/
 * 
 * Given an array of N elements with distinct values of 1..N+1, one is
 * missing. Find the missing number.
 * 
 * This solution is simple using Gauss' equation for a sum of a sequence. 
 * Worst and Best time complexity is O(N) to find the actual sum and 
 * the missing element is the difference from sum of the sequence 1..N+1,
 * which is O(1) complexity as it is N*(N+1)/2.
 * 
 * As always with these exercises, be careful with integer overflows.
 * 
 * @author Dr Polar Humenn
 *
 */
public class PermMissingElem {

	/**
	 * A zero-indexed array A consisting of N different integers is given. 
	 * The array contains integers in the range [1..(N + 1)], 
	 * which means that exactly one element is missing.
	 * 
	 */
	public int solution(int[] A) {
		int n = A.length+1;
		long sum = 0;
		for(int i = 0; i < A.length; i++) {
			sum += A[i];
		}
		// Gauss
		return (int) ((long)n*((long)n+1)/2 - sum);
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
