package com.example.zaid.tipcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.os.health.PackageHealthStats;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity
{
    public static TipCalculator tipCalc;
    private EditText billAmount;
    private RadioButton r10;
    private RadioButton r15;
    private RadioButton r30;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tipCalc = new TipCalculator(0.0f, 0.0f);
    }

    public void updateObject()
    {
        RadioButton r10 = (RadioButton) findViewById(R.id.ten);
        RadioButton r15 = (RadioButton) findViewById(R.id.fifteen);
        int rate = 30;
        if( r10.isChecked( ) )//check which button is pressed
        {
            rate = 10;
        }
        else if( r15.isChecked( ) )
        {
            rate = 15;
        }
        billAmount = (EditText) findViewById(R.id.billAmount);

        String rateString = String.valueOf(rate);
        String billString = billAmount.getText().toString();

        try
        {
            float Frate = Float.parseFloat(rateString);
            float Fbill = Float.parseFloat(billString);
            tipCalc.setTip(Frate);
            tipCalc.setBill(Fbill);
        }
        catch(NumberFormatException nfe)
        {
            tipCalc.setBill(10);
            tipCalc.setTip(10);
        }
    }

    public void viewScreen(View v)
    {
        Intent myIntent = new Intent (this, DataActivity.class);
        updateObject();
        this.startActivity(myIntent);
    }

}