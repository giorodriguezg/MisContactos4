package co.grgiral.miscontactos.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.grgiral.miscontactos.R;
import co.grgiral.miscontactos.adapter.ContactoAdaptador;
import co.grgiral.miscontactos.pojo.Contacto;
import co.grgiral.miscontactos.presentador.IRecyclerViewFragmentPresenter;
import co.grgiral.miscontactos.presentador.RecyclerViewFragmentPresenter;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {
    private RecyclerView rvContactos;
    private ArrayList<Contacto> contactos;
    public ContactoAdaptador adaptador;
    private IRecyclerViewFragmentPresenter presenter;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview,container,false);

        //android.support.v7.widget.Toolbar miActionBar;
        //miActionBar = (android.support.v7.widget.Toolbar) findViewById(R.id.miActionBar);
        //setSupportActionBar(miActionBar);
        //**linear layotu

        rvContactos = (RecyclerView) v.findViewById(R.id.rvContactos);
        presenter = new RecyclerViewFragmentPresenter( this,getContext());
       // inicializarListaContactos();
        return v;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }


    /*public void inicializarListaContactos(){

        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto(R.drawable.img_20140816_wa0000, "Giovanni Rodriguez", "3006602553", "giorodriguezg@gmail.com", 0));
        contactos.add(new Contacto(R.drawable.img_20140816_wa0000, "Laura María Villa", "3105074273", "lalis310@gmail.com", 0));
        contactos.add(new Contacto(R.drawable.img_20140816_wa0000, "Melissa", "3006602553", "artpiece8@gmail.com", 0));
        contactos.add(new Contacto(R.drawable.img_20140816_wa0000, "Juan", "3006602553", "fdafasdf@gmail.com", 0));

    }
*/

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this,3);
        rvContactos.setLayoutManager(llm);
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos) {
        return          new ContactoAdaptador(contactos,getActivity());
    }

    @Override
    public void incializarAdaptadorRV(ContactoAdaptador contactoAdaptador) {
        rvContactos.setAdapter(contactoAdaptador);

    }
}
