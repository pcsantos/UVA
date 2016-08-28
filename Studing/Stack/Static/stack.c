#include<stdio.h>
#include<stdlib.h>

#define STACKSIZE 100
#define TRUE 1
#define FALSE 0

typedef struct {
    int top;
    int items[STACKSIZE];
} Stack;

void initstack(Stack*);
int empty(Stack*);
int full(Stack*);
void push(Stack*, int);
int pop(Stack*);

int main(void) {
    Stack stack;
    initstack(&stack);
    push(&stack, 10);
    push(&stack, 20);
    push(&stack, 40);
    push(&stack, 30);
    printf("Pop: %d\n", pop(&stack));
    printf("Pop: %d\n", pop(&stack));
    printf("Pop: %d\n", pop(&stack));
    printf("Pop: %d\n", pop(&stack));
    printf("Pop: %d\n", pop(&stack));
    return 0;
}

int pop(Stack *s) {
    if (empty(s)) {
        printf("Underflow!\n");
        exit(1);
    } else {
        return s->items[s->top--];
    }
}

void push(Stack *s, int v) {
    if (full(s)) {
        printf("Overflow!\n");
    } else {
        s->items[++s->top] = v;
    }
}

void initstack(Stack *s) {
    s->top = -1;
}

int empty(Stack *s) {
    if (s->top == -1)
        return TRUE;
    return FALSE;
}

int full(Stack *s) {
    if (s->top == STACKSIZE - 1)
        return TRUE;
    return FALSE;
}
