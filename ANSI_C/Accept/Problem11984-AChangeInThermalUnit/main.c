#include<stdio.h>
#include<math.h>

int main(void) {
    int testCases, i;
    double initialTemp, increaseFah;
    double tempFah;
    double result;
    scanf("%d\n", &testCases);
    for (i = 1; i <= testCases; i++) {
        scanf("%lf %lf\n", &initialTemp, &increaseFah);
        tempFah =  initialTemp * 9.0 / 5.0 + 32.0 + increaseFah;
        result = (tempFah - 32.0) * 5.0 / 9.0;
        printf("Case %d: %.2lf\n", i, result);
    }
    return 0;
}
