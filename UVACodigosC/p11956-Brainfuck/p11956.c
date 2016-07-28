#include<stdio.h>
#include<string.h>

#define SIZE 100

typedef struct _posMem {
    char l;
    char r;
    int value;
} PosMem;


int main(void) {
    PosMem m[SIZE];
    char v[] = "0123456789ABCDEF";
    int tC;
    int i, j;
    char in[1000001];
    int pos;

    scanf("%d", &tC);
    for(i = 1; i <= tC; i++) {
        scanf(" %[^\n]", in);
        for(j = 0 ; j < SIZE; j++) {
            m[j].value = 0;
            m[j].l = '0';
            m[j].r = '0';
        }
        pos = 0;
        for(j = 0; j < strlen(in); j++) {
            switch(in[j]) {
                case '<': {
                    pos--;
                    if(pos < 0) pos = 99;
                    break;
                }
                case '>': {
                    pos++;
                    if(pos > 99) pos = 0;
                    break;
                }
                case '+': {
                    m[pos].value++;
                    if(m[pos].value >= 256) {
                        m[pos].l = '0';
                        m[pos].r = v[m[pos].value % 16];
                        m[pos].value = 0;
                    } else {
                        m[pos].l = v[m[pos].value / 16];
                        m[pos].r = v[m[pos].value % 16];
                    }
                    break;
                }
                case '-': {
                    m[pos].value--;
                    if(m[pos].value < 0) {
                        m[pos].l = 'F';
                        m[pos].r = 'F';
                        m[pos].value = 255;
                    } else {
                        m[pos].l = v[m[pos].value / 16];
                        m[pos].r = v[m[pos].value % 16];
                    }
                    break;
                }
                case '.': {
                    break;
                }
            }
        }
        printf("Case %d:", i);
        for(j = 0; j < SIZE; j++) {
            printf(" %c%c", m[j].l, m[j].r);
        }
        printf("\n");
    }
    return 0;
}
