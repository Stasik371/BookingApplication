package logic.models.places;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class SportsComplex extends  BasedClass {
    private String sportType;
    private int countOfFans;
    private String allArea;
    private String workArea;
    @SerializedName("SportsComplexes")
    public ArrayList<SportsComplex>sportsComplexes;

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

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public int getCountOfFans() {
        return countOfFans;
    }

    public void setCountOfFans(int countOfFans) {
        this.countOfFans = countOfFans;
    }

    public String getAllArea() {
        return allArea;
    }

    public void setAllArea(String allArea) {
        this.allArea = allArea;
    }

    public String getWorkArea() {
        return workArea;
    }

    public void setWorkArea(String workArea) {
        this.workArea = workArea;
    }
}
