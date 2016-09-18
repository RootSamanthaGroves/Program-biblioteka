package okienka;

import baza.OperacjeNaBazie;
import baza.PolaczenieBaza;
import doxml.ParserXML;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.stream.XMLStreamException;
import tabelka.Adjuster;

/**
 * @author Dii ES
 */
public class Okno extends javax.swing.JFrame {

    public Okno() {
        this.setTitle("Biblioteka");
        initComponents();
        ladujMenuPlik.setEnabled(false);
        importBtn.setEnabled(false);
        textTA.disable();
        zapytanieTA.disable();
        polecenieCombo.disable();
        bazaCombo.disable();
        wykonajBtn.setEnabled(false);
        wyczyscBtn.setEnabled(false);
        String[] pusta = {""};
      //  uformujTabele(1, 1, pusta);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaWynikow = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        zapytanieTA = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        textTA = new javax.swing.JTextArea();
        polaczBtn = new javax.swing.JToggleButton();
        edytujBtn = new javax.swing.JButton();
        importBtn = new javax.swing.JButton();
        wykonajBtn = new javax.swing.JButton();
        wyczyscBtn = new javax.swing.JButton();
        bazaCombo = new javax.swing.JComboBox();
        polecenieCombo = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        plikMenu = new javax.swing.JMenu();
        ladujMenuPlik = new javax.swing.JMenuItem();
        zamknijMenuPlik = new javax.swing.JMenuItem();
        opcjeMenu = new javax.swing.JMenu();
        ustawieniaMenuOpcje = new javax.swing.JMenuItem();
        pomocMenu = new javax.swing.JMenu();
        oProgramieMenuPomoc = new javax.swing.JMenuItem();
        podrecznikMenuPomoc = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelaWynikow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaWynikow);

        zapytanieTA.setColumns(20);
        zapytanieTA.setRows(5);
        jScrollPane2.setViewportView(zapytanieTA);

        textTA.setColumns(20);
        textTA.setRows(5);
        jScrollPane3.setViewportView(textTA);

