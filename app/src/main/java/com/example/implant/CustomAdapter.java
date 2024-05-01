package com.example.implant;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<String> {
    private Context context;
    private Button play_btn,pause_btn,hare_it_btn,not_hare_it_btn;
    private TextView textView;
    private List<String> listValues;


    public CustomAdapter(Context context, int resource, List<String> listValues) {
        super(context, resource,listValues);
        this.context = context;
        this.listValues = listValues;
    }

    /**
     * getView method is called for each item of ListView
     */
    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String currentValue = listValues.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.ui_activity, null);

        textView = (TextView) convertView.findViewById(R.id.text_audio);
        textView.setText(currentValue);

        play_btn = (Button)convertView.findViewById(R.id.play_btn);
        pause_btn = (Button)convertView.findViewById(R.id.pause_btn);
        hare_it_btn = (Button)convertView.findViewById(R.id.hare_it_btn);
        not_hare_it_btn = (Button)convertView.findViewById(R.id.not_here_it_btn);

        //To lazy to implement interface
        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Play Button Working "+currentValue,Toast.LENGTH_SHORT).show();
            }
        });
        pause_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Pause Button Working "+currentValue,Toast.LENGTH_SHORT).show();
            }
        });
        hare_it_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Hare it Button Working "+currentValue,Toast.LENGTH_SHORT).show();
            }
        });
        not_hare_it_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Not here it Button Working "+currentValue,Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
