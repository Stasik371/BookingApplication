package logic.models.places;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;

@Data
@EqualsAndHashCode(callSuper = true)
public class RehearsalBase extends BasedClass {
    public ArrayList<RehearsalBase> rehearsalBases;
    private int powerOfVolume;
    private String commonFeatures;
    @Override
    public String toString() {
        return "RehearsalBase{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", pricePerHour=" + getPricePerHour() +
                ", freeDays=" + getFreeDays() +
                ", location='" + getLocation() + '\'' +
                ", feedBackStars=" + getFeedBackStars() +
                ", powerOfVolume='" + powerOfVolume + '\'' +
                ", commonFeatures=" + commonFeatures +
                '}';
    }
}
