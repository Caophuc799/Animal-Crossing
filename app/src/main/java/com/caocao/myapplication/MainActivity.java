package com.caocao.myapplication;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textViewDiem;
    CheckBox cbone,cbtwo,cbthree;
    SeekBar skOne,skTwo,skThree;
    ImageButton btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        final CountDownTimer countDownTimer = new CountDownTimer(60000,10) {
            @Override
            public void onTick(long l) {
                int number = 5;
                Random random = new Random();
                int one = random.nextInt(number);

                int two = random.nextInt(number);

                int three = random.nextInt(number);
                skOne.setProgress(skOne.getProgress()+one);
                skTwo.setProgress(skTwo.getProgress()+two);
                skThree.setProgress(skThree.getProgress()+three);
                if(skOne.getProgress()>=skOne.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this,"One win",Toast.LENGTH_SHORT).show();

                    btnPlay.setVisibility(View.VISIBLE);
                    if(cbone.isChecked()){

                        Toast.makeText(MainActivity.this,"Bạn đoán chính xác",Toast.LENGTH_SHORT).show();
                        textViewDiem.setText(String.valueOf(Integer.parseInt(textViewDiem.getText().toString())+10));
                    }else{

                        Toast.makeText(MainActivity.this,"Bạn đã đoán sai rồi",Toast.LENGTH_SHORT).show();
                        textViewDiem.setText(String.valueOf(Integer.parseInt(textViewDiem.getText().toString())-10));
                    }
                    EnableCheckBox();
                }
                if(skTwo.getProgress()>=skTwo.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this,"Two win",Toast.LENGTH_SHORT).show();

                    btnPlay.setVisibility(View.VISIBLE);
                    if(cbtwo.isChecked()){
                        Toast.makeText(MainActivity.this,"Bạn đoán chính xác",Toast.LENGTH_SHORT).show();
                        textViewDiem.setText(String.valueOf(Integer.parseInt(textViewDiem.getText().toString())+10));
                    }else{
                        Toast.makeText(MainActivity.this,"Bạn đã đoán sai rồi",Toast.LENGTH_SHORT).show();
                        textViewDiem.setText(String.valueOf(Integer.parseInt(textViewDiem.getText().toString())-10));
                    }
                    EnableCheckBox();
                }
                if(skThree.getProgress()>=skThree.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this,"Three win",Toast.LENGTH_SHORT).show();

                    btnPlay.setVisibility(View.VISIBLE);
                    if(cbthree.isChecked()){

                        Toast.makeText(MainActivity.this,"Bạn đoán chính xác",Toast.LENGTH_SHORT).show();
                        textViewDiem.setText(String.valueOf(Integer.parseInt(textViewDiem.getText().toString())+10));
                    }else{

                        Toast.makeText(MainActivity.this,"Bạn đã đoán sai rồi",Toast.LENGTH_SHORT).show();
                        textViewDiem.setText(String.valueOf(Integer.parseInt(textViewDiem.getText().toString())-10));
                    }
                    EnableCheckBox();
                }
            }

            @Override
            public void onFinish() {

            }
        };
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbone.isChecked()||cbtwo.isChecked()||cbthree.isChecked()) {
                    skOne.setProgress(0);
                    skTwo.setProgress(0);
                    skThree.setProgress(0);
                    btnPlay.setVisibility(View.INVISIBLE);
                    DisanableCheckBox();
                    countDownTimer.start();
                }else{
                    Toast.makeText(MainActivity.this,"Vui lòng đặt cược trước khi chơi",Toast.LENGTH_SHORT).show();
                }
            }
        });

        cbone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbtwo.setChecked(false);
                    cbthree.setChecked(false);
                }
            }
        });
        cbtwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbone.setChecked(false);
                    cbthree.setChecked(false);
                }
            }
        });
        cbthree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbtwo.setChecked(false);

                    cbone.setChecked(false);
                }
            }
        });

    }

    private void EnableCheckBox(){
        cbone.setEnabled(true);
        cbtwo.setEnabled(true);
        cbthree.setEnabled(true);
    }


    private void DisanableCheckBox(){
        cbone.setEnabled(false);
        cbtwo.setEnabled(false);
        cbthree.setEnabled(false);
    }
    private void Anhxa(){
        textViewDiem = findViewById(R.id.textViewDiemso);
        cbone = findViewById(R.id.checkboxOne);
        cbtwo= findViewById(R.id.checkboxTwo);
        cbthree = findViewById(R.id.checkboxThree);
        skOne = findViewById(R.id.seekbarOne);
        skTwo = findViewById(R.id.seekbarTwo);
        skThree = findViewById(R.id.seekbarThree);
        btnPlay = findViewById(R.id.btnPlay);
        skThree.setEnabled(false);
        skTwo.setEnabled(false);
        skOne.setEnabled(false);
    }
}
