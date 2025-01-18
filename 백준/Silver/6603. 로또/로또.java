import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static void back(int dep, int start, int k, int[] arr, int[] selete) {
        if (dep == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(selete[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < k; i++) {
            selete[dep] = arr[i];
            back(dep + 1, i + 1, k, arr, selete);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] s = br.readLine().split(" ");
            int k = Integer.parseInt(s[0]);

            if (k == 0) break; 

            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(s[i + 1]);
            }

            int[] selete = new int[6]; 
            back(0, 0, k, arr, selete);
            System.out.println(); 
        }
    }
}
