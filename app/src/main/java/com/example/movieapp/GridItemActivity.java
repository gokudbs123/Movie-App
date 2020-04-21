package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class GridItemActivity extends AppCompatActivity {
    TextView name;
    ImageView image;
    Button but1;
    RatingBar rating1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_item);
        name=findViewById(R.id.griddata);
        image=findViewById(R.id.imageview);
        rating1=findViewById(R.id.rating);
        but1=findViewById(R.id.b1);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Totalstars="Total stars : " + rating1.getNumStars();
                String rating="Rating : " + rating1.getRating();
                Toast.makeText(GridItemActivity.this, "Thank You For Rating\n"+rating, Toast.LENGTH_SHORT).show();

            }
        });

        Intent intent=getIntent();
        name.setText(intent.getStringExtra("name"));
        image.setImageResource(intent.getIntExtra("image",0));
    }
}
