#include<stdio.h>

int main(void) {

    int hL;
    char h[2000001];
    int min;
    int i;
    char status;
    int pre, pos;

    scanf("%d\n", &hL);
    while(hL) {
        fgets(h, hL + 1, stdin);

        pre = 0;
        pos = 0;
        min = 2000001;
        status = '.';
        for(i = 0; i < hL; i++) {
            if(h[i] == 'Z') {
                min = 0;
                break;
            }
            if((h[i] == 'R' || h[i] == 'D') && status == '.') {
                status = h[i];
                pre = i;
            }

            if(h[i] == 'R' && status == 'D') {
                status = h[i];
                pos = i;
                if(min > pos - pre) min = pos - pre;
                pre = pos;
            }

            if(h[i] == status && status != '.') {
                pre = i;
            }

            if(h[i] == 'D' && status == 'R') {
                status = h[i];
                pos = i;
                if(min > pos - pre) min = pos - pre;
                pre = pos;
            }
        }
        printf("%d\n", min);
        scanf("%d\n", &hL);
    }
    return 0;
}
