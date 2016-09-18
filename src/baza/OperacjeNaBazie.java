package baza;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import okienka.Okno;

/**
 *
 * @author Dii ES
 */
public class OperacjeNaBazie {

    public static final String TABELA_KSIAZKI = "KSIAZKA";
    public static final String TABELA_CZYTELNICY = "CZYTELNIK";
    public static final String TABELA_WYPOZYCZENIA = "WYPOZYCZENIE";

    /**
     * Metoda wstawiajaca rekordy do tabeli KSIAZKA w bazie danych
     *
     * @param naglowki
     * @param wartosci
     * @throws SQLException
     */
    public static void wstawTabKsiazka(ArrayList<String> naglowki,
            ArrayList<String> wartosci) throws SQLException {

        //Czyscimy listy
        naglowki.remove(0);
        wartosci.remove(0);

        //Z listy wartosci wycinamy wartosci ktore nastepne umiescimy w bazie.
        int wartoscIDKsiazka = Integer.valueOf(wartosci.get(0));
        String wartoscAutor = wartosci.get(1);
        String wartoscTytul = wartosci.get(2);

        // Składamy zapytanie SQL
        String zapytanie = "INSERT INTO " + TABELA_KSIAZKI
                + " VALUES (" + wartoscIDKsiazka + ","
                + "'" + wartoscAutor + "',"
                + "'" + wartoscTytul + "');";

        // Wykonujemy zapytanie
        zwacajWynikiUPDATE(zapytanie);

    }

    /**
     * Metoda wtawia dane do tabeli CZYTELNICY w bazie danych
     *
     * @param naglowki
     * @param wartosci
     * @throws SQLException
     */
    public static void wstawTabCzytelnik(ArrayList<String> naglowki,
            ArrayList<String> wartosci) throws SQLException {

        //Czyscimy listy
        naglowki.remove(0);
        wartosci.remove(0);

        //Z listy wartosci wycinamy wartosci ktore nastepne umiescimy w bazie.
        int wartoscIDCzytelnik = Integer.valueOf(wartosci.get(0));
        String imieAutora = wartosci.get(1);
        String nazwiskoAutora = wartosci.get(2);
        String miastoAutora = wartosci.get(3);

        // Składamy zapytanie SQL
        String zapytanie = "INSERT INTO " + TABELA_CZYTELNICY
                + " VALUES (" + wartoscIDCzytelnik + ","
                + "'" + imieAutora + "',"
                + "'" + nazwiskoAutora + "','" + miastoAutora + "');";

        // Wykonujemy zapytanie
        zwacajWynikiUPDATE(zapytanie);

    }

    /**
     * Metoda wstawia powązania do tabeli WYPOZYCZENIE między tabelami CZYTELNIK
     * i KSIAZKA
     *
     * @param naglowki
     * @param wartosci
     * @throws SQLException
     */
    public static void wstawTabWypozyczenie(ArrayList<String> naglowki,
            ArrayList<String> wartosci) throws SQLException {

        //Czyscimy listy
        naglowki.remove(0);
        wartosci.remove(0);

        //Z listy wartosci wycinamy wartosci ktore nastepne umiescimy w bazie.
        int wartoscIDWypozyczenie = Integer.valueOf(wartosci.get(0));
        int wartoscIDCzytelnik = Integer.valueOf(wartosci.get(1));
        int wartoscIDKsiazka = Integer.valueOf(wartosci.get(2));
        String wartoscStatus = wartosci.get(3);

        String zapytanie = "INSERT INTO " + TABELA_WYPOZYCZENIA
                + " VALUES (" + wartoscIDWypozyczenie + ","
                + wartoscIDCzytelnik + ","
                + wartoscIDKsiazka + ","
                + "'" + wartoscStatus + "');";

        // Wykonujemy zapytanie
        zwacajWynikiUPDATE(zapytanie);
    }

