package ir.cdesign.sticknote;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amin pc on 01/10/2016.
 */
public class ColorModel {

    int colorId;

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public List<ColorModel> getColorList(){
        List<ColorModel> colors = new ArrayList<>();

        int[] colorsCode = new int[]{
          R.color.colorBlue     ,    R.color.colorBlueGrey      ,    R.color.colorBrown      ,
          R.color.colorCyan     ,    R.color.colorDeepOrange    ,    R.color.colorDeepPurple ,
        };

        for (int i = 0 ; i < colorsCode.length ; i++){
            ColorModel colorModel = new ColorModel();
            colorModel.setColorId(colorsCode[i]);
            colors.add(colorModel);
        }

        return colors;
    }

}
