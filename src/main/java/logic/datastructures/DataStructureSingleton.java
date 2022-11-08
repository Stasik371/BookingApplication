package logic.datastructures;


import logic.models.places.ConcertHall;
import logic.models.places.Loft;
import logic.models.places.RehearsalBase;
import logic.models.places.SportsComplex;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DataStructureSingleton {
    private static DataStructureSingleton obj;

    public static ArrayList<ConcertHall> getConcertHalls() {
        return concertHalls;
    }

    public static void setConcertHalls(ArrayList<ConcertHall> concertHalls) {
        DataStructureSingleton.concertHalls = concertHalls;
    }

    public static ArrayList<Loft> getLofts() {
        return lofts;
    }

    public static void setLofts(ArrayList<Loft> lofts) {
        DataStructureSingleton.lofts = lofts;
    }

    public static ArrayList<SportsComplex> getSportsComplexes() {
        return sportsComplexes;
    }

    public static void setSportsComplexes(ArrayList<SportsComplex> sportsComplexes) {
        DataStructureSingleton.sportsComplexes = sportsComplexes;
    }

    public static ArrayList<RehearsalBase> getRehearsalBases() {
        return rehearsalBases;
    }

    public static void setRehearsalBases(ArrayList<RehearsalBase> rehearsalBases) {
        DataStructureSingleton.rehearsalBases = rehearsalBases;
    }

    private static ArrayList<ConcertHall> concertHalls;
    private static ArrayList<Loft> lofts;
    private static ArrayList<SportsComplex> sportsComplexes;
    private static ArrayList<RehearsalBase> rehearsalBases;
    private DataStructureSingleton(){
        concertHalls = new ArrayList<>();
        lofts = new ArrayList<>();
        sportsComplexes = new ArrayList<>();
        rehearsalBases = new ArrayList<>();
    }
    public static DataStructureSingleton getObject(){
        if(obj==null){
            obj=new DataStructureSingleton();
        }
        return obj;
    }
}
