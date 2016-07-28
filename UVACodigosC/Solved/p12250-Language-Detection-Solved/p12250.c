#include<stdio.h>
#include<string.h>

int main(void) {
    char contries[][8] = {"ENGLISH", "SPANISH", "GERMAN", "FRENCH", "ITALIAN", "RUSSIAN", "UNKNOWN"};
    char words[][15] = {"HELLO", "HOLA", "HALLO", "BONJOUR", "CIAO", "ZDRAVSTVUJTE"};
    char word[15];
    int flag;
    int i;

    scanf("%s", word);
    i = 1;
    while(strcmp("#", word)) {
        flag = 1;
        if(strcmp(words[0], word) == 0){
            printf("Case %d: %s\n", i++, contries[0]);
            flag = 0;
        }
        if(strcmp(words[1], word) == 0) {
            printf("Case %d: %s\n", i++, contries[1]);
            flag = 0;
        }
        if(strcmp(words[2], word) == 0) {
            printf("Case %d: %s\n", i++, contries[2]);
            flag = 0;
        }
        if(strcmp(words[3], word) == 0) {
            printf("Case %d: %s\n", i++, contries[3]);
            flag = 0;
        }
        if(strcmp(words[4], word) == 0) {
            printf("Case %d: %s\n", i++, contries[4]);
            flag = 0;
        }
        if(strcmp(words[5], word) == 0) {
            printf("Case %d: %s\n", i++, contries[5]);
            flag = 0;
        }
        if(flag)
            printf("Case %d: %s\n", i++, contries[6]);
        scanf("%s", word);
    }
    return 0;
}
