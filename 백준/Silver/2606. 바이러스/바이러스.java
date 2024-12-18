import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int start = 1;
    static int count =0;
    public static void bfs (List<List<Integer>> arr, boolean[] visit){

        Queue<Integer> q = new LinkedList<Integer>();
        visit[start] = true;
        q.add(start);


        while (!q.isEmpty()){
            int node = q.poll();
//            System.out.println(node);
            count++;
            for (int i : arr.get(node)){
                if (!visit[i]){
                    visit[i] = true;
                    q.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine()); //컴퓨터 수
        int N = Integer.parseInt(br.readLine()); //간선 수
        List<List<Integer>> arr = new ArrayList<>();
        boolean[] visited = new boolean[C+1];

        // 리스트 초기화
        for (int i = 0; i <= C; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            String[] st = br.readLine().split(" ");
            int a = Integer.parseInt(st[0]);
            int b = Integer.parseInt(st[1]);
            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        for (int i=1; i<=C; i++) {
            Collections.sort(arr.get(i));
        }

        bfs(arr,visited);
        System.out.println(count-1);
    }
}
