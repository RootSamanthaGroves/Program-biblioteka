package baza;
/**
 *
 * @author Dii ES
 */
public class Ustawienia {
    
    public static String LOGIN = "SYSDBA";
    public static String HASLO = "masterkey";
    public static final String RODZAJ_STEROWNIKA = "org.firebirdsql.jdbc.FBDriver";
    public static final String SCIEZKA_PLIK = "C:\\WYPOZYCZ.FDB";
    public static final String KODOWANIE = "?lc_ctype=ISO_PLK";

    // URL bazy poskłdany z części składowych
    public static final String URL = "jdbc:firebirdsql://localhost/" + SCIEZKA_PLIK + KODOWANIE;
}
