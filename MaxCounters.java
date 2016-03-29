
/**
 * This is my solution to the Codility MaxCounters problem.
 * https://codility.com/programmers/task/max_counters/
 * 
 * There is nothing really tricky needed about this solution. You need an array
 * of N elements and you are going to go through the instruction array A only
 * once. Keep a running track of the max in all of the counters, and you won't 
 * have to scan the counters when it calls to max out the counters. 
 * 
 * The only trick is to see if you really need to max out the counters. 
 * If the maximum did not change since the last max_counter operation, 
 * there is no need to do anything..
 *  
 * @author Dr. Polar Humenn
 *
 */
public class MaxCounters {
	
	public int[] solution(int N, int[] A) {
		int[] counters = new int[N];
		int max = 0;
		int lastMax = 0;
		
		for(int i = 0; i < A.length; i++) {
			int x = A[i];
			if (x <= N) {
				max = Math.max(max, counters[A[i]-1] += 1);
			} else {
				if (lastMax != max) {
					for(int j = 0; j < counters.length; j++) {
						counters[j] = max;
					}
					lastMax = max;
				}
			}
		}
		return counters;
	}

	static void print(String name, int[] array) {
		System.out.print(String.format("%s[%d] = [", name, array.length));
		for(int a : array) {
			System.out.print(String.format("%d,",a));
		}
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		MaxCounters sol = new MaxCounters();
		int A[] = new int[] { 3, 4, 4, 6, 1, 4, 4 };
		long time1 = System.currentTimeMillis();
		int[] result = sol.solution(5, A);
		long time2 = System.currentTimeMillis();
		print("Answer", result);
		System.out.format("Answer time %dms\n", time2-time1);
	}

}
