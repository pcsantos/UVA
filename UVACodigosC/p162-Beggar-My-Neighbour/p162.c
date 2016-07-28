#include<stdio.h>
#include<string.h>
#define DECK 52

typedef struct _card {
    char c[3];
} Card;

typedef struct _hand {
    Card hand[DECK];
    int qtdCards;
} Hand;



int main(void) {
    Hand dealer;
    Hand nDealer;
    Hand table;
    char card[3];
    int i, j;
    int tgg;
    int flag;
    int qtd;
    int times;

    do {

        qtd = 0;
        i = 0;
        j = 0;
        nDealer.qtdCards = 0;
        dealer.qtdCards = 0;
        tgg = 0;
        while(qtd < 52){
            scanf(" %s", card);
            if(strcmp(card, "#") == 0) break;
            if(tgg) {
                strcpy(dealer.hand[i++].c, card);
                dealer.qtdCards++;
                tgg = 0;
            } else {
                strcpy(nDealer.hand[j++].c, card);
                nDealer.qtdCards++;
                tgg = 1;
            }
            qtd++;
        }

        tgg = 0;
        times = 1;
        table.qtdCards = 0;
        j = 0;
        while(nDealer.qtdCards && dealer.qtdCards) {

            if(tgg) {
                switch(dealer.hand[dealer.qtdCards].c[1]) {
                    case 'J': {

                        break;
                    }
                    default: {
                        tgg = 0;
                        strcpy(table.hand[j++].c, dealer.hand[dealer.qtdCards].c);
                        table.qtdCards++;
                        dealer.qtdCards--;
                        times = 1;
                        break;
                    }
                }
            } else {
                switch(nDealer.hand[nDealer.qtdCards].c[1]) {
                    case 'J': {

                        break;
                    }
                    default: {
                        tgg = 0;
                        strcpy(table.hand[j++].c, nDealer.hand[nDealer.qtdCards].c);
                        table.qtdCards++;
                        nDealer.qtdCards--;
                        times = 1;
                        break;
                    }
                }

            }
        }

    } while(strcmp(card, "#") != 0);
    return 0;
}
