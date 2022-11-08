package logic.datastructures;

import logic.models.places.ConcertHall;
import logic.models.places.Loft;
import logic.models.places.RehearsalBase;
import logic.models.places.SportsComplex;
import java.util.ArrayList;

public class DataStructureSingleton {
    private static ArrayList<ConcertHall> concertHalls;
    private static ArrayList<Loft> lofts;
    //@SerializedName("SportsComplex")
    private static ArrayList<SportsComplex> sportsComplexes;
    private static ArrayList<RehearsalBase> rehearsalBases;

    public static ArrayList<ConcertHall> getConcertHalls() {
        if (concertHalls == null) {
            concertHalls = new ArrayList<ConcertHall>();;
        }
        return concertHalls;
    }

    public static ArrayList<Loft> getLofts() {
        if (lofts == null) {
            lofts = new ArrayList<Loft>();;
        }
        return lofts;
    }

    public static ArrayList<SportsComplex> getSportsComplexes() {
        if (sportsComplexes == null) {
            sportsComplexes = new ArrayList<SportsComplex>();;
        }
        return sportsComplexes;
    }

    public static ArrayList<RehearsalBase> getRehearsalBases() {
        if (rehearsalBases == null) {
            rehearsalBases = new ArrayList<RehearsalBase>();;
        }
        return rehearsalBases;
    }
}
