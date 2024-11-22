package com.example.tictactoe;

import static com.example.tictactoe.R.layout.*;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9 ,reset_button;
    String s1, s2, s3, s4, s5, s6, s7, s8, s9 ;
    Button cancel_btn, reset_btn ;
    int flag = 0 ;
    Dialog dialog ;

    int count =0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inti();
        dialog = new Dialog(this) ;

        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_main_btn() ;
            }
        });

    }

    private void inti() {
        btn1 = findViewById(R.id.btn1) ;
        btn2 = findViewById(R.id.btn2) ;
        btn3 = findViewById(R.id.btn3) ;
        btn4 = findViewById(R.id.btn4) ;
        btn5 = findViewById(R.id.btn5) ;
        btn6 = findViewById(R.id.btn6) ;
        btn7 = findViewById(R.id.btn7) ;
        btn8 = findViewById(R.id.btn8) ;
        btn9 = findViewById(R.id.btn9) ;
        reset_button = findViewById(R.id.reset_button) ;
        cancel_btn = findViewById(R.id.cancle_btn) ;
        reset_btn = findViewById(R.id.reset_btn) ;

    }



    public void Check(View view){
        Button btnCurrent = (Button) view ;
        count++ ;
    if(btnCurrent.getText().toString().equals("")){
        if(flag==0){
            btnCurrent.setText("X");
            btnCurrent.setTextColor(getResources().getColor(R.color.Xcolor));
            btnCurrent.setTextSize(50);
            flag = 1 ;
        }else{
            btnCurrent.setText("O");
            btnCurrent.setTextColor(getResources().getColor(R.color.Ocolor));
            flag = 0 ;
            btnCurrent.setTextSize(50);
        }


        if (count>4){
            s1 = btn1.getText().toString() ;
            s2 = btn2.getText().toString() ;
            s3 = btn3.getText().toString() ;
            s4 = btn4.getText().toString() ;
            s5 = btn5.getText().toString() ;
            s6 = btn6.getText().toString() ;
            s7 = btn7.getText().toString() ;
            s8 = btn8.getText().toString() ;
            s9 = btn9.getText().toString() ;


            if (s1.equals(s2) && s2.equals(s3) && !s1.equals("")){
                // 1 2 3
                Toast.makeText(this, s1+" Won The Game", Toast.LENGTH_SHORT).show();
                newGame() ;
            } else if (s4.equals(s5) && s5.equals(s6) && !s4.equals("")) {
                // 4 5 6
                Toast.makeText(this, s4+" Won The Game", Toast.LENGTH_SHORT).show();
                newGame() ;
            } else if (s7.equals(s8) && s8.equals(s9) && !s7.equals("")) {
                //7  8  9
                Toast.makeText(this, s7+" Won The Game", Toast.LENGTH_SHORT).show();
                newGame() ;
            } else if (s1.equals(s4) && s4.equals(s7) && !s1.equals("")) {
                // 1 4 7
                Toast.makeText(this, s1+" Won The Game", Toast.LENGTH_SHORT).show();
                newGame() ;
            } else if (s2.equals(s5) && s5.equals(s8) && !s2.equals("")) {
                //2 5 8
                Toast.makeText(this, s2+" Won The Game", Toast.LENGTH_SHORT).show();
                newGame() ;
            } else if (s3.equals(s6) && s6.equals(s9) && !s3.equals("")) {
                //3 6 9
                Toast.makeText(this, s3+" Won The Game", Toast.LENGTH_SHORT).show();
                newGame() ;
            } else if (s1.equals(s5) && s5.equals(s9) && !s1.equals("")) {
                // 1 5 9
                Toast.makeText(this, s1+" Won The Game", Toast.LENGTH_SHORT).show();
                newGame() ;
            }else if (s3.equals(s5) && s5.equals(s7) && !s3.equals("")){
                // 3  5  7
                Toast.makeText(this, s3+" Won The Game", Toast.LENGTH_SHORT).show();
                newGame() ;
            } else if (count==9) {
                Toast.makeText(this, "The Game is Draw", Toast.LENGTH_SHORT).show();
                newGame();
            }

        }

    }
    }

    public void newGame(){
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        count = 0 ;
        flag = 0 ;
    }

    public void dialog_main_btn(){
        dialog.setContentView(reset_dialouge_box_msg);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        cancel_btn = dialog.findViewById(R.id.cancle_btn);
        reset_btn = dialog.findViewById(R.id.reset_btn);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.reset_dialoge_bg));
        dialog.show();

    cancel_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialog.cancel();
        }
    });

    reset_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            newGame();
            dialog.cancel();
        }
    });

    }


}