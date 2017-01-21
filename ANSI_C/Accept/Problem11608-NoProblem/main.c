#include<stdio.h>

#define SIZE 12

int main(void) {
    int created[SIZE];
    int required[SIZE];
    int i, available;
    int cases = 1;

    scanf("%d\n", &available);
    while (available >= 0) {
        for (i = 0; i < SIZE; i++) {
            scanf("%d", &created[i]);
        } 
        for (i = 0; i < SIZE; i++) {
            scanf("%d", &required[i]);
        }
        printf("Case %d:\n", cases++);
        for (i = 0; i < SIZE; i++) {
            if (required[i] <= available) {
                printf("No problem! :D\n");
                available -= required[i];
            } else {
                printf("No problem. :(\n");
            }
            available += created[i];
        }
        scanf("%d\n", &available);
    }
    return 0;
}
