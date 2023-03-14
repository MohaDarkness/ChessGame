package color;

import color.colors.Black;
import color.colors.White;

import java.util.ArrayList;

public class ColorsCreator {
    private final ArrayList<Color> availableColors = new ArrayList<>();

    public ColorsCreator(){
        availableColors.add(new White());
        availableColors.add(new Black());
    }

    public ArrayList<Color> getColors(String[] colors) throws Exception {
        ArrayList<Color> colorsToReturn = new ArrayList<>();

        for(String wantedColor : colors) {
            for (Color avColor : availableColors) {
                if (wantedColor.equals(avColor.getColorName())){
                    colorsToReturn.add(avColor);
                    break;
                }
            }
        }
        if(colors.length != colorsToReturn.size())
            throw new Exception("Invalid color from settings!!");

        return colorsToReturn;
    }
}
