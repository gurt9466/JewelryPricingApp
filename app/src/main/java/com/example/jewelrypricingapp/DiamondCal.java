package com.example.jewelrypricingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DiamondCal extends AppCompatActivity implements View.OnClickListener{

    EditText Entermateriald, Enterpriced, purityd, Enterweightd, Enterhoursd, laborhoursd, Enteroverheadd, caratd;
    String strmaterial, strprice, strpurity, strweight, strhours, strlaorhours, stroverhead,strcarat, resultMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamond_cal);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        ComputeResult();
    }

    public void ComputeResult()

    {
        Entermateriald = findViewById(R.id.Entermateriald);
        caratd = findViewById(R.id.caratd);
        Enterpriced = findViewById(R.id.Enterpriced);
        purityd= findViewById(R.id.purityd);
        Enterweightd = findViewById(R.id.Enterweightd);
        Enterhoursd = findViewById(R.id.Enterhoursd);
        laborhoursd = findViewById(R.id.laborhoursd);
        Enteroverheadd = findViewById(R.id.Enteroverheadd);

        if (Entermateriald.getText().toString().isEmpty() || Enterpriced.getText().toString().isEmpty() || caratd.getText().toString().isEmpty() ||
                purityd.getText().toString().isEmpty() || Enterweightd.getText().toString().isEmpty() ||
                Enterhoursd.getText().toString().isEmpty() || laborhoursd.getText().toString().isEmpty() || Enteroverheadd.getText().toString().isEmpty()) {

            strmaterial = "0";
            strprice = "0";
            strpurity = "0";
            strcarat="0";
            strweight = "0";
            strhours = "0";
            strlaorhours = "0";
            stroverhead = "0";

        } else {
            strmaterial = Entermateriald.getText().toString();
            strprice = Enterpriced.getText().toString();
            strpurity = purityd.getText().toString();
            strweight = Enterweightd.getText().toString();
            strhours = Enterhoursd.getText().toString();
            strcarat = caratd.getText().toString();
            strlaorhours = laborhoursd.getText().toString();
            stroverhead = Enteroverheadd.getText().toString();
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
        Entermateriald.getText().clear();
        Enterpriced.getText().clear();
        purityd.getText().clear();
        Enterweightd.getText().clear();
        Enterhoursd.getText().clear();
        laborhoursd.getText().clear();
        Enteroverheadd.getText().clear();
        Entermateriald.requestFocus();
    }
}
