package ir.cdesign.sticknote;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amin pc on 01/10/2016.
 */
public class ColorPanelAdapter extends RecyclerView.Adapter<ColorPanelAdapter.Holder> {

    Context context;
    LayoutInflater inflater;
    List<ColorModel> colors = new ArrayList<>();

    public ColorPanelAdapter(Context context , List<ColorModel> colors){
        this.context = context;
        this.colors = colors;
        this.inflater = inflater.from(context);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_layout,parent,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        ColorModel current = colors.get(position);
        holder.setData(current , position);
    }

    @Override
    public int getItemCount() {
        return colors.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        ColorModel current;
        int position;
        CardView card;

        public Holder(View itemView) {
            super(itemView);
            card = (CardView) itemView.findViewById(R.id.card);
        }

        public void setData(ColorModel current, int position) {
            this.current = current;
            this.position = position;
            card.setCardBackgroundColor(current.getColorId());
        }
    }
}
