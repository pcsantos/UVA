#include<stdio.h>
#include<string.h>

int main(void) {

    int tC;
    char word[6];
    int i, j;
    int flag;

    scanf("%d", &tC);
    for(i = 0; i < tC; i++) {
        scanf("%s", word);
        if(strlen(word) == 5)
            printf("%d\n", 3);
        else {
            if(strlen(word) == 3) {
                flag = 0;
                if(word[1] == 'n' && word[2] == 'e') flag = 1;
                if(word[0] == 'o' && word[2] == 'e') flag = 1;
                if(word[0] == 'o' && word[1] == 'n') flag = 1;
                if(flag)
                    printf("%d\n", 1);
                else
                    printf("%d\n", 2);
            }
        }
    }
    return 0;
}
