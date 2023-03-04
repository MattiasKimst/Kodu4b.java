/***********************************
 * Programmeerimine II. LTAT.03.007
 * 2022/2023 kevadsemester
 *
 * Kodutöö nr 4b
 * Teema: ühe- ja kahemõõtmelised järjendid
 *
 * Autor: Mattias Kimst
 *
 **********************************/

public class Kodu4b {
    /**
     * @param a ühemõõtmeline massiiv
     * @return kahemõõtmeline massiiv, mis saadud sisendmassiivist
     * säilitades elementide järjekorra ja jagades ridadeks sisendmassiivi
     * nii, et veergude arv oleks võrdne ridade arvuga ja võimalikult väike
     */
    public static int[][] taidaMassiiv(int[] a) {
        int massiivilaius = (int) Math.ceil(Math.sqrt(a.length));
        int[][] tagastusMassiiv = new int[massiivilaius][massiivilaius];
        int ümbertõstetavaElemendiIndeks = 0;
        int reaPikkus;
        int[] ajutineMassiiv; // kasutusel kui vaja teha mõne rea massiiv lühemaks
        for (int i = 0; i < massiivilaius; i++) {
            reaPikkus = 0;
            ajutineMassiiv = new int[massiivilaius];
            for (int j = 0; j < massiivilaius; j++) {
                if (ümbertõstetavaElemendiIndeks < a.length) {
                    tagastusMassiiv[i][j] = a[ümbertõstetavaElemendiIndeks];
                    ajutineMassiiv[j] = a[ümbertõstetavaElemendiIndeks++];
                    reaPikkus++;
                }
            }
            if (reaPikkus < massiivilaius) {
                tagastusMassiiv[i] = new int[reaPikkus];
                for (int k = 0; k < reaPikkus; k++) {
                    tagastusMassiiv[i][k] = ajutineMassiiv[k];
                }
            }
        }


        return tagastusMassiiv;
    }

    /**
     *
     * @param b kahemõõtmeline massiiv
     * @return ühemõõtmeline massiiv, kuhu sisendmassiivi elemendid on salvestatud peadiagonaaliga paralleelsete
     * diagonaalide kaupa järjestuses vasakult paremale
     */
    public static int[] diagonaalid(int[][] b) {
        int massiivilaius = b.length;
        int j;
        int massiivisuurus = 0;
        for (int k = 0; k < b.length; k++) { 
            for (int l = 0; l < b[k].length; l++) {
                massiivisuurus++;
            }
        }
        int[] lõppMassiiv = new int[massiivisuurus];
        int lõppMassiiviLoendur = 0;
        for (int i = massiivilaius - 1; i >= 0; i--) {
            //lisab lõppmassiivi peadiagonaali ja sellest vasakul asuvate diagonaalide elemendid

            j = 0;
            while (true) {

                try {
                    lõppMassiiv[lõppMassiiviLoendur] = b[i + j][0 + j++];
                } catch (Exception e) {
                    break;
                }
                lõppMassiiviLoendur++;
            }

        }
        for (int i = 1; i < massiivilaius; i++) {
            //lisab lõppmassiivi peadiagonaalist paremal olevate diagonaalide elemendid

            j = 0;
            while (true) {
                try {
                    lõppMassiiv[lõppMassiiviLoendur] = b[0 + j][i + j++];
                } catch (Exception e) {
                    break;
                }
                lõppMassiiviLoendur++;
            }

        }

        return lõppMassiiv;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int[] b = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        taidaMassiiv(a);
        int[][] c = taidaMassiiv(a);
        int[] d = diagonaalid(c);

        taidaMassiiv(b);
        int[][] e = taidaMassiiv(b);
        int[] f = diagonaalid(e);
        String o=null;
        System.out.println(o.equals(null));
        //...
    }//main

}//klass

