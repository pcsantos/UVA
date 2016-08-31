/*only positive integer numbers*/
#include<stdio.h>
#include<ctype.h>
#include<string.h>

#define gc() getchar_unlocked()
#define TRUE 1

int readInt();

int main(void) {
    int in;
    scanf("%d", &in);
    while (in != 0) {
        printf("%d\n", in);
        scanf("%d", &in);
    }
    return 0;
}

int readInt () {
	int result = 0;
	char ch;
	ch = gc();
	while (TRUE) {
		if (isdigit(ch)) break;
		ch = gc();
	}
	result = ch-'0';
	while (TRUE) {
		ch = gc();
		if (!isdigit(ch)) break;
		result = result * 10 + (ch - '0');
	}
	return result;
}
