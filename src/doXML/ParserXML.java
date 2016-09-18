package doxml;

import baza.OperacjeNaBazie;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class ParserXML {

    /**
     * Metoda parsujaca plik xml, przetwarzajaca pozyskane dane
     *
     * @param sciezka Sciezka pliku xml.
     * @throws FileNotFoundException
     * @throws XMLStreamException
     * @throws java.sql.SQLException
     */
    static int ilRekKsiazka = 0;
    static int ilRekCzytelnik = 0;
    static int ilRekwypozyczenie = 0;

    public static void parsujXML(File sciezka) throws FileNotFoundException, XMLStreamException, SQLException {
        // tworzenie parsera
        XMLInputFactory factory = XMLInputFactory.newInstance();
        InputStream plikXML = new FileInputStream(sciezka);
        XMLStreamReader parser = factory.createXMLStreamReader(plikXML);

        // Arraylisty tagow i odpowiadajacych im wartosci
        ArrayList<String> naglowki = new ArrayList<String>();
        ArrayList<String> wartosci = new ArrayList<String>();

        // dopoki masz nastepny element ...
        while (parser.hasNext()) {
            // jesli jest to ... , wowczas ...
            switch (parser.next()) {
// START ELEMENT //
                case XMLStreamConstants.START_ELEMENT:

                    if (parser.getLocalName().equals("ksiazka")) {
                        naglowki.add("tabela");
                        wartosci.add("ksiazka");
                    }
                    if (parser.getLocalName().equals("czytelnik")) {
                        naglowki.add("tabela");
                        wartosci.add("czytelnik");
                    }
                    if (parser.getLocalName().equals("wypozyczenie")) {
                        naglowki.add("tabela");
                        wartosci.add("wypozyczenie");
                    }

                    if (parser.getLocalName().equals("idk")) {
                        naglowki.add("id_ksiazka");
                        ilRekKsiazka++;
                        wartosci.add(parser.getElementText());
                    }
                    if (parser.getLocalName().equals("autor")) {
                        naglowki.add("autor");
                        wartosci.add(parser.getElementText());
                    }
                    if (parser.getLocalName().equals("tytul")) {
                        naglowki.add("tytul");
                        wartosci.add(parser.getElementText());
                    }

                    if (parser.getLocalName().equals("idc")) {
                        naglowki.add("id_czytelnik");
                        ilRekCzytelnik++;
                        wartosci.add(parser.getElementText());
                    }
                    if (parser.getLocalName().equals("imie")) {
                        naglowki.add("imie");
                        wartosci.add(parser.getElementText());
                    }
                    if (parser.getLocalName().equals("nazwisko")) {
                        naglowki.add("nazwisko");
                        wartosci.add(parser.getElementText());
                    }
                    if (parser.getLocalName().equals("miasto")) {
                        naglowki.add("miasto");
                        wartosci.add(parser.getElementText());
                    }

                    if (parser.getLocalName().equals("idwypozycz")) {
                        naglowki.add("id_wypozyczenie");
                        ilRekwypozyczenie++;
                        wartosci.add(parser.getElementText());
                    }
                    if (parser.getLocalName().equals("idksiazka")) {
                        naglowki.add("id_ksiazka");
                        wartosci.add(parser.getElementText());
                    }
                    if (parser.getLocalName().equals("idczytelnik")) {
                        naglowki.add("id_czytelnik");
                        wartosci.add(parser.getElementText());
                    }
                    if (parser.getLocalName().equals("status")) {
                        naglowki.add("status");
                        wartosci.add(parser.getElementText());
                    }
                    break;
// END ELEMENT //
                case XMLStreamConstants.END_ELEMENT:

                    if (parser.getLocalName().equals("ksiazka")
                            || parser.getLocalName().equals("czytelnik")
                            || parser.getLocalName().equals("wypozyczenie")) {

                        //Jezeli to jest grupa "ksiazka" 
                        if (parser.getLocalName().equals("ksiazka")) {
                            //Wywołujemy metode wstawiania do tabeli ksiażki
                            OperacjeNaBazie.wstawTabKsiazka(naglowki, wartosci);

                            naglowki.clear();
                            wartosci.clear();
                            //jezeli to jest grupa "czytelnik"
                        } else if (parser.getLocalName().equals("czytelnik")) {
                            //Wywołujemy metode wstawiania do tabeli czytelnicy
                            OperacjeNaBazie.wstawTabCzytelnik(naglowki, wartosci);

                            naglowki.clear();
                            wartosci.clear();
                            //Jezeli to jest grupa "wypozyczenia"
                        } else {
                            //Wywołujemy metode wstawiania do tabeli wypożyczone
                            OperacjeNaBazie.wstawTabWypozyczenie(naglowki, wartosci);

                            naglowki.clear();
                            wartosci.clear();
                        }
                    }
                    break;
// END DOCUMENT //
                case XMLStreamConstants.END_DOCUMENT:
                    System.out.println("Koniec");
                    break;
            }
        }
    }

    public static String ilerekordow() {
        String komunikat = "Wstawiono " + ilRekKsiazka + " książek, "
                + ilRekCzytelnik + " czytelników i " + ilRekwypozyczenie + " wypożyczeń";
        return komunikat;
    }
}
