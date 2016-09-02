#include<stdio.h>
#include<ctype.h>

#define TRUE 1
#define FALSE 0
#define SIZE 20

int isValid(char[]);
void removeBlanks(char[], char[]);
int digitsSum(int);

int main(void) {
    char cardNumber[SIZE];
    int testCases;
    int i;

    scanf("%d\n", &testCases);
    for (i = 0; i < testCases; i++) {
        fgets(cardNumber, SIZE + 1, stdin);
        cardNumber[SIZE - 1] = '\0';
        if(isValid(cardNumber))
            printf("Valid\n");
        else    
            printf("Invalid\n");
    }
    return 0;
}

int isValid(char cN[]) {
    int doubleDigits = 0;
    int sumDigits = 0;
    char newCN[SIZE];
    int aux, total;
    int i;
    removeBlanks(cN, newCN);

    for (i = 0; newCN[i]; i++) {
        if (i % 2 == 0) {
            aux = (newCN[i] - '0') * 2;
            if (aux > 9)
                doubleDigits += digitsSum(aux);
            else    
                doubleDigits += aux;
        } else {
            sumDigits += newCN[i] - '0';
        }
    }
    total  = doubleDigits + sumDigits;
    if (total % 10 == 0)
        return TRUE;
    return FALSE;
}

int digitsSum(int n) {
    return 1 + n % 10;    
}

void removeBlanks(char cN[], char newCN[]) {
    int i, j;
    j = 0;
    for (i = 0; cN[i]; i++) {
        if (isdigit(cN[i]))
            newCN[j++] = cN[i];
    }
    newCN[j] = '\0';
}
