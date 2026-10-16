package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivitateRezultat extends AppCompatActivity {
    private int nr1;
    private int nr2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_rezultat);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //aflu intentul prin care activ a fost lansata, salvat in it
        Intent it=getIntent();
        //preiau bundle ul dat de intent
        Bundle bundle=it.getExtras();
        String mesaj=bundle.getString("mesaj","");//daca nu gaesc da un empty string
        this.nr1=bundle.getInt("numar1",0);//cheia si val implicita
        this.nr2=bundle.getInt("numar2",0);
        //info preluate le afisez intr-un toast-(log urile pt prog) toast pt utiliz
        //am info le afis utiliz
        Toast.makeText(this,mesaj,Toast.LENGTH_SHORT).show();//context ca sa stiu in ce activitate e afisata
    }

    public void intoarceInActivitate(View view)
    {
        //intorc celor 2 nr
        String altMesaj="Mesaj nou";
        int suma=this.nr1+this.nr2;
        //cum intorc mesajul - am nev de intent
        //nu mai deschid activitatea inca odata, o inchid pt ca revine cealalta
        Intent it=new Intent();
        //creez bundle prin intent
        it.putExtra("altMesaj",altMesaj);
        it.putExtra("suma",suma);//cheia si suma calc
        //setez rezultatul la activitate
        setResult(RESULT_OK,it);
        //inchid sau distrug activitatea cu finish nu pot destroy
        finish();

    }
}