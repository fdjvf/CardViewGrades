package co.edu.uninorte.cardviewgrades;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<gradesubject> ListElements;
     int i=2;
    private ListView MyListView;
    private NewRow temp;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListElements =new ArrayList<gradesubject>();
                ListElements.add(new gradesubject("Materia 1"));


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String mat="Materia "+i;
             i=i+1;
                ListElements.add(new gradesubject(mat));
                temp.Data = ListElements;
                MyListView.setAdapter(temp);
            }
        });

        MyListView=(ListView) findViewById(R.id.MyListView);
        temp = new NewRow(this, ListElements);
        MyListView.setAdapter(temp);

        MyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Elemento : " + position, Toast.LENGTH_SHORT).show();

//Podemos agregarle un evento de click a cada de uno de los items de tal forma que e
// Estos realicen operaciones diferentes, y cada elemento lo poemos identificar con ayudar del id

            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
          gradesubject temp=(gradesubject) data.getSerializableExtra("Result");

            ListElements.get(temp.Index).Gr1=temp.Gr1;
            ListElements.get(temp.Index).Gr2=temp.Gr2;
            ListElements.get(temp.Index).Gr3=temp.Gr3;
            ListElements.get(temp.Index).Gr4=temp.Gr4;
//La actividad devolvio un ok y se procece normalmente
        } else if (requestCode == RESULT_CANCELED) {
//Probablemente la activiades recibir un error y se cerro
        }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void ActionRow(View view) {

        Toast.makeText(this, "HALPPP ", Toast.LENGTH_SHORT).show();//ALFINNNNNN
    }
}
