package unac.form.com.taller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class Main extends AppCompatActivity {



    @BindView(R.id.spUniversity)
    Spinner spU;
    @BindView(R.id.spCareer)
    Spinner spC;
    @BindView(R.id.txtSem)
    TextView spS;

    String[] datos = new String[] {"[Seleccione una Universidad]","UNAC", "Javeriana", "UPB"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spU = findViewById(R.id.spUniversity);
        spC = findViewById(R.id.spCareer);
        spS = findViewById(R.id.txtSem);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(spU.getContext(),
                android.R.layout.simple_spinner_item, datos);

        spU.setAdapter(adapter);

        spU.setPrompt("Universidad");
        spC.setPrompt("Seleccione su carrera");

       eventos();

    }

    public void eventos(){
        spU.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> spn,
                                               android.view.View v,
                                               int posicion,
                                               long id) {
                        switch(posicion)
                        {
                            case 0:
                                spC.setAdapter(new ArrayAdapter(spC.getContext(), android.R.layout.simple_spinner_item
                                        ,new String[]{" "}));
                                break;
                            case 1:
                                spC.setAdapter(new ArrayAdapter(spC.getContext(), android.R.layout.simple_spinner_item
                                        ,new String[]{"[Seleccione una Carrera]","Ing Sistemas","Enfermeria","Teologia"}));
                                break;
                            case 2:
                                spC.setAdapter(new ArrayAdapter(spC.getContext(), android.R.layout.simple_spinner_item
                                        ,new String[]{"[Seleccione una Carrera]","Negocios Internacionales","Mecatronica","Robotica"}));
                                break;
                            case 3:
                                spC.setAdapter(new ArrayAdapter(spC.getContext(), android.R.layout.simple_spinner_item
                                        ,new String[]{"[Seleccione una Carrera]","Ing Industrial","Medicina","Teatro"}));
                                break;
                        }
                        if((posicion) > 0) {
                            Toast.makeText(spn.getContext(), "Has seleccionado " +
                                            spn.getItemAtPosition(posicion).toString(),
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                    public void onNothingSelected(AdapterView<?> spn) {

                    }
                });

        spC.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> spn,
                                               android.view.View v,
                                               int posicion,
                                               long id) {
                        String num="";
                        switch(spn.getItemAtPosition(posicion).toString())
                        {
                            case "Ing Sistemas":
                                num="10";
                                break;
                            case "Enfermeria":
                                num="11";
                                break;
                            case "Teologia":
                                num="8";
                                break;
                            case "Negocios Internacionales":
                                num="4";
                                break;
                            case "Mecatronica":
                                num="10";
                                break;
                            case "Robotica":
                                num="10";
                                break;
                            case "Ing Industrial":
                                num="10";
                                break;
                            case "Medicina":
                                num="12";
                                break;
                            case "Teatro":
                                num="6";
                                break;
                        }

                        spS.setText("Semestres: " + num);

                        if(posicion > 0) {
                            Toast.makeText(spn.getContext(), "Has seleccionado " +
                                            spn.getItemAtPosition(posicion).toString(),
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                    public void onNothingSelected(AdapterView<?> spn) {

                    }
                });
}




}
//DEFINIR SPINNER
// List<String> listSpinner = Arrays.asList("arra", "ing sistemas", "contaduria");
// ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.spinner.getContext(),android.R.layout.simple_spinner_item, listSpinner);
