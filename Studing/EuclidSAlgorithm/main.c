#include<stdio.h>

#define TRUE 1
#define FALSE 0

typedef struct {
    int numerator;
    int denominator;
} Rational;

void reduce(Rational*, Rational*);
int equal(Rational*, Rational*);
void multiply(Rational*, Rational*, Rational*);
void divide(Rational*, Rational*, Rational*);
void add(Rational*, Rational*, Rational*);
void sub(Rational*, Rational*, Rational*);
void printRat(Rational*);

int main(void) {
    Rational rat1, rat2, rat3;
    
    rat1.numerator = 10;
    rat1.denominator = 15;
    rat2.numerator = 8;
    rat2.denominator = 16;
    reduce(&rat1, &rat3);
    printRat(&rat1);
    printf(" reduce ");
    printRat(&rat3);
    printf("\n");
    if (equal(&rat1, &rat3)) {
        printRat(&rat1);
        printf(" is equal ");
        printRat(&rat3);
        printf("\n");
    }

    printRat(&rat1);
    printf(" times ");
    printRat(&rat2);
    multiply(&rat1, &rat2, &rat3);
    printf(" equal ");
    printRat(&rat3);
    printf("\n");
    
    printRat(&rat1);
    printf(" divided by ");
    printRat(&rat2);
    divide(&rat1, &rat2, &rat3);
    printf(" equal ");
    printRat(&rat3);
    printf("\n");

    printRat(&rat1);
    printf(" plus ");
    printRat(&rat2);
    add(&rat1, &rat2, &rat3);
    printf(" equal ");
    printRat(&rat3);
    printf("\n");
    
    printRat(&rat1);
    printf(" minus ");
    printRat(&rat2);
    sub(&rat1, &rat2, &rat3);
    printf(" equal ");
    printRat(&rat3);
    printf("\n");
    
    return 0;
}

void printRat(Rational *rat) {
    printf("%d/%d", rat->numerator, rat->denominator);
}

/*Euclid's Algorithm*/
void reduce(Rational *inrat, Rational *outrat) {
    int a, b, rem;
    
    if (inrat->numerator > inrat->denominator) {
        a = inrat->numerator;
        b = inrat->denominator;
    } else {
        a = inrat->denominator;
        b = inrat->numerator;
    }
    
    while (b != 0) {
        rem = a % b;
        a = b;
        b = rem;
    }
    
    outrat->numerator = inrat->numerator / a;
    outrat->denominator = inrat->denominator / a;
}

int equal(Rational *rat1, Rational *rat2) {
    Rational r1, r2;

    reduce(rat1, &r1);
    reduce(rat2, &r2);
    if (r1.numerator == r2.numerator && r1.denominator == r2.denominator)
        return TRUE;
    return FALSE;
}

void multiply(Rational *r1, Rational *r2, Rational *r3) {
    Rational rat3;

    rat3.numerator = r1->numerator * r2->numerator;
    rat3.denominator = r1->denominator * r2->denominator;
    reduce(&rat3, r3);
}

void divide(Rational *r1, Rational *r2, Rational *r3) {
    Rational rat3;

    rat3.numerator = r1->numerator * r2->denominator;
    rat3.denominator = r1->denominator * r2->numerator;

    reduce(&rat3, r3);
}

void add(Rational *r1, Rational *r2, Rational *r3) {
    Rational rat1, rat2, rat3;
    rat1.numerator = r1->numerator * r2->denominator;
    rat1.denominator = r1->denominator * r2->denominator;
    
    rat2.numerator = r2->numerator * r1->denominator;
    rat2.denominator = r2->denominator * r1->denominator;

    rat3.numerator = rat1.numerator + rat2.numerator;
    rat3.denominator = rat1.denominator;

    reduce(&rat3, r3);
}

void sub(Rational *r1, Rational *r2, Rational *r3) {
    Rational rat1, rat2, rat3;
    rat1.numerator = r1->numerator * r2->denominator;
    rat1.denominator = r1->denominator * r2->denominator;
    
    rat2.numerator = r2->numerator * r1->denominator;
    rat2.denominator = r2->denominator * r1->denominator;

    rat3.numerator = rat1.numerator - rat2.numerator;
    rat3.denominator = rat1.denominator;

    reduce(&rat3, r3);
}
