package logic.models.places;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ConcertHall extends RehearsalBase {
    public ArrayList<ConcertHall> concertHalls;
    private int soundPower;
    private int countOfFans;
}
