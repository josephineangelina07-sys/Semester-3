#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char name[15];
    int total_points;
    int total_penalty;
} Contestant;

int compare(const void *a, const void *b) {
    Contestant *c1 = (Contestant *)a;
    Contestant *c2 = (Contestant *)b;

    if (c1->total_points != c2->total_points) {
        return c2->total_points - c1->total_points;
    }
  
    if (c1->total_penalty != c2->total_penalty) {
        return c1->total_penalty - c2->total_penalty;
    }
    
    return strcmp(c1->name, c2->name);
}

int main() {
    int n;
    
    if (scanf("%d", &n) != 1) {
        return 0;
    }
    
    Contestant contestants[105];
    
    for (int i = 0; i < n; i++) {
        int a, b, c, d;
        scanf("%s %d %d %d %d", contestants[i].name, &a, &b, &c, &d);
        
        contestants[i].total_points = a + c;
        contestants[i].total_penalty = b + d;
    }

    qsort(contestants, n, sizeof(Contestant), compare);
    
    for (int i = 0; i < n; i++) {
        printf("%s\n", contestants[i].name);
    }
    
    return 0;
}