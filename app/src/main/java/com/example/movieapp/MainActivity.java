package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    String[] moviename={"Avengers","Bloodshot","Dolittle","Ford VS Ferrari","Jumanji","1917","Sonic","Star Wars"};
    int[] moviesimages={R.drawable.avengers,R.drawable.bloodshot,R.drawable.dolittle,R.drawable.fordvsferrari,R.drawable.jumanji,R.drawable.nineteenseventeen,R.drawable.sonic,R.drawable.starwars};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.gridview);

        CustomAdapter customadapter=new CustomAdapter();
        gridView.setAdapter(customadapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getApplicationContext(),GridItemActivity.class);
                intent.putExtra("name",moviename[i]);
                intent.putExtra("image",moviesimages[i]);
                startActivity(intent);
            }
        });
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return moviesimages.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1=getLayoutInflater().inflate(R.layout.data_row,null);
            TextView name=view1.findViewById(R.id.moviesnames);
            ImageView image=view1.findViewById(R.id.images);

            name.setText(moviename[i]);
            image.setImageResource(moviesimages[i]);
            return view1;
        }
    }
}
