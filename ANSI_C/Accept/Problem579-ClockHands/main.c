#include<stdio.h>
#include<string.h>
#include<math.h>

#define SIZE 6

void getTime(char[], int*, int*);

int main(void) {
    char in[SIZE];
    int hour;
    int min;
    float hourDegrees, minDegrees;
    while (scanf("%s\n", in) != EOF) {
        if (strcmp(in,"0:00") == 0)
            break;
        getTime(in, &hour, &min);
        hourDegrees = (hour * 60  + min) * 0.5;
        minDegrees = min * 6;
        float diff = fabs(hourDegrees - minDegrees);
        if (fabs(diff > 180))
            printf("%.3f\n",  360 - diff);
        else
            printf("%.3f\n", diff);
    }

    return 0;
}

void getTime(char in[], int *h, int *m) {
    
    if (strlen(in) == 5) {
        *h = (in[0] - '0') * 10 + (in[1] - '0');
        *m = (in[3] - '0') * 10 + (in[4] - '0');
    } else {
        *h = (in[0] - '0');
        *m = (in[2] - '0') * 10 + (in[3] - '0');
    }

}
