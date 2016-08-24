#include<stdio.h>
#include<math.h>

#define SIZE 3001
#define TRUE 1
#define FALSE 0

int array[SIZE];
int isJolly[SIZE];

int main(void) {
    int number;
    int i;
    while ((scanf("%d", &number)) != EOF) {
         for (i = 0; i < number; i++) {
            scanf(" %d ", &array[i]);
            isJolly[i] = FALSE;
         }
         for (i = 1; i < number; i++) {
            int absDiff = abs(array[i-1] - array[i]);
            if (absDiff > 0 && absDiff < number) {
                isJolly[absDiff] = TRUE;
            }
         }

         int notJolly = FALSE;
         for (i = 1; i < number; i++) {
            if (!isJolly[i]) {
                notJolly = TRUE;
                break;
            }
         }
         if (notJolly) {
            printf("Not jolly\n");
         } else {
            printf("Jolly\n");
         }
    }
    return 0;
}
