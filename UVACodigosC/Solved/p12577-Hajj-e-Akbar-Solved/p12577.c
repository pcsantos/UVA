#include<stdio.h>
#include<string.h>

int main(void) {
    char output[][14] = {"Hajj-e-Akbar", "Hajj-e-Asghar"};
    char input[6];
    int i;

    scanf(" %s", input);
    i = 1;
    while(strcmp("*", input)) {
        if(strcmp("Hajj", input) == 0)
            printf("Case %d: %s\n", i++, output[0]);
        else
            printf("Case %d: %s\n", i++, output[1]);
        scanf(" %s", input);
    }
    return 0;
}
