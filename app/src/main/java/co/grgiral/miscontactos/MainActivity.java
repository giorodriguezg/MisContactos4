package co.grgiral.miscontactos;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import co.grgiral.miscontactos.adapter.PageAdapter;
import co.grgiral.miscontactos.fragment.PerfilFragment;
import co.grgiral.miscontactos.fragment.RecyclerViewFragment;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout ;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar= (Toolbar) findViewById(R.id.toolbar);

        tabLayout= (TabLayout) findViewById(R.id.tabLayout);
        viewPager= (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        if(toolbar!= null){
            setSupportActionBar(toolbar);
        }


      /*  ArrayList<String> nombresContacto = new ArrayList<>();
        for (Contacto contacto:contactos){
            nombresContacto.add(contacto.getNombre());
        }
       /* ListView lstContactos= (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, nombresContacto));
        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre),contactos.get(i).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono),contactos.get(i).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail),contactos.get(i).getEmail());
                startActivity(intent);
            }
        });*/
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_contacts);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_perfil);

    }
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments= new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }



}
