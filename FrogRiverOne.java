/**
 * This is my solution to the Codility FrogRiverOne problem.
 * https://codility.com/programmers/task/frog_river_one/
 * 
 * As with others, it takes a Guassian solution to keep the time complexity
 * down. We need to notice when a sequence 1..X is complete, and we use a 
 * O(X) space, boolean array, to record an fallen leaf position as it may
 * multiple leaves may fall into the same position. If there is not one there,
 * recorded by the boolean array, then record it and subtract from the Gaussian
 * total of the sequence. If we reached a zero, then the sequence is complete.
 * This is O(N) better than scanning the boolean array each time scanning for
 * a false.
 *  
 * @author Dr Polar Humenn
 *
 */
public class FrogRiverOne {

	public int solution(int X, int[] A) {
		int i = 0;
		long total = (long) X * ((long) X + 1)/2;
		boolean[] down = new boolean[X];
		
		while(i < A.length && total > 0) {
			if (A[i] <= X) {
				if (!down[A[i]-1]) {
					total -= A[i];
				}
				down[A[i]-1] = true;
			}
			i++;
		}
		return total == 0 ? i-1 : -1;
	}
	
	public static void main(String[] args) {
		FrogRiverOne sol = new FrogRiverOne();
		int A[] = new int[] { 1, 3, 1, 4, 2, 3, 4, 4 };
		long time1 = System.currentTimeMillis();
		int result = sol.solution(5, A);
		long time2 = System.currentTimeMillis();
		System.out.format("Answer is %d, time %dms\n", result, time2-time1);
	}

}
