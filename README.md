# Problema: teanculcuprobleme
# Cerinta

Se da un sir teanc cu numere, randurile fiind separate prin litere ale alfabetului englez. Pe randul urmator se da un numar `C` care reprezinta numarul de operatii care trebuie facute pe respectivul sir teanc. Pe urmatoarele `C` randuri se afla cate trei elemente, `O`, `N` si `I`. `O` reprezinta tipul operatiei (`p`rodus, `s`uma, `d`iferenta, `i`mpartire si `m`odulo), `N` reprezinta numarul cu care se va face operatia de suma, produs, diferenta, impartire respectiv modulo iar `I` este numarul de randuri carora li se va aplica respectiva operatie. Daca `I` este egal cu `0`, operatia se va aplica tuturor randurilor din teanc, daca este negativ operatia se va aplica primelor `I` randuri de la sfarsitul teancului iar daca `I` este pozitiv operatia se va aplica primelor `I` randuri de la inceputul teancului.

Sa se afiseze urmatoarele separate de un rand nou:
   - Teancul obtinut dupa efectuarea tuturor operatiilor, fiecare rand pe un rand nou, fara literele separatoare;
   - Numerele prime prezente in intregul teanc (Daca nu exista nici un numar prim in teanc se va scrie `NU`);
   - Raportul de numere pare:impare sub forma `numerePare:numereImpare`, care va fi adus la o forma ireductibila;
   - Numerele care au suma cifrelor egala cu numarul divizorilor (daca nu exista sa se scrie `NU`);
   - Numerele magice existente in sirul teanc (daca nu exista sa se scrie `NU`);

Caracteristicile unui numar magic:
   - Prima cifra NU este para;
   - Are cel putin 2 cifre;
   - Face parte din sirul lui Fibonacci;


# Restrictii si precizari:
 - Lungimea sirului teanc va fi strict mai mica decat 100000;
 - Teancul va avea intre 2 si 20 randuri (inclusiv);
 - Fiecare rand al teancului va contine intre 1 si 20 elemente (inclusiv);
 - `1 <= C <= 50`;
 - `O` este egal cu una dintre urmatoarele: `p`, `s`, `d`, `i` sau `m`. (produs, suma, diferenta, impartire, modulo);
 - `1 <= N <= 100000`;
 - `-20 <= I <= 20`;
 - Exista cel putin un numar par si cel putin un numar impar in tot sirul final;
 - 

# Exemplu
### Intrare:
```
1 2 3 a 7 a 356 913 184 9812 945 n 5 8 9 10 23 238
3
s 12 0
d 5 3
p 2 -1
```

### Iesire:
```
8 9 10
14
363 920 191 9819 952
34 40 42 44 70 500
191
11:4
952
34
```