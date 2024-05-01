package com.example.implant.ui.home;
import android.content.Intent;
import android.graphics.Color;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.implant.AboutAids;
import com.example.implant.Howtouse;
import com.example.implant.Precaution;
import com.example.implant.R;
import com.example.implant.RandomActivity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.implant.HearingTestActivity;
import com.example.implant.R;
import com.example.implant.RandomActivity;
import com.example.implant.VideoCallActivity;
import com.example.implant.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    GridLayout mainGrid;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        mainGrid = (GridLayout) rootView.findViewById(R.id.mainGrid);


        //Set Event
        setSingleEvent(mainGrid);
        //setToggleEvent(mainGrid);
        return rootView;

    }

    /*private void setToggleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Toast.makeText(getActivity(), "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(getActivity(), "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }*/

    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        CardView btn1= mainGrid.findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RandomActivity.class);
                startActivity(intent);
            }
        });
        CardView btn2= mainGrid.findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Howtouse.class);
                startActivity(intent);
            }
        });
        CardView btn3= mainGrid.findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Precaution.class);
                startActivity(intent);
            }
        });
        CardView btn4= mainGrid.findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AboutAids.class);
                startActivity(intent);
            }
        });
        CardView btn5= mainGrid.findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HearingTestActivity.class);
                startActivity(intent);
            }
        });
        CardView btn6= mainGrid.findViewById(R.id.button6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), VideoCallActivity.class);
                startActivity(intent);
            }
        });

       /* for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(getActivity(), RandomActivity.class);
                    intent.putExtra("info", "This is activity from card item index  " + finalI);
                    startActivity(intent);

                }
            });
        }*/
    }
            /*ImageButton button1=rootView.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),HearingTestActivity.class));
            }
        });*/

        /*Button button = (Button) rootView.findViewById(R.id.heartest);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HearingTestActivity.class);
                startActivity(intent);
            }
        });*/


            @Override
            public void onDestroyView () {
                super.onDestroyView();
                binding = null;
            }
        }


