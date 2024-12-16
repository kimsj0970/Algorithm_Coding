import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }

    public static void bfs(List<List<Integer>> graph, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int v = Integer.parseInt(s[2]);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[n + 1];

        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            String[] ss = input.split(" ");
            int a = Integer.parseInt(ss[0]);
            int b = Integer.parseInt(ss[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(graph, visited, v);
        System.out.println();

        Arrays.fill(visited, false);
        bfs(graph, visited, v);
    }
}
