import BLL.BLLException;
import BLL.entityManager.ActeurManager;
import BLL.entityManager.FilmManager;
import Entity.Acteur;
import Entity.Film;

import java.util.List;
import java.util.Scanner;

public class AppSearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        FilmManager filmManager = FilmManager.getInstance();
        ActeurManager acteurManager = ActeurManager.getInstance();
        int userChoice = 0;
        do {
            Menu();
            userChoice = scan.nextInt();
            switch (userChoice) {
                case 1 -> {
//                    Filmographie d'un acteur
                    System.out.println("Quel acteur souhaitez-vous consulter ? ");
                    scan.nextLine();
                    String acteur = scan.nextLine();
                    System.out.println("Vous consultez " + acteur + " : ");
                    try {
                        List<Film> filmsByActor = filmManager.getFilmsByActor(acteur);
                        for (Film film : filmsByActor) {
                            System.out.println("- " + film.getNom() + " (" + film.getAnneeSortie() + ")");
                        }
                    } catch (BLLException e) {
                        throw new RuntimeException(e);
                    }

                }
                case 2 -> {
//                    Casting d'un film
                    System.out.println("Quel casting de film souhaitez-vous consulter ? ");
                    scan.nextLine();
                    String film = scan.nextLine();
                    System.out.println("Vous consultez le casting du film " + film + " : ");
                    try {
                        List<Acteur> acteurs = acteurManager.selectActorsByFilm(film);
                        for (Acteur acteur : acteurs) {
                            System.out.println("- " + acteur.getIdentite() + "(" + acteur.getRoles() + ")");
                        }
                    } catch (BLLException e) {
                        throw new RuntimeException(e);
                    }

                }
                case 3 -> {
//                    Films sortis entre 2 ann??es
                    scan.nextLine();
                    System.out.println("Merci de saisir la premi??re ann??e");
                    String firstDate = scan.nextLine();
                    System.out.println("Merci de saisir la second ann??e");
                    String secondDate = scan.nextLine();
                    System.out.println("Les films sortis entre " + firstDate + " - " + secondDate + " : ");
                    try {
                        List<Film> films = filmManager.selectFilmsByTwoDate(firstDate, secondDate);
                        for (Film film : films) {
                            System.out.println("- " + film.getNom() + " (" + film.getAnneeSortie() + ")");
                        }

                    } catch (BLLException e) {
                        throw new RuntimeException(e);
                    }

                }
                case 4 -> {
//                    Films communs ?? 2 acteurs/actrices
                    System.out.println("Merci de saisir le premier acteur");
                    scan.nextLine();
                    String firstActeur = scan.nextLine();
                    System.out.println("Merci de saisir le second acteur");
                    String secondActeur = scan.nextLine();
                    System.out.println("Les acteurs " + firstActeur + " et " + secondActeur + " ont en commun: ");
                    try {
                        List<Film> films = filmManager.selectFilmsBetweenTwoActors(firstActeur, secondActeur);
                        for (Film film : films) {
                            System.out.println("- " + film.getNom() + " (" + film.getAnneeSortie() + ")");
                        }

                    } catch (BLLException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 5 -> {
//                    Affichage des acteurs communs ?? 2 films donn??s
                    System.out.println("Merci de saisir le premier film");
                    scan.nextLine();
                    String firstFilm = scan.nextLine();
                    System.out.println("Merci de saisir le second film");
                    String secondFilm = scan.nextLine();
                    System.out.println("Les films " + firstFilm + " et " + secondFilm + " ont les acteurs suivant en commun: ");
                    try {
                        List<Acteur> acteurs = acteurManager.selectActorsBetweenTwoFilms(firstFilm, secondFilm);
                        for (Acteur acteur : acteurs) {
                            System.out.println("- " + acteur.getIdentite());
                        }

                    } catch (BLLException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 6 -> {
//                    Films sortis entre 2 ann??es et qui ont un acteur/actrice commun au casting
                    scan.nextLine();
                    System.out.println("Merci de renseigner l'acteur ?? retrouver dans un film");
                    String acteurResearch = scan.nextLine();
                    System.out.println("Merci de saisir la premi??re ann??e");
                    String firstYearResearch = scan.nextLine();
                    System.out.println("Merci de saisir la second ann??e");
                    String secondYearResearch = scan.nextLine();
                    System.out.println("Vous recherchez " + acteurResearch + " apparu dans au moins un film entre " + firstYearResearch + "  et " + secondYearResearch);
                    try {
                        List<Film> films = filmManager.selectFilmsByTwoDateWithActor(firstYearResearch,secondYearResearch, acteurResearch);
                        for (Film film : films) {
                            System.out.println("- " + film.getNom());
                        }

                    } catch (BLLException e) {
                        throw new RuntimeException(e);
                    }
                }

//                Sortir
                case 7 -> System.out.println("A une prochaine fois !");
            }
        } while (userChoice < 7 && userChoice > 0);
        scan.close();
    }

    private static void Menu() {
        System.out.println("--- Menu ---");
        System.out.println("1. Affichage de la filmographie d???un acteur donn??");
        System.out.println("2. Affichage du casting d???un film donn??");
        System.out.println("3. Affichage des films sortis entre 2 ann??es donn??es");
        System.out.println("4. Affichage des films communs ?? 2 acteurs/actrices donn??s");
        System.out.println("5. Affichage des acteurs communs ?? 2 films donn??s");
        System.out.println("6. Affichage des films sortis entre 2 ann??es donn??es et qui ont un acteur/actrice donn?? au \n" +
                "casting");
        System.out.println("7. Sortie");
    }
}

