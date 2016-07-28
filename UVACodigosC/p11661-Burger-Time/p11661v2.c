#include<stdio.h>
#include<stdlib.h>

int main(void) {

    int hL;
    char *h;
    int min;
    int i, j, flag;
    char status;
    int pre, pos;

    scanf("%d\n", &hL);
    while(hL) {
        h = malloc(sizeof(char) * hL + 1);
        fgets(h, hL + 1, stdin);

        pre = 0;
        pos = 0;
        min = 2000001;
        status = '.';
        flag = 0;
        for(i = 0; i < hL; i++) {
            if(h[i] == 'Z') {
                min = 0;
                break;
            }
            if((h[i] == 'R' || h[i] == 'D') && status == '.') {
                status = h[i];
                pre = i;
            }

            if(h[i] != status && h[i] != '.' && status != '.') {
                status = h[i];
                pos = i;
                if(min > pos - pre) min = pos - pre;
                if(min == 1) {
                    j = i;
                    flag = 1;
                    break;
                }
                pre = pos;
            }

            if(h[i] == status && status != '.') {
                pre = i;
            }
        }
        if(flag) {
            for(i = j; i < hL; i++)
                if(h[i] == 'Z') {
                    min = 0;
                    break;
                }
        }

        printf("%d\n", min);
        free(h);
        scanf("%d\n", &hL);
    }
    return 0;
}
