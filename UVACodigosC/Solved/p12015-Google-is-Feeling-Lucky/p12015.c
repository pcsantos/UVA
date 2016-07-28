#include<stdio.h>
#include<string.h>

typedef struct _web{
    char url[101];
    int value;
}Web;

int main(void) {

    Web pages[10];
    int tC;
    int i, j, k;
    Web aux;
    int lucky;

    scanf(" %d\n", &tC);
    for(i = 1; i <= tC; i++) {
        for(j = 0; j < 10; j++) {
            scanf(" %s %d \n", &pages[j].url, &pages[j].value);
        }
        for(j = 9; j >= 1; j--) {
            for(k = 0; k < j; k++) {
                if(pages[k].value < pages[k + 1].value) {
                    aux.value = pages[k].value;
                    strcpy(aux.url, pages[k].url);
                    pages[k].value = pages[k + 1].value;
                    strcpy(pages[k].url, pages[k + 1].url);
                    pages[k + 1].value = aux.value;
                    strcpy(pages[k + 1].url, aux.url);
                }
            }
        }
        printf("Case #%d:\n", i);
        lucky = pages[0].value;
        for(j = 0; j < 10; j++) {
            if(pages[j].value == lucky)
                printf("%s\n", pages[j].url);
            else break;
        }
    }
    return 0;
}
