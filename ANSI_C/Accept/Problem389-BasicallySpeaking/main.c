#include<stdio.h>
#include<string.h>
#include<ctype.h>
#include<math.h>

#define TRUE 1
#define FALSE 0

#define SIZE 7

int convert(char[], int, int, char[]);
int convertToDecimal(char[], int);
int getValue(char);
char getChar(int);
void reverse(char[], char[]);

const char passTen[] = "ABCDEF";

int main(void) {
    char number[SIZE];
    char out[SIZE];
    int currentBase;
    int toBase;
    int i;

    while(scanf("%s %d %d", number, &currentBase, &toBase) != EOF) {
        if (convert(number, currentBase, toBase, out)) {
            char rev[strlen(out)];
            reverse(out, rev);
            printf("%7s\n", rev);
        } else {
            printf("%7s\n", "ERROR");
        }
    }
    
    return 0;
}

void reverse(char in[], char out[]) {
    int i, j;
    j = 0;
    for (i = strlen(in) - 1; i >= 0; i--)
        out[j++] = in[i];
    out[j] = '\0';
}

int convertToDecimal(char in[], int base) {
    int i;
    int decimal = 0;
    double j = 0;
    for (i = strlen(in) - 1; i >= 0; i--) {
        if (isdigit(in[i]))
            decimal += (in[i] - '0') * pow(base, j++);
        else {
            int value = getValue(in[i]);
            decimal += value * pow(base, j++);
        }
    }
    return decimal;
}

int convert(char in[], int currentBase, int toBase, char out[]) {
    int decimal = convertToDecimal(in, currentBase); 
    int aux;
    int i = 0;
    do {
        if (i == 7)
            return FALSE;
        aux = decimal % toBase;
        if (aux < 10)
            out[i++] = aux + '0';
        else
            out[i++] = getChar(aux);
        decimal /= toBase;
    } while (decimal > 0);
    out[i] = '\0';
    return TRUE;
}

char getChar(int v) {
    switch (v) {
        case 10 : return 'A';
        case 11 : return 'B';
        case 12 : return 'C';
        case 13 : return 'D';
        case 14 : return 'E';
        case 15 : return 'F';
    }
}

int getValue(char ch) {
    char *loc;
    loc = strchr(passTen, ch);
    return loc - passTen + 10;
}
