/*Divide & Conquer exponentiation*/
#include<stdio.h>

long square(long);
long fastexp(long, long);

int main(void) {
    
    printf("%ld\n", fastexp(2, 10));
    printf("%ld\n", fastexp(5, 5));
    printf("%ld\n", fastexp(4, 20));
    printf("%ld\n", fastexp(42, 10));
    printf("%ld\n", fastexp(9, 25));

    return 0;
}

long square(long x) {
    return x * x;
}

long fastexp(long base, long power) {
    if (power == 0)
        return 1;
    else if (power % 2 == 0)
        return square(fastexp(base, power / 2));
    else
        return base * (fastexp(base, power - 1));
}

