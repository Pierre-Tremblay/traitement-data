package DAL;

import DAL.entityDAO.*;

public class DAOFactory {
    public static ActeurDAO getActeurDAO() {
        return new ActeurDAO();
    }

    public static FilmDAO getFilmDAO() {
        return new FilmDAO();
    }

    public static GenreDAO getGenreDAO() {
        return new GenreDAO();
    }

    public static LieuTournageDAO getLieuTournageDAO() {
        return new LieuTournageDAO();
    }

    public static PaysDAO getPaysDAO() {
        return new PaysDAO();
    }

    public static RealisateurDAO getRealisateurDAO() {
        return new RealisateurDAO();
    }
    public static RoleDAO getRoleDAO() {
        return new RoleDAO();
    }
}
