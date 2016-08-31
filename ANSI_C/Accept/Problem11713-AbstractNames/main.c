#include<stdio.h>
#include<string.h>

#define SIZE 21
#define TRUE 1
#define FALSE 0

int isAbstractName(char[], char[]);
int isVowel(char);

char vowels[] = "aeiou";

int main(void) {
    int testCases;
    int i;
    char name[SIZE];
    char pAbsName[SIZE];

    scanf("%d\n", &testCases);
    for (i = 0; i < testCases; i++) {
        scanf(" %s\n", name);
        scanf(" %s\n", pAbsName);
        if (isAbstractName(name, pAbsName))
            printf("Yes\n");
        else
            printf("No\n");
    }
    return 0;
}

int isAbstractName(char n[], char pAN[]) {
    int i;
    if (strlen(n) != strlen(pAN))
        return FALSE;
    for (i = 0; n[i]; i++) {
        if (!isVowel(n[i])) {
            if (!isVowel(pAN[i])) {
                if (n[i] != pAN[i])
                    return FALSE;
            } else
                return FALSE;
        } else if (!isVowel(pAN[i]))
            return FALSE;
    }
    return TRUE;
}

int isVowel(char c) {
    int i;
    for (i = 0; vowels[i]; i++)
        if (vowels[i] == c)
            return TRUE;
    return FALSE;
}
