package co.grgiral.miscontactos.db;

import android.content.Context;

import java.util.ArrayList;

import co.grgiral.miscontactos.R;
import co.grgiral.miscontactos.pojo.Contacto;

public class ConstructorContactos {

    private Context context;

    public ConstructorContactos(Context context) {
        this.context = context;
    }


    public ArrayList<Contacto> obtenerDatos(){
        //ArrayList<Contacto> contactos =new ArrayList<>();
        ArrayList<Contacto> contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto(R.drawable.img_20140816_wa0000, "Giovanni Rodriguez", "3006602553", "giorodriguezg@gmail.com", 5));
        contactos.add(new Contacto(R.drawable.img_20140816_wa0000, "Laura María Villa", "3105074273", "lalis310@gmail.com", 4));
        contactos.add(new Contacto(R.drawable.img_20140816_wa0000, "Melissa", "3006602553", "artpiece8@gmail.com", 8));
        contactos.add(new Contacto(R.drawable.img_20140816_wa0000, "Juan", "3006602553", "fdafasdf@gmail.com", 11));
        return contactos;
    }
}
