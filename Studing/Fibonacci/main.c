#include<stdio.h>

long long fib(long long);
long long divideConquerFib(long long);

int main(void) {

    printf("%li\n", fib(8));
    printf("%li\n", divideConquerFib(8));
    printf("%li\n", fib(80));
    printf("%li\n", divideConquerFib(80));

    return 0;
}

long long fib(long long n) {
    long long a = 1;
    long long b = 1;
    long long i, c;
    for (i = 3; i <= n; i++) {
        c = a + b;
        a = b;
        b = c;
    }
    return c;
}

long long divideConquerFib(long long n) {
    long long h = 1;
    long long i = 1;
    long long j = 0;
    long long k = 0;
    long long t;
    while (n > 0) {
        if (n % 2 == 1) {
            t = j * h;
            j = i * h + j * k + t;
            i = i * k + t;
        }
        t = h * h;
        h = 2 * k * h + t;
        k = k * k + t;
        n = (long long) n / 2;
    }
    return j;
}
