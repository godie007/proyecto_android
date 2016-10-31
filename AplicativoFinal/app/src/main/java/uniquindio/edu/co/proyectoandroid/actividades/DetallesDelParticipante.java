package uniquindio.edu.co.proyectoandroid.actividades;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import uniquindio.edu.co.proyectoandroid.R;
/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class DetallesDelParticipante extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_del_participante);
        //se habilita el boton atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //se muestra el titulo con la nueva configuracion de idioma
        getSupportActionBar().setTitle(R.string.app_name);

        Spinner dropdown = (Spinner)findViewById(R.id.entrenador);
        String[] items = new String[]{"Jonny Rivera", "Rihana", "Adele"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        Spinner dropdown2 = (Spinner)findViewById(R.id.univercity);
        String[] items2 = new String[]{"Uniquindio", "Eafi", "Andes","Pontifica","EAM","Andes"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        dropdown2.setAdapter(adapter2);

        Spinner dropdown3 = (Spinner)findViewById(R.id.estado);
        String[] items3 = new String[]{"Activo", "Innactivo"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items3);
        dropdown3.setAdapter(adapter3);

        ImageButton btn_imagen = (ImageButton)findViewById(R.id.imageButton);
        btn_imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.parse("file://" + "/sdcard/test.jpg"), "image/*");
                startActivity(intent);
            }
        });

    }
    /**
     *  Se indica en el menu superior al momento de presionar atras el sistema redirige a la actividad anterior
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Al momento de presionar el voton atras se finaliza la actividad actual
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
