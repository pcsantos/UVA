#include<stdio.h>
#include<string.h>

int main(void) {

    int requirementNumbers;
    int proposalNumbers;
    char requirement[81];
    char proposal[81];
    float price;
    float finalPrice;
    int metRequirement;
    float compliance;
    int i, j;
    float finalCompliance;
    char finalProposal[81];


    int testCases = 1;
    scanf(" %d %d\n", &requirementNumbers, &proposalNumbers);
    while(requirementNumbers != 0) {
        finalCompliance = 0;
        finalPrice = 9999999999;
        for(i = 0; i < requirementNumbers; i++) {
            gets(requirement);
        }

        for(i = 0; i < proposalNumbers; i++) {
            gets(proposal);
            scanf(" %f %d\n", &price, &metRequirement);
            for(j = 0; j < metRequirement; j++) {
                gets(requirement);
            }
            compliance = (float)metRequirement / requirementNumbers;
            if(compliance > finalCompliance) {
                finalCompliance = compliance;
                strcpy(finalProposal, proposal);
                finalPrice = price;
            } else if(compliance == finalCompliance) {
                if(finalPrice > price) {
                    finalCompliance = compliance;
                    strcpy(finalProposal, proposal);
                    finalPrice = price;
                }
            }
        }
        printf("RFP #%d\n", testCases++);
        printf("%s\n", finalProposal);

        scanf(" %d %d\n", &requirementNumbers, &proposalNumbers);
        if(requirementNumbers != 0) printf("\n");
    }
    return 0;
}
