package ir.cdesign.sticknote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<NoteModel> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_main);

        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        notes = databaseHandler.getAllContacts();
        
        setRecycler();
    }

    private void setRecycler(){
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        NoteAdapter adapter = new NoteAdapter(this,notes);
        GridLayoutManager glm = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(glm);
        recyclerView.setAdapter(adapter);
    }
}
