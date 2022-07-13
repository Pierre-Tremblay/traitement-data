package BLL;


import BLL.entityManager.ActeurManager;
import Entity.Acteur;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ActeurManager acteurManager = ActeurManager.getInstance();

        try {
            List<Acteur> acteurList = ReadFileManager.readJsonFile();
            for (Acteur acteur : acteurList) {
                acteurManager.create(acteur);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}