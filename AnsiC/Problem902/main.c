#include<stdio.h>
#include<string.h>
#include<stdlib.h>

#define SIZE 3000000
#define WORD_SIZE 11

typedef struct _word {
    char word[WORD_SIZE];
    int occur;
} Word;

char* substring(char[], int , int, int);

char input[SIZE];

int main (void) {

    int size;
    int i, j;

    while ((scanf("%d %s", &size, input)) != EOF) {
        int limit = strlen(input);
        int numberOfWords = SIZE/limit + 1;
        Word words[numberOfWords];
        for (i = 0; i < numberOfWords; i++) {
            strcpy(words[i].word, "");
            words[i].occur = 0;
        }
        char word[limit + 1];
        for (i = 0; i <= limit - size; i++) {
            strcpy(word, substring(input, i, size, limit));
            int insert = 1;
            for (j = 0 ; j < numberOfWords; j++) {
                if (strcmp(words[j].word, "") != 0) {
                    if (strcmp(words[j].word, word) == 0) {
                        words[j].occur++;
                        insert = 0;
                        break;
                    }
                } else
                    break;
            }
            if (insert) {
                strcpy(words[j].word, word);
                words[j].occur = 1;
            }
        }
        int index = 0;
        int max = words[0].occur;
        i = 1;
        while (strcmp(words[i].word, "") != 0) {
            if (words[i].occur > max) {
                max = words[i].occur;
                index = i;
            }
            i++;
        }
        printf("%s\n", words[index].word);
    }

    return 0;
}

char* substring(char str[], int start, int size, int limit) {
    int i, j;
    char *word = malloc(sizeof(char)*(size + 1));
    j = 0;
    for (i = start; i < limit; i++) {
        word[j++] = str[i];
        if (j == size)
            break;
    }
    word[j] = '\0';
    return word;
}
