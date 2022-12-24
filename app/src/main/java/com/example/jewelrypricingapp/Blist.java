package com.example.jewelrypricingapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Blist extends AppCompatActivity {

    ListView listView;
    String[] mTitle = {"No Stone Bracelet", "Diamond Bracelet", "Gemstone Bracelet"};
    int[] images = {R.drawable.subn, R.drawable.diamond2, R.drawable.gemstone};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blist);

        listView = findViewById(R.id.list_view);

        Blist.MyAdapter adapter = new Blist.MyAdapter(this, mTitle, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            if(position==0){
                startActivity(new Intent(Blist.this,NoStoneBracelet.class));
            }else if(position==1){
                startActivity(new Intent(Blist.this,DiamontBracelet.class));
            }else if(position==2){
                startActivity(new Intent(Blist.this,GemstoneBracelet.class));
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String[] rTitle;
        int[] rImgs;

        MyAdapter (Context c, String[] title, int[] imgs) {
            super(c, R.layout.rlist, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rlist = layoutInflater.inflate(R.layout.rlist, parent, false);
            ImageView images = rlist.findViewById(R.id.image);
            TextView myTitle = rlist.findViewById(R.id.textView1);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);

            return rlist;
        }
    }
}
