package ir.cdesign.sticknote;

import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

/**
 * Created by amin pc on 01/10/2016.
 */
public class ColorPanelHandle {

    Activity activity;
    RecyclerView recyclerView;
    LinearLayout container;
    int recyclerViewHeight;
    ColorModel colors = new ColorModel();

    public ColorPanelHandle(Activity activity) {
        this.activity = activity;
        setPanel();
    }

    private void setPanel(){
        recyclerView = (RecyclerView) activity.findViewById(R.id.colorPanel);
        container = (LinearLayout) activity.findViewById(R.id.container);
        ColorPanelAdapter adapter = new ColorPanelAdapter(activity,colors.getColorList());
        GridLayoutManager glm = new GridLayoutManager(activity , 4);
        recyclerView.setLayoutManager(glm);
        recyclerView.setAdapter(adapter);
        recyclerViewHeight = container.getHeight();
        container.setY(-recyclerViewHeight);
    }

    public void openPanel() {
        Log.d("amin","opening color panel");
        container.animate().yBy(-recyclerViewHeight).start();
    }

    public void closePanel() {

    }

}
