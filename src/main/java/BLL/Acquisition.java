package BLL;


import java.util.List;

import BLL.entityManager.ActeurManager;
import BLL.entityManager.FilmManager;
import BLL.entityManager.PaysManager;
import BLL.entityManager.RealisateurManager;
import BLL.entityManager.RoleManager;
import Entity.Acteur;
import Entity.Film;
import Entity.Realisateur;
import Entity.Role;

public class Acquisition {
    public static void main(String[] args) {
        ActeurManager acteurManager = ActeurManager.getInstance();
        FilmManager filmManager = FilmManager.getInstance();
        RealisateurManager realisateurManager = RealisateurManager.getInstance();
        RoleManager roleManager = RoleManager.getInstance();
        PaysManager paysManager = PaysManager.getInstance();
        		
        try {
            List<Acteur> acteurList = ReadFileManager.readJsonFile();

            for (Acteur acteur : acteurList) {
            	System.out.println(acteur);
                for (Role role : acteur.getRoles()) {
                    for (Film film : role.getFilms()) {
                    	
                    	if (film.getPays()!=null) {
                    		paysManager.create(film.getPays());
                    	}
                    	
                        for (Acteur acteurDuFilm : film.getActeurs()) {
                            acteurManager.create(acteurDuFilm);
                        }
                        
                        for (Realisateur realisateur : film.getRealisateurs()) {
                            realisateurManager.create(realisateur);
                        }
                        
                        filmManager.create(film);
                    }
                    roleManager.create(role);                 
                }
                acteurManager.create(acteur);
            }

//            System.out.println(acteurList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}