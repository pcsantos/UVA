#include<stdio.h>
#include<stdlib.h>
#include<math.h>

typedef struct _result {
    int firstScore;
    int secScore;
} Result;

Result* getResult(int, int);

int main(void) {
    int testCases;
    long sum, difference;
    int i;

    scanf(" %d\n", &testCases);
    for (i = 0 ; i < testCases; i++) {
        scanf("%ld %ld\n", &sum, &difference);
        Result *result = getResult(sum, difference);
        if (result->firstScore >= 0  && result->secScore >= 0 && 
            (result->firstScore + result->secScore) == sum && 
            abs(result->firstScore - result->secScore) == difference)
            printf("%ld %ld\n", result->firstScore, result->secScore);
        else
            printf("impossible\n");
        free(result);
    }

    return 0;
}

Result* getResult(int sum, int difference) {
    Result *result = malloc(sizeof(Result));
    long x1, x2;
    x2 = (difference - sum) / (-2);
    x1 = sum - x2;
    if (x1 > x2) {
        result->firstScore = x1;
        result->secScore = x2;
    } else {
        result->firstScore = x2;
        result->secScore = x1;
    }
    return result;
}
