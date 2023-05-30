package sg.edu.rp.c346.id22013080.democontextmenutranslation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvTranslatedText;
    TextView tvTranslatedText2;
    String wordClick = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText = findViewById(R.id.textViewTranslatedText);
        tvTranslatedText2 = findViewById(R.id.textViewTranslatedText2);

        registerForContextMenu(tvTranslatedText);
        registerForContextMenu(tvTranslatedText2);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main, menu);

        if(v == tvTranslatedText){
            wordClick = "hello";
        }
        else if(v == tvTranslatedText2){
            wordClick = "bye";
        }



    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(wordClick.equalsIgnoreCase("hello")){
            if (id == R.id.EnglishSelection) {
                tvTranslatedText.setText("Hello ");
                return true;
            } else if (id == R.id.italianSelection) {
                tvTranslatedText.setText("Ciao");
                return true;
            } else {
                tvTranslatedText.setText("Error translation");
            }

        }
        else if (wordClick.equalsIgnoreCase("bye")) {
            if (id == R.id.EnglishSelection) {
                tvTranslatedText2.setText("Bye");
                return true;
            } else if (id == R.id.italianSelection) {
                tvTranslatedText2.setText("Addios");
                return true;
            } else {
                tvTranslatedText2.setText("Error translation");
            }
        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }


}