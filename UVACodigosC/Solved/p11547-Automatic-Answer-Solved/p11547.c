#include<stdio.h>
#include<string.h>

int main(void) {

    int tC;
    int number;
    int i;
    char n[20];

    scanf("%d\n", &tC);
    for(i = 0; i < tC; i++) {
        scanf("%d\n", &number);
        number = ((((number * 567 / 9) + 7492) * 235) / 47) - 498;
        sprintf(n, "%d", number);
        printf("%c\n", n[strlen(n) - 2]);
    }
    return 0;
}
