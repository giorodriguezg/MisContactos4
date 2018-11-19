package co.grgiral.miscontactos.presentador;

import android.content.Context;

import java.util.ArrayList;

import co.grgiral.miscontactos.adapter.ContactoAdaptador;
import co.grgiral.miscontactos.db.ConstructorContactos;
import co.grgiral.miscontactos.fragment.IRecyclerViewFragmentView;
import co.grgiral.miscontactos.pojo.Contacto;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{


    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;
    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView=iRecyclerViewFragmentView;
        this.context= context;
        obtenerContactosBaseDatos();
    }




    @Override
    public void obtenerContactosBaseDatos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();


    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.incializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();

    }
}
