import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[][][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Node {
        int x, y, wall;

        Node(int x, int y, int wall) {
            this.x = x;
            this.y = y;
            this.wall = wall;
        }
    }

    public static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0));
        visit[0][0][0] = 1;

        while (!q.isEmpty()) {
            Node current = q.poll();
            int x = current.x;
            int y = current.y;
            int wall = current.wall;

            if (x == n-1 && y == m-1)
                return visit[x][y][wall];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    // 벽이 없고 아직 방문하지 않은 경우
                    if (arr[nx][ny] == 0 && visit[nx][ny][wall] == 0) {
                        visit[nx][ny][wall] = visit[x][y][wall] + 1;
                        q.add(new Node(nx, ny, wall));
                    }

                    // 벽이 있고 아직 벽을 뚫지 않은 경우
                    if (arr[nx][ny] == 1 && wall == 0 && visit[nx][ny][1] == 0) {
                        visit[nx][ny][1] = visit[x][y][wall] + 1;
                        q.add(new Node(nx, ny, wall + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];
        visit = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }
}
