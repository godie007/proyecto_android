package uniquindio.edu.co.proyectoandroid.actividades.util;

/**
 * Created by Jack on 10/23/2016.
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.Locale;

/**
 * Clase de utilidades que brinda diferentes funciones
 */
public class Utilidades {

    public final static String MIS_PREFERENCIAS = "MisPreferencias";
    public final static String LENGUAJE_DE_PREFERENCIA =
            "languaje_preferences";
    public final static String LENGUAJE_ES = "es";
    public final static String LENGUAJE_EN = "en";

    /**
     * Metodo que permite cambiar el lenguaje actual del telefono
     * @param context
     */
    public static void cambiarIdioma(Context context){
        SharedPreferences prefs =
                context.getSharedPreferences(MIS_PREFERENCIAS,
                        context.MODE_PRIVATE);
        String language = prefs.getString(LENGUAJE_DE_PREFERENCIA, LENGUAJE_ES);
        if(language.equals(LENGUAJE_ES)){
            language = LENGUAJE_EN;
        }
        else{
            language = LENGUAJE_ES;
        }
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(LENGUAJE_DE_PREFERENCIA, language);
        editor.commit();
    }

    /**
     * Metodo que permite obtener el lenguaje actual del telefono
     * @param context
     */
    public static void obtenerLenguaje(Context context){
        SharedPreferences prefs =
                context.getSharedPreferences(MIS_PREFERENCIAS,context.MODE_PRIVATE)
                ;
        String language = prefs.getString(LENGUAJE_DE_PREFERENCIA,
                LENGUAJE_ES);
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;

        context.getApplicationContext().getResources().updateConfiguration(
                config, null);
    }

    public static boolean estaConectado(Context context){
        boolean connected = false;

        ConnectivityManager connec = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo[] redes = connec.getAllNetworkInfo();

        for (int i = 0; i < redes.length; i++) {
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                connected = true;
            }
        }
        return connected;
    }

}
