#include<stdio.h>

int f91(int);

int main(void) {
    int number;

    scanf("%d\n", &number);
    while(number) {
        printf("f91(%d) = %d\n", number, f91(number));        
        scanf("%d\n", &number);
    }
    return 0;
}

int f91(int N) {
    if (N >= 101)
        return N - 10;
    f91(f91(N + 11));
}

