package ir.cdesign.sticknote;

/**
 * Created by amin pc on 01/10/2016.
 */
public class NoteModel {

    String note;
    int id;

    public NoteModel(){

    }

    public NoteModel(int id, String note) {
        this.id = id ;
        this.note = note ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
