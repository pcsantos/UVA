#include<iostream>
#include<algorithm>
#include<string.h>

#define SIZE 51

using namespace std;

int main(void) {

    char word[SIZE];

    cin >> word;
    while (strcmp(word, "#")) {
        if (next_permutation(word, word + strlen(word)))
            cout << word << "\n";        
        else 
            cout << "No Successor\n";
        cin >> word;
    }
    return 0;
}
