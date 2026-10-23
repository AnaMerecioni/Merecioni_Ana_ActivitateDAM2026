package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void culegeDate(View view) {
        EditText et = findViewById(R.id.id_nume_ET);
        CheckBox cb = findViewById(R.id.eStudent_CB);
        String nume = et.getText().toString();
        Boolean eStudent = cb.isChecked();
        // trimite datele in alta activitate etc.
    }
    //2 liniar layout orizontale

    public void deschideAdaugare(View view)
    {
        Intent it = new Intent(this, ActivitateMasina.class);
        startActivityForResult(it, 100);//request code - stiu de la care activitate primesc rasp
    }

    public void deschideAdaugareAI(View view)
    {
        Intent it = new Intent(this, ActivitateMasinaAI.class);
        startActivityForResult(it, 101);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 100 || requestCode == 101) && resultCode == RESULT_OK && data != null)
        {
            //iau obiectul din bundle-ul primit
            Bundle bundle = data.getExtras();
            Masina masina = (Masina) bundle.getSerializable("masina");

            //il afisez prin toast si in TextView
            Toast.makeText(this, masina.toString(), Toast.LENGTH_LONG).show();
            TextView tv = findViewById(R.id.masina_TV);
            tv.setText(masina.toString());
        }
    }
}