#include<stdio.h>

#define SIZE 10000

unsigned long int numerator[SIZE];
unsigned long int denominator[SIZE];

unsigned long int reduceTerms(unsigned long int, unsigned long int);
void reduce(unsigned long int);
void reducePlus(unsigned long int, unsigned long int);

unsigned long int main(void) {
    unsigned long int k, n;

    scanf("%lu %lu\n", &k, &n);
    while(k != 0  && n != 0) {
        printf("%lu\n" ,reduceTerms(k, n)); 
        scanf("%lu %lu\n", &k, &n);
    }
    return 0;
}

unsigned long int reduceTerms(unsigned long int k, unsigned long int n) {
    unsigned long int i, j;
    unsigned long int numeratorSize = 0;
    unsigned long int denominatorSize = 0;

    if (n < k - n) {
        j = 0;
        for (i = k; i > k - n; i--) {
            numerator[j++] = i;    
        }
        numeratorSize = j;
        j = 0;
        for (i = n; i >= 2; i--) {
            denominator[j++] = i;
        }
        denominatorSize = j;
    } else {
        j = 0;
        for (i = k; i > n; i--) {
            numerator[j++] = i;    
        }
        numeratorSize = j;
        j = 0;
        for (i = k- n; i >= 2; i--) {
            denominator[j++] = i;
        }
        denominatorSize = j;
    }

    if (numeratorSize < denominatorSize) {
        for (i = 1; i < numeratorSize; i++) {
            reduce(i);
        }
    } else {
        for (i = 1; i < denominatorSize; i++) {
            reduce(i);           
        }
    }
    
    unsigned long int num = 1;
    unsigned long int den = 1;
    for (i = 0; i < numeratorSize; i++)
        num *= numerator[i];
    for (i = 0; i < denominatorSize; i++)
        den *= denominator[i];
    
    return num / den;
}

void reduce(unsigned long int index) {
    reducePlus(index - 1, index - 1);
    reducePlus(index, index - 1);
}

void reducePlus(unsigned long int num, unsigned long int den) {
    unsigned long int a, b, rem;
    if (numerator[num] > denominator[den]) {
        a = numerator[num];
        b = denominator[den];
    } else {
        a = denominator[den];
        b = numerator[num];
    }

    while (b != 0) {
        rem = a % b;
        a = b;
        b = rem;
    }
    numerator[num] /= a;
    denominator[den] /= a;
}


