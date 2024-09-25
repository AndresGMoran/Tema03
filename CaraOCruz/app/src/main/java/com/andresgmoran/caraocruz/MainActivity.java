package com.andresgmoran.caraocruz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private final Random rnd = new Random();
    private TextView mensaje;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        mensaje = findViewById(R.id.textView3);
        img = findViewById(R.id.imageView);
        Button heads = findViewById(R.id.button2);
        Button tails = findViewById(R.id.button3);
        heads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAction(true);
            }
        });
        tails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAction(false);
            }
        });
    }
    private void onClickAction(boolean seleccionUsuario){
        boolean tirada = rnd.nextBoolean();
        if (tirada){
            img.setImageResource(R.drawable.euro_cara);
        } else {
            img.setImageResource(R.drawable.euro_cruz);
        }
        if (tirada == seleccionUsuario){
            mensaje.setText(R.string.win_message);
        } else {
            mensaje.setText(R.string.lose_message);
        }
    }
}