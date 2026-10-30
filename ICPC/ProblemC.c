#include <stdio.h>

#define INF 1000000000

int main() {
    int n;
    if (scanf("%d", &n) != 1) return 0;
    
    int prev_y;
    if (scanf("%d", &prev_y) != 1) return 0;
    
    int all_equal = 1;
    
    int dp0 = 0; 
    int dp1 = 0; 
    
    for (int i = 1; i < n; i++) {
        int y;
        scanf("%d", &y);
        
        if (y != prev_y) {
            all_equal = 0;
        }
        
        int v = 0;
        if (y > prev_y) v = 1;
        else if (y < prev_y) v = -1;
        
        int next_dp0 = INF;
        int next_dp1 = INF;
        
        if (v == 1) {
            next_dp1 = dp1;
            if (dp0 + 1 < next_dp1) next_dp1 = dp0 + 1;
        } else if (v == -1) {
            next_dp0 = dp0;
            if (dp1 + 1 < next_dp0) next_dp0 = dp1 + 1;
        } else {
            next_dp0 = dp1 + 1;
            next_dp1 = dp0 + 1;
        }
        
        if (next_dp0 > INF) next_dp0 = INF;
        if (next_dp1 > INF) next_dp1 = INF;
        
        dp0 = next_dp0;
        dp1 = next_dp1;
        
        prev_y = y;
    }
    
        if (all_equal) {
        printf("0\n");
    } else {
        int min_crossings = dp0 < dp1 ? dp0 : dp1;
        printf("%d\n", min_crossings + 1);
    }
    
    return 0;
}