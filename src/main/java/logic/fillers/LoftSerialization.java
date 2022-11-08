package logic.fillers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import logic.datastructures.DataStructureSingleton;
import logic.models.places.Loft;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class LoftSerialization implements Filler<Loft> {
    private static final Type listLoftsType =
            new TypeToken<ArrayList<Loft>>() {
            }.getType();

    public Collection<Loft> fillFromJson() {
        try {
            return new Gson().fromJson(new BufferedReader(new
                            FileReader("src/main/resources/placesJSON/Lofts.json")),
                    listLoftsType);
        }
        catch (FileNotFoundException e){
            System.out.println(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }
    @Override
    public void arrayFill(@NotNull Collection<Loft> places){
        for (Loft object: places) {
            DataStructureSingleton.getLofts().add(object);
        }
    }
}
