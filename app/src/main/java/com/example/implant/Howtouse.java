package com.example.implant;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;

import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Howtouse extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    List<String> moviesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howtouse);

        moviesList = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerAdapter = new RecyclerAdapter(moviesList);

//        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(recyclerAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);


        moviesList.add("Always handle your hearing aids with care");
        moviesList.add("Wash your hands before handling your hearing aids");
        moviesList.add("Store your hearing aids in a safe, dry place away from children and pets");
        moviesList.add("Turn off your hearing aids when you are not using them");
        moviesList.add("Periodically clean the battery contacts and remove any visible earwax or debris with a clean cloth");
        moviesList.add("Change filters or wax guards to remove wax and dirt that may deter sound quality");
        moviesList.add("Schedule routine checkups with your hearing professional for professional cleanings");
        moviesList.add("Don’t wear your hearing aids in the shower, while swimming or while using a hair dryer or hair spray");
        moviesList.add("Keep hearing aids away from heat and moisture");
        moviesList.add("Replace dead batteries immediately.");
        moviesList.add("Clean hearing aids as instructed.");
        moviesList.add("Do not use hairspray or other hair care products while wearing hearing aids.\n" +
                "Turn off hearing aids when they are not in use.");
//        moviesList.add("Captain America: Civil War");
//        moviesList.add("Doctor Strange");
//        moviesList.add("Guardians of the Galaxy Vol. 2");
//        moviesList.add("Spider-Man: Homecoming");
//        moviesList.add("Thor: Ragnarok");
//        moviesList.add("Black Panther");
//        moviesList.add("Avengers: Infinity War");
//        moviesList.add("Ant-Man and the Wasp");
//        moviesList.add("Captain Marvel");
//        moviesList.add("Avengers: Endgame");
//        moviesList.add("Spider-Man: Far From Home");
    }
}