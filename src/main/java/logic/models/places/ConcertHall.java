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

    @Override
    public String toString() {
        return "ConcertHall{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", pricePerHour=" + getPricePerHour() +
                ", freeDays=" + getFreeDays() +
                ", location='" + getLocation() + '\'' +
                ", feedBackStars=" + getFeedBackStars() +
                ", soundPower='" + soundPower + '\'' +
                ", countOFFans=" + countOfFans +
                '}';
    }
}
