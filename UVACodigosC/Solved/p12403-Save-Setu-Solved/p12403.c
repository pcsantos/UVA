#include<stdio.h>
#include<string.h>

int main(void) {

    int op;
    char action[7];
    int value;
    int mAcc;
    int i;

    scanf("%d", &op);
    mAcc = 0;
    for(i = 0; i < op; i++) {
        scanf("%s", action);
        if(strcmp("report", action) == 0) {
            printf("%d\n", mAcc);
        } else {
            scanf(" %d\n", &value);
            mAcc += value;
        }
    }
    return 0;
}
