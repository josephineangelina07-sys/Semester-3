#include <stdio.h>
#include <stdlib.h>

int cmp(const void *a, const void *b) {
    long long arg1 = *(const long long*)a;
    long long arg2 = *(const long long*)b;
    if (arg1 < arg2) return 1;
    if (arg1 > arg2) return -1;
    return 0;
}

int groups[200005][3];
int group_len[200005];
long long gains[400005];

int main() {
    int n, m, k;
    if (scanf("%d %d %d", &n, &m, &k) != 3) {
        return 0;
    }
    for (int i = 0; i < m; i++) {
        int r;
        char s;
        scanf("%d %c", &r, &s);
        
        int g_idx = (r - 1) * 2;
        int val = 0;
        
        if (s == 'A' || s == 'F') val = 1;
        else if (s == 'B' || s == 'E') val = 2;
        else if (s == 'C' || s == 'D') val = 3;
        
        if (s == 'D' || s == 'E' || s == 'F') {
            g_idx += 1;
        }
        
        groups[g_idx][group_len[g_idx]++] = val;
    }
    
    long long total_cost = 0;
    int gains_count = 0;

    for (int i = 0; i < 2 * n; i++) {
        int len = group_len[i];
        if (len == 2) {
            if (groups[i][0] > groups[i][1]) {
                total_cost += 1;
                gains[gains_count++] = 1;
            }
        } else if (len == 3) {
            int v0 = groups[i][0];
            int v1 = groups[i][1];
            int v2 = groups[i][2];
            
            int inv = 0;
            if (v0 > v1) inv++;
            if (v0 > v2) inv++;
            if (v1 > v2) inv++;
            
            total_cost += inv;
           
            if (v0 == 1 && v1 == 3 && v2 == 2) {
                gains[gains_count++] = 1;
            } else if (v0 == 2 && v1 == 1 && v2 == 3) {
                gains[gains_count++] = 1;
            } else if (v0 == 2 && v1 == 3 && v2 == 1) {
                gains[gains_count++] = 2;
            } else if (v0 == 3 && v1 == 1 && v2 == 2) {
                gains[gains_count++] = 1;
                gains[gains_count++] = 1;
            } else if (v0 == 3 && v1 == 2 && v2 == 1) {
                gains[gains_count++] = 2;
                gains[gains_count++] = 1;
            }
        }
    }

    qsort(gains, gains_count, sizeof(long long), cmp);

    int limit = (k < gains_count) ? k : gains_count;
    for (int i = 0; i < limit; i++) {
        total_cost -= gains[i];
    }
    printf("%lld\n", total_cost);
    return 0;
}