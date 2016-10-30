#include<stdio.h>

int main(void) {
    int a, b, c;
    int divisor, limit;
    int i;
    int count = 0;
    scanf("%d %d %d %d %d\n", &a, &b, &c, &divisor, &limit);
    while (a || b || c || divisor || limit) {
        for (i = 0; i <= limit; i++) {
            if ((a * i * i + b * i + c) % divisor == 0)   
                count++;
        }
        printf("%d\n", count);
        count = 0;
        scanf("%d %d %d %d %d\n", &a, &b, &c, &divisor, &limit);
    }
    return 0;
}
