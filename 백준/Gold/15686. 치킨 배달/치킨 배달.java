import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] arr ;
    static List<int[]> chicken = new ArrayList<>();
    static List<int[]> home = new ArrayList<>();
    static List<int[]> chose = new ArrayList<>();
    static int minDistance = Integer.MAX_VALUE;
    static int m;

    static void backtrack(int idx, int depth) {
        // 내가 원하는 치킷집 갯수 만큼만 조합
        if (depth == m) {
            // 거리 계산하는 함수로 따로
            distance();
            return;
        }

        // 치킨집 고르는 반복
        for (int i = idx; i < chicken.size(); i++) {
            chose.add(chicken.get(i));
            backtrack(i + 1, depth + 1);

            // a, b 고른 후 b만 삭제해 a는 다시 재선택 가능하게
            chose.remove(chose.size() - 1);
        }
    }

    static void distance(){
        int hap = 0;

        for (int i = 0; i < home.size(); i++) {
            // 집 해당 위치 하나를 골라서
            int[] homeXY = home.get(i);

            // 한 집에서 최소의 거리인 치킨집을 찾기 위해
            int minDistance = Integer.MAX_VALUE;

            for (int j = 0; j < m; j++) {
                // 골라진 치킨집들의 거리 계산
                int[] chickenXY = chose.get(j);

                int chickenTemporary = Math.abs(chickenXY[0] - homeXY[0]) + Math.abs(chickenXY[1]- homeXY[1]);
                if (minDistance > chickenTemporary) {
                    minDistance = chickenTemporary;
                }
            }
            hap+=minDistance;
        }
        if (hap < minDistance) {
            minDistance = hap;
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstInput = br.readLine().split(" ");

        int n = Integer.parseInt(firstInput[0]);
        m = Integer.parseInt(firstInput[1]);

        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                int parseInt = Integer.parseInt(input[j]);
                arr[i][j] = parseInt;
                if (parseInt == 2) {
                    chicken.add(new int[]{i, j});
                }
                if (parseInt == 1) {
                    home.add(new int[]{i, j});
                }
            }
        }

        backtrack(0,0);

        sb.append(minDistance);
        System.out.println(sb.toString());
    }
}