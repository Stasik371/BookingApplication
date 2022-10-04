package logic.fillers;

import logic.models.enums.Days;
import logic.models.places.SportsComplex;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JsonFiller {
    private static final String TAG_NAME = "name";
    private static final String TAG_PLACES = "places";
    private static final String TAG_ID = "id";
    private static final String TAG_PRICE_PER_HOUR = "pricePerHour";
    private static final String TAG_LOCATION = "location";
    private static final String TAG_FEEDBACK_STARS = "feedBackStars";
    private static final String TAG_FREE_DAY = "freeDay";
    private static final String TAG_SPORT_TYPE = "sportType";
    private static final String TAG_COUNT_OF_FANS = "countOfFans";
    private static final String TAG_ALL_AREA = "allArea";
    private static final String TAG_WORK_AREA = "workArea";

    public void sportComplexJSONfill(List<SportsComplex> sportComplexArr) {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("src/main/java/logic/fillers/SportsComplex.json")) {
            JSONObject rootJsonObject = (JSONObject) parser.parse(reader);
            String name = (String) rootJsonObject.get(TAG_NAME);
            if (!Objects.equals(name, "SportsComplex")) {
                throw new Exception("File is not correct");
            }
            JSONArray JSONSportComplexArray = (JSONArray) rootJsonObject.get(TAG_PLACES);
            for (Object item : JSONSportComplexArray) {
                JSONObject place = (JSONObject) item;
                SportsComplex sportsComplex = new SportsComplex();
                sportsComplex.setName((String) place.get(TAG_NAME));
                long buffer = (Long) place.get(TAG_ID); //error with JSON long type
                sportsComplex.setId((int) buffer);
                sportsComplex.setPricePerHour((double) place.get(TAG_PRICE_PER_HOUR));
                sportsComplex.setLocation((String) place.get(TAG_LOCATION));
                buffer = (Long) place.get(TAG_FEEDBACK_STARS);
                sportsComplex.setFeedBackStars((byte) buffer);
                sportsComplex.setFreeDays((List<Days>) place.get(TAG_FREE_DAY));
                sportsComplex.setSportType((String) place.get(TAG_SPORT_TYPE));
                buffer = (Long) place.get(TAG_COUNT_OF_FANS);
                sportsComplex.setCountOfFans((int) buffer);
                sportsComplex.setAllArea((String) place.get(TAG_ALL_AREA));
                sportsComplex.setWorkArea((String) place.get(TAG_WORK_AREA));
                sportComplexArr.add(sportsComplex);
            }

        } catch (Exception e) {
            System.err.println("Parsing SportsComplex Error " + e.toString());
        }

    }
}
