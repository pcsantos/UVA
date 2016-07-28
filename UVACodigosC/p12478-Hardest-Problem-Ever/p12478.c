#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define SIZE 9

typedef struct _charOcc {
    char type;
    int value;
    int found;
} CharOcc;

int search(char name[], char m[][9]) {

    int i, j, k, l, s;
    int occ;
    int size = strlen(name);
    CharOcc v[SIZE];
    int flag;

    for(i = 0; i < SIZE; i++) v[i].type = '0';

    v[0].type = name[0];
    v[0].value = 1;
    v[0].found = 0;
    k = 1;
    for(i = 1; i < size; i++) {
        flag = 1;
        for(j = 0 ; j < i; j++) {
            if(name[i] == v[j].type) {
                v[j].value++;
                flag = 0;
            }
        }
        if(flag) {
            v[k].type = name[i];
            v[k].value = 1;
            v[k].found = 0;
            k++;
        }
    }

    occ = 0;
    for(i = 0; i < SIZE; i++) {
        for(j = 0; j <= SIZE - size; j++) {
            for(k = j; k < size + j; k++) {
                for(l = 0; v[l].type != '0'; l++) {
                    if(v[l].type == m[i][k]) {
                        v[l].found++;
                    }
                }
            }
            flag = 1;
            for(s = 0; v[s].type != '0'; s++) {
                if(v[s].found != v[s].value) {
                    flag = 0;
                    break;
                }
            }
            if(flag) occ++;
            for(l = 0; v[l].type != '0'; l++) v[l].found = 0;
        }
        for(j = 0; j <= SIZE - size; j++) {
            for(k = j; k < size + j; k++) {
                for(l = 0; v[l].type != '0'; l++) {
                    if(v[l].type == m[k][i]) {
                        v[l].found++;
                    }
                }
            }
            flag = 1;
            for(s = 0; v[s].type != '0'; s++) {
                if(v[s].found != v[s].value) {
                    flag = 0;
                    break;
                }
            }
            if(flag) occ++;
            for(l = 0; v[l].type != '0'; l++) v[l].found = 0;
        }
    }
    return occ;
}

int main(void) {

    char m[SIZE][SIZE] = {"OBIDAIBKR", "RKAULHISP", "SADIYANNO", "HEISAWHIA", "IRAKIBULS", "MFBINTRNO", "UTOYZIFAH", "LEBSYNUNE", "EMOTIONAL"};

    char names[][8] = {"RAKIBUL", "ANINDYA", "MOSHIUR", "SHIPLU", "KABIR", "SUNNY", "OBAIDA", "WASI"};

    int i, j;

    for(i = 0; i < 9; i++) {
        for(j = 0; j < 9; j++) {
            printf("%c ", m[i][j]);
        }
        printf("\n");
    }

    for(i = 0; i < 8; i++) {
        printf("%s %d\n", names[i], search(names[i], m));
    }

    return 0;
}
