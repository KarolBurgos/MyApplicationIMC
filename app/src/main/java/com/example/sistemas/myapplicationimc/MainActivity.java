package com.example.sistemas.myapplicationimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText pes,estatur;
    private TextView im,cla,cla2;
    private ImageView im3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pes=(EditText)findViewById(R.id.peso1);
        estatur=(EditText)findViewById(R.id.estaura1);

        im=(TextView)findViewById(R.id.imc);
        cla=(TextView)findViewById(R.id.clasificacion);
        cla2=(TextView)findViewById(R.id.cla22);
        im3=(ImageView)findViewById(R.id.im3);
    }
    public void acercade(View view){
        Intent i=new Intent (this,AcercaDe.class);
        startActivity(i);
    }
    public  void limpiar(View view){
        pes.setText("");
        estatur.setText("");
        im.setText("");
        cla.setText("");
        cla2.setText("");
    }
    public void sal(View view)
    {
        finish();
    }

    public void operar(View view){
        String esta1=estatur.getText().toString();
        String p1=pes.getText().toString();
        try {
            double est1=Double.valueOf(esta1).doubleValue();

            int x1 = (int) est1;

            int nr1=Integer.parseInt(p1);
            double mul=est1*est1;
            double imc= nr1/mul;
            DecimalFormat f= new DecimalFormat("#.00");
            int x = (int) imc;
            String resu=String.valueOf(""+f.format(imc));

            if(x1<=0||nr1<=0)
            {
                String resur=String.valueOf(getResources().getString(R.string.numer));
                Toast toas= Toast.makeText(this,resur,Toast.LENGTH_LONG);
                toas.show();
                im.setText("");
                cla.setText("");
                cla2.setText("");
            }
            if(x1>0) {


                im.setText(resu);

                String resu2 = String.valueOf(getResources().getString(R.string.ind) + resu);
                Toast toas2 = Toast.makeText(this, resu2, Toast.LENGTH_LONG);
                toas2.show();
                if (x < 18.50) {
                    cla.setText(getResources().getString(R.string.bpeso));
                    cla.setEnabled(false);
                    cla2.setEnabled(false);
                    im.setEnabled(false);
                    im3.setImageResource(R.drawable.cal);
                    if (x < 16.00) {
                        cla.setText(getResources().getString(R.string.bpeso));
                        cla2.setText(getResources().getString(R.string.delsevera));
                        cla.setEnabled(false);
                        cla2.setEnabled(false);
                        im.setEnabled(false);


                    } else if (x >= 16.00 && x <= 16.99) {
                        cla.setText(getResources().getString(R.string.bpeso));
                        cla2.setText(getResources().getString(R.string.delmodera));
                        cla.setEnabled(false);
                        cla2.setEnabled(false);
                        im.setEnabled(false);

                    } else if (x >= 17.00 && x <= 18.49) {
                        cla.setText(getResources().getString(R.string.bpeso));
                        cla2.setText(getResources().getString(R.string.delleve));
                        cla.setEnabled(false);
                        cla2.setEnabled(false);
                        im.setEnabled(false);

                    }
                } else if (x > 25.00 && x < 29.99) {
                    cla.setText(getResources().getString(R.string.sopre));
                    cla.setEnabled(false);
                    cla2.setEnabled(false);
                    im.setEnabled(false);
                } else if (x >= 30.00 && x <= 34.99) {
                    cla.setText(getResources().getString(R.string.obe));
                    cla2.setText(getResources().getString(R.string.oleve));
                    cla.setEnabled(false);
                    cla2.setEnabled(false);
                    im.setEnabled(false);

                } else if (x >= 35.00 && x <= 39.99) {
                    cla.setText(getResources().getString(R.string.obe));
                    cla2.setText(getResources().getString(R.string.omedia));
                    cla.setEnabled(false);
                    cla2.setEnabled(false);
                    im.setEnabled(false);

                } else if (x >= 40.00) {
                    cla.setText(getResources().getString(R.string.obe));
                    cla2.setText(getResources().getString(R.string.obemor));
                    cla.setEnabled(false);
                    cla2.setEnabled(false);
                    im.setEnabled(false);

                } else if (x >= 18.5 && x <= 24.99) {
                    cla.setText("Normal");
                    cla.setEnabled(false);
                    cla2.setEnabled(false);
                    im.setEnabled(false);
                }

            }

        }
        catch (Exception e)
        {
            if(esta1.equals("")||p1.equals(""))
            {
                String resur=String.valueOf(getResources().getString(R.string.nocampo));
                Toast toas= Toast.makeText(this,resur,Toast.LENGTH_LONG);
                toas.show();
            }
        }





    }
}
