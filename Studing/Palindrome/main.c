#include<stdio.h>
#include<string.h>

#define TRUE 1
#define FALSE 0;
#define WORD_SIZE 255

int palindrome(char*);

int main(void) {
    char word[255];
    scanf("%s\n", word);
    while (strcmp(word, "exit") != 0){
        if (palindrome(word)) {
            printf("Is palindrome.\n");
        } else {
            printf("Is not palindrome.\n");
        } 
        scanf("%s\n", word);
    }
    return 0;
}

int palindrome(char *word) {
    int i, j;
    int size = strlen(word);
    j = size - 1;
    for (i = 0; i < size / 2; i++) {
        if (word[i] != word[j--])
            return FALSE;
    }
    return TRUE;
}
