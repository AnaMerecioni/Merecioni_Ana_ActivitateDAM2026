package com.example.seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

//aceeasi activitate de adaugare, dar cu design realizat cu AI
public class ActivitateMasinaAI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_masina_ai);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void salveazaMasina(View view)
    {
        EditText etModel = findViewById(R.id.model_ET);
        RadioGroup rgMarca = findViewById(R.id.marca_RG);
        CheckBox cbNoua = findViewById(R.id.esteNoua_CB);
        Spinner spCombustibil = findViewById(R.id.combustibil_SP);
        RatingBar rbNota = findViewById(R.id.nota_RB);
        Switch swAer = findViewById(R.id.aer_SW);

        String model = etModel.getText().toString();
        if (model.isEmpty())
        {
            Toast.makeText(this, R.string.eroare_model, Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton rbMarca = findViewById(rgMarca.getCheckedRadioButtonId());
        String marca = rbMarca.getText().toString();
        boolean esteNoua = cbNoua.isChecked();
        String combustibil = spCombustibil.getSelectedItem().toString();
        float nota = rbNota.getRating();
        boolean areAer = swAer.isChecked();

        Masina masina = new Masina(model, marca, esteNoua, combustibil, nota, areAer);

        Intent it = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("masina", masina);
        it.putExtras(bundle);
        setResult(RESULT_OK, it);
        finish();
    }
}
