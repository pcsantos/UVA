#include<stdio.h>

int main(void) {

    char success[] = "success on day";
    char failure[] = "failure on day";
    int height;
    int distanceDay;
    int distanceNight;
    int fatigueFactor;
    int day;
    float climbed;
    float distanceClimbed;
    float fatigueFactorPercent;

    scanf(" %d %d %d %d\n", &height, &distanceDay, &distanceNight, &fatigueFactor);
    while(height != 0) {
        day = 0;
        climbed = 0;
        fatigueFactorPercent = (float)fatigueFactor / 100;
        distanceClimbed = 0;
        while(1) {
            distanceClimbed = distanceDay - (distanceDay * fatigueFactorPercent * day);
            if(distanceClimbed > 0)
                climbed = climbed + distanceClimbed;
            if(climbed > height) break;
            climbed = climbed - distanceNight;
            if(climbed < 0) break;
            day++;
        }
        if(climbed > height)
            printf("%s %d\n", success, ++day);
        else
            printf("%s %d\n", failure, ++day);
        scanf(" %d %d %d %d\n", &height, &distanceDay, &distanceNight, &fatigueFactor);
    }
    return 0;
}
