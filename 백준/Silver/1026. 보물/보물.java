import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        Integer[] b = new Integer[n];
        //n번 입력
        String[] s = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            a[i]= Integer.parseInt(s[i]);
        }
        s = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            b[i]= Integer.parseInt(s[i]);
        }
        //내림차순, 오름차순 정렬
        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());
        int sum=0;
        for(int i=0 ; i<n ;i++){
            sum += a[i] * b[i];
        }
    System.out.println(sum);
}
}