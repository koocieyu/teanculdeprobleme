#include <iostream>
#include <cstring>
using namespace std;

int main()
{
    char str[100005];
    int teanc[21][21], n, cerinte[21][21], nrcurent=0,o=1,j=1,cateelem=0;
    cin.getline(str,100001);
    for(int z=0; str[z]; z++)
    {
        if(strchr("0123456789",str[z]))
            nrcurent=nrcurent*10+str[z];
        else if(str[z]==' ')
        {   teanc[o][j]=nrcurent;
            j++;
            teanc[o][0]++;
            if(j>20) j=1,o++;
        }
        else o++,j=1;
    }
    for(int z=1;z<=o;z++){
        for(int p=1;p<=teanc[o][0];p++){
            cout<<teanc[z][p]<<" ";
        }
        cout<<endl;
    }
    return 0;
}