
/**
 * This is my solution for Codility FrogJmp problem.
 * https://codility.com/programmers/task/frog_jmp/
 * 
 * Solution must be constant time O(1), of course, as it's just an equation.
 * 
 * @author polar
 *
 */
public class FrogJmp {
	
	/**
	 * Given three integers X, Y and D, X <= Y, 
	 * returns the minimal number of jumps by D, from position X to a 
	 * position equal to or greater than Y.
	 * 
	 * @param X starting position
	 * @param Y minimum ending position
	 * @param D distance of jumps
	 * @return the minimum number of jumps to get past Y
	 */
	public int solution(int X, int Y, int D) {
		return (Y-X)/D + (((Y-X) % D != 0) ? 1 : 0);
		
	}
	
	public static void main(String[] args) {
		FrogJmp sol = new FrogJmp();
		
		long time1 = System.currentTimeMillis();
		int result = sol.solution(1, 5, 2);
		long time2 = System.currentTimeMillis();
		System.out.format("Answer is %d, time %dms\n", result, time2-time1);
	}

}
