#include<stdio.h>

#define MAXSIZE 500

int getValue(char);

int main(void) {
    int testCases;
    char exp[MAXSIZE];
    int 

    scanf("%d\n", &testCases);
    for (i = 0; i < testCases; i++) {
        scanf("%s", exp);
    }
    return 0;
}

int getValue(char ch) {
    switch(ch) {
        case 'B' : return 1;
        case 'U' : return 10;
        case 'S' : return 100;
        case 'P' : return 1000;
        case 'F' : return 10000;
        case 'T' : return 100000;
        case 'M' : return 1000000;
        default: return -1;
    }
}
