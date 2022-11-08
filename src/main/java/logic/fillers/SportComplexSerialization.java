package logic.fillers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import logic.datastructures.DataStructureSingleton;
import logic.models.places.SportsComplex;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public final class SportComplexSerialization implements Filler<SportsComplex> {
    private static final Type listSportComplexesType =
            new TypeToken<ArrayList<SportsComplex>>() {
            }.getType();

    public Collection<SportsComplex> fillFromJson() {
        try {
            return new Gson().fromJson(new BufferedReader(new
                            FileReader("src/main/resources/placesJSON/SportsComplex.json")),
                    listSportComplexesType);
        }
        catch (FileNotFoundException e){
            System.out.println(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }
    @Override
    public void arrayFill(@NotNull Collection<SportsComplex> places){
        for (SportsComplex object: places) {
            DataStructureSingleton.getSportsComplexes().add(object);
        }
    }
}
