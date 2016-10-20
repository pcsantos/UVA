#include<stdio.h>

int main(void) {
    int testCases, i, aux;
    int players, kplayer, passes;
    scanf("%d\n", &testCases);
    for (i = 1; i <= testCases; i++) {
        scanf("%d %d %d\n", &players, &kplayer, &passes);
        aux = (passes % players) + kplayer;
        if (aux > players)
            printf("Case %d: %d\n", i, aux % players);
        else
            printf("Case %d: %d\n", i, aux);
    }
    return 0;
}
