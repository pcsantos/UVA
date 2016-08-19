#include<stdio.h>

int main (void) {

    int velocity, time;
    while (scanf("%d %d\n", &velocity, &time) != EOF) {
        printf("%d\n", velocity * 2 * time);
    }
    return 0;
}
