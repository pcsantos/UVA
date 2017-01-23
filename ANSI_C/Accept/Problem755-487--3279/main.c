#include<stdio.h>
#include<ctype.h>
#include<string.h>

#define TRUE 1
#define FALSE 0
#define PHONESIZE 9
#define LIMIT 100000
#define gc() getchar_unlocked()

typedef struct _phone {
    char number[PHONESIZE];
    int times;
} Phone;

char getValue(char);
int phonecmp(Phone*, Phone*);

Phone arr[LIMIT];
Phone ordered[LIMIT];

int main(void) {
    int testCases, j;
    int i, nElements;
    char ch;
    int index, flag;

    scanf("%d\n", &testCases);
    for (i = 0; i < testCases; i++) {
        if (i > 0)
            printf("\n");
        scanf("%d\n", &nElements);
        for (j = 0; j < nElements; j++) {
            index = 0;
            flag = FALSE;
            while ((ch = gc()) != '\n') {
                if (ch != '-') {
                    if (isalpha(ch))
                        arr[j].number[index++] = getValue(ch);
                    else
                        arr[j].number[index++] = ch;
                }
                if (index == 3) {
                    arr[j].number[index++] = '-';
                }
                if (index == 8) {
                    arr[j].number[index] = '\0';
                    flag = TRUE;
                    break;
                }
            }
            if (flag)
                while ((ch = gc()) != '\n');
        }
        qsort(arr, nElements, sizeof(Phone), phonecmp);
        index = 0;
        strcpy(ordered[index].number, arr[0].number);
        ordered[index].times = 1;

        for (j = 1; j < nElements; j++) {
            if (strcmp(arr[j - 1].number, arr[j].number) == 0) {
                ordered[index].times++;
            } else {
                strcpy(ordered[++index].number, arr[j].number);
                ordered[index].times = 1;
            }
        }
        index++;
        flag = TRUE;
        for (j = 0; j < index; j++) {
            if (ordered[j].times > 1) {
                printf("%s %d\n", ordered[j].number, ordered[j].times);
                flag = FALSE;
            }
        }
        if (flag)
            printf("No duplicates.\n");
    }
    return 0;
}

int phonecmp(Phone *a, Phone *b) {
    return (strcmp(a->number, b->number));
}

char getValue(char ch) {
    switch(ch) {
        case 'A': 
        case 'B':
        case 'C': return '2';
        case 'D':
        case 'E':
        case 'F': return '3';
        case 'G':
        case 'H':
        case 'I': return '4';
        case 'J':
        case 'K':
        case 'L': return '5';
        case 'M':
        case 'N':
        case 'O': return '6';
        case 'P':
        case 'R':
        case 'S': return '7';
        case 'T':
        case 'U':
        case 'V': return '8';
        case 'W': 
        case 'X':          
        case 'Y': return '9';
    }
}
