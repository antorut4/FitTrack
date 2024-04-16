import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fittrack.R;

public class AggiornaScheda extends AppCompatActivity {

    private EditText eserciziLunedi, eserciziMercoledi, eserciziVenerdi;
    private EditText gruppoLunedi, gruppoMercoledi, gruppoVenerdi;
    private Button aggiornaScheda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_esercizi);

        // Inizializza le EditText e il pulsante
        eserciziLunedi = findViewById(R.id.monday_exercises);
        eserciziMercoledi = findViewById(R.id.friday_exercises);
        eserciziVenerdi = findViewById(R.id.wednesday_exercises);
        gruppoLunedi = findViewById(R.id.monday_muscle_groups);
        gruppoMercoledi = findViewById(R.id.friday_muscle_groups);
        gruppoVenerdi = findViewById(R.id.wednesday_muscle_groups);
        aggiornaScheda = findViewById(R.id.save);

        // Imposta un listener per il pulsante di aggiornamento
        aggiornaScheda.setOnClickListener(view -> salvaDati());
    }

    // Metodo per salvare i dati utilizzando SharedPreferences
    private void salvaDati() {
        SharedPreferences preferences = getSharedPreferences("DatiScheda", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        // Salva i dati delle EditText
        editor.putString("esercizi_lunedi", eserciziLunedi.getText().toString());
        editor.putString("esercizi_mercoledi", eserciziMercoledi.getText().toString());
        editor.putString("esercizi_venerdi", eserciziVenerdi.getText().toString());
        editor.putString("gruppo_lunedi", gruppoLunedi.getText().toString());
        editor.putString("gruppo_mercoledi", gruppoMercoledi.getText().toString());
        editor.putString("gruppo_venerdi", gruppoVenerdi.getText().toString());

        // Applica i cambiamenti
        editor.apply();
    }
}
