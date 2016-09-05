#include<stdio.h>
#include<string.h>
#include<algorithm>

#define MAXSIZE 255

using namespace std;

void fillArrStr(char[], int[]);
int getValue(char);
char arr[] = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";

int main(void) {
    char word[MAXSIZE];
    int testCases;

    scanf("%d", &testCases);
    while (testCases--) {
        scanf("%s\n", word);
        int size = strlen(word);
        int str[size];
        fillArrStr(word, str);
        sort(str, str + size);
        do {
            for (int i = 0; i < size; i++) {
                printf("%c", arr[str[i]]);            
            } 
            printf("\n");
        } while (next_permutation(str, str + size));
    }
    return 0;
}

void fillArrStr(char str[], int number[]) {
    for (int i = 0; str[i]; i++) {
        number[i] = getValue(str[i]);
    }
}

int getValue(char ch) {
    for (int i = 0; arr[i]; i++) {
        if (arr[i] == ch) {
            return i;
        }
    }
}
