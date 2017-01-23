#include<stdio.h>
#include<string.h>
#include<stdlib.h>

#define TEAMSIZE 31
#define TOURNAMENTSIZE 101
#define MAXTEAM 30
#define RESULTSIZE 70

typedef struct _team {
    char name[TEAMSIZE];
    int pEarned;
    int wins;
    int ties;
    int loss;
    int golsDiff;
    int golsScored;
    int gamesPlayed;
    int golsAgainst;
} team;

int teamcmp(const void*, const void*);
void addResult(char*, int);

team arr[MAXTEAM];

int main(void) {
    int testCases, i, j;
    char tournament[TOURNAMENTSIZE];
    int teams, games;
    char result[RESULTSIZE];

    scanf("%d\n", &testCases);
    for (i = 0; i < testCases; i++) {
        if (i > 0)
            printf("\n");
        fgets(tournament, TOURNAMENTSIZE, stdin);
        scanf("%d\n", &teams);
        for (j = 0; j < teams; j++) {
            fgets(arr[j].name, TEAMSIZE, stdin);
            arr[j].name[strlen(arr[j].name) - 1] = '\0';
            arr[j].pEarned = 0;
            arr[j].wins = 0;
            arr[j].ties = 0;
            arr[j].loss = 0;
            arr[j].golsDiff = 0;
            arr[j].golsScored = 0;
            arr[j].gamesPlayed = 0;
            arr[j].golsAgainst = 0;
        }
        scanf("%d\n", &games);
        for (j = 0; j < games; j++) {
            fgets(result, RESULTSIZE, stdin);
            addResult(result, teams);
        }
        qsort(arr, teams, sizeof(team), teamcmp);
        printf("%s", tournament);
        for (j = 0; j < teams; j++)
            printf("%d) %s %dp, %dg (%d-%d-%d), %dgd (%d-%d)\n", j + 1, arr[j].name, arr[j].pEarned, arr[j].gamesPlayed,
                    arr[j].wins, arr[j].ties, arr[j].loss, arr[j].golsDiff, arr[j].golsScored, arr[j].golsAgainst);
    }
    return 0;
}

int teamcmp(const void *first, const void *second) {

    team *a = (team*)first;
    team *b = (team*)second;
    
    if (a->pEarned > b->pEarned) return -1;
    if (a->pEarned < b->pEarned) return 1;

    if (a->wins > b->wins) return -1;
    if (a->wins < b->wins) return 1;

    if (a->golsDiff > b->golsDiff) return -1;
    if (a->golsDiff < b->golsDiff) return 1;

    if (a->golsScored > b->golsScored) return -1;
    if (a->golsScored < b->golsScored) return 1;

    if (a->gamesPlayed < b->gamesPlayed) return -1;
    if (a->gamesPlayed > b->gamesPlayed) return 1;
    return strcasecmp((*a).name, (*b).name);
}

void addResult(char result[], int teams) {
    char terms[4][TEAMSIZE];
    int index = 0;
    char *pch;
    
    pch = strtok(result,"#@");
    while (pch != NULL) {
        strcpy(terms[index++], pch);
        pch = strtok(NULL,"#@");
    }
    terms[3][strlen(terms[3]) - 1] = '\0';
    char *ptr;
    int golsA = strtol(terms[1], &ptr, 10);
    int golsB = strtol(terms[2], &ptr, 10);
    int i;
    int indexA, indexB;
    for (i = 0; i < teams; i++) {
        if (strcmp(terms[0], arr[i].name) == 0) {
            indexA = i;
        }
        if (strcmp(terms[3], arr[i].name) == 0) {
            indexB = i;
        }
    }
    if (golsA > golsB) {
        arr[indexA].pEarned += 3;
        arr[indexA].wins++;
        arr[indexA].golsDiff += golsA - golsB;
        arr[indexA].golsScored += golsA;
        arr[indexA].golsAgainst += golsB;
        arr[indexA].gamesPlayed++;
        
        arr[indexB].loss++;
        arr[indexB].golsDiff += golsB - golsA;
        arr[indexB].golsScored += golsB;
        arr[indexB].golsAgainst += golsA;
        arr[indexB].gamesPlayed++;
        
    } 
    if (golsA < golsB) {
        arr[indexB].pEarned += 3;
        arr[indexB].wins++;
        arr[indexB].golsDiff += golsB - golsA;
        arr[indexB].golsScored += golsB;
        arr[indexB].golsAgainst += golsA;
        arr[indexB].gamesPlayed++;
        
        arr[indexA].loss++;
        arr[indexA].golsDiff += golsA - golsB;
        arr[indexA].golsScored += golsA;
        arr[indexA].golsAgainst += golsB;
        arr[indexA].gamesPlayed++;
    }
    if (golsA == golsB) {
        arr[indexA].pEarned += 1;
        arr[indexA].golsScored += golsA;
        arr[indexA].gamesPlayed++;
        arr[indexA].golsAgainst += golsB;
        arr[indexA].ties++;
    
        arr[indexB].pEarned += 1;
        arr[indexB].golsScored += golsB;
        arr[indexB].gamesPlayed++;
        arr[indexB].golsAgainst += golsA;
        arr[indexB].ties++;
    }
} 
