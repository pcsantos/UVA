#include<stdio.h>
#include<string.h>

#define SIZE 10
#define TRUE 1
#define FALSE 0

void border();
void process(int, int, int);
void putKing(int, int);
void putQueen(int, int);
void moveQueen(int, int, int, int);
int kingIsLooked(int, int);

char grid[SIZE][SIZE];

int main(void) {
    int kingPos, qPos, qNextPos;
    while (scanf("%d %d %d", &kingPos, &qPos, &qNextPos) != EOF) {
        memset(grid, '*', sizeof(grid));
        border();
        process(kingPos, qPos, qNextPos);
    }
    return 0;
}

void process(int king, int q, int qNext) {
    if (king == q) {
        printf("Illegal state\n");
        return;
    }
    int kingRow, kingCol;
    int qRow, qCol;
    kingRow = king / 8 + 1;
    kingCol = king % 8 + 1;
    putKing(kingRow, kingCol);
    qRow = q / 8 + 1;
    qCol = q % 8 + 1;
    putQueen(qRow, qCol);

    int qNextRow, qNextCol;
    qNextRow = qNext / 8 + 1;
    qNextCol = qNext % 8 + 1; 
    
    moveQueen(qNextRow, qNextCol, kingRow, kingCol);
}

void moveQueen(int row, int col, int krow, int kcol) {

    if (grid[row][col] == 'K' || grid[row][col] != 'q' || grid[row][col] == 'k') {
        if (grid[row][col] == '@')
            printf("Move not allowed\n");
        else 
            printf("Illegal move\n");
        return;
    }
    putQueen(row, col);

    if (kingIsLooked(krow, kcol)) {
        printf("Stop\n");
    } else {
        printf("Continue\n");
    }
}

int kingIsLooked(int r, int c) {
    if (grid[r][c + 1] == 'k') return FALSE;
    if (grid[r][c - 1] == 'k') return FALSE;
    if (grid[r + 1][c] == 'k') return FALSE;
    if (grid[r - 1][c] == 'k') return FALSE;
    return TRUE;
}

void putKing(int row, int col) {
    grid[row][col] = 'K';
    if (grid[row + 1][col] != '@')
        grid[row + 1][col] = 'k';
    if (grid[row - 1][col] != '@')
        grid[row - 1][col] = 'k';
    if (grid[row][col + 1] != '@')
        grid[row][col + 1] = 'k';
    if (grid[row][col - 1] != '@')
        grid[row][col - 1] = 'k';
}

void putQueen(int row, int col) {
    int i, j;
    grid[row][col] = 'Q';
    j = col;
    for (i = row + 1; i < SIZE; i++) {
        if (grid[i][j] != '@' && grid[i][j] != 'K') {
            if (grid[i][j] != 'k')
                grid[i][j] = 'q';
            else
                grid[i][j] = '@';
        } else 
            break;
    
    }
    j = col;
    for (i = row - 1; i >= 0; i--) {
        if (grid[i][j] != '@' && grid[i][j] != 'K') {
            if (grid[i][j] != 'k')
                grid[i][j] = 'q';
            else
                grid[i][j] = '@';
        } else
            break;
    }
    i = row;
    for (j = col + 1; j < SIZE; j++) {
        if (grid[i][j] != '@' && grid[i][j] != 'K') {
            if (grid[i][j] != 'k')
                grid[i][j] = 'q';
            else
                grid[i][j] = '@';
        } else
            break;
    }
    i = row;
    for (j = col - 1; j >= 0; j--) {
        if (grid[i][j] != '@' && grid[i][j] != 'K') {
            if (grid[i][j] != 'k')
                grid[i][j] = 'q';
            else
                grid[i][j] = '@';
        } else
            break;
    }

}

void border() {
    int i;
    for (i = 0; i < SIZE; i++) {
        grid[0][i] = '@';
        grid[SIZE - 1][i] = '@';
        grid[i][0] = '@';
        grid[i][SIZE - 1] = '@';
    }
}