        polaczBtn.setText("Połącz");
        polaczBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                polaczBtnActionPerformed(evt);
            }
        });

        edytujBtn.setText("Edytuj ustawienia z bazą danych");
        edytujBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edytujBtnActionPerformed(evt);
            }
        });

        importBtn.setText("Import danych z xml");
        importBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importBtnActionPerformed(evt);
            }
        });

        wykonajBtn.setText("Wykonaj ");
        wykonajBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wykonajBtnActionPerformed(evt);
            }
        });

        wyczyscBtn.setText("Wyczyść");
        wyczyscBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wyczyscBtnActionPerformed(evt);
            }
        });

        bazaCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "KSIAZKA", "CZYTELNICY", "WYPOŻYCZ" }));

        polecenieCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SELECT", "INSERT", "DELETE" }));
        polecenieCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                polecenieComboActionPerformed(evt);
            }
        });

        plikMenu.setText("Plik");

        ladujMenuPlik.setText("Ładuj z pliku xml");
        ladujMenuPlik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ladujMenuPlikActionPerformed(evt);
            }
        });
        plikMenu.add(ladujMenuPlik);

        zamknijMenuPlik.setText("Zamknij");
        zamknijMenuPlik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zamknijMenuPlikActionPerformed(evt);
            }
        });
        plikMenu.add(zamknijMenuPlik);

        jMenuBar1.add(plikMenu);

        opcjeMenu.setText("Opcje");

        ustawieniaMenuOpcje.setText("Ustawienia");
        ustawieniaMenuOpcje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ustawieniaMenuOpcjeActionPerformed(evt);
            }
        });
        opcjeMenu.add(ustawieniaMenuOpcje);

        jMenuBar1.add(opcjeMenu);

        pomocMenu.setText("Pomoc");

        oProgramieMenuPomoc.setText("O programie");
        pomocMenu.add(oProgramieMenuPomoc);

        podrecznikMenuPomoc.setText("Podręcznik użytkownika");
        pomocMenu.add(podrecznikMenuPomoc);

        jMenuBar1.add(pomocMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(importBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(polaczBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edytujBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(polecenieCombo, 0, 98, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(wykonajBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bazaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(wyczyscBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(edytujBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(polaczBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(importBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(polecenieCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(bazaCombo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wykonajBtn)
                    .addComponent(wyczyscBtn))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void polecenieComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_polecenieComboActionPerformed
        if (polecenieCombo.getSelectedIndex() == 0 || polecenieCombo.getSelectedIndex() == 2) {
            textTA.setText("FROM");
            zapytanieTA.setText(";");
        } else {
            textTA.setText("INTO");
            zapytanieTA.setText("VALUES();");
        }
    }//GEN-LAST:event_polecenieComboActionPerformed

    private void zamknijMenuPlikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zamknijMenuPlikActionPerformed
        System.exit(0);
    }//GEN-LAST:event_zamknijMenuPlikActionPerformed

    private void polaczBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_polaczBtnActionPerformed
        try {
            if (this.polaczBtn.isSelected()) {
                this.polaczBtn.setText("Rozłącz");
                PolaczenieBaza.polaczeniezBaza();
                ladujMenuPlik.setEnabled(true);
                importBtn.setEnabled(true);
                textTA.enable();
                zapytanieTA.enable();
                polecenieCombo.enable();
                bazaCombo.enable();
                wykonajBtn.setEnabled(true);
                wyczyscBtn.setEnabled(true);
            } else {
                this.polaczBtn.setText("Połącz");
                PolaczenieBaza.rozlaczBaze();
                ladujMenuPlik.setEnabled(false);
                importBtn.setEnabled(false);
                textTA.disable();
                zapytanieTA.disable();
                polecenieCombo.disable();
                bazaCombo.disable();
                wykonajBtn.setEnabled(false);
                wyczyscBtn.setEnabled(false);

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Nie udało się połączyc z bazą danych",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_polaczBtnActionPerformed

    private void importBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importBtnActionPerformed
        try {
            try {
                ParserXML.parsujXML(new File(OperacjeNaBazie.wybierzPlikXML()));
                JOptionPane.showMessageDialog(null, ParserXML.ilerekordow(),
                        "Import danych z pilku zakończony powodzeniem. ",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (FileNotFoundException | XMLStreamException | SQLException |
                    HeadlessException ex) {
                JOptionPane.showMessageDialog(null,
                        "Możliwe że te dane znajdują się juz w bazie \n"
                        + ex.getMessage(),
                        "Nie udało się pobrac danych z pliku *.xml",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Nie wybrałeś pliku *.xml");
        }
    }//GEN-LAST:event_importBtnActionPerformed

    private void ustawieniaMenuOpcjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ustawieniaMenuOpcjeActionPerformed
        UstawieniaPolacz ustpol = new UstawieniaPolacz();
        ustpol.setVisible(true);
        ustpol.setResizable(false);
        ustpol.setLocationRelativeTo(null);
    }//GEN-LAST:event_ustawieniaMenuOpcjeActionPerformed

    private void ladujMenuPlikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ladujMenuPlikActionPerformed
        try {
            ParserXML.parsujXML(new File(OperacjeNaBazie.wybierzPlikXML()));
            JOptionPane.showMessageDialog(null, ParserXML.ilerekordow(),
                    "Import danych z pilku zakończony powodzeniem. ",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException | XMLStreamException | SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Możliwe że te dane znajdują się juz w bazie \n"
                    + ex.getMessage(),
                    "Nie udało się pobrac danych z pliku *.xml",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_ladujMenuPlikActionPerformed

    private void edytujBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edytujBtnActionPerformed
        UstawieniaPolacz ustpol = new UstawieniaPolacz();
        ustpol.setVisible(true);
        ustpol.setResizable(false);
        ustpol.setLocationRelativeTo(null);
    }//GEN-LAST:event_edytujBtnActionPerformed

    private void wykonajBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wykonajBtnActionPerformed

        try {
            // Pobieramy części zapytania z pol tekstowych i combo-boxów
            String a = (String) polecenieCombo.getSelectedItem();
            String b = textTA.getText();
            String c = (String) bazaCombo.getSelectedItem();
            String d = zapytanieTA.getText();
            //Sklejamy zapytanie
            String zapytanie = a + " * " + b + " " + c + " " + d;
            // pobieramy dane z bazy
            String[][] dane = OperacjeNaBazie.pobierzDaneZBazy(zapytanie);
            // pobieramy nazwe kolumn
            // String[] nazwyKolumn = OperacjeNaBazie.naglowkiKolumn(zapytanie);

            String[] nazwyKolumn = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
            this.uzupelnijTabele(dane, nazwyKolumn);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Niepoprawne zapytanie"
                    + ex.getMessage());
        }
    }//GEN-LAST:event_wykonajBtnActionPerformed

    private void wyczyscBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wyczyscBtnActionPerformed
        polecenieCombo.setSelectedIndex(0);
        bazaCombo.setSelectedIndex(0);
        zapytanieTA.setText("");
        textTA.setText("");
    }//GEN-LAST:event_wyczyscBtnActionPerformed
    /**
     * Metoda do dopasowywania tabeli przed umieszczeniem w niej danych.
     *
     * @param wiersze ilość wierszy
     * @param kolumny ilość kolumn
     * @param nazwy nazwy kolumn
     */
    private void uformujTabele(int wiersze, int kolumny, String[] nazwy) {

        //model.setRowCount(wiersze);
      //  model.setColumnCount(kolumny);

        //for (int i = 0; i < nazwy.length; i++) {
            tabelaWynikow.getTableHeader().getColumnModel().getColumn(0).
                    setHeaderValue(nazwy[0]);
      //  }
    }

    /**
     * Metoda do dopasowywania zawartości do kolumn.
     */
    private void dopasujKolumny() {
        Adjuster adjuster = new Adjuster(tabelaWynikow);
        adjuster.adjustColumns();
    }

    private void uzupelnijTabele(String[][] dane, String[] nazwyKolumn) {

        // Z pobranej tablicy wyciagamy: ilość wierszy i kolumn
        int wiersze = dane.length;
        int kolumny = dane[0].length;
        System.out.println(wiersze + " " + kolumny);

        // Na postawie ptrzymanych danych modyfikujemy konstrukcję tabeli:
        // określamy ilość jej wierszy i kolumn, a także nazwy kolumn
        uformujTabele(wiersze, kolumny, nazwyKolumn);

        // Następnie wypełniamy tabele danymi
        for (int i = 0; i < wiersze; i++) {
            for (int j = 0; j < kolumny; j++) {
                tabelaWynikow.setValueAt(dane[i][j], i - 1, j - 1);
            }
        }
        // Po wypełnieniu tabeli danymi dopasowywujemy dane do wyświetlania
        this.dopasujKolumny();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Okno okienko = new Okno();
        okienko.setVisible(true);
        okienko.setResizable(false);
        okienko.setLocationRelativeTo(null);
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox bazaCombo;
    private javax.swing.JButton edytujBtn;
    private javax.swing.JButton importBtn;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuItem ladujMenuPlik;
    private javax.swing.JMenuItem oProgramieMenuPomoc;
    private javax.swing.JMenu opcjeMenu;
    private javax.swing.JMenu plikMenu;
    private javax.swing.JMenuItem podrecznikMenuPomoc;
    private javax.swing.JToggleButton polaczBtn;
    private javax.swing.JComboBox polecenieCombo;
    private javax.swing.JMenu pomocMenu;
    private javax.swing.JTable tabelaWynikow;
    private javax.swing.JTextArea textTA;
    private javax.swing.JMenuItem ustawieniaMenuOpcje;
    private javax.swing.JButton wyczyscBtn;
    private javax.swing.JButton wykonajBtn;
    private javax.swing.JMenuItem zamknijMenuPlik;
    private javax.swing.JTextArea zapytanieTA;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel model;

}
