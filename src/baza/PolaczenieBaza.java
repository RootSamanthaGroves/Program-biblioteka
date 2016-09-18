/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dii ES
 */
public class PolaczenieBaza {

    private static Connection polacz;

    /**
     * Metoda łącząca sie z bazą danych
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static boolean polaczeniezBaza() throws SQLException,
            ClassNotFoundException, InstantiationException,
            IllegalAccessException {
        boolean polaczenie = false;
        String haslo = Ustawienia.HASLO;
        String login = Ustawienia.LOGIN;

        if (polacz == null || polacz.isClosed()) {
            Class.forName(Ustawienia.RODZAJ_STEROWNIKA).newInstance();
            polacz = DriverManager.getConnection(Ustawienia.URL, login, haslo);//nawiązywanie połaczenia  ( podaje URL i login oraz haslo
            polaczenie = true;
        }
        return polaczenie;
    }

    /**
     * Zamykanie połączenia z bazą danych
     *
     * @throws SQLException
     */
    public static void rozlaczBaze() throws SQLException {
        polacz.close();
    }

    public static Connection przekazPolaczenie() {
        return polacz;
    }
}
