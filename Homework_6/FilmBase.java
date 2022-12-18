package Homework_6;

import java.util.ArrayList;
import java.util.Scanner;

public class FilmBase {
  public static void main(String[] args) {
    Infrastructure infrastructure = new Infrastructure();
    /*
     * System.out.println(infrastructure.getAllInfo(1));
     * System.out.println(infrastructure.getAllInfo(2));
     * System.out.println(infrastructure.getAllInfo(3));
     * System.out.println(infrastructure.getAllInfo(4));
     * System.out.println(infrastructure.getAllInfo(5));
     * System.out.println(infrastructure.getAllInfo(6));
     */
    System.out.println(infrastructure.printList(infrastructure.findAll()));
  }
}

class Infrastructure {
  public Infrastructure() {
    init();
  }

  Db db;

  public Db getDb() {
    return db;
  }

  public String getAllInfo(int idCinema) {
    Cinema c = db.films.get(idCinema - 1);

    return String.format("%d %s %s %s",
        c.id,
        c.name,
        db.genres.get(c.genre - 1).name,
        db.prod.get(c.filmProd - 1).titleName);
  }

  Db init() {
    db = new Db();
    Cinema c1 = new Cinema(1, "Ironman", 1, 1);
    Cinema c2 = new Cinema(2, "Spiderman", 1, 2);
    Cinema c3 = new Cinema(3, "Tenet", 3, 4);
    Cinema c4 = new Cinema(4, "Serenity", 3, 3);
    Cinema c5 = new Cinema(5, "Superman", 1, 3);
    Cinema c6 = new Cinema(6, "Antman", 1, 1);

    db.films.add(c1);
    db.films.add(c2);
    db.films.add(c3);
    db.films.add(c4);
    db.films.add(c5);
    db.films.add(c6);

    db.genres.add(new Genre(1, "Comics"));
    db.genres.add(new Genre(2, "Comedy"));
    db.genres.add(new Genre(3, "Fantastic"));
    FilmProducerFactory pf = new FilmProducerFactory();
    db.addFilmProducer(pf.getFilmProducer("Marvel"));
    db.addFilmProducer(pf.getFilmProducer("Sony"));
    db.addFilmProducer(pf.getFilmProducer("MGM"));
    db.addFilmProducer(pf.getFilmProducer("DC"));

    return db;
  }

  public ArrayList<String> findAll() {
    ArrayList<String> searchRes = new ArrayList<>();
    Scanner mSc = new Scanner(System.in);
    System.out.print("Enter part of the film's title: ");
    String request = mSc.next();
    for (int i = 0; i < db.films.size(); i++) {
      Cinema c = db.films.get(i);
      if (c.name.toLowerCase().contains(request)) {
        searchRes.add(c.name);
      }
    }
    return searchRes;
  }

  public String printList(ArrayList<String> list) {
    String res = "";
    for (int i = 0; i < list.size(); i++) {
      res += list.get(i) + "\n";
    }
    return res;
  }
}

class Db {
  ArrayList<Cinema> films = new ArrayList<>();
  ArrayList<FilmProducer> prod = new ArrayList<>();
  ArrayList<Genre> genres = new ArrayList<>();

  public void addFilmProducer(FilmProducer producer) {
    prod.add(producer);
  }
}

class Cinema {
  int id;
  int filmProd;
  String name;
  int genre;

  public Cinema(int id, String name, int genre, int filmProd) {
    this.id = id;
    this.filmProd = filmProd;
    this.name = name;
    this.genre = genre;
  }
}

class FilmProducer {
  int id;
  String titleName;
}

class Genre {
  int id;
  String name;

  public Genre(int id, String name) {
    this.id = id;
    this.name = name;
  }
}

class FilmProducerFactory {
  int count = 1;

  public FilmProducer getFilmProducer(String name) {
    FilmProducer fp = new FilmProducer();
    fp.id = count++;
    fp.titleName = name;
    return fp;
  }

}
