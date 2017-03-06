package co.edu.uninorte.cardviewgrades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fdjvf on 3/6/2017.
 */

public class gradesubject implements Serializable {

   public  float Gr1;
    public  float Gr2;
    public  float Gr3;
    public  float Gr4;
    public  String Name;
    public  int Index;
    public  gradesubject(String name)
    {
       Gr1=0f;
        Gr2=0f;
        Gr3=0f;
        Gr4=0F;
        Name=name;
    }
    public float GetProm(){

        return (Gr1+Gr2+Gr3+Gr4)/4f;
    }
}
