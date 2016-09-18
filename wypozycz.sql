CREATE DATABASE "C:\WYPOZYCZ.FDB"
user "SYSDBA" password "masterkey";

CREATE TABLE czytelnik(
id_czytelnik INTEGER NOT NULL PRIMARY KEY,
imie varchar(50) NOT NULL ,
nazwisko varchar(50) NOT NULL ,
miasto varchar(50) NOT NULL
); 

commit;

INSERT INTO czytelnik (id_czytelnik, imie, nazwisko, miasto) VALUES (1, 'Jan', 'Kowalski', 'Rzeszow');
INSERT INTO czytelnik (id_czytelnik, imie, nazwisko, miasto) VALUES (2, 'Jan', 'Nowak', 'Rzeszow');

commit;

CREATE TABLE ksiazka(
id_ksiazka INTEGER NOT NULL PRIMARY KEY,
tytul varchar(100) NOT NULL,
autor varchar(100) NOT NULL
);

commit;

INSERT INTO ksiazka (id_ksiazka, tytul, autor) VALUES (1, 'Lokomotywa', 'Julian Tuwim');
INSERT INTO ksiazka (id_ksiazka, tytul, autor) VALUES (2, 'Pan Tadeusz', 'Adam Mickiewicz');

commit;

CREATE TABLE wypozyczenie(
id_wypozyczenie INTEGER NOT NULL PRIMARY KEY,
id_czytelnik INTEGER NOT NULL,
id_ksiazka INTEGER NOT NULL,
status varchar(50)
);	  
	  
commit;
  
  
ALTER TABLE wypozyczenie  ADD CONSTRAINT FK_wypozyczenie_czytelnik FOREIGN KEY(id_czytelnik)
REFERENCES czytelnik;
 
commit; 
 
ALTER TABLE wypozyczenie  ADD CONSTRAINT FK_wypozyczenie_ksiazka FOREIGN KEY(id_ksiazka)
REFERENCES ksiazka;

commit;