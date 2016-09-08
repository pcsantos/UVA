/*Answer was pre calculate*/
#include<stdio.h>
#include<string.h>

int calculate(int, int);
void process(int, int, int);
int square(int);

int values[9][10] = { {-1},
                      {-1},
                      {0,1,81, -1},  
                      {-1},
                      {0, 1, 2025, 3025, 9801, -1},
                      {-1},
                      {0, 1, 88209, 494209, 998001, -1},
                      {-1},
                      {0, 1, 4941729, 7441984, 24502500, 25502500, 52881984, 60481729, 99980001, -1}
                        };

int main(int argc, char **argv) {
    int digits;
    int aux, i;
    int terms;
    /*memset(values, -1, sizeof(values));
    for (i = 2; i < 9; i += 2) {
        terms = 1;
        aux = i;
        while(aux--) {
            terms *= 10;
        }
        process(terms, i/2, i);
    }*/
    while (scanf("%d\n", &digits) != EOF) {
        for (i = 0; i < 10; i++) {
            if (values[digits][i] != -1) {
                switch(digits) {
                    case 2 :
                        printf("%02d\n", values[digits][i]);
                    break;
                    case 4 :
                        printf("%04d\n", values[digits][i]);
                    break;
                    case 6 :
                        printf("%06d\n", values[digits][i]);
                    break;
                    case 8 :
                        printf("%08d\n", values[digits][i]);
                    break;
                }
            } else {
                break;
            }
        }
    }

    return 0;
}

void process(int terms, int d, int digits) {
    int i, j;
    int value;
    int div = 1;
    while(d--) {
        div *= 10;
    }
    j = 0;
    for (i = 0; i < terms; i++) {
        value = calculate(i/div, i % div);
        if (value == i) {
            values[digits][j++] = value;
        }
    }
}

int calculate(int a, int b) {
    return square(a) + 2 *a * b + square(b);   
}

int square(int a) {
    return a * a;
}
