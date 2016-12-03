#include<stdio.h>
#include<ctype.h>

#define gc() getchar_unlocked()

int main(void) {
    int ch, i;
    int digit = 0;
    while ((ch = gc()) != EOF) {
        if (ch == '\n' || ch == '!')
            printf("\n");
        else if (isdigit(ch))
            digit += ch - '0';
        else {
            if (ch == 'b') {
                for (i = 0; i < digit; i++) {
                    printf(" ");
                }
            } else {
                for (i = 0; i < digit; i++)
                    printf("%c", ch);
            }
            digit = 0;
        }
    }
    return 0;
}
