#include<stdio.h>
#include<stdlib.h>

#define TRUE 1
#define FALSE 0

typedef struct _node {
    int info;
    struct _node *next;
} Node;

void insert(Node**, int);
void print(Node*);
void delete(Node**, int);
int empty(Node*);

int main(void) {
    Node *list = NULL;
    
    print(list);
    insert(&list, 10);
    insert(&list, 20);
    insert(&list, 30);
    print(list);
    insert(&list, 40);

    delete(&list, 10);
    print(list);
    
    delete(&list, 50);
    print(list);
    
    delete(&list, 40);
    print(list);

    delete(&list, 10);
    print(list);
    return 0;
}

void insert(Node **list, int info) {
    if (empty(*list)) {
        Node *node = (Node*) malloc(sizeof(Node));
        node->info = info;
        node->next = NULL;
        *list = node;
        return;
    }

    Node *aux = *list;
    while(aux->next != NULL) {
        aux = aux->next;
    }
    Node *node = (Node*) malloc(sizeof(Node));
    node->info = info;
    node->next = NULL;
    aux->next = node;
}

void delete(Node **list, int info) {
    if (empty(*list)) {
        printf("Empty List!\n");
        return;
    }
    Node *aux, *pre;
    aux = *list;
    if (aux->info == info) {
        *list = (*list)->next;
        aux->next = NULL;
        free(aux);
        return;
    }
    pre = aux;
    aux = aux->next;
    while (aux != NULL) {
        if (aux->info == info) {
            pre->next = aux->next;
            aux->next = NULL;
            free(aux);
            return;
        } else {
            pre = aux;
            aux = aux->next;
        }
    }
    printf("Value %d not found!\n", info);
}

int empty(Node *list) {
    if (list == NULL)
        return TRUE;
    return FALSE;
}

void print(Node *list) {
    if (list == NULL) {
        printf("Empty List!\n");
    } else {
        Node *aux = list;
        while (aux != NULL) {
            printf("%d ", aux->info);
            aux = aux->next;
        }
        printf("\n");
    }
}
