package com.example.appgojeta;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText txfValor;
    private TextView txfPorcento;
    private TextView txfGojeta;
    private TextView txfValorTotal;
    private SeekBar seekBarGorgeta;
    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txfValor = findViewById(R.id.txfValor);
        txfPorcento = findViewById(R.id.txfPorcento);
        txfGojeta = findViewById(R.id.txfGojeta);
        txfValorTotal = findViewById(R.id.txfValorTotal);
        seekBarGorgeta = findViewById(R.id.seekBarGorgeta);

        seekBarGorgeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                porcentagem = i;
                txfPorcento.setText(porcentagem + "%");

                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular (){
        String valorRecupera = txfValor.getText().toString();


            double txfValor = Double.parseDouble(valorRecupera);
            double gorgeta = txfValor * (porcentagem/100);
            txfGojeta.setText("R$"+gorgeta);

            double txftotal = gorgeta + txfValor;
            txfValorTotal.setText("R$ "+ txftotal);

        }


    }
