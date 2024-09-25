package com.andresgmoran.factorial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TextView number = findViewById(R.id.editTextText);
        TextView result = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int num = Integer.parseInt(number.getText().toString());
                    int aux = 1;
                    for(int i = 1; i <= num; i++){
                        aux *= i;
                    }
                    result.setText(String.valueOf(aux));
                } catch (NumberFormatException n) {
                    result.setText(String.valueOf("Not Number"));
                }

            }
        });
    }
}