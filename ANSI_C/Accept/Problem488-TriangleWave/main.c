#include<stdio.h>

#define TRUE 1
#define FALSE 0

void waveDraw(int);

int main(void) {
    int testCases, i;
    int amplitude, frequency;
    int flag = FALSE;
    scanf("%d\n", &testCases);
    while (scanf("%d\n", &amplitude) != EOF) {
        scanf("%d\n", &frequency);
        for (i = 0; i < frequency; i++) {
            if (i == 0 && flag)
                printf("\n");
            waveDraw(amplitude);
            if (i != frequency - 1)
                printf("\n");
        }
        flag = TRUE;
    }
    return 0;
}

void waveDraw(int amplitude) {
    int i, j;
    for (i = 1; i <= amplitude; i++) {
        for (j = 1; j <= i; j++) 
            printf("%d", i);
        printf("\n");
    }
    for (i = amplitude - 1; i >= 1; i--) {
        for (j = 1; j <= i; j++)
            printf("%d", i);
        printf("\n");
    }
}
