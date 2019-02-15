package com.developer.eduardo.androidfibonacci;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText number;
    private Button btnFat;
    private Button btnFib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.number = findViewById(R.id.editNumber);
        this.btnFat = findViewById(R.id.btnFatorial);
        this.btnFib = findViewById(R.id.btnFibonacci);

        this.btnFat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = getN();
                String fat = calcFatorial(n);
                Message("Resultado", fat);
            }
        });

        this.btnFib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = getN();
                String seq = seqFib(n);
                Message("Resultado", seq);
            }
        });

    }

    private int getN() {
        return Integer.parseInt(this.number.getText().toString());
    }

    private void Message (String title, String message) {
        AlertDialog.Builder al = new AlertDialog.Builder(this);
        al.setTitle(title);
        al.setMessage(message);
        al.setNeutralButton("Ok", null);
        al.show();
    }

    private String calcFatorial(int n) {
        long result=1;
        if (n > 0) {
            for (int i=1;i<=n;i++){
                result *= i;
            }
        }
        return String.valueOf(result);
    }
    private String calcSeqFibonacci (int n) {
        long f=0;
        long ant=0;
        for (int i=1;i<=n;++i){
            if (i == 1) {
                f=1;
                ant=0;
            } else {
                f += ant;
                ant = f-ant;
            }
        }
        return String.valueOf(f);
    }
    private String seqFib (int n) {
        StringBuilder str = new StringBuilder();
        for (int i=1;i<=n;++i) {
            str.append(calcSeqFibonacci(i));
            if (i < n) {
                str.append(", ");
            }
        }
        return str.toString();
    }
}
