package logic.fillers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import logic.datastructures.DataStructureSingleton;
import logic.models.places.ConcertHall;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ConcertHallSerialization implements Filler<ConcertHall> {
    private static final Type listConcertHallsType =
            new TypeToken<ArrayList<ConcertHall>>() {
            }.getType();

    public Collection<ConcertHall> fillFromJson() {
        try {
            return new Gson().fromJson(new BufferedReader(new
                            FileReader("src/main/resources/placesJSON/ConcertHalls.json")),
                    listConcertHallsType);
        }
        catch (FileNotFoundException e){
            System.out.println(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }
    @Override
    public void arrayFill(@NotNull Collection<ConcertHall> places){
        for (ConcertHall object: places) {
            DataStructureSingleton.getConcertHalls().add(object);
        }
    }
}
