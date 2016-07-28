#include<stdio.h>
#include<string.h>

int main(void) {

    int tC;
    int i;
    char output[5] = "+-?*";
    char input[10000];
    int size;
    int flag;
    scanf("%d", &tC);
    for(i = 0; i < tC; i++) {
        scanf(" %s\n", &input);
        size = strlen(input);
        flag = 1;
        if((strcmp("1", input) == 0 || strcmp("4", input) == 0 || strcmp("78", input) == 0) && flag) {
            printf("%c\n", output[0]);
            flag = 0;
        }

        if(size > 1)
            if(input[size - 2] == '3' && input[size - 1] == '5' && flag) {
                printf("%c\n", output[1]);
                flag = 0;
            }

        if(size > 2)
            if(input[0] == '1' && input[1] == '9' & input[2] == '0' && flag) {
                printf("%c\n", output[2]);
                flag = 0;
            }

        if(size > 2)
            if(input[0] == '9' && input[size - 1] == '4' && flag) {
                printf("%c\n", output[3]);
                flag = 0;
            }
    }
    return 0;
}
