package com.example.horoscopochino;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Descripcion extends AppCompatActivity {

    TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);

        tvDescripcion = findViewById(R.id.tvDescripcion);

        recibeDatos();
    }

    private void recibeDatos(){
        Bundle extras = getIntent().getExtras();
        int a = extras.getInt("animal");
        if(a==0){
            tvDescripcion.setText(getResources().getString(R.string.rata));
        }else if(a==1){
            tvDescripcion.setText(getResources().getString(R.string.buey));
        }else if(a==2){
            tvDescripcion.setText(getResources().getString(R.string.tigre));
        }else if(a==3){
            tvDescripcion.setText(getResources().getString(R.string.conejo));
        }else if(a==4){
            tvDescripcion.setText(getResources().getString(R.string.dragon));
        }else if(a==5){
            tvDescripcion.setText(getResources().getString(R.string.serpiente));
        }else if(a==6){
            tvDescripcion.setText(getResources().getString(R.string.caballo));
        }else if(a==7){
            tvDescripcion.setText(getResources().getString(R.string.cabra));
        }else if(a==8){
            tvDescripcion.setText(getResources().getString(R.string.mono));
        }else if(a==9){
            tvDescripcion.setText(getResources().getString(R.string.gallo));
        }else if(a==10){
            tvDescripcion.setText(getResources().getString(R.string.perro));
        }else if(a==11){
            tvDescripcion.setText(getResources().getString(R.string.cerdo));
        }
    }
}
