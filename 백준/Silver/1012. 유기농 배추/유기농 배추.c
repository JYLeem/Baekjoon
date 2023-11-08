#include <stdio.h>
#include <string.h>

#define MAX_SIZE 50

int field[MAX_SIZE][MAX_SIZE];
int m, n;
int dx[] = {1, -1, 0, 0};
int dy[] = {0, 0, 1, -1};

int dfs(int x, int y) {
    field[x][y] = 0;

    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && nx < m && ny >= 0 && ny < n && field[nx][ny] == 1) {
            dfs(nx, ny);
        }
    }
    return 0;
}

int main() {
    int T;
    scanf("%d", &T);

    int k, x, y, cnt;
    for (int test_case = 0; test_case < T; test_case++) {
        memset(field, 0, sizeof(field));
        scanf("%d %d %d", &m, &n, &k);

        while (k--) {
            scanf("%d %d", &x, &y);
            field[x][y] = 1;
        }

        cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (field[i][j] == 1) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        printf("%d\n", cnt);
    }
    return 0;
}
