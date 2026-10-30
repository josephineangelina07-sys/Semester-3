#include <stdio.h>

long long gcd(long long a, long long b) {
    while (b != 0) {
        long long temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

int main() {
    char X_str[20];
    long long L, R;

    if (scanf("%19s", X_str) != 1) return 0;
    if (scanf("%lld %lld", &L, &R) != 2) return 0;

    long long N = 0;
    long long D = 1;
    int seen_dot = 0;

    for (int i = 0; X_str[i] != '\0'; i++) {
        if (X_str[i] == '.') {
            seen_dot = 1;
        } else {
            N = N * 10 + (X_str[i] - '0');
            if (seen_dot) {
                D = D * 10;
            }
        }
    }

    if (N < L * D || N > R * D) {
        printf("-1\n");
        return 0;
    }


    long long g = gcd(N, D);
    long long k = D / g;          
    long long total_sum = N / g;  

    printf("%lld\n", k);

    long long rem = total_sum - (k * L); 
    
    for (long long i = 0; i < k; i++) {
        long long add = rem;
        if (add > R - L) {
            add = R - L;
        }
        printf("%lld", L + add);
        if (i < k - 1) {
            printf(" ");
        }
        rem -= add;
    }
    printf("\n");

    return 0;
}