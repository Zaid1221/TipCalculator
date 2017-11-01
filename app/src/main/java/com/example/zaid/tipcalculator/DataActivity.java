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
        s = Float.toString((tipCalc.getTip()));
        Tip.setText(s + "%");

        totalTip = (TextView) findViewById(R.id.totalTip);
        s = Float.toString(tipCalc.tipAmount());
        totalTip.setText(s);

        Total = (TextView) findViewById(R.id.Total);
        s = Float.toString(tipCalc.totalAmount());
        Total.setText(s);
    }

    public void editScreen()
    {
        this.finish();
        overridePendingTransition( R.anim.slide_from_left, 0 );
    }

}
