package BLL;


import BLL.entityManager.ActeurManager;
import BLL.entityManager.FilmManager;
import BLL.entityManager.RealisateurManager;
import Entity.Acteur;
import Entity.Film;
import Entity.Realisateur;
import Entity.Role;

import java.util.List;

public class Acquisition {
    public static void main(String[] args) {
        ActeurManager acteurManager = ActeurManager.getInstance();
        FilmManager filmManager = FilmManager.getInstance();
        RealisateurManager realisateurManager = RealisateurManager.getInstance();
        try {
            List<Acteur> acteurList = ReadFileManager.readJsonFile();

            for (Acteur acteur : acteurList) {

                for (Role role : acteur.getRoles()) {
                    for (Film film : role.getFilms()) {
                        for (Acteur acteurDuFilm : film.getActeurs()) {
                            acteurManager.create(acteurDuFilm);
                        }
                        for (Realisateur realisateur : film.getRealisateurs()) {
                            realisateurManager.create(realisateur);
                        }
                        filmManager.create(film);
                    }
//                    acteurManager.create(acteur);

                }

            }

            System.out.println(acteurList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}