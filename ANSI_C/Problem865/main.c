#include<stdio.h>

#define SIZE 255
#define gc() getchar_unlocked()
#define TRUE 1
#define FALSE 0

int getIndex(char[], char);

int main(void) {
    int testCases;
    char plainText[SIZE];
    char subText[SIZE];
    char ch;
    int i, flag, index;

    scanf("%d\n", &testCases);
    for (i = 0; i < testCases; i++) {
        if (i > 0)
            printf("\n");
        scanf("%s\n", plainText);
        scanf("%s\n", subText);
        flag = FALSE;
        printf("%s\n", subText);
        printf("%s\n", plainText);
        while ((ch = gc())!= EOF) {
            if (flag) {
                if (ch == '\n')
                    break;
                else
                    flag = FALSE;
            }
            if (ch == '\n')
                flag = TRUE;
            index = getIndex(plainText, ch);
            if (index != -1)
                printf("%c", subText[index]);
            else
                printf("%c", ch);
        }
    }
    return 0;
}

int getIndex(char text[], char c) {
    int i;
    for (i = 0; text[i]; i++)
        if (text[i] == c)
            return i;
    return -1;
}
