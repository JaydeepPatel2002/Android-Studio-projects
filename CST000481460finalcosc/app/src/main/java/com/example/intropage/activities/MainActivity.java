package com.example.intropage.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.intropage.PizzaMenu;
import com.example.intropage.R;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText nameTv, phoneTv;
    Button btnSubmit;
    public String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTv = findViewById(R.id.inputfname);
        phoneTv = findViewById(R.id.inputPhone);
        btnSubmit = findViewById(R.id.btnSubmit);

        ImageSlider imageSlider = findViewById(R.id.slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.firstfinal));
        slideModels.add(new SlideModel(R.drawable.secondfinal));
        slideModels.add(new SlideModel(R.drawable.thirdfinal));
        slideModels.add(new SlideModel(R.drawable.fourthfinal));

        imageSlider.setImageList(slideModels,true);

        nameTv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                String num = phoneTv.getText().toString();
                name = nameTv.getText().toString();
                if(validPhone(num) && validname(name))
                {
                    btnSubmit.setEnabled(true);
                }
                else if (!validname(name))
                {
                    btnSubmit.setEnabled(false);
                    nameTv.setError("this format of name is incorrect!!!");
                }
                else
                {
                    btnSubmit.setEnabled(false);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        phoneTv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                String num = phoneTv.getText().toString();
                String name = nameTv.getText().toString();
                if(validPhone(num) && validname(name))
                {
                    btnSubmit.setEnabled(true);
                }
                else if (!validPhone(num))
                {
                    btnSubmit.setEnabled(false);
                    phoneTv.setError("this phone number is incorrect!!!");
                }
                else
                {
                    btnSubmit.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, PizzaMenu.class);
                intent.putExtra("total",name);

                startActivity(intent);

            }
        });

    }

    private boolean validname(String name)
    {
        Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z]*$");
        Matcher m = p.matcher(name);
        return m.matches();
    }

    private boolean validPhone(String num)
    {
        Pattern p = Pattern.compile("^(639|306)[0-9]{7}$");
        Matcher m = p.matcher(num);
        return m.matches();
    }
}