package com.iliyas.assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_text, et_number;
    Button evaluate_btn;
    TextView result_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_number = findViewById(R.id.num_et);
        et_text = findViewById(R.id.text_et);
        result_tv = findViewById(R.id.tv_result);
        evaluate_btn = findViewById(R.id.btn_evaluate);

        evaluate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!et_number.getText().toString().isEmpty() && !et_text.getText().toString().isEmpty()){
                    fun(et_text.getText().toString().trim(), Integer.parseInt(et_number.getText().toString().trim()));
                } else if(et_number.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter number", Toast.LENGTH_LONG).show();
                } else if(et_text.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter string", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void fun(String s, int k) {

        String answer = "";

        for (int i = 0; i < s.length(); ++i) {
            int val = s.charAt(i);
            int dup = k;

            if (val + k > 122) {
                k -= (122 - val);
                k = k % 26;

                answer += (char)(96 + k);
            } else {
                answer += (char)(val + k);
            }

            k = dup;
        }
        result_tv.setText("Result: "+answer);
    }
}