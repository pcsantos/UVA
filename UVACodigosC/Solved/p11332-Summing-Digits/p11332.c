#include<stdio.h>
#include<string.h>
#include<stdlib.h>

char func(char n[]){

    int i;
    int number = 0;
    int value;
    char* n1= (char*) malloc(sizeof(char) * 3);


    if(strlen(n) == 1) return n[0];

    for(i = 0; i < strlen(n); i++) {
        value = n[i] - '0';
        number += value;
    }
    sprintf(n1, "%d", number);
    func(n1);
}

int main(void) {

    int n;
    char number[11];
    char output;
    int i;

    scanf(" %d\n", &n);
    while(n != 0) {
        sprintf(number, "%d", n);
        if(strlen(number) < 2) output = number[0];
        else {
            output = func(number);
        }

        printf("%c\n", output);
        scanf(" %d\n", &n);
    }
    return 0;
}
