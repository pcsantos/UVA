#include<stdio.h>
#include<string.h>
#include<ctype.h>

const char passTen[] = "ABCDEF";
const int two[] = 
int getValue(char);

int main(void) {
    int i;
    char in[8];
    int base, toConvert;
    while (scanf("%s %d %d", in, &base, &toConvert) != EOF) {
        printf("%s %d %d\n", in, base, toConvert);
    }
    /*for (i = 0; in[i]; i++)
        if (isdigit(in[i]))
            printf("%d ", in[i] - '0');
        else
            printf("%d ", getValue(in[i]));
    printf("\n");*/
    return 0;
}

int getValue(char ch) {
    char *loc;
    loc = strchr(passTen, ch);
    return loc - passTen + 10;
}
