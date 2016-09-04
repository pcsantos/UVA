#include<stdio.h>

#define SIZE 4
#define TRUE 1

void arrToArrNumber(char[], int[]);
void findNextPalindrome(int[]);
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

void findNextPalindrome(int n[]) {
    while (TRUE) {
        increment(n);
        if (n[0] == 0) {
            if (n[1] == 0) {
                if (n[2] == 0) {
                    printf("%d%d:%d%d\n", n[0], n[1], n[2], n[3]);
                    break;
                } else {
                    if (n[2] == n[3]) {
                        printf("%d%d:%d%d\n", n[0], n[1], n[2], n[3]);
                        break;
                    }
                }
            } else {
                if (n[1] == n[3]) {
                    printf("%d%d:%d%d\n", n[0], n[1], n[2], n[3]);
                    break;
                }
            }
        } else {
            if (n[0] == n[3] && n[1] == n[2]) {
                    printf("%d%d:%d%d\n", n[0], n[1], n[2], n[3]);
                    break;
            }
        }
    }    
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
