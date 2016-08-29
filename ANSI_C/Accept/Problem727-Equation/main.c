#include<stdio.h>
#include<stdlib.h>

#define MAXCOLS 51
#define TRUE 1
#define FALSE 0

typedef struct {
    int top;
    char items[MAXCOLS];
} Stack;

void postfix(char*, char*);
int isOperand(char);
void popAndTest(Stack*, char*, int*);
int prcd(char, char);
void push(Stack*, char);
char pop(Stack*);
void initStack(Stack*);
int empty(Stack*);

int main(void) {
    int testcases;
    int i;
    char infix[MAXCOLS];
    char postr[MAXCOLS];
    int pos = 0;
    scanf("%d\n", &testcases);
    for (i = 0; i < testcases; i++) {
        if (i > 0)
            printf("\n");
        infix[pos] = getchar();
        while (infix[pos] != EOF && infix[pos] != '\n') {
            getchar();
            pos++;
            infix[pos] = getchar();
        }
        infix[pos] = '\0';
        postfix(infix, postr);
        printf("%s\n", postr);
        pos = 0;
    }
    return 0;
}

void postfix(char infix[], char postr[]) {
    int position, und;
    int outpos = 0;
    char topsymb = '+';
    char symb;
    Stack opstk;
    initStack(&opstk);
    for (position = 0; (symb = infix[position]) != '\0'; position++) {
        if (isOperand(symb)) {
            postr[outpos++] = symb;
        } else {
            popAndTest(&opstk, &topsymb, &und);
            while (!und && prcd(topsymb, symb)) {
                postr[outpos++] = topsymb;
                popAndTest(&opstk, &topsymb, &und);
            }
            if (!und) {
                push(&opstk, topsymb);
            }
            if (und || (symb != ')')) {
                push(&opstk, symb);
            } else {
                topsymb = pop(&opstk);
            }
        }
    }
    while (!empty(&opstk))
        postr[outpos++] = pop(&opstk);
    postr[outpos] = '\0';
}

void push(Stack *s, char symb) {
    s->items[++s->top] = symb;
}

char pop(Stack *s) {
    if (empty(s)) {
        printf("Underflow");
        exit(1);
    }
    return s->items[s->top--];
}

int prcd(char topsymb, char symb) {
    switch(topsymb) {
        case '+' :
        case '-' :
            switch (symb) {
                case ')' :
                case '-' :
                case '+' : return TRUE;
                default : return FALSE;
            }
        case '*' :
        case '/' :
            switch (symb) {
                case '(' : return FALSE;
                default : return TRUE;
            }

        case '(' : return FALSE;
        default : printf("Ilegall operator!\n");
                  exit(1);
    }
}

void popAndTest(Stack *s, char *px, int *pund) {
    if (empty(s)) {
        *pund = TRUE;
        return;
    }
    *pund = FALSE;
    *px = s->items[s->top--];
    return;
}

int isOperand(char c) {
    return (c != '+' && c != '-' && c != '*' && 
            c != '/' && c != '(' && c != ')');
}

void initStack(Stack *s) {
    s->top = -1;
}

int empty(Stack *s) {
    if (s->top == -1)
        return TRUE;
    return FALSE;
}
