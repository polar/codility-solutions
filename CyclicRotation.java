
/**
 * Simplistic solution for Codility CyclicRotation
 * https://codility.com/demo/take-sample-test/cyclic_rotation/
 * 
 * @author Dr. Polar Humenn
 *
 */
public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        int[] b = new int[A.length];
        for(int i = 0; i < b.length; i++) {
            b[i] = A[(A.length + i - (K % A.length)) % A.length];
        }
        return b;
    }

}
