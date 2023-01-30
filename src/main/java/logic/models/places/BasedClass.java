package logic.models.places;

import java.time.DayOfWeek;
import java.util.List;

import lombok.Data;

public @Data
class BasedClass {
    private int id;
    private String name;
    private double pricePerHour;
    private List<DayOfWeek> freeDays;
    private String location;
    private byte feedBackStars;
    private String description;
    private String phoneNumber;
}
