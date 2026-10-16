package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivitateNoua extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_noua);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void deschideActivitate(View view)
    {
        //cum obtin fisier class?- compilare cod Java
        Intent it=new Intent(this,ActivitateRezultat.class);
        Bundle bundle=new Bundle();
        bundle.putString("mesaj","mesaj din prima activitate");//cheie si continut mesaj
        //adaug cele 2 nr intregi
        bundle.putInt("numar1",5);
        bundle.putInt("numar2",5);
        //adaug bundle ul pe intent
        it.putExtras(bundle);

        startActivityForResult(it,52);//request code- sa stiu de la care activitate primesc rasp
    }
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        //request-
        if(requestCode==52)
        {
            //a fct activitatea ceva?
            if(resultCode==RESULT_OK)
            {
                //daca da, mi a returnat ceva
                //iau info din intent
                String mesaj=data.getStringExtra("altMesaj");
                int suma=data.getIntExtra("suma",0);
                //afisez info din bundle printr un toast
                StringBuilder builder=new StringBuilder();
                builder.append(mesaj);
                builder.append(" ");
                builder.append(suma);

                Toast.makeText(this,builder.toString(), Toast.LENGTH_LONG).show();

            }
        }
    }


}