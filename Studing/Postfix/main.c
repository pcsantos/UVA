/*Exemplo adaptado do livro Data Structures using c and c++ Langsam, Augenstein, Tenenbaum*/
#include<stdio.h>
#include<stdlib.h>
#include<math.h>

#define MAXCOLS 80
#define TRUE 1
#define FALSE 0

typedef struct {
    int top;
    double items[MAXCOLS];
} Stack;

int isDigit(char);
void initStack(Stack*);
void push(Stack*, double);
double pop(Stack*);
int empty(Stack*);
double oper(int, double, double);
double eval(char[]);

int main(void) {
    char expr[MAXCOLS];
    int position = 0;

    while ((expr[position++] = getchar()) != '\n')
        ;
    expr[--position] = '\0';
    printf("The original postfix expression is: %s.\n", expr);
    printf("Value: %.2f\n", eval(expr));
    return 0;
}

double eval(char expr[]) {
    int c, position;
    double opnd1, opnd2, value;
    Stack opndstk;

    initStack(&opndstk);
    for (position = 0; (c = expr[position]) != '\0'; position++) {
        if (isDigit(c)){
            push(&opndstk, (double) (c - '0'));
        } else {
            opnd2 = pop(&opndstk);
            opnd1 = pop(&opndstk);
            value = oper(c, opnd1, opnd2);
            push(&opndstk, value);
        }
    }
    return pop(&opndstk);
}

double oper(int symb, double op1, double op2) {
    switch (symb) {
        case '+' : return (op1 + op2);
        case '-' : return (op1 - op2);
        case '*' : return (op1 * op2);
        case '/' : return (op1 / op2);
        case '$' : return (pow(op1, op2));
        default : printf("illegal operation");
                  exit(1);
    }
}

void initStack(Stack *s) {
    s->top = -1;
}

void push(Stack *s, double v) {
    s->items[++s->top] = v;
}

double pop(Stack *s) {
    if (empty(s)) {
        printf("underflow!");
        exit(1);
    } else {
        return s->items[s->top--];
    }
}

int empty(Stack *s) {
    if (s->top == -1)
        return TRUE;
    return FALSE;
}

int isDigit(char symb) {
    return (symb >= '0' && symb <= '9');
}

