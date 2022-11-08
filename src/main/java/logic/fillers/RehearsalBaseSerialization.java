package logic.fillers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import logic.datastructures.DataStructureSingleton;
import logic.models.places.RehearsalBase;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class RehearsalBaseSerialization implements Filler<RehearsalBase> {
    private static final Type listRehearsalBasesType =
            new TypeToken<ArrayList<RehearsalBase>>() {
            }.getType();

    public Collection<RehearsalBase> fillFromJson() {
        try {
            return new Gson().fromJson(new BufferedReader(new
                            FileReader("src/main/resources/placesJSON/RehearsalBases.json")),
                    listRehearsalBasesType);
        }
        catch (FileNotFoundException e){
            System.out.println(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }
    @Override
    public void arrayFill(@NotNull Collection<RehearsalBase> places){
        for (RehearsalBase object: places) {
            DataStructureSingleton.getRehearsalBases().add(object);
        }
    }
}
