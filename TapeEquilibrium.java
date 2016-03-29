
/**
 * This is my solution to the Codility TapeEquilibrium problem.
 * https://codility.com/programmers/task/tape_equilibrium/
 * 
 * Need to be careful with integer overflow on sums. 
 * 
 * Expected worst case is O(N) time and O(N) space complexity. 
 * However, with 2*N scan, one for the sum, and one for scanning the
 * differences, we can get away with O(1) space complexity as we 
 * only need accumulators. 
 * 
 * @author Dr Polar Humenn
 *
 */
public class TapeEquilibrium {
	
	public int solution(int[] A) {
		long sum = 0;
		for(int i = 0; i < A.length; i++ ) {
			sum += A[i];
		}
		long left = 0;
		long right = sum;
		int min = Integer.MAX_VALUE;
		for(int p = 1; p < A.length; p++) {
			left += A[p-1];
			right -= A[p-1];
			int diff = (int) Math.abs(left - right);
			//System.out.format("%d |%d - %d| diff %d\n", p, left, right, diff);
			min = Math.min(min, diff);
		}
		return min;
	}
	
	public static void main(String[] args) {
		TapeEquilibrium sol = new TapeEquilibrium();
		int A[] = new int[] { 3, 1, 2, 4, 3 };
		long time1 = System.currentTimeMillis();
		int result = sol.solution(A);
		long time2 = System.currentTimeMillis();
		System.out.format("Answer is %d, time %dms\n", result, time2-time1);
	}

}
