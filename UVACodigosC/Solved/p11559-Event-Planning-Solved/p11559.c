#include<stdio.h>

int main(void) {

    int participants;
    int budget;
    int hotels;
    int weeks;
    int priceForWeek;
    int availableBed;
    int i, j;
    char stayHome[] = "stay home";
    int price;
    int vacancy = 0;
    int finalPrice = 0;
    while(scanf(" %d %d %d %d\n", &participants, &budget, &hotels, &weeks) != EOF) {

            finalPrice = 600000;
            vacancy = 0;
            price = 0;
            for(j = 0; j < hotels; j++) {
                scanf(" %d\n", &priceForWeek);
                for(i = 0; i < weeks; i++) {
                    scanf("%d", &availableBed);
                    if(vacancy < availableBed)
                        vacancy = availableBed;
                }
                if(vacancy >= participants && participants * priceForWeek <= budget)
                    price = participants * priceForWeek;
                if(finalPrice > price && price != 0)
                    finalPrice = price;
            }
            if(finalPrice == 600000)
                printf("%s\n", stayHome);
            else
                printf("%d\n", finalPrice);
    }

    return 0;
}
