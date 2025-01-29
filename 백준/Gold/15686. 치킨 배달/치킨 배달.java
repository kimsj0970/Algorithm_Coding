import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Main {
    static int N,M;
    static int arr[][];
    static int min = Integer.MAX_VALUE;
    static List<int[]> homeq = new LinkedList<>();
    static List<int[]> chickenq = new LinkedList<>();
    static boolean visit[];

    static void back(int start, int depth) {

        if (depth == M) {
            diff();
            return;
        }

        for (int i = start; i < chickenq.size(); i++) { //치킨집 여러군대에서 m개를 뽑기 위해
            if (!visit[i]) {
                visit[i] = true;
                back(i+1, depth + 1);
                visit[i] = false;
            }
        }
    }

    static void diff() {
        int totaltime = 0; // 각 집에 대해 최소 치킨 거리 합 계산

        // 각 집마다 가장 가까운 치킨집과의 거리 계산
        for (int i = 0; i < homeq.size(); i++) {
            int home[] = homeq.get(i);  // 각 집에 대해서
            int distance = Integer.MAX_VALUE; // 집마다 최소 거리 초기화

            // 각 집에 대해 선택된 치킨집과의 거리 계산
            for (int j = 0; j < chickenq.size(); j++) {
                if (visit[j]) { // 선택된 치킨집만 계산
                    int ch[] = chickenq.get(j);  // 치킨집
                    int sum = Math.abs(home[0] - ch[0]) + Math.abs(home[1] - ch[1]); // 각 집들마다 치킨집과의 거리들 합을 구함
                    distance = Math.min(distance, sum); // 여러 치킨집 중 가장 가까운 치킨집 찾기
                }
            }

            totaltime += distance; // 최소 치킨거리 더하기
        }

        min = Math.min(min, totaltime); // 최소 치킨 거리 갱신
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        N= Integer.parseInt(s[0]);
        M= Integer.parseInt(s[1]);
        arr = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            String line[] = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
                if (arr[i][j]==1){
                    homeq.add(new int[]{i, j});
                }
                else if (arr[i][j]==2){
                    chickenq.add(new int[]{i, j});
                }
            }
        }
        visit= new boolean[chickenq.size()];
        back(0, 0);
        System.out.println(min);

    }
}
