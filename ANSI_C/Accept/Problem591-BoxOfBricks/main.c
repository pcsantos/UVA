#include<stdio.h>

#define SIZE 51

int stacks[SIZE];

int main(void) {
    int numberOfStacks;
    int set, i;
    int moves;
    int sum, average;
    set = 1;

    scanf("%d\n", &numberOfStacks);
    while (numberOfStacks != 0) {
        sum = 0;
        moves = 0;
        average = 0;
        for (i = 0; i < numberOfStacks; i++) {
            scanf("%d", &stacks[i]);
            sum += stacks[i];
        }
        average = sum / numberOfStacks;
        for (i = 0; i < numberOfStacks; i++) {
            if (average > stacks[i]) {
                moves += average - stacks[i];
            }
        }
        printf("Set #%d\n", set++);
        printf("The minimum number of moves is %d.\n\n", moves);
        scanf("%d\n", &numberOfStacks);
    }

    return 0;
}
