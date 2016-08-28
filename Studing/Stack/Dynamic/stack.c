#include<stdio.h>
#include<stdlib.h>

#define TRUE 1
#define FALSE 0

typedef struct _node{
    int info;
    struct _node *next;
} Node;

void push(Node**, int);
int pop(Node**);
int empty(Node*);

int main(void) {
    Node *top = NULL;
    push(&top, 10);
    push(&top, 20);
    push(&top, 9);
    printf("%d\n", pop(&top));
    printf("%d\n", pop(&top));
    printf("%d\n", pop(&top));
    push(&top, 11);
    push(&top, 15);
    printf("%d\n", pop(&top));
    printf("%d\n", pop(&top));
    printf("%d\n", pop(&top));
    return 0;
}

void push(Node **top, int info) {
    Node *node = (Node*) malloc(sizeof(Node));
    node->info = info;
    node->next = (*top);
    (*top) = node;
}

int pop(Node **top) {
    int info;
    if (empty(*top)) {
        printf("Underflow!\n");
        exit(1);
    } else {
        Node *node = (*top);
        info = node->info;
        (*top) = (*top)->next;
        free(node);
        return info;
    }
}

int empty(Node *top) {
    if (top == NULL)
        return TRUE;
    return FALSE;
}

