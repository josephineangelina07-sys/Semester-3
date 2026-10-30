#include <stdio.h>

int main() {
    int n;
    if (scanf("%d", &n) == 1) {
        int a;
        for (int i = 0; i < n; i++) {
            scanf("%d", &a);
        }
        printf("%d\n", n);
    }
    return 0;
}