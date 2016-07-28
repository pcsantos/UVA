#include<stdio.h>
#include<string.h>

int main(void) {

    int length;
    char state[3];
    char nextState[3];
    int i;
    int flag;

    scanf(" %d\n", &length);
    while(length != 0) {
        strcpy(state, "+x");
        for(i = 0 ; i < length - 1; i++) {
            scanf(" %s", nextState);
            flag = 1;
            if(strcmp("+x", state) == 0 && flag) {
                flag = 0;
                if(strcmp("No", nextState))
                    strcpy(state, nextState);
            }
            if(strcmp("-x", state) == 0 && flag) {
                flag = 0;
                if(strcmp("+y", nextState) == 0) strcpy(state, "-y");
                if(strcmp("-y", nextState) == 0) strcpy(state, "+y");
                if(strcmp("+z", nextState) == 0) strcpy(state, "-z");
                if(strcmp("-z", nextState) == 0) strcpy(state, "+z");
            }
            if(strcmp("+y", state) == 0 && flag) {
                flag = 0;
                if(strcmp("+y", nextState) == 0) strcpy(state, "-x");
                if(strcmp("-y", nextState) == 0) strcpy(state, "+x");
                if(strcmp("+z", nextState) == 0 || strcmp("-z", nextState) == 0) strcpy(state, "+y");
            }
            if(strcmp("-y", state) == 0 && flag) {
                flag = 0;
                if(strcmp("+y", nextState) == 0) strcpy(state, "+x");
                if(strcmp("-y", nextState) == 0) strcpy(state, "-x");
                if(strcmp("+z", nextState) == 0 || strcmp("-z", nextState) == 0) strcpy(state, "-y");
            }
            if(strcmp("+z", state) == 0 && flag) {
                flag = 0;
                if(strcmp("+z", nextState) == 0) strcpy(state, "-x");
                if(strcmp("-z", nextState) == 0) strcpy(state, "+x");
                if(strcmp("+y", nextState) == 0 || strcmp("-y", nextState) == 0) strcpy(state, "+z");
            }
            if(strcmp("-z", state) == 0 && flag) {
                flag = 0;
                if(strcmp("+z", nextState) == 0) strcpy(state, "+x");
                if(strcmp("-z", nextState) == 0) strcpy(state, "-x");
                if(strcmp("+y", nextState) == 0 || strcmp("-y", nextState) == 0) strcpy(state, "-z");
            }
        }
        printf("%s\n", state);
        scanf(" %d\n", &length);
    }
    return 0;
}
