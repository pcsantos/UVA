#include<stdio.h>

int main(void) {
    int testCases, i;
    int familyA, familyB, value;
    
    scanf("%d\n", &testCases);
    for (i = 0; i < testCases; i++) {
        scanf("%d %d %d\n", &familyA, &familyB, &value);
        printf("%d\n", (2 * familyA * value - familyB * value) / (familyA + familyB));
    }
    return 0;
}
