import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int arr[][];
    static int in[][];
    static List<Integer> size =  new ArrayList<>();
    static boolean visits [][];
    static int xd[] = {-1,1,0,0};
    static int yd[] = {0,0,-1,1};
    static int count;
    static int n,m;

    static void dfs(int x, int y) {
        count++;

        for (int i = 0; i < 4; i++) {
            int xsum = x + xd[i];
            int ysum = y + yd[i];
            if (xsum >= 0 && xsum < n && ysum >= 0 && ysum < m && arr[xsum][ysum] == 0 && !visits[xsum][ysum]) {

                visits[xsum][ysum] = true;
                dfs(xsum, ysum);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);
        visits = new boolean[n][m];
        arr = new int[n][m];
        in = new int[k][4];
        for (int i = 0; i < k; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < 4; j++) {
                in[i][j] = Integer.parseInt(s[j]);
            }
        }


        for (int i = 0; i < k; i++) {
            for (int j = in[i][1]; j < in[i][3]; j++) {
                for (int l = in[i][0]; l < in[i][2]; l++) {
                    arr[j][l] = 1;
                }

            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(arr[i][j] == 0 && !visits[i][j]){
                    count=0;
                    visits[i][j] = true;
                    dfs(i, j);
                    size.add(count);
                }
            }
        }

        System.out.println(size.size());
        Collections.sort(size);
        for (int i = 0; i < size.size(); i++) {
            System.out.print(size.get(i)+" ");
        }

    }

}
