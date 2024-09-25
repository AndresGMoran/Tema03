package com.andresgmoran.piedrapapelotijeras;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private final Random rnd = new Random();
    private TextView text;
    private ImageView imgUser;
    private ImageView imgCpu;
    private final int VALOR_PIEDRA = 0;
    private final int VALOR_PAPEL = 1;
    private final int VALOR_TIJERAS = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textView);

        imgUser = findViewById(R.id.usuario);
        imgCpu = findViewById(R.id.cpu);

        ImageButton rock = findViewById(R.id.imageButton2);
        ImageButton paper = findViewById(R.id.imageButton3);
        ImageButton scissors = findViewById(R.id.imageButton4);
        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game(VALOR_PIEDRA);
            }
        });
        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game(VALOR_PAPEL);
            }
        });
        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game(VALOR_TIJERAS);
            }
        });
    }
    private void game(int selection){
        int selectionCPU = rnd.nextInt(3);

        changeImages(selection, imgUser);
        changeImages(selectionCPU, imgCpu);

        if (selectionCPU == selection) {
            text.setText("Empate");
        }
        // Condiciones de victoria
        else if (selection == VALOR_PIEDRA && selectionCPU == VALOR_TIJERAS) {  // Piedra gana a Tijeras
            text.setText(R.string.win_message);
        }
        else if (selection == VALOR_PAPEL && selectionCPU == VALOR_PIEDRA) {  // Papel gana a Piedra
            text.setText(R.string.win_message);
        }
        else if (selection == VALOR_TIJERAS && selectionCPU == VALOR_PAPEL) {  // Tijeras gana a Papel
            text.setText(R.string.win_message);
        }
        else {
            text.setText(R.string.lose_message);
        }
    }
    private void changeImages(int opcion, ImageView img){
        if (opcion == VALOR_PIEDRA){
            img.setImageResource(R.drawable.pedra);
        } else if (opcion == VALOR_PAPEL) {
            img.setImageResource(R.drawable.paper);
        } else {
            img.setImageResource(R.drawable.tisores);
        }
    }
}