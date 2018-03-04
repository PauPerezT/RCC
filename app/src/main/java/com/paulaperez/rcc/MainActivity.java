package com.paulaperez.rcc;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Spinner mostSignificantColor, leastSignificantColor, multiplierColor, toleranceColor;
   private LinearLayout color1 , color2, color3, color4;
    public String mSc,lSc, mC,tC;
    public Button comp;
    private TextView tvTolerance,tvResult;
    private double numMSC,numLSC,numMC;
    private String result, numTC;
    private double resultNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mostSignificantColor=(Spinner)(findViewById(R.id.spinner1));
        leastSignificantColor=(Spinner)(findViewById(R.id.spinner2));
        multiplierColor=(Spinner)(findViewById(R.id.spinner3));
        toleranceColor=(Spinner)(findViewById(R.id.spinner4));
        comp=(Button) findViewById(R.id.comp);
        tvResult=(TextView)findViewById(R.id.tvResult);
        tvTolerance=(TextView)findViewById(R.id.tvTolerance);

        color1=(LinearLayout)findViewById(R.id.spinnerc1);
        color2=(LinearLayout)findViewById(R.id.spinnerc2);
        color3=(LinearLayout)findViewById(R.id.spinnerc3);
        color4=(LinearLayout)findViewById(R.id.spinnerc4);


        ArrayAdapter<String> mostSignificantColorAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.colorsR));
        //ArrayAdapter<String> mostSignificantColorAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.colorsR));
        mostSignificantColor.setAdapter(mostSignificantColorAdapter);
        mostSignificantColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                numMSC=0;
                numLSC=0;
                numMC=1;
                mSc= mostSignificantColor.getSelectedItem().toString();
                lSc=leastSignificantColor.getSelectedItem().toString();
                mC=multiplierColor.getSelectedItem().toString();
                tC=toleranceColor.getSelectedItem().toString();
                organizeResistance( mSc, lSc, mC, tC );
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter<String> leastSignificantColorAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.colorsR));
        leastSignificantColor.setAdapter(leastSignificantColorAdapter);
        leastSignificantColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                numMSC=0;
                numLSC=0;
                numMC=1;
                mSc= mostSignificantColor.getSelectedItem().toString();
                lSc=leastSignificantColor.getSelectedItem().toString();
                mC=multiplierColor.getSelectedItem().toString();
                tC=toleranceColor.getSelectedItem().toString();
                organizeResistance( mSc, lSc, mC, tC );
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter<String> multiplierColorAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.colorsR));
        multiplierColor.setAdapter(multiplierColorAdapter);
        multiplierColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                numMSC=0;
                numLSC=0;
                numMC=1;
                mSc= mostSignificantColor.getSelectedItem().toString();
                lSc=leastSignificantColor.getSelectedItem().toString();
                mC=multiplierColor.getSelectedItem().toString();
                tC=toleranceColor.getSelectedItem().toString();
                organizeResistance( mSc, lSc, mC, tC );
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> toleranceColorAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.toleranceC));
        toleranceColor.setAdapter(toleranceColorAdapter);
        toleranceColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                numMSC=0;
                numLSC=0;
                numMC=1;

                mSc= mostSignificantColor.getSelectedItem().toString();
                lSc=leastSignificantColor.getSelectedItem().toString();
                mC=multiplierColor.getSelectedItem().toString();
                tC=toleranceColor.getSelectedItem().toString();
                organizeResistance( mSc, lSc, mC, tC );
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numMSC=0;
                numLSC=0;
                numMC=1;
                mSc= mostSignificantColor.getSelectedItem().toString();
                lSc=leastSignificantColor.getSelectedItem().toString();
                mC=multiplierColor.getSelectedItem().toString();
                tC=toleranceColor.getSelectedItem().toString();
                organizeResistance( mSc, lSc, mC, tC );

                resultNum = ((numMSC*10) + numLSC) * numMC;
                Log.e("David", Double.toString(resultNum));

               result=Double.toString(resultNum)+" Ohms";
                //Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();

                tvResult.setText(result);
                tvTolerance.setText(numTC); // Esto es un cambio
            }
        });

        mSc= mostSignificantColor.getSelectedItem().toString();
        lSc=leastSignificantColor.getSelectedItem().toString();
        mC=multiplierColor.getSelectedItem().toString();
        tC=toleranceColor.getSelectedItem().toString();

        organizeResistance( mSc, lSc, mC, tC );
        result = "0 Ohms";
        tvResult.setText(result);
        tvTolerance.setText(numTC);
    }

    private void organizeResistance( String mSc, String lSc, String mC, String tC ){
        if (mSc.equals("Black")){
            numMSC=0;
            color1.setBackgroundColor(getResources().getColor(R.color.colorblack));

        }else if(mSc.equals("Brown")) {
            color1.setBackgroundColor(getResources().getColor(R.color.colorbrown));

            numMSC=1;
        }else if(mSc.equals("Red")) {
            color1.setBackgroundColor(getResources().getColor(R.color.colorred));

            numMSC=2;
        }else if(mSc.equals("Orange")) {
            color1.setBackgroundColor(getResources().getColor(R.color.colororange));

            numMSC=3;
        }else if(mSc.equals("Yellow")){
            color1.setBackgroundColor(getResources().getColor(R.color.coloryellow));

            numMSC=4;
        }else if(mSc.equals("Green")) {
            color1.setBackgroundColor(getResources().getColor(R.color.colorgreen));

            numMSC=5;
        }else if(mSc.equals("Blue")) {
            color1.setBackgroundColor(getResources().getColor(R.color.colorblue));

            numMSC=6;
        }else if(mSc.equals("Purple")) {
            color1.setBackgroundColor(getResources().getColor(R.color.colorpurple));

            numMSC = 7;
        }else if(mSc.equals("Gray")) {
            color1.setBackgroundColor(getResources().getColor(R.color.colorgray));

            numMSC=8;
        }
        else{
            color1.setBackgroundColor(getResources().getColor(R.color.colorwhite));

            numMSC=9;
        }



        if (lSc.equals("Black")){
            color2.setBackgroundColor(getResources().getColor(R.color.colorblack));

            numLSC=0;
        }else if(lSc.equals("Brown")) {
            color2.setBackgroundColor(getResources().getColor(R.color.colorbrown));

            numLSC=1;
        }else if(lSc.equals("Red")) {
            color2.setBackgroundColor(getResources().getColor(R.color.colorred));

            numLSC=2;
        }else if(lSc.equals("Orange")) {
            color2.setBackgroundColor(getResources().getColor(R.color.colororange));

            numLSC=3;
        }else if(lSc.equals("Yellow")){
            color2.setBackgroundColor(getResources().getColor(R.color.coloryellow));

            numLSC=4;
        }else if(lSc.equals("Green")) {
            color2.setBackgroundColor(getResources().getColor(R.color.colorgreen));

            numLSC=5;
        }else if(lSc.equals("Blue")) {
            color2.setBackgroundColor(getResources().getColor(R.color.colorblue));

            numLSC=6;
        }else if(lSc.equals("Purple")) {
            color2.setBackgroundColor(getResources().getColor(R.color.colorblue));

            numLSC=7;
        }else if(lSc.equals("Gray")) {
            color2.setBackgroundColor(getResources().getColor(R.color.colorgray));

            numLSC=8;
        }else {
            color2.setBackgroundColor(getResources().getColor(R.color.colorwhite));

            numLSC=9;
        }



        if(mC.equals("Black")){
            color3.setBackgroundColor(getResources().getColor(R.color.colorblack));

            numMC=1;
        }else if(mC.equals("Brown")) {
            color3.setBackgroundColor(getResources().getColor(R.color.colorbrown));

            numMC=10;
        }else if(mC.equals("Red")) {
            color3.setBackgroundColor(getResources().getColor(R.color.colorred));

            numMC=100;
        }else if(mC.equals("Orange")) {
            color3.setBackgroundColor(getResources().getColor(R.color.colororange));

            numMC=1000;
        }else if(mC.equals("Yellow")){
            color3.setBackgroundColor(getResources().getColor(R.color.coloryellow));

            numMC=10000;
        }else if(mC.equals("Green")) {
            color3.setBackgroundColor(getResources().getColor(R.color.colorgreen));

            numMC=100000;
        }else if(mC.equals("Blue")) {
            color3.setBackgroundColor(getResources().getColor(R.color.colorblue));

            numMC=1000000;
        }else if(mC.equals("Purple")) {
            color3.setBackgroundColor(getResources().getColor(R.color.colorpurple));

            numMC=1.0/10.0;
        }else if(mC.equals("Gray")) {
            color3.setBackgroundColor(getResources().getColor(R.color.colorgray));

            numMC=1.0/100.0;
        }





        if(tC.equals("Brown")) {
            color4.setBackgroundColor(getResources().getColor(R.color.colorbrown));

            numTC="Tolerance 1%";
        }else if(tC.equals("Red")) {
            color4.setBackgroundColor(getResources().getColor(R.color.colorred));

            numTC="Tolerance 2%";
        }else if(tC.equals("Golden")) {
            color4.setBackgroundColor(getResources().getColor(R.color.colorgolden));

            numTC="Tolerance 5%";
        }else if(tC.equals("Silver")){
            color4.setBackgroundColor(getResources().getColor(R.color.colorsilver));

            numTC="Tolerance 10%";
        }
    }
}
