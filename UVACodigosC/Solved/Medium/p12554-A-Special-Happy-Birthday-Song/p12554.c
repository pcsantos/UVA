#include<stdio.h>

typedef struct _person {
    char name[101];
}Person;

int main(void) {

    Person persons[100];
    int people;
    int i, j, k;
    char singing[][9] = {"Aux", "Happy", "birthday", "to", "you"};
    int flag;
    int cycle;
    scanf(" %d\n", &people);
    for(i = 0; i < people; i++) {
        scanf(" %s\n", persons[i].name);
    }
    i = 0;
    j = 1;
    k = 1;
    flag = 1;
    cycle = 0;
    while(flag) {
        if(i % people == 0 && i != 0) i = 0;
        if(people <= 16) {
            if(k % 12 == 0) {
                printf("%s: Rujia\n", persons[i].name);
                j = 0;
            } else {
                if(j % 5 == 0) j = 1;
                printf("%s: %s\n", persons[i].name, singing[j]);
            }
        } else {
            if(k == 12 + 16 * cycle) {
                printf("%s: Rujia\n", persons[i].name);
                cycle++;
                j = 0;
            } else {
                if(j % 5 == 0) j = 1;
                printf("%s: %s\n", persons[i].name, singing[j]);
            }
        }
        if(k >= people && k % 16 == 0) flag = 0;
        j++;
        i++;
        k++;
    }
    return 0;
}
