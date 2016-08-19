#include<stdio.h>
#include<math.h>

int main(void) {
    int testCases;
    float distance, vRiver, vBoat;
    int i;

    scanf("%d\n", &testCases);
    for (i = 1; i <= testCases; i++) {
        scanf("%f %f %f \n", &distance, &vRiver, &vBoat);
        float fastestPath = 0;
        float shortestPath = 0;
        float test = vBoat*vBoat - vRiver*vRiver;
        if (test > 0)
            fastestPath = distance / sqrt(test);
        if (vBoat != 0)
            shortestPath = distance / vBoat;
        if (fastestPath > shortestPath && vBoat != 0) {
            printf("Case %d: %.3f\n", i, fastestPath - shortestPath);
        } else
            printf("Case %d: can't determine\n", i);
    }
    return 0;
}
