package logic.models.places;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public @Data class SportsComplex extends  BasedClass {
    private final String sportType;
    private final int countOfFans;
    private final String allArea;
    private final String workArea;

    public final ArrayList<SportsComplex>sportsComplexes;

    @Override
    public String toString() {
        return "SportsComplex{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", pricePerHour=" + getPricePerHour() +
                ", freeDays=" + getFreeDays() +
                ", location='" + getLocation() + '\'' +
                ", feedBackStars=" + getFeedBackStars() +
                "sportType='" + sportType + '\'' +
                ", countOfFans=" + countOfFans +
                ", allArea=" + allArea +
                ", workArea=" + workArea +
                '}';
    }
}
