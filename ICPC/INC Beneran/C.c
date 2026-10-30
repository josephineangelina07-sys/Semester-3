#include <stdio.h>

#define MOD 998244353

int N, K;
int A[100005];
long long valid_count = 0;

int get_utility() {
    int max_u = 0;
    for (int i = 0; i < N; i++) {
        int min_val = A[i];
        for (int j = i; j < N; j++) {
            if (A[j] < min_val) {
                min_val = A[j];
            }
            int current_area = (j - i + 1) * min_val;
            if (current_area > max_u) {
                max_u = current_area;
            }
        }
    }
    return max_u;
}

void solve(int idx) {
    if (idx == N) {
        if (get_utility() == K) {
            valid_count = (valid_count + 1) % MOD;
        }
        return;
    }
    for (int v = 0; v <= K; v++) { 
        A[idx] = v;
        solve(idx + 1);
    }
}

int main() {
    if (scanf("%d %d", &N, &K) != 2) {
        return 1;
    }
    solve(0);
    printf("%lld\n", valid_count);
    
    return 0;
}