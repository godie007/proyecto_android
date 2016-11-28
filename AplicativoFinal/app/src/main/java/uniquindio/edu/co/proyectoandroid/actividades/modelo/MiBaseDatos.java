package uniquindio.edu.co.proyectoandroid.actividades.modelo;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * @autor Diego Fernando Echeverry
 * @autor Luisa Maria Valderrama
 */
public class MiBaseDatos extends SQLiteOpenHelper {

    // configutaciones iniciales de la base de datos
    private static final int VERSION_BASEDATOS = 1;
    private static final String NOMBRE_BASEDATOS = "mibasedatos.db";
    private static final String TABLA_CONTACTOS = "CREATE TABLE contactos (_id INT PRIMARY KEY, nick TEXT, password TEXT)";


    /**
     * Metodo constructor
     * @param context
     */
    public MiBaseDatos(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_CONTACTOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLA_CONTACTOS);
        onCreate(db);
    }


    /**
     * Metodo para insertar un contacto
     * @param id
     * @param nick
     * @param password
     */
    public void insertarCONTACTO(int id, String nick, String password) {
        SQLiteDatabase db = getWritableDatabase();
        if (db != null) {
            ContentValues valores = new ContentValues();
            valores.put("_id", id);
            valores.put("nick", nick);
            valores.put("password", password);
            db.insert("contactos", null, valores);
        }
        db.close();
    }

    /**
     * Metodo para modificar un Contacto
     * @param id
     * @param nick
     * @param password
     */
    public void modificarCONTACTO(int id, String nick, String password){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("_id", id);
        valores.put("nick", nick);
        valores.put("password", password);
        db.update("contactos", valores, "_id=" + id, null);
        db.close();
    }

    /**
     * Metodo para borrar un Contacto
     * @param id
     */
    public void borrarCONTACTO(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("contactos", "_id=" + id, null);
        db.close();
    }

    /**
     * Metodo para buscar un determinado contacto por medio del id
     * @param id
     * @return
     */
    public Contactos recuperarCONTACTO(int id) {
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"_id", "nick", "password"};
        Cursor c = db.query("contactos", valores_recuperar, "_id=" + id, null, null, null, null, null);
        if(c != null) {
            c.moveToFirst();
        }
        Contactos contactos = new Contactos(c.getInt(0), c.getString(1), c.getString(2));
        db.close();
        c.close();
        return contactos;
    }

    /**
     * Metodo para retornar todos los contactos registrados
     * @return
     */
    public List<Contactos> recuperarCONTACTOS() {
        SQLiteDatabase db = getReadableDatabase();
        List<Contactos> lista_contactos = new ArrayList<Contactos>();
        String[] valores_recuperar = {"_id", "nick", "password"};
        Cursor c = db.query("contactos", valores_recuperar, null, null, null, null, null, null);
        c.moveToFirst();
        do {
            Contactos contactos = new Contactos(c.getInt(0), c.getString(1), c.getString(2));
            lista_contactos.add(contactos);
        } while (c.moveToNext());
        db.close();
        c.close();
        return lista_contactos;
    }
}
