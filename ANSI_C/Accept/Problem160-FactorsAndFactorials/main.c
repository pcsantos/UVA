#include<stdio.h>
#include<string.h>
#include<math.h>

#define SIZE 101
void primeFactors(int);

int number[SIZE];

int main(void) {
    int value, i, j;

    scanf("%d\n", &value);
    while (value) {
        j = 1;
        memset(number, 0, sizeof(number));
        for (i = value; i >= 2; i--) {
            primeFactors(i);
        }
        printf("%3d! =", value);
        for (i = 2; i <= value; i++) {
            if (number[i]) {
                if (j % 16 == 0)
                    printf("\n%9d", number[i]);
                else 
                    printf("%3d", number[i]);
                j++;
            }
        }
        printf("\n");
        scanf("%d\n", &value);
    }
    return 0;
}

void primeFactors(int value) {
    int i;
    while (value % 2 == 0) {
        number[2]++;
        value /= 2;
    }
    for (i = 3; i <= sqrt(value); i = i + 2) {
        while (value % i == 0) {
            number[i]++;
            value /= i;
        }
    }
    if (value > 2)
        number[value]++;
}
