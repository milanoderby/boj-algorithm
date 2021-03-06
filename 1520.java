import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] dy = {0, 0, -1, 1};
    private static int[] dx = {-1, 1, 0, 0};
    private static int N, M;
    private static int[][] NUM_OF_PATH, MAP;
    private static boolean[][] isCalculated;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        MAP = new int[N + 2][M + 2];
        NUM_OF_PATH = new int[N + 2][M + 2];
        isCalculated = new boolean[N + 2][M + 2];
        for (int i = 1; i <= N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                MAP[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        System.out.println(dfs(N, M));
    }

    private static int dfs(int y, int x) {
        if (y == 1 && x == 1) {
            isCalculated[y][x] = true;
            return 1;
        }

        if(isCalculated[y][x]) {
            return NUM_OF_PATH[y][x];
        }

        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (!(1 <= ny && ny <= N && 1 <= nx && nx <= M)) {
                continue;
            }

            if (MAP[y][x] < MAP[ny][nx]) {
                NUM_OF_PATH[y][x] += dfs(ny, nx);
            }
        }
        isCalculated[y][x] = true;
        return NUM_OF_PATH[y][x];
    }
}

