#include<stdio.h>
#include<string.h>

#define SIZE 1000001
#define TRUE 1
#define FALSE 0

int getPattern(char[]);

char word[SIZE];
char* getWord(int, char[]);

int main(void) {
    int pos = 0;
    while (TRUE) {
        while((word[pos++] = getchar()) != '\n')
            ;
        word[--pos] = '\0';
        if (strcmp(word, ".") == 0)
            break;
        printf("%d\n", getPattern(word));
        pos = 0;
    }
    return 0;
}

int getPattern(char word[]) {
    int size = strlen(word);
    int pattern = 1;
    int flag;
    int i, j;
    for (i = 0; i < size/2; i++) {
        char sub[i+1];
        memcpy(sub, &word[0], i + 1);
        sub[i+1] = '\0';
        flag = TRUE;
        for (j = i + 1; j < size; j += pattern) {
            char sub2[i+1];
            memcpy(sub2, &word[j], i + 1);
            sub2[i+1] = '\0';
            if (strcmp(sub, sub2) != 0) {
                flag = FALSE;
                pattern++;
                break;
            }   
        }
        if (flag)
            return size / pattern;
    }
    return 1;
}
