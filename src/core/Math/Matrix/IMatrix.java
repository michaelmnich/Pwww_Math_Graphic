package core.Math.Matrix;

/**
 * Created by Michal on 2018-04-08.
 */
public interface IMatrix {
    /** Generuje macierz jednostkową o podarnym rozmiarze
     * MAKSYMALNIE 3X3 po utwoezeniu niech ja wypisze pusta do html
     * Qery ?...&MatReq=createIdentityMatrix&size=WSTAW WARTOSC
     * */
    void createIdentityMatrix(int size);

    /** Oblicza wartość wyznacznika dla kwadratowej macierzy, w przypadku innej mamy wyjątek
     * Qery ?...&MatReq=determinant
     * */
    double determinant() throws InvalidDimensionException;

    /** Zwraca wartość pola w macierzy
     * Qery ?...&MatReq=getMatrixValue
     * */
    double getMatrixValue(int row, int column);

    /** Ustala wartość pojedyńczej komórki
     * itd ogolna zasada robienia qery ma być taka &MatReq=nazwaFunkcji&nazwaparametru=wartosc ....
     * */
    void setMatrixValue(int row, int column, double value);

    /** Ustala zawartość macierzy na podstawie tablicy */
    void setMatrixValues(double[][] values) throws InvalidDimensionException;

    int getWidth();
    int getHeight();

    /** Reprezentacja w formie String macierzy, powinna utrzymywać konwencję wierszy i kolumn
     *  Niech zwraca HTML w postaci
     *  <table>
     *  <tr>
     *      <td>kol01 wiersz 01</td> <td>kol02 wiersz 01</td>
     *  </tr>
     *   <tr>
     *      <td>kol01 wiersz 02</td> <td>kol02 wiersz 02</td>
     *  </tr>
     *  ITD...
     *  </table>
     * */
    String toString();
}