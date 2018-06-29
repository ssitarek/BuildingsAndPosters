Plakatowanie

Wszystkie budynki we wschodniej części Bajtogrodu zostały zbudowane zgodnie z zasadami
starego bajtobudownictwa: stoją one jeden przy drugim (nie ma między nimi przerw). Razem
tworzą bardzo długą ścianę budynków o zróżnicowanej wysokości, ciągnącą się ze wschodu na
zachód.
Burmistrz Bajtogrodu, Bajtazar, postanowił, że ścianę budynków należy od północnej
strony pokryć plakatami. Bajtazar zastanawia się, jaką minimalną liczbą plakatów można
pokryć całą północną ścianę budynków. Plakaty powinny mieć kształt prostokątów o bokach
pionowych i poziomych. Plakaty nie mogą zachodzić na siebie, natomiast mogą stykać
się brzegami. Każdy plakat musi w całości przylegać do ścian pewnych budynków i cała
powierzchnia północnych ścian budynków musi być pokryta plakatami.
Zadanie:
Napisz program, który:
- wczyta ze standardowego wejścia opisy budynków,
- wyznaczy minimalną liczbę plakatów potrzebnych do całkowitego pokrycia ich północnych
ścian,
- wypisze wynik na standardowe wyjście.

Wejście:

Pierwszy wiersz wejścia zawiera jedną liczbę całkowitą n (1 6 n 6 250 000 ), oznaczającą
liczbę budynków stojących w rzędzie. Kolejne n wierszy zawiera po dwie liczby całkowite di
i wi (1 6 di,wi 6 1 000 000 000 ), oddzielone pojedynczym odstępem i oznaczające długość
i wysokość i-tego budynku w rzędzie.

Wyjście:

Pierwszy i jedyny wiersz wyjścia powinien zawierać jedną liczbę całkowitą — minimalną liczbę
prostokątnych plakatów, którymi można całkowicie pokryć północne ściany budynków.64 Plakatowanie

Przykład

Dla danych wejściowych:

```
5
1 2
1 3
2 2
2 5
1 4
```

poprawnym wynikiem jest:
```
4
```