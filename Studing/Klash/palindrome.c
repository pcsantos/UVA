/*Verifica se uma palavra digitada pelo usuário é um palindromo*/
#include<stdio.h>
#include<string.h>

#define TRUE 1
#define FALSE 0;
#define WORD_SIZE 255

int palindrome(char*);

int main(void) {
    char word[WORD_SIZE];
    scanf("%s", word);
    if (palindrome(word)) {
        printf("Is palindrome.\n");
    } else {
        printf("Is not palindrome.\n");
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
