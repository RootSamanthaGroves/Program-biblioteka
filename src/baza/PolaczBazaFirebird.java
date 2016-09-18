package baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * @author Dii ES
 */
public class PolaczBazaFirebird 
{
    private static Connection connection;
    private static Statement statement;
    
    public static void main(String[] args)
    {
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
        } catch (ClassNotFoundException ex) {
            System.out.println("! Nie odnaleziono sterownika JDBC!");
        }
        
        // nawiazanie polaczenia
        try {
            connection=DriverManager.getConnection("jdbc:firebirdsql://localhost/C:/wypozycz.FDB","SYSDBA","masterkey");
            statement = connection.createStatement();
            System.out.println("Po��czono z baz� danych!");
        } 
        catch (SQLException ex) 
        {
            System.out.println("! Wyst�pi� b��d podczas pr�by nawi�zania po��czenia z baz� danych!!!");
        }
        
        // wykonywanie zapytan SELECT do bazy
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ksiazka;");
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int liczbaKol = rsmd.getColumnCount();
            while (resultSet.next())
            {
                String linia = new String();
                for (int i=1; i<=liczbaKol; i++)
                {
                    if (i>1) linia = linia + " ";
                        linia = linia + resultSet.getString(i);
                }
                System.out.println(linia);
            }
        } catch (SQLException ex) {
            System.out.println("! Wyst�pi� b��d podczas pr�by wykonania zapytania do bazy danych!!!");
        }
        
        // wykonywanie zapytan INSERT/DELETE/UPDATE do bazy
        try {
            int wynikUpdate = statement.executeUpdate("INSERT INTO CZYTELNIK VALUES (1,'Anna', 'Abacka', 'Rzeszow');");
            if(wynikUpdate > 0)
                System.out.println("Liczba zmodyfikowanych rekordow: " + wynikUpdate);
            else
                System.out.println("Nie zmodyfikowano zadnego rekordu");
        } catch (SQLException ex) {
            System.out.println("! Wyst�pi� b��d podczas pr�by aktualizacji bazy danych!!!");
        }
        
        // zamkniecie polaczenia
        try {
            statement.close();
            System.out.println("Pomy�lnie zamkni�to po��czenie z baz� danych!");
        } catch (SQLException ex) {
            System.out.println("! Wyst�pi� b��d podczas pr�by zamkni�cia po��czenia z baz� danych!!!");
        }
        
    }
}
