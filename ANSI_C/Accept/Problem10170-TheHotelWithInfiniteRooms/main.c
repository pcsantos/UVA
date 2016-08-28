#include<stdio.h>

int main(void) {
    double groups, days;

    while (scanf("%lf %lf\n", &groups, &days) != EOF) {
        while (groups < days) {
            days -= groups;
            groups++;
        }
        printf("%.0lf\n", groups);
    }
    return 0;
}
