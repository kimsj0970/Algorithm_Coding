import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int [] a,b;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        a = new int[N];
        String[] inputA = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(inputA[i]);
        }
        Arrays.sort(a);

        int M = Integer.parseInt(br.readLine());
        b = new int[M];
        String[] inputB = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            b[i] = Integer.parseInt(inputB[i]);
        }


        for (int i = 0; i < M; i++) {
            check(a,b[i]);
        }
    }

    public static void check(int[] a, int target) {
        int st = 0;
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (a[mid]==target) {
                st = 1;
                break;
            }
            else if (a[mid]>target) {
                right = mid - 1;
            }
            else {
                left = mid + 1 ;
            }

        }
    if (st == 1){
        System.out.println(1);
    }
    else
        System.out.println(0);
    }
}