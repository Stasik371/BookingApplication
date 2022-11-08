package logic.models.places;

import logic.fillers.*;
import logic.models.enums.TypesOfSquares;
import org.jetbrains.annotations.NotNull;


import java.util.Objects;

public class SquaresFactory {
    public static void createSquare(@NotNull TypesOfSquares type) {
        switch (type) {
            case Loft -> new LoftSerialization().arrayFill(
                    Objects.requireNonNull(new LoftSerialization()
                            .fillFromJson()));
            case ConcertHall -> new ConcertHallSerialization().arrayFill(
                    Objects.requireNonNull(new ConcertHallSerialization()
                            .fillFromJson()));
            case RehearsalBase -> new RehearsalBaseSerialization().arrayFill(
                    Objects.requireNonNull(new RehearsalBaseSerialization()
                            .fillFromJson()));
            case SportsComplex -> new SportComplexSerialization().arrayFill(
                    Objects.requireNonNull(new SportComplexSerialization()
                            .fillFromJson()));
        }
    }
}

