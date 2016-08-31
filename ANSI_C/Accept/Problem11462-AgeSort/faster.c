#include<stdio.h>
#include<string.h>

#define gc() getchar_unlocked()
#define TRUE 1
#define RANGE 100
#define SIZE 2000001

int input[SIZE];
int output[SIZE];

int readInt();

int main(void) {
    int inSize;
    int count[RANGE + 1];
    int i;
    while (TRUE) {
        scanf("%d", &inSize);
        if (inSize == 0)
            break;
        memset(count, 0, sizeof(count));
        for (i = 0; i < inSize; i++) {
            input[i] = readInt();
            count[input[i]]++;
        }
        for (i = 1; i <= RANGE; i++)
            count[i] += count[i - 1];
        for (i = 0; i < inSize; i++) {
            output[count[input[i]] - 1] = input[i];
            count[input[i]]--;
        }
        printf("%d", output[0]);
        for (i = 1; i < inSize; i++)
            printf(" %d", output[i]);
        printf("\n");
    }
    return 0;
}

int readInt () {
	int result = 0;
	char ch;
	ch = gc();
	while (TRUE) {
		if (ch >= '0' && ch <= '9') break;
		ch = gc();
	}
	result = ch-'0';
	while (TRUE) {
		ch = gc();
		if (ch < '0' || ch > '9') break;
		result = result*10 + (ch - '0');
	}
	return result;
}
