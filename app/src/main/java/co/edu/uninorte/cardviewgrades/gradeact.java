package co.edu.uninorte.cardviewgrades;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import co.edu.uninorte.cardviewgrades.R;

public class gradeact extends AppCompatActivity {
    gradesubject mysubject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gradeact);


        //Inicializar mysubject

         mysubject=(gradesubject)getIntent().getSerializableExtra("Element");
        ((EditText) findViewById(R.id.Gr1)).setText(mysubject.Gr1+"");
        ((EditText) findViewById(R.id.Gr2)).setText(mysubject.Gr2+"");
        ((EditText) findViewById(R.id.Gr3)).setText(mysubject.Gr3+"");
        ((EditText) findViewById(R.id.Gr4)).setText(mysubject.Gr4+"");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.back);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent T = getIntent();
                T.putExtra("Result",mysubject);
                setResult(RESULT_OK,T);
                finish();
            }
        });
    }

    public void ActionDef(View view) {
        TextView gr=(TextView) findViewById(R.id.textView5);


        mysubject.Gr1=Float.parseFloat(((EditText) findViewById(R.id.Gr1)).getText().toString());
        mysubject.Gr2=Float.parseFloat(((EditText) findViewById(R.id.Gr2)).getText().toString());
        mysubject.Gr3=Float.parseFloat(((EditText) findViewById(R.id.Gr3)).getText().toString());
        mysubject.Gr4=Float.parseFloat(((EditText) findViewById(R.id.Gr4)).getText().toString());
        gr.setText(Float.toString(mysubject.GetProm()));


    }
}
