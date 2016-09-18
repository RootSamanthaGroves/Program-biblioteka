package tabelka;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Klasa wypełnia tabelkę informacjami na temat poszczególnych książek
 *
 * @author Dii ES
 */
public class TModel extends AbstractTableModel {

    /**
     * Twożenie tablicy zawierającej nazwy poszczególnych kolumn tabeli
     */
    protected String[] columnNames = {"ISBN", "Tytuł", "Autor", "Wydawnictwo", "Rok", "Opis"};

    private List<BookAndAuthor> data;

    /**
     * Konstruktor z parametem będącym listą powiązań z tabeli w bazie danych
     *
     * @param data
     */
    public TModel(List<BookAndAuthor> data) {
        this.data = data;
    }

    /**
     * Metoda zwracająca ilość kilumn w tabeli
     *
     * @return
     */
    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int row, int column) {

        switch (column) {
            case 0:
                return data.get(row).getBook().getIsbn();
            case 1:
                return data.get(row).getBook().getTitle();
            case 2:
                return data.get(row).getAuthor().getAuthor();
            case 3:
                return data.get(row).getBook().getHouse();
            case 4:
                return data.get(row).getBook().getYear();
            case 5:
                return data.get(row).getBook().getDescription();
            default:
                return "N/A";
        }

    }
}