    public static String wybierzPlikXML() {
        String fileName = null;
        JFileChooser wybierzPlik = new JFileChooser();
        wybierzPlik.setDialogTitle("Wybierz plik *.xml z którego chcesz załadowac dane do bazy ");
        wybierzPlik.setFileFilter(new FileNameExtensionFilter("Plik *.xml z rekordami bazy", "XML", "XML"));
        Okno okienko = new Okno();
        int result = wybierzPlik.showOpenDialog(okienko);
        if (result == JFileChooser.APPROVE_OPTION) {
            //     try {
            fileName = wybierzPlik.getSelectedFile().getPath();//pobranie ścieżki do pliku
            //        nameDB = wybierzPlik.getSelectedFile().getName();
        }
        return fileName;
    }

    /**
     * Metoda do pobierania wynikow zapytan z uzyciem SELECT
     *
     * @param zapytanie
     * @return
     * @throws SQLException
     */
    public static ResultSet zwracajWynikiSELECT(String zapytanie) throws SQLException {
        return PolaczenieBaza.przekazPolaczenie().createStatement().
                executeQuery(zapytanie);
    }

    /**
     * Metoda do pobierania wynikow zapytan INNYCH niz z uzyciem SELECT
     *
     * @param zapytanie
     * @return
     * @throws SQLException
     */
    public static int zwacajWynikiUPDATE(String zapytanie) throws SQLException {
        return PolaczenieBaza.przekazPolaczenie().createStatement().
                executeUpdate(zapytanie);
    }

    public static String[][] pobierzDaneZBazy(String zapytanie) throws SQLException {

        // Pobieramy ilosc kolumn i wierszy w zapytaniu.
        int kolumny = ileKolumn(zapytanie);
        int wiersze = ileWierszy(zapytanie);

        // Uruchamiamy metode do pobierania danych z zapytania typu SELECT.
        // Obiekt typu ResultSet to paczka z danymi.
        ResultSet wynikZapytania = zwracajWynikiSELECT(zapytanie);

        // Deklarujemy tablice w oparciu o pobrane dane.
        String tab[][] = new String[wiersze][kolumny];

        // Zmienna do indeksowania wierszy tabeli
        int nrWiersza = 0;

        // Podczas gdy wynikiem zapytania jest wiersz danych
        while (wynikZapytania.next()) {

            // Petla przeskakowywujaca po kolejnych kolumnach w danym 
            // wierszu danych
            for (int nrKolumny = 1; nrKolumny <= kolumny; nrKolumny++) {

                // Do tablicy na odpowiednie indeksy wrzucamy pobraną wartość
                // -1 ponieważ kolumny w bazie numerujemy od 1 a normalnie od 0
                tab[nrWiersza][nrKolumny - 1]
                        = wynikZapytania.getObject(nrKolumny).toString();
            }
            nrWiersza++;
        }
        return tab;

    }

    // Metoda do obierania ILOSC KOLUMN z bazy danych wedlug ZAPYTANIA
    public static int ileKolumn(String zapytanie) throws SQLException {
        return zwracajWynikiSELECT(zapytanie).getMetaData().getColumnCount();
    }
    
     public static String[] naglowkiKolumn(String zapytanie) throws SQLException{
        
        // Pobieramy ilość kolumn
        int ileKolumn = ileKolumn(zapytanie);
        
        // Tworzymy tablicę z nazwami kolumn
        String[] nazwy = new String[ileKolumn];
        
        // Wykonujemy zapytanie
        ResultSet wynik = zwracajWynikiSELECT(zapytanie);
        
        // Przechodzimy na pierwszy rekord (wystarczy raz)
        wynik.next();
               
        // korzystając z pierwszego wiersza pobranych danych
        // wyciągamy w pętli kolejne nazwy kolumn
        for(int i = 1 ; i <= ileKolumn ; i++){
            nazwy[i - 1] = wynik.getMetaData().getColumnName(i);
            System.out.println(nazwy[i - 1]);
        }
        
        return nazwy;
    }

    public static int ileWierszy(String zapytanie) throws SQLException {
        // Zmienna okreslajaca ilosc wierszy w bazie
        int iloscWierszy = 0;
        // Wykonujemy zapytanie do bazy i pobieramy jego wynik
        ResultSet wynikZapytania = zwracajWynikiSELECT(zapytanie);
        while (wynikZapytania.next()) {
            iloscWierszy++;
        }
        return iloscWierszy;
    }
}
