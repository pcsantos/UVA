#include<stdio.h>
#include<string.h>

#define SIZE 11
#define BUFFER 1024

void getWords(char[][SIZE], char[]);
void findMatch(char[], char[], int*, int*);
void fillGridAndPrint(int, int, int, int);

char buff[BUFFER];
char words[4][SIZE];

int main(int argc, char **argv) {
    int i;
    int indexA, indexB;
    int indexC, indexD;

    fgets(buff, sizeof(buff), stdin);
    buff[strlen(buff) - 1] = '\0';
    while(strcmp(buff, "#")) {
        getWords(words, buff);
        findMatch(words[0], words[1], &indexA, &indexB);
        findMatch(words[2], words[3], &indexC, &indexD);
        if (indexA != -1 && indexB != -1 && indexC != -1 && indexD != -1) {
            /*fillGridAndPrint(indexA, indexB, indexC, indexD);*/
        } else {
            printf("Unable to make two crosses\n");
        }
        /*for (i = 0; i < 4; i++)
            printf("%s\n", words[i]);*/
        fgets(buff, sizeof(buff), stdin);
        buff[strlen(buff) - 1] = '\0';
        indexA = indexB = indexC = indexD = -1;
    }
    return 0;
}

void fillGridAndPrint(int A, int B, int C, int D) {
    int i, j;
    int rows = strlen(words[1]) + strlen(words[3]) - B + C;
    int cols = strlen(words[0]) + strlen(words[2]) + 3;
    char grid[rows][cols];
    memset(grid, ' ', sizeof(grid));
    for (i = 0; words[1][i] != '\0'; i++) 
        grid[i][A] = words[1][i];
    for (i = 0; words[0][i] != '\0'; i++)
        grid[B][i] = words[0][i];
    int start = strlen(words[0]) + 3;
    j = 0;
    for (i = start; words[2][j] != '\0'; i++)
        grid[B][i] = words[2][j++];
    start = B - D;
    int col = strlen(words[0]) + 3 + C;
    j = 0;
    for (i = start; words[3][j] != '\0'; i++)
        grid[i][col] = words[3][j++];
    
    for (i = 0; i < rows; i++) {
        for (j = 0;  j < cols; j++) {
            printf("%c", grid[i][j]);
        }
        printf("\n");
    }
    printf("\n");
}

void getWords(char words[][SIZE], char buff[]) {
    int i, j, k;
    j = 0;
    k = 0;
    for (i = 0 ; buff[i] != '\0'; i++) {
        words[j][k++] = buff[i];
        if (buff[i] == ' ') {
           while(buff[i] == ' ')
               i++;
            i--;
            words[j][--k] = '\0';
            j++;
            k = 0;
        }
    }
    words[j][k] = '\0';
}

void findMatch(char vert[], char horiz[], int *v, int *h) {
    int i, j;
    char *loc;

    for (i = 0; vert[i] != '\0'; i++) {
        loc = strchr(horiz, vert[i]);
        if (loc != NULL) {
            *v = i;
            *h = loc - horiz;
            return;
        }
    }


}
