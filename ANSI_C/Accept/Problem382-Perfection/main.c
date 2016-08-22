#include<stdio.h>

char* output(int);

int main(void) {
    int number;
    scanf("%d", &number);
    printf("PERFECTION OUTPUT\n");
    while (number != 0) {
        printf("%5d  %s\n", number, output(number));
        scanf("%d", &number);
    }
    printf("END OF OUTPUT\n");
    return 0;
}

char* output(int number) {
    int i;
    int sum = 0;
    for (i = 1; i < number; i++) {
        if (number % i == 0)
            sum += i;
    }
    if (sum == number)
        return "PERFECT";
    if (sum > number)
        return "ABUNDANT";
    else
        return "DEFICIENT";
}
