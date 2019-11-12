package com.example.horoscopochino;

import android.content.Intent;
import android.util.Patterns;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.DatePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity{

    EditText etName, etDate, etAccount, etMail;
    ImageView btnCheck;
    public int dia,mes,anio,diaA,mesA,anioA,edad,error;
    public String animal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        btnCheck = findViewById(R.id.btnCheck);
        etDate = findViewById(R.id.etDate);
        etAccount = findViewById(R.id.etAccount);
        etMail = findViewById(R.id.etMail);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(MainActivity.this, "AHHHHH", Toast.LENGTH_LONG).show();
                validateName();
                validateDate();
                validateAccount();
                validateEmail();
                if (validateEmail() && validateName() && validateDate() && validateAccount()) {
                   Intent intent = new Intent (v.getContext(), Horoscopo.class);
                   String nombre = etName.getText().toString();
                   //calculaEdad();
                   // int edad1=12;
                   //Toast.makeText(MainActivity.this, ""+edad, Toast.LENGTH_LONG).show();
                   intent.putExtra("nombre",nombre);
                   intent.putExtra("edad",edad);
                   intent.putExtra("animal",animal);
                   startActivityForResult(intent, 0);
                }
            }
        });

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, getResources().getString(R.string.error1), Toast.LENGTH_LONG).show();
                final Calendar c= Calendar.getInstance();
                dia=c.get(Calendar.DAY_OF_MONTH);
                mes=c.get(Calendar.MONTH);
                anio=c.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener(){
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
                        animal = calculaAnimal(year);
                        edad = calculaEdad(year, monthOfYear, dayOfMonth);
                        if (error==1){
                            etDate.setText("");
                        }else {
                            etDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        }
                        //Toast.makeText(MainActivity.this, ""+edad, Toast.LENGTH_LONG).show();
                    }
                }
                        ,anio,mes,dia);
                datePickerDialog.show();
            }
        });
    }



    private boolean validateName(){
        String NameInput = etName.getText().toString().trim();
        if (NameInput.isEmpty()) {
            etName.setError(getResources().getString(R.string.error1));
            return false;
        } else {
            etName.setError(null);
            return true;
        }
    }

    private boolean validateDate(){
        String DateInput = etDate.getText().toString().trim();
        if (DateInput.isEmpty()) {
            etDate.setError(getResources().getString(R.string.error1));
            return false;
        } else {
            etDate.setError(null);
            return true;
        }
    }

    private boolean validateEmail() {
        String emailInput = etMail.getText().toString().trim();
        if (emailInput.isEmpty()) {
            etMail.setError(getResources().getString(R.string.error1));
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            etMail.setError(getResources().getString(R.string.error2));
            return false;
        } else {
            etMail.setError(null);
            return true;
        }
    }

    private boolean validateAccount(){
        String AccountInput = etAccount.getText().toString().trim();
        if (AccountInput.isEmpty()) {
            etAccount.setError(getResources().getString(R.string.error1));
            return false;
        } else if (AccountInput.length()<9) {
            etAccount.setError(getResources().getString(R.string.errorAccount));
            return false;
        } else {
            etAccount.setError(null);
            return true;
        }
    }

    public int calculaEdad(int year, int monthofYear, int dayOfMonth){
        int nacimiento = year;
        int nacimientoM = monthofYear;
        int nacimientoD = dayOfMonth;
        int edadDia;
        int edadMes;
        //Toast.makeText(MainActivity.this, ""+year, Toast.LENGTH_LONG).show();
        final Calendar c1= Calendar.getInstance();
        diaA=c1.get(Calendar.DAY_OF_MONTH);
        mesA=c1.get(Calendar.MONTH);
        anioA=c1.get(Calendar.YEAR);
        if (nacimientoM==mesA && nacimientoD==diaA) {
            Toast.makeText(MainActivity.this, getResources().getString(R.string.Cumpleaños), Toast.LENGTH_LONG).show();
            error = 0;
        }
        if(nacimientoM>=mesA && nacimientoD>diaA){
            if(nacimiento>=anioA) {
                Toast.makeText(MainActivity.this, getResources().getString(R.string.errorFecha), Toast.LENGTH_LONG).show();
                error = 1;
            }else{
                edad = anioA - nacimiento - 1;
            }
        } else {
            edad = anioA - nacimiento;
            //Toast.makeText(MainActivity.this, "entre aqui", Toast.LENGTH_LONG).show();
            error=0;
        }
        //Toast.makeText(MainActivity.this, ""+edad, Toast.LENGTH_LONG).show();
        return edad;
    }

    public String calculaAnimal(int year){
        int a;
        a = year%12;
        if (a==0){animal = "Mono";}
        else if (a==1){animal = "Gallo";}
        else if (a==2){animal = "Perro";}
        else if (a==3){animal = "Cerdo";}
        else if (a==4){animal = "Rata";}
        else if (a==5){animal = "Buey";}
        else if (a==6){animal = "Tigre";}
        else if (a==7){animal = "Conejo";}
        else if (a==8){animal = "Dragón";}
        else if (a==9){animal = "Serpiente";}
        else if (a==10){animal = "Caballo";}
        else if (a==11){animal = "Cabra";}
        return animal;
    }
}
