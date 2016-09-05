#include<stdio.h>
#include<string.h>
#include<algorithm>

#define MAXSIZE 15

using namespace std;

int main(void) {
    char word[MAXSIZE];
    int testCases;

    scanf("%d", &testCases);
    while (testCases--) {
        scanf("%s\n", word);
        int size = strlen(word);
        sort(word, word + size);
        do {
            for (int i = 0; i < size; i++) {
                printf("%c", word[i]);            
            } 
            printf("\n");
        } while (next_permutation(word, word + size));
        printf("\n");
    }
    return 0;
}
