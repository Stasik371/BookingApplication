package logic.models.places;

import logic.models.enums.Days;

import java.util.List;
import lombok.Data;

public @Data class BasedClass {
    private int id;
    private String name;
    private double pricePerHour;
    private List<Days> freeDays;
    private String location;
    private byte feedBackStars;

}
