package BLL;

import Entity.Acteur;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Classe ReadFileManager qui permet la gestion d'un fichier JSON et
 * d'en récupéré les informations sous forme d'un objet Java
 */
public class ReadFileManager {
    /**
     * Méthode readJsonFile qui permet la gestion d'un fichier JSON et
     * d'en récupéré les informations sous forme d'un objet Java avec un
     * retour sous la forme List<Acteur></Acteur>
     */
    public static List<Acteur> readJsonFile() throws IOException {
        String RESOURCES_PATH = "src/main/resources/";
        String JSON_PATH = "films.json";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.readValue(new File(RESOURCES_PATH + JSON_PATH), new TypeReference<>() {
        });
    }
}
