#include<stdio.h>

#define gc() getchar_unlocked()

int main(void) {
    int testCases;
    char ch;
    scanf("%d\n", &testCases);
    while ((ch = gc()) != EOF) {
        switch (ch) {
            case '0': printf("O");
                break;
            case '1': printf("I");
                break;
            case '2': printf("Z");
                break;
            case '3': printf("E");
                break;
            case '4': printf("A");
                break;
            case '5': printf("S");
                break;
            case '6': printf("G");
                break;
            case '7': printf("T");
                break;
            case '8': printf("B");
                break;
            case '9': printf("P");
                break;
            default:
                printf("%c", ch);
                break;
        }
    }
    return 0;
}
