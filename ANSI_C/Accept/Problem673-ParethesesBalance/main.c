#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define MAXCOLS 130
#define TRUE 1
#define FALSE 0

typedef struct {
    int top;
    char items[MAXCOLS];
} Stack;

char* balance(char*);
void push(Stack*, char);
char pop(Stack*);
void initStack(Stack*);
int empty(Stack*);
int match(char, char);

int main(void) {
    int testcases;
    int i;
    char str[MAXCOLS];
    scanf("%d\n", &testcases);
    for (i = 0; i < testcases; i++) {
        fgets(str, sizeof(str), stdin);
        str[strlen(str) - 1] = '\0';
        printf("%s\n", balance(str));
    }
    return 0;
}

char* balance(char str[]) {
    int position;
    char topsymb = '(';
    char symb;
    Stack stk;
    initStack(&stk);
    if (str[0] == '\0')
        return "Yes";
    push(&stk, str[0]);
    for (position = 1; (symb = str[position]) != '\0'; position++) {
        if (empty(&stk)) {
            push(&stk, str[position]);
        } else {
            symb = str[position];
            topsymb = pop(&stk);
            if (!match(topsymb, symb)) {
                push(&stk, topsymb);
                push(&stk, symb);
            }
        }
    }
    if (empty(&stk))
        return "Yes";
    return "No";
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

int match(char topsymb, char symb) {
    switch (topsymb) {
        case '(' :
            if (symb == ')')
                return TRUE;
            return FALSE;
        case '[' :
            if (symb == ']')
                return TRUE;
            return FALSE;
        default :
            return FALSE;
    }
}

void initStack(Stack *s) {
    s->top = -1;
}

int empty(Stack *s) {
    if (s->top == -1)
        return TRUE;
    return FALSE;
}
