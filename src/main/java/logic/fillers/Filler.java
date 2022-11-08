package logic.fillers;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;


public interface Filler<T> {
    Collection<T> fillFromJson();
    void arrayFill(@NotNull Collection<T> places);

}
