#include<iostream>
#include<string>
#include<algorithm>

using namespace std;

int main(void) {
    string test = "ABab";

    sort(test.begin(), test.end());
    do {
        cout << test << endl;
    
    } while (next_permutation(test.begin(), test.end()));

    return 0;
}
