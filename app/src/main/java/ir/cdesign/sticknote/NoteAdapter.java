package ir.cdesign.sticknote;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by amin pc on 01/10/2016.
 */
public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.Holder> {

    Context context;
    List<NoteModel> notes = new ArrayList<>();
    LayoutInflater inflater;

    public NoteAdapter(Context context , List<NoteModel> notes){
        this.context = context;
        this.notes = notes;
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
        NoteModel current = notes.get(position);
        holder.setData(current,position);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        NoteModel current;
        int position;
        TextView textView;

        public Holder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.note_text);
        }

        public void setData(final NoteModel current, final int position) {
            this.current = current;
            this.position = position;
            textView.setText(current.getNote());
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    DatabaseHandler dh = new DatabaseHandler(context);
                    dh.deleteContact(current);
                    notes.remove(position);
                    notifyItemRemoved(position);
                    notifyDataSetChanged();
                    return false;
                }
            });
        }
    }

}
