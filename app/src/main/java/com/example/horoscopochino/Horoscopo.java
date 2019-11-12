package com.example.horoscopochino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Horoscopo extends AppCompatActivity {
    ImageView ivAnimal;
    TextView tvHola;
    TextView tvTuEdad;
    TextView tvAnimal;
    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horoscopo);

        tvHola = findViewById(R.id.tvHola);
        tvTuEdad = findViewById(R.id.tvTuEdad);
        tvAnimal = findViewById(R.id.tvAnimal);
        ivAnimal = findViewById(R.id.ivAnimal);

        recibirDatos();
    }

    private void recibirDatos() {
        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        int edad = extras.getInt("edad");
        String animal = extras.getString("animal");
        tvHola.setText(getResources().getString(R.string.hola) + " " + nombre);
        if (edad==0){
            tvTuEdad.setText(getResources().getString(R.string.edad3));
        }else if(edad==1){
            tvTuEdad.setText(getResources().getString(R.string.edad1) + " " + edad + " " + getResources().getString(R.string.edad4));
        }else{
            tvTuEdad.setText(getResources().getString(R.string.edad1) + " " + edad + " " + getResources().getString(R.string.edad2));
        }
        tvAnimal.setText(getResources().getString(R.string.animal)+" "+animal);
        if (animal.equals("Rata")) {
            ivAnimal.setImageResource(R.drawable.rata);a=0;
        } else if (animal.equals("Buey")) {
            ivAnimal.setImageResource(R.drawable.buey);a=1;
        } else if (animal.equals("Tigre")) {
            ivAnimal.setImageResource(R.drawable.tigre);a=2;
        } else if (animal.equals("Conejo")) {
            ivAnimal.setImageResource(R.drawable.conejo);a=3;
        } else if (animal.equals("Dragón")) {
            ivAnimal.setImageResource(R.drawable.dragon);a=4;
        } else if (animal.equals("Serpiente")) {
            ivAnimal.setImageResource(R.drawable.serpiente);a=5;
        } else if (animal.equals("Caballo")) {
            ivAnimal.setImageResource(R.drawable.caballo);a=6;
        } else if (animal.equals("Cabra")) {
            ivAnimal.setImageResource(R.drawable.cabra);a=7;
        } else if (animal.equals("Mono")) {
            ivAnimal.setImageResource(R.drawable.mono);a=8;
        } else if (animal.equals("Gallo")) {
            ivAnimal.setImageResource(R.drawable.gallo);a=9;
        } else if (animal.equals("Perro")) {
            ivAnimal.setImageResource(R.drawable.perro);a=10;
        } else if (animal.equals("Cerdo")) {
            ivAnimal.setImageResource(R.drawable.cerdo);a=11;
        }else{
            ivAnimal.setImageResource(R.drawable.send);
        }
        ivAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Descripcion.class);
                intent.putExtra("animal",a);
                startActivityForResult(intent, 0);
            }
        });
    }
}
