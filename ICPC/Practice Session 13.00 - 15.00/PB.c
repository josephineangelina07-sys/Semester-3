#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b) {
    return (*(int*)a - *(int*)b);
}

int main(){
    int N;
    scanf("%d", &N);
    int *A = (int *)malloc(N * sizeof(int));
    for(int i = 0; i < N; i++){
        scanf("%d", &A[i]);
    }
    qsort(A, N, sizeof(int), compare);
    for(int i = 0; i < N; i++){
        printf("%d", A[i]);
        if(i < N - 1){
            printf(" "); 
        }
    }
    printf("\n"); 
    free(A);
    return 0;
}