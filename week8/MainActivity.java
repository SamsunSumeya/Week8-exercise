package com.example.week8;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText num1, num2;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        num1 = findViewById(R.id.inputFirstNumber);
        num2 = findViewById(R.id.inputSecondNumber);
        result = findViewById(R.id.textResult);

        findViewById(R.id.buttonPlus).setOnClickListener(v -> calculate('+'));
        findViewById(R.id.buttonMinus).setOnClickListener(v -> calculate('-'));
        findViewById(R.id.buttonMultiply).setOnClickListener(v -> calculate('*'));
        findViewById(R.id.buttonDivide).setOnClickListener(v -> calculate('/'));
    }

    private void calculate(char op) {
        try {
            double n1 = Double.parseDouble(num1.getText().toString());
            double n2 = Double.parseDouble(num2.getText().toString());
            double res;

            if (op == '+') {
                res = n1 + n2;
            } else if (op == '-') {
                res = n1 - n2;
            } else if (op == '*') {
                res = n1 * n2;
            } else if (op == '/') {
                res = (n2 != 0) ? n1 / n2 : Double.NaN;
            } else {
                res = 0;
            }

            if (op == '/') {
                String formattedResult = String.format("%.4f", res);
                result.setText(formattedResult);
            } else {
                String formattedResult = String.format("%.0f", res);
                result.setText(formattedResult);}
        } catch (NumberFormatException e) {
            result.setText("Invalid input");
        }
    }
}