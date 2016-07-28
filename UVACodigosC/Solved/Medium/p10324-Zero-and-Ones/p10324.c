#include<stdio.h>

int main(void) {

    char word[1000000];
    int i, j;
    int tC;
    int k, l, m;
    int flag;

    l = 1;
    while(scanf("%s\n", word) != EOF) {
        scanf(" %d\n", &tC);
        printf("Case %d:\n", l);
        for(k = 0; k < tC; k++) {
            scanf(" %d %d\n", &i, &j);
            flag = 1;
            if(i < j) {
                for(m = i; m < j; m++) {
                    if(word[m] != word[m + 1])
                        flag = 0;
                }
            } else {
                for(m = j; m < i; m++) {
                    if(word[m] != word[m + 1])
                        flag = 0;
                }
            }
            if(flag)
                printf("Yes\n");
            else
                printf("No\n");
        }
        l++;
    }
    return 0;
}
