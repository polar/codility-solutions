import java.util.HashSet;

/**
 * This is my solution for the Codility OddOccurencesInArray problem.
 * https://codility.com/programmers/task/odd_occurrences_in_array/
 * 
 * I racked my brain over this thinking there is some number theoretic trick
 * to an array of positive numbers to get an O(N) time complexity and an
 * O(1) space complexity. It is a requirement of the problem that there
 * are no zeros or negative numbers in the array. So, maybe there is. 
 * If the array was guaranteed to have only values of 0..n-1, you can use 
 * an indexing trick, but the values could be an order of magnitude bigger,
 * 0..1,000,000,000 than the length of the array, 0..1,000,000. So,
 * I'm stumped.
 * 
 * This solution uses a HashSet, which tells me that the worst case analysis
 * is O(N) time, but O(N) space. This is because HashSet has O(1) for functions
 * "contains", "remove", and "add". However, it is not O(1) space. 
 * In the worse case at least N/2 space is needed, which is basically O(N);
 * 
 * The worst case for this particular solution would be, for example, of the 
 * form:
 *             [1,2,3,4,5,5,4,3,2,1,6].
 *             
 * This problem would require storing N/2 numbers, which is O(N), not O(1);
 * It must store [1,2,3,4,5] before it starting depleting the storage.
 * 
 * However, Codelitiy claims the detected analysis for this solution is 
 * "O(N) or O(N*log(N))," and deems that acceptable. I don't get it.
 * 
 * @author Dr Polar Humenn
 *
 */
public class OddOccurrencesInArray {
	
	public int solution(int[] A) {
		HashSet<Integer> set = new HashSet<Integer>(A.length/2);
		
		for(int i = 0; i < A.length; i++) {
			if (set.contains(A[i])) {
				set.remove(A[i]);
			} else {
				set.add(A[i]);
			}
		}
		return (int) set.toArray(new Integer[0])[0];
	}

	static void print(String name, int[] array) {
		System.out.print(String.format("%s[%d] = [", name, array.length));
		for(int a : array) {
			System.out.print(String.format("%d,",a));
		}
		System.out.println("]");
	}

	static int[] worst(int n) {
		int[] w = new int[n];
		for(int i = 0; i < n; i++) {
			if (i < n/2) {
				w[i] = i+1;
			} else {
				w[i] = (n-i-1);
			}
		}
		w[n-1] = n;
		return w;
	}
	
	public static void main(String[] argv) {
		int[] A = worst(999999);
		//print("Solution", A);
		long time1 = System.currentTimeMillis();
		OddOccurrencesInArray sol = new OddOccurrencesInArray();
		int result = sol.solution(A);
		long time2 = System.currentTimeMillis();
		System.out.format("Answer is %d, time = %dms\n", result, time2-time1);
	}
}
