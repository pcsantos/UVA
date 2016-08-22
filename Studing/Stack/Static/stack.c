#include<stdio.h>
#include<stdlib.h>

#define SIZE 100
#define TRUE 1
#define FALSE 0

typedef struct _data {
    int value;
} Data;

typedef struct _stack {
    Data item[SIZE];
    int size;
} Stack;

Stack* initStack();
int isEmpty(Stack);
void push(Data, Stack*);
Data pop(Stack*);
int isFull(Stack);

int main(void) {
    Stack *stack;
    stack = initStack();
    if (isEmpty(*stack))
        printf("Is empty!\n");
    Data data;
    data.value = 10;
    push(data, stack);
    Data data1;
    data1.value = 20;
    push(data1, stack);
    data = pop(stack);
    printf("%d\n", data);
    if (isEmpty(*stack))
        printf("Is empty!\n");
    else
        printf("Is not empty!\n");
    free(stack);

    return 0;
}

Stack* initStack() {
    Stack *stack;
    stack = malloc(sizeof(Stack));
    stack->size = -1;
    return stack;
}

int isEmpty(Stack stack) {
    if (stack.size == -1) return TRUE;
    return FALSE;
}

void push(Data data, Stack* stack) {
    if (!isFull(*stack)) {
        stack->size++;
        stack->item[stack->size] = data;
    }
}

Data pop(Stack* stack) {
    if (!isEmpty(*stack))
        return stack->item[stack->size--];
}

int isFull(Stack stack) {
    if (stack.size == SIZE - 1) return TRUE;
    return FALSE;
}
