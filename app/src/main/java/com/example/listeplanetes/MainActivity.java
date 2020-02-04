package com.example.listeplanetes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    PlaneteAdapter adapter;
    Button verifButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView)findViewById(R.id.listView);
        adapter = new PlaneteAdapter();
        adapter.mainActivity = this;
        listview.setAdapter(adapter);

        verifButton = (Button)findViewById(R.id.verif);
        verifButton.setEnabled(false);
        verifButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = listview.getChildCount();
                int correct = 0;

                for(int i = 0; i < count; ++i) {
                    View view = listview.getChildAt(i);
                    TextView nomPlanete = (TextView)view.findViewById(R.id.textView);
                    final Spinner spinner = (Spinner)view.findViewById(R.id.spinner);
                    String inputTaille = spinner.getSelectedItem().toString();
                    int index = Data.nomPlanetes.indexOf(nomPlanete.getText());

                    if(index >= 0 && index < Data.taillePlanetes.length && Data.taillePlanetes[index].equals(inputTaille)) {
                        ++correct;
                    }
                }

                Toast.makeText(MainActivity.this, String.format("Réponses correctes : %1$s%%", 100*correct/Data.taillePlanetes.length), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
