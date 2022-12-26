package com.example.jewelrypricingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NoGemCal extends AppCompatActivity implements View.OnClickListener {
    EditText Entermaterial1, Enterprice1, purity, Enterweight1, Enterhours1, laborhours, Enteroverhead1;
    String strmaterial, strprice, strpurity, strweight, strhours, strlaorhours, stroverhead, resultMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_gem_cal);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        ComputeResult();
    }

    public void ComputeResult() {
        Entermaterial1 = (EditText) findViewById(R.id.Entermaterial1);
        Enterprice1 = (EditText) findViewById(R.id.Enterprice1);
        purity = (EditText) findViewById(R.id.purity);
        Enterweight1 = (EditText) findViewById(R.id.Enterweight1);
        Enterhours1 = (EditText) findViewById(R.id.Enterhours1);
        laborhours = (EditText) findViewById(R.id.laborhours);
        Enteroverhead1 = (EditText) findViewById(R.id.Enteroverhead1);

        if (Entermaterial1.getText().toString().isEmpty() || Enterprice1.getText().toString().isEmpty() ||
                purity.getText().toString().isEmpty() || Enterweight1.getText().toString().isEmpty() ||
                Enterhours1.getText().toString().isEmpty() || laborhours.getText().toString().isEmpty() || Enteroverhead1.getText().toString().isEmpty()) {

            strmaterial = "0";
            strprice = "0";
            strpurity = "0";
            strweight = "0";
            strhours = "0";
            strlaorhours = "0";
            stroverhead = "0";

        } else {
            strmaterial = Entermaterial1.getText().toString();
            strprice = Enterprice1.getText().toString();
            strpurity = purity.getText().toString();
            strweight = Enterweight1.getText().toString();
            strhours = Enterhours1.getText().toString();
            strlaorhours = laborhours.getText().toString();
            stroverhead = Enteroverhead1.getText().toString();
        }
        double material = Double.parseDouble(strmaterial);
        double matprice = Double.parseDouble(strprice);
        double matpurity = Double.parseDouble(strpurity);
        double matweight = Double.parseDouble(strweight);
        double lcost = Double.parseDouble(strhours);
        double lhours = Double.parseDouble(strlaorhours);
        double overhead = Double.parseDouble(stroverhead);

        double result = material+matprice+matpurity+matweight+lcost+lhours+overhead;
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
        Entermaterial1.getText().clear();
        Enterprice1.getText().clear();
        purity.getText().clear();
        Enterweight1.getText().clear();
        Enterhours1.getText().clear();
        laborhours.getText().clear();
        Enteroverhead1.getText().clear();
        Entermaterial1.requestFocus();
    }
}
