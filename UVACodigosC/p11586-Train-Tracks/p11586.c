#include<stdio.h>
#include<string.h>

int main(void) {

    int tC;
    char buffer[1024];
    char pieces[101];
    int i, j, k;
    int flag;
    int ff, mm;

    scanf("%d\n", &tC);
    for(i = 0; i < tC; i++) {
        flag = 0;
        scanf("%[A-Z a-z]\n", buffer);
        k = 0;
        for(j = 0; j < strlen(buffer); j++) {
            if(buffer[j] != ' ')
                pieces[k++] = buffer[j];
        }
        pieces[k] = '\0';
        mm = 0;
        ff = 0;
        for(j = 0; j < strlen(pieces); j+= 2){
            if(pieces[j] == 'M' && pieces[j + 1] == 'M')
                mm++;
            if(pieces[j] == 'F' && pieces[j + 1] == 'F')
                ff++;
        }
        if(mm == ff) flag = 1;

        if(strlen(pieces) == 2) flag = 0;

        if(flag)
            printf("LOOP\n");
        else
            printf("NO LOOP\n");
    }
    return 0;
}
