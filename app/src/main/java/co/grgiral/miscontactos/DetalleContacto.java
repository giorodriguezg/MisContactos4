package co.grgiral.miscontactos;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;

import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    private TextView tvNombre;//= (TextView) findViewById(R.id.tvNombre);
    private TextView tvEmail;//l= (TextView) findViewById(R.id.tvEmail);
    private TextView tvTelefono;//= (TextView) findViewById(R.id.tvTelefono);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle parametros = getIntent().getExtras();
        String nombre = (String) parametros.get(getResources().getString(R.string.pnombre));
        String telefono = (String) parametros.get(getResources().getString(R.string.ptelefono));
        String email = (String) parametros.get(getResources().getString(R.string.pemail));

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);

    }

    @SuppressLint("MissingPermission")
    public void llamar(View v) {
        String telefono = tvTelefono.getText().toString();

       /* if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }*/
        Intent llamarIntent = new Intent(Intent.ACTION_CALL);
        llamarIntent.setData(Uri.parse("tel:3104074335"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(llamarIntent);
        //llamarIntent.setData(Uri.parse("tel:"+telefono));
        //v.callOnClick();
        //startActivity(llamarIntent);

          //  startActivity(new Intent(Intent.ACTION_CALL,Uri.parse("tel:3105074273")));

        //startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + telefono)));
    }

    public void enviarMail(View v){
        String mail = tvEmail.getText().toString();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mail to:"));

        emailIntent.putExtra(Intent.EXTRA_EMAIL,mail);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email"));
        //startActivity(emailIntent);
    }

    public TextView getTvNombre() {
        return tvNombre;
    }

    public void setTvNombre(TextView tvNombre) {
        this.tvNombre = tvNombre;
    }

    public TextView getTvEmail() {
        return tvEmail;
    }

    public void setTvEmail(TextView tvEmail) {
        this.tvEmail = tvEmail;
    }

    public TextView getTvTelefono() {
        return tvTelefono;
    }

    public void setTvTelefono(TextView tvTelefono) {
        this.tvTelefono = tvTelefono;
    }
}
