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

            switch(state[1]) {
            case 'x':
                if(state[0] == '-') {
                    switch(nextState[1]){
                        case 'y':
                            state[1] = 'y';
                            if(nextState[0] == '+')
                                state[0] = '-';
                            else
                                state[0] = '+';
                            break;
                        case 'z':
                            state[1] = 'z';
                            if(nextState[0] == '+')
                                state[0] = '-';
                            else
                                state[0] = '+';
                            break;
                    }
                } else {
                    if(strcmp("No", nextState))
                        strcpy(state, nextState);
                }
                break;
            case 'z':
            case 'y':
                if(state[0] == '+') {
                    if(nextState[1] == state[1]){
                        state[1] = 'x';
                        if(nextState[0] == '+')
                            state[0] = '-';
                        else
                            state[0] = '+';
                    }
                } else {
                    if(nextState[1] == state[1]){
                        state[1] = 'x';
                        if(nextState[0] == '+')
                            state[0] = '+';
                        else
                            state[0] = '-';
                    }
                }
                break;
            }
        }
        printf("%s\n", state);
        scanf(" %d\n", &length);
    }
    return 0;
}
