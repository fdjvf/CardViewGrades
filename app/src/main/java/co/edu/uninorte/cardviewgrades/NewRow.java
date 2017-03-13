package co.edu.uninorte.cardviewgrades;

/**
 * Created by fdjvf on 3/6/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class NewRow extends BaseAdapter {
    public ArrayList<gradesubject> Data;
    private Context MyContext;


    public NewRow(Context context, ArrayList<gradesubject> data) {

        MyContext = context;
        Data = data;
    }

    @Override
    public int getCount() {
        return Data.size();
    }

    @Override
    public Object getItem(int position) {
        return Data.get(position).Name;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final String Text = Data.get(position).Name;
        if (convertView == null) {
            LayoutInflater T = (LayoutInflater) MyContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = T.inflate(R.layout.myrow, null);

        }
        //Ingresamos el listviw con cada una de las propiedades y deseadas y posteriormente devolvermos esa view( Cada view es una fila)
        TextView textView = (TextView) convertView.findViewById(R.id.textViewrow);
        textView.setText(Text);
        Button MyButton = (Button) convertView.findViewById(R.id.ActionRow);
        MyButton.setFocusable(false);
        MyButton.setFocusableInTouchMode(false);
        MyButton.setTag(position);


        return convertView;
    }
}
