#include<stdio.h>
#include<string.h>

int main(void) {

    int flag;
    char input;

    flag = 1;
    while((input = getchar()) != EOF) {
        if(input == '"') {
            if(flag) {
                printf("%c%c", 96, 96);
                flag = 0;
            } else {
                printf("%c%c", 39, 39);
                flag = 1;
            }
        } else
            printf("%c", input);
    }
    return 0;
}
