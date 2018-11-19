package co.grgiral.miscontactos.fragment;

import java.util.ArrayList;

import co.grgiral.miscontactos.adapter.ContactoAdaptador;
import co.grgiral.miscontactos.pojo.Contacto;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();
    public ContactoAdaptador    crearAdaptador(ArrayList<Contacto> contactos);
    public void incializarAdaptadorRV(ContactoAdaptador contactoAdaptador);

}
