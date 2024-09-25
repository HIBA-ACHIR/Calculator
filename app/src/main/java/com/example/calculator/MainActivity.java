package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private boolean isOp1=true;
    private int val1=0;
    private int val2=0;
    private String operation="";
    private TextView Ch_saisi;
    private TextView result;


    private static final int OPE_PLUS = R.id.ope_plus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Ch_saisi=findViewById(R.id.textView);
        Button btnPlus = findViewById(R.id.ope_plus);
        Button btnMoins = findViewById(R.id.ope_moins);
        Button btnDiv = findViewById(R.id.ope_division);
        Button btnPourcentage = findViewById(R.id.pourcentage);
        Button btnMultip = findViewById(R.id.ope_multiplication);
        Button btnCalcule = findViewById(R.id.resultat);
        result = findViewById(R.id.textViewOperation);
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperator(v);
            }
        });
        btnCalcule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer(v);
            }
        });

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer(v);
            }
        });
        btnMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperator(v);
            }
        });
        btnMultip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperator(v);
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperator(v);
            }
        });
        btnPourcentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperator(v);
            }
        });


    }

    public void ajouterChiffre(View V){
        int val = Integer.parseInt(((TextView )V).getText().toString());
        if(isOp1){
            val1 = val1 * 10 + val;
            afficher();
        }
        else{
            val2 = val2 * 10 +val;
            afficher();
        }
    }

    private void afficher() {
        if(!isOp1){

            result.setText((val1)+ " " + operation +" "+(val2));

        }
        else{
            result.setText(String.valueOf(val1));
        }

    }


    private void setOperator(View view) {
        String tag = view.getTag().toString();
        switch (tag) {
            case "plus":
                operation = "+";
                break;
            case "moins":
                operation = "-";
                break;
            case "multiplication":
                operation = "*";
                break;
            case "Div":
                operation = "/";
                break;
            case "Pource":
                operation = "%";
                break;
            default:
                return; 
        }

        afficher(); // Mettre à jour l'affichage de l'opération
        isOp1=false;
    }


    private void calculer(View view){
        if(!isOp1){
            switch (operation){
                case "+" : val1 = val1 + val2;break;
                case "-" : val1 = val1 - val2;break;
                case "*" : val1 = val1 * val2;break;
                case "/" : val1 = val1 / val2;break;
                case "%" : val1 = val1 /100;break;
                default:return;// do nothing if no operator
            }

          //  textViewOperation.setText(val1 + " " + operation + " " + val2); // Mettre à jour l'opération dans textViewOperation
            Ch_saisi.setText(String.valueOf(val1)); // Mettre à jour le résultat dans textViewResult

        }
        else{
            val2 = 0;
            isOp1=true;

            afficher();
            Ch_saisi.setText("");
        }
    }

    public void reset(View view){
        val1=0;val2=0; isOp1=true;
        operation="";
        Ch_saisi.setText("0");
        afficher();
    }

}