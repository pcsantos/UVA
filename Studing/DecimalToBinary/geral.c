#include<stdio.h>
#include<string.h>

#define TRUE 1
#define FALSE 0

int convert(int, int, char[]);

char hex[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F'};

int main(void) {
    int number, base, i;
    char converted[7];
    memset(converted, '0', sizeof(converted));
    scanf("%d %d", &number, &base);
    while(number >= 0) {
        if (convert(number, base, converted)) {
            for (i = 6; i >= 0; i--)
                printf("%c", converted[i]);
            printf("\n");
        } else {
            printf("Overflow!\n");
        }
        scanf("%d %d", &number, &base);
    }
    return 0;
}

int convert(int number, int base, char conv[]) {
    int i = 0;
    int aux;
    do {
        aux = number % base;
        if (aux > 9) {
            conv[i] = hex[aux];           
        } else { 
            conv[i] = aux + '0';
        }
        i++;
        number /= base;
    } while (number > 0 && i < 7);
}
