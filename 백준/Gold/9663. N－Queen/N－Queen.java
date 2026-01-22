import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int count = 0;
    static int[] n;

    public static void dfs (int height){
        if(height == n.length){
            count++;
            return;
        }
        for(int i = 0; i < n.length; i++){
            if(isAlive(height, i)){

                // 해당 행에 열 위치만 저장 (굳이 2차원 배열 사용 X)
                n[height] = i;
                dfs(height+1);
            }
        }

    }

    public static boolean isAlive(int height, int width){
        for(int i = 0; i < height; i++){

            // 같은 열
            if(n[i] == width){
                return false;
            }

            // 대각선
            if(Math.abs(height-i) == Math.abs(width-n[i])){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nums = Integer.parseInt(br.readLine());
        n = new int[nums];

        dfs(0);

        System.out.println(count);
    }
}
