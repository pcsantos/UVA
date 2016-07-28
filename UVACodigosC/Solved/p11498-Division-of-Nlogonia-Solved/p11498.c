#include<stdio.h>

int main(void) {

    char regions[][7] = { "divisa", "NO", "NE" , "SE", "SO" };
    int lines;
    int i;
    int divisonPointN;
    int divisonPointM;
    int coordenateX;
    int coordenateY;

    scanf("%d\n", &lines );
    while( lines != 0) {
        scanf(" %d %d\n", &divisonPointN, &divisonPointM);
        for(i = 0; i < lines; i++) {
            scanf(" %d %d\n", &coordenateX, &coordenateY);
            if(coordenateX > divisonPointN && coordenateY > divisonPointM)
                printf("%s\n", regions[2]);
            if(coordenateX > divisonPointN && coordenateY < divisonPointM)
                printf("%s\n", regions[3]);
            if(coordenateX < divisonPointN && coordenateY > divisonPointM)
                printf("%s\n", regions[1]);
            if(coordenateX < divisonPointN && coordenateY < divisonPointM)
                printf("%s\n", regions[4]);
            if(coordenateX == divisonPointN || coordenateY == divisonPointM)
                printf("%s\n", regions[0]);
        }
        scanf("%d\n", &lines );
    }

    return 0;
}
