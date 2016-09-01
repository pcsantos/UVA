/*N == a^i * b^j * .. * c^k then N has (i+1) * (j+1) *...* (k+1) divisors*/
#include<stdio.h>
#include<math.h>

#define TRUE 1
#define SIZE 10000

int numberDiv(int);
int divisors(int, int, int*);

int main(void) {
    int testCases;
    int lower, upper;
    int bigger, bigDiv;
    int i;
    scanf("%d", &testCases);
    for (i = 0; i < testCases; i++) {
        scanf("%d %d", &lower, &upper);
        bigger = 0;
        bigDiv = divisors(lower, upper, &bigger);
        printf("Between %d and %d, %d has a maximum of %d divisors.\n", lower, bigger, bigger, bigDiv);
    }
    return 0;
}

int divisors(int lower, int upper, int *bigger) {
    int max = 0;
    int div, pBigger;
    int i;
    for (i = lower; i <= upper; i++) {
        div = numberDiv(i);
        if (max < div) {
            max = div;
            pBigger = i;
        }
    }
    *bigger = pBigger;
    return max;
}

int numberDiv(int number) {
    int total = 1;
    int exp = 0;
    int i;
    while (number % 2 == 0) {
        exp++;
        number /= 2;
    }
    total *= (exp + 1);
    for (i = 3; i <= number; i += 2) {
        exp = 0;
        while (number % i == 0) {
            exp++;
            number /= i;
        }
        if (exp) {
            total *= (exp + 1);
        }
    }
    if (number > 2)
        return 2;
    return total;
}
