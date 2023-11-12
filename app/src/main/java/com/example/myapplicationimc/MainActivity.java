package com.example.myapplicationimc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button calcularBtn = findViewById(R.id.calcular_button);
        calcularBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nomeEditText = findViewById(R.id.nome_edit_text);
                EditText idadeEditText = findViewById(R.id.idade_edit_text);
                EditText pesoEditText = findViewById(R.id.peso_edit_text);
                EditText alturaEditText = findViewById(R.id.altura_edit_text);
                TextView resultadoTextView = findViewById(R.id.resultado_text_view);
                ImageView resultadoImageView = findViewById(R.id.resultado_image_view);

                String idadeStr = idadeEditText.getText().toString();
                String nomeStr = nomeEditText.getText().toString();
                String pesoStr = pesoEditText.getText().toString();
                String alturaStr = alturaEditText.getText().toString();

                if (!TextUtils.isEmpty(pesoStr) && !TextUtils.isEmpty(alturaStr)) {

                    double peso = Double.parseDouble(pesoStr);
                    double altura = Double.parseDouble(alturaStr);
                    double imc = calcularIMC(peso, altura);

                    int imageResource;
                    String resultadoTexto;

                    if (imc < 18.5) {
                        resultadoTexto = "Abaixo do peso normal";
                        imageResource = R.drawable.abaixo_peso_image;
                    } else if (imc <= 24.9) {
                        resultadoTexto = "Peso normal";
                        imageResource = R.drawable.normal_peso_image;
                    } else if (imc <= 29.9) {
                        resultadoTexto = "Sobrepeso";
                        imageResource = R.drawable.sobrepeso_image;
                    } else if (imc <= 34.9) {
                        resultadoTexto = "Obesidade classe I";
                        imageResource = R.drawable.obesidade_image_um;
                    } else if (imc <= 39.9) {
                        resultadoTexto = "Obesidade classe II";
                        imageResource = R.drawable.obesidade_image_dois;
                    } else {
                        resultadoTexto = "Obesidade classe III";
                        imageResource = R.drawable.obesidade_image_tres;
                    }

                    String mensagemResultado = nomeStr + ", " + idadeStr + " anos. \nSeu índice de massa corporal é: \n" + resultadoTexto;
                    resultadoTextView.setText(mensagemResultado);
                    resultadoImageView.setImageResource(imageResource);
                }
            }
        });

        final Button resetButton = findViewById(R.id.reset_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nomeEditText = findViewById(R.id.nome_edit_text);
                EditText idadeEditText = findViewById(R.id.idade_edit_text);
                EditText pesoEditText = findViewById(R.id.peso_edit_text);
                EditText alturaEditText = findViewById(R.id.altura_edit_text);
                TextView resultadoTextView = findViewById(R.id.resultado_text_view);
                ImageView resultadoImageView = findViewById(R.id.resultado_image_view);

                nomeEditText.getText().clear();
                idadeEditText.getText().clear();
                pesoEditText.getText().clear();
                alturaEditText.getText().clear();
                resultadoTextView.setText("");
                resultadoImageView.setImageResource(0);
            }
        });
    }

    private double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }
}
