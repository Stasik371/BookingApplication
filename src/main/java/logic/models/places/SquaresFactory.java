package logic.models.places;

import logic.datastructures.DataStructureSingleton;
import logic.fillers.JsonFiller;
import logic.models.enums.TypesOfSquares;

public class SquaresFactory {
    public static void createSquare(TypesOfSquares type) {
        JsonFiller jsonFiller = new JsonFiller();
        DataStructureSingleton dataStructureSingleton = DataStructureSingleton.getObject();
        switch (type) {
            case Loft -> jsonFiller.loftJSONFill(DataStructureSingleton.getLofts());
            case ConcertHall -> jsonFiller.concertHallJSONFill(DataStructureSingleton.getConcertHalls());
            case RehearsalBase -> jsonFiller.rehearsalBaseJSONFill(DataStructureSingleton.getRehearsalBases());
            case SportsComplex -> jsonFiller.sportComplexJSONFill(DataStructureSingleton.getSportsComplexes());
        }


    }
}
