package com.example.jewelrypricingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GemCal extends AppCompatActivity implements View.OnClickListener{

    EditText Entermaterialg, Enterpriceg, purityg, Enterweightg, Enterhoursg, laborhoursg, Enteroverheadg, caratg, gemtypeg;
    String strmaterial, strprice, strpurity, strweight, strhours, strlaorhours, stroverhead,strcarat, resultMessage, strgemtypeg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gem_cal);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        ComputeResult();
    }

    public void ComputeResult()

    {
        gemtypeg = (EditText) findViewById(R.id.gemtypeg);
        Entermaterialg = findViewById(R.id.Entermaterialg);
        caratg = findViewById(R.id.caratg);
        Enterpriceg = findViewById(R.id.Enterpriceg);
        purityg= findViewById(R.id.purityg);
        Enterweightg = findViewById(R.id.Enterweightg);
        Enterhoursg = findViewById(R.id.Enterhoursg);
        laborhoursg = findViewById(R.id.laborhoursg);
        Enteroverheadg = findViewById(R.id.Enteroverheadg);

        if (Entermaterialg.getText().toString().isEmpty() || gemtypeg.getText().toString().isEmpty()|| Enterpriceg.getText().toString().isEmpty() || caratg.getText().toString().isEmpty() ||
                purityg.getText().toString().isEmpty() || Enterweightg.getText().toString().isEmpty() ||
                Enterhoursg.getText().toString().isEmpty() || laborhoursg.getText().toString().isEmpty() || Enteroverheadg.getText().toString().isEmpty()) {

            strgemtypeg = "0";
            strmaterial = "0";
            strprice = "0";
            strpurity = "0";
            strcarat="0";
            strweight = "0";
            strhours = "0";
            strlaorhours = "0";
            stroverhead = "0";

        } else {
            strgemtypeg = gemtypeg.getText().toString();
            strmaterial = Entermaterialg.getText().toString();
            strprice = Enterpriceg.getText().toString();
            strpurity = purityg.getText().toString();
            strweight = Enterweightg.getText().toString();
            strhours = Enterhoursg.getText().toString();
            strcarat = caratg.getText().toString();
            strlaorhours = laborhoursg.getText().toString();
            stroverhead = Enteroverheadg.getText().toString();
        }
        double material = Double.parseDouble(strmaterial);
        double matprice = Double.parseDouble(strprice);
        double matpurity = Double.parseDouble(strpurity);
        double matweight = Double.parseDouble(strweight);
        double dcarat = Double.parseDouble(strcarat);
        double lcost = Double.parseDouble(strhours);
        double lhours = Double.parseDouble(strlaorhours);
        double overhead = Double.parseDouble(stroverhead);

        double result = material+matprice+matpurity+matweight+lcost+lhours+overhead+dcarat;
        resultMessage = "Your Final Grade is :" +result;

        // Create Bundle instance, this will allow transfer of data from Activity to DialogFragment
        Bundle args = new Bundle();
        args.putString("result", resultMessage);

        // Create a dialog instance
        DialogFragmentCustom dialogFragmentImp = new DialogFragmentCustom();
        // Pass on dialog argument(args), the result
        dialogFragmentImp.setArguments(args);
        // Display the Dialog
        dialogFragmentImp.show(getSupportFragmentManager(),"Display Result");
        // Reset EditTexts
        clearEditText();
    }
    public void clearEditText(){
        Entermaterialg.getText().clear();
        Enterpriceg.getText().clear();
        purityg.getText().clear();
        Enterweightg.getText().clear();
        Enterhoursg.getText().clear();
        laborhoursg.getText().clear();
        Enteroverheadg.getText().clear();
        Entermaterialg.requestFocus();
    }
}
