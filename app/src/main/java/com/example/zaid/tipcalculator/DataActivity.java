package com.example.zaid.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DataActivity extends AppCompatActivity
{
    private TextView Bill;
    private TextView Tip;
    private TextView totalTip;
    private TextView Total;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        updateView();
    }

    public void updateView()
    {
        TipCalculator tipCalc = MainActivity.tipCalc;

        Bill = (TextView) findViewById(R.id.billAmount);
        String s = Float.toString(tipCalc.getBill());
        Bill.setText(s);

        Tip = (TextView) findViewById(R.id.tip);
        Tip.setText(tipCalc.getTip());

        totalTip = (TextView) findViewById(R.id.totalTip);
        totalTip.setText(tipCalc.tipAmount());

        Total = (TextView) findViewById(R.id.Total);
        Total.setText(tipCalc.totalAmount());
    }

    public void editScreen()
    {
        this.finish();
    }

}
