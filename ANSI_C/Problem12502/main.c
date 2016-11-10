#include<stdio.h>

int main(void) {
    int testCases, i;
    int familyA, familyB, value;
    int totalFamilyA = 0;
    int hour;
    int sum, aux;
    scanf("%d\n", &testCases);
    for (i = 0; i < testCases; i++) {
        scanf("%d %d %d\n", &familyA, &familyB, &value);
        sum = familyA + familyB;
        if (value % 3 == 0) {
            hour = value / 3;
        }

        printf("%d\n", totalFamilyA);
    }
    return 0;
}
