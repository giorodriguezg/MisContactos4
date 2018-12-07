package co.grgiral.miscontactos.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import co.grgiral.miscontactos.R;
import co.grgiral.miscontactos.pojo.Contacto;

public class ConstructorContactos {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorContactos(Context context) {
        this.context = context;
    }


    public ArrayList<Contacto> obtenerDatos(){
        //ArrayList<Contacto> contactos =new ArrayList<>();
        ArrayList<Contacto> contactos = new ArrayList<Contacto>();
      /*  contactos.add(new Contacto(R.drawable.img_20140816_wa0000, "Giovanni Rodriguez", "3006602553", "giorodriguezg@gmail.com", 5));
        contactos.add(new Contacto(R.drawable.img_20140816_wa0000, "Laura María Villa", "3105074273", "lalis310@gmail.com", 4));
        contactos.add(new Contacto(R.drawable.img_20140816_wa0000, "Melissa", "3006602553", "artpiece8@gmail.com", 8));
        contactos.add(new Contacto(R.drawable.img_20140816_wa0000, "Juan", "3006602553", "fdafasdf@gmail.com", 11));
        */

      BaseDatos db =  new BaseDatos(context);
      insertarTresContactos(db);
      return db.obtenerTodosLosContactos();

    }

    public void insertarTresContactos(BaseDatos db){
        //(telefono,foto,nombre,email
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Giovanni Rodriguez");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "3006602553");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "giorodriguezg@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.img_20140816_wa0000);
        db.insertarContacto(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Laura Villa");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "3006602553");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "giorodriguezg@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.img_20140816_wa0000);
        db.insertarContacto(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "MElissa");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "3006602553");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "giorodriguezg@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.img_20140816_wa0000);
        db.insertarContacto(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "gio2 Rodriguez");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "3006602553");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "giorodriguezg@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.img_20140816_wa0000);
        db.insertarContacto(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "gio3 Rodriguez");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "3006602553");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "giorodriguezg@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.img_20140816_wa0000);
        db.insertarContacto(contentValues);
    }

    public void darLikeContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues= new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES, LIKE);

        db.insetarLikeContacto(contentValues);
    }

    public int obtenerLikesContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);

    }
}
