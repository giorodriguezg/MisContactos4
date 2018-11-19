package co.grgiral.miscontactos.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import co.grgiral.miscontactos.pojo.Contacto;
import co.grgiral.miscontactos.DetalleContacto;
import co.grgiral.miscontactos.R;

public class ContactoAdaptador extends  RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){
        this.contactos=contactos;
        this.activity = activity;
    }


    ArrayList<Contacto> contactos;
    Activity activity;
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent,false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ContactoViewHolder holder, int position) {
        final Contacto contacto= contactos.get(position);
        holder.imgFoto.setImageResource(contacto.getFoto());
        holder.tvNombreCV.setText(contacto.getNombre());
        holder.tvTelefonoCV.setText(contacto.getTelefono());
        holder.tvLikes.setText(String.valueOf(contacto.getLikes())+ " Likes");

        holder.imgFoto.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity,DetalleContacto.class);
                intent.putExtra("nombre",contacto.getNombre());
                intent.putExtra("telefono",contacto.getTelefono());
                intent.putExtra("email",contacto.getEmail());
                activity.startActivity(intent);
            }
        });
        holder.btnLike.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(activity, "diste like a: "+contacto.getNombre(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {//cantidad de elementos

        return contactos.size();
    }

    public static class  ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;
        private ImageButton btnLike;
        private TextView tvLikes;

        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFoto= (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
            tvLikes = (TextView) itemView.findViewById(R.id.tvlikes);

        }
    }
}
