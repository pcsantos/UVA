#include<stdio.h>
#include<string.h>

#define MOVE 5
#define SIZE 25

void process(char*, char*, int, int);
void initGrid();
void moveOnto(int, int);
void moveOver(int, int);
void pileOnto(int, int);
void pileOver(int, int);

int grid[SIZE][SIZE];
int size;

int main(void) {
    int a, b;
    char move[MOVE];
    char moveTo[MOVE];
    scanf("%d\n", &size);
    initGrid();
    scanf("%s\n", move);
    while (strcmp(move, "quit") != 0) {
        scanf("%d %s %d\n", &a, moveTo, &b);
        process(move, moveTo, a, b);
        /*printf("%s %d %s %d\n", move, a, moveTo, b);*/
        scanf("%s\n", move);
    }
    return 0;
}

void process(char m[], char mT[], int a, int b) {
    if (strcmp(m, "move") == 0) {
        if (strcmp(mT, "onto") == 0) {
            moveOnto(a, b); 
        } else {
            moveOver(a, b);
        }
    } else {
        if (strcmp(mT, "onto") == 0) {
            pileOnto(a, b);
        } else {
            pileOver(a, b);
        }
    }
}

void moveOnto(int a, int b) {
    
}

void moveOver(int a, int b) {

}

void pileOnto(int a, int b) {

}

void pileOver(int a, int b) {

}

void initGrid() {
    int i;
    memset(grid, -1, sizeof(grid));
    for (i = 0; i < size; i++) {
        grid[i][0] = i;
    }
}
