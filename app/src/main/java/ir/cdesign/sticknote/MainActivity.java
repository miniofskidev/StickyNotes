package ir.cdesign.sticknote;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView noteView;
    List<NoteModel> notes;
    DatabaseHandler databaseHandler;
    NoteAdapter adapter;

    Button submit , colorPanleButton;
    EditText textField;

    String text;

    ColorPanelHandle panel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_main);

        databaseHandler = new DatabaseHandler(this);

        init();

        setRecycler();

        panel = new ColorPanelHandle(this);
//        panel.openPanel();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.submit:
                text = String.valueOf(textField.getText());
                NoteModel noteModel = new NoteModel();
                noteModel.setNote(text);
                textField.setText("");
                databaseHandler.addContact(noteModel);
                notes = databaseHandler.getAllContacts();
                noteView.setAdapter(new NoteAdapter(this ,notes));
                hideKeyBoard();
                break;
            case R.id.colorPanelButton:
                Log.d("amin","color panel clicked ");
                panel.openPanel();
                break;
        }
    }

    private void init(){
        submit = (Button) findViewById(R.id.submit);
        colorPanleButton= (Button) findViewById(R.id.colorPanelButton);
        textField = (EditText) findViewById(R.id.textField);

        submit.setOnClickListener(this);
        colorPanleButton.setOnClickListener(this);
    }

    private void setRecycler(){
        noteView = (RecyclerView) findViewById(R.id.recycler);
        notes = databaseHandler.getAllContacts();
        adapter = new NoteAdapter(this,notes);
        GridLayoutManager glm = new GridLayoutManager(this,3);
        noteView.setLayoutManager(glm);
        noteView.setAdapter(adapter);
    }

    private void hideKeyBoard(){
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}
