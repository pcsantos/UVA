#include<stdio.h>

#define SIZE 4
#define TRUE 1
#define FALSE 0

void increment(int[]);
int process(int, int, int, int);
void getTime(int[], int, int);
int diff(int[], int[]);

int main(void) {
    int hour1, min1;
    int hour2, min2;
    int totalMinutes;

    scanf("%d %d %d %d", &hour1, &min1, &hour2, &min2);
    while (hour1 || min1 || hour2 || min2) {
        totalMinutes = process(hour1, min1, hour2, min2);
        printf("%d\n", totalMinutes);
        scanf("%d %d %d %d", &hour1, &min1, &hour2, &min2);
    }
    return 0;
}

int process(int h1, int m1, int h2, int m2) {
    int n1[SIZE];
    int n2[SIZE];
    getTime(n1, h1, m1);
    getTime(n2, h2, m2);
    int count = 0;
    while (diff(n1, n2)) {
        increment(n1);
        count++;
    }
    return count;
}

int diff(int n1[], int n2[]) {
    int i;
    for (i = 0; i < SIZE; i++)
        if (n1[i] != n2[i])
            return TRUE;
    return FALSE;
}

void getTime(int n[], int h, int m) {
    if(h < 9) {
        n[0] = 0;
        n[1] = h;
    } else {
        n[0] = h / 10;
        n[1] = h % 10;
    }
    if(m < 9) {
        n[2] = 0;
        n[3] = m;
    } else {
        n[2] = m / 10;
        n[3] = m % 10;
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
