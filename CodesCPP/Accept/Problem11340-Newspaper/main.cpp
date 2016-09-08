#include<stdio.h>
#include<map>

#define gc() getchar_unlocked()

using namespace std;

map<unsigned char, int> prices;

int main(void) {
    map<unsigned char, int> :: iterator it;
    int testCases;
    int lines;
    int chs;
    unsigned char ch;
    int cents;
    int total;

    scanf("%d\n", &testCases);
    while(testCases--) {
        scanf("%d\n", &chs);
        while(chs--) {
            scanf("%c %d\n", &ch, &cents);
            prices[ch] = cents;
        }
        scanf("%d\n", &lines);
        total = 0;
        while (lines) {
            ch = gc();
            if (ch == '\n')
                lines--;
            it = prices.find(ch);
            if (it != prices.end()) {
                total += it->second;
            }
        }
        printf("%d.%02d$\n", total / 100, total % 100);
        prices.clear();
    }

    return 0;
}
