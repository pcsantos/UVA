#include<stdio.h>
#include<string.h>

typedef struct _person{
    char name[13];
    int spent;
    int earn;
} Person;

int main (void) {
    Person persons[10];
    char name[13];
    int groupMembers;
    int money;
    int gived;
    int earnNumber;
    int i, j, k;
    int flag = 0;

    while(scanf("%d", &groupMembers) != EOF) {
        if(flag)
            printf("\n");
        flag++;
        for(i = 0; i < groupMembers; i++) {
            scanf(" %s", persons[i].name);
            persons[i].spent = 0;
            persons[i].earn = 0;
        }

        for(i = 0; i < groupMembers; i++) {
            scanf(" %s %d %d", name, &money, &earnNumber);
            if(earnNumber)
                gived = money / earnNumber;
            else
                gived = 0;

            for(j = 0; j < groupMembers; j++) {
                if(strcmp(name, persons[j].name) == 0) {
                    persons[j].spent += gived * earnNumber;
                    break;
                }
            }

            for(j = 0; j < earnNumber; j++) {
                scanf(" %s", name);
                for(k = 0; k < groupMembers; k++) {
                    if(strcmp(name, persons[k].name) == 0) {
                        persons[k].earn += gived;
                        break;
                    }
                }
            }
        }
        for(i = 0; i < groupMembers; i++)
            printf("%s %d\n", persons[i].name, persons[i].earn - persons[i].spent);
    }
    return 0;
}
