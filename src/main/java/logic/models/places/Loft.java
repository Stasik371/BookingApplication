package logic.models.places;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
@Data
@EqualsAndHashCode(callSuper = true)
public class Loft extends BasedClass{
    public ArrayList<Loft> lofts;
    private int area;
    private String style;
}
