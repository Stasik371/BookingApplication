package logic.models.places;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;

@Data
@EqualsAndHashCode(callSuper = true)
public class RehearsalBase extends BasedClass {
    public ArrayList<RehearsalBase> rehearsalBases;
    private int powerOfVolume;
    private String commonFeatures;

}
