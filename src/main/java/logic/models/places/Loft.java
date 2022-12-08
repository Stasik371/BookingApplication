package logic.models.places;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Loft extends BasedClass {
    public ArrayList<Loft> lofts;
    private int area;
    private String style;

    @Override
    public String toString() {
        return "Loft{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", pricePerHour=" + getPricePerHour() +
                ", freeDays=" + getFreeDays() +
                ", location='" + getLocation() + '\'' +
                ", feedBackStars=" + getFeedBackStars() +
                ", area='" + area + '\'' +
                ", style=" + style +
                '}';
    }
}
