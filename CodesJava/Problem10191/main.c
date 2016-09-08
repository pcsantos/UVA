#include<stdio.h>

#define SIZE 4
#define TRUE 1
#define FALSE 0

void increment(int[]);

int main(void) {
    int number[SIZE];
    char in[SIZE + 2];
    int testCases, i;

    scanf("%d", &testCases);
    while (testCases--) {
        scanf("%s\n", in);
        arrToArrNumber(in, number);
        findNextPalindrome(number);
    }
    return 0;
}

void increment(int n[]) {
    int i;
    int carry = 1;
    for (i = SIZE - 1; i >= 0; i--) {
        if (n[i] + carry > 9 && i == 3) {
            n[i] = 0;
            carry = 1;
        } else if (n[i] + carry > 5 && i == 2) {
            n[i] = 0;
            carry = 1;
        } else if (n[i] + carry > 9 && i == 1) {
            n[i] = 0;
            carry = 1;
        } else if (n[i] + carry > 3 && i == 1 && n[0] == 2) {
            n[i] = 0;
            n[0] = 0;
            break;
        } else {
            n[i]++;
            break;
        }
    }
}

void arrToArrNumber(char in[], int n[]) {
    int i, j;
    j = 0;
    for (i = 0; in[i]; i++) {
        if (in[i] != ':')
            n[j++] = in[i] - '0';
    }
}
