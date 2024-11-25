import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] a;
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(a);

        StringBuilder sb = new StringBuilder();
        for(int num : a){
            sb.append(num).append("\n");
        }
        System.out.print(sb);
    }
}
