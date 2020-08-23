package com.example.pracroomdata;

import android.content.Intent;
import android.os.Bundle;

import com.example.pracroomdata.Adaptador.AnimalListAdapter;
import com.example.pracroomdata.RoomDataBase.Animal;
import com.example.pracroomdata.RoomDataBase.AnimalDao;
import com.example.pracroomdata.ViewModel.AnimalViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int NUEVO_ANIMAL_RC = 1;
    private AnimalViewModel animalViewModel;
    public static String[] cont = {"ASIA", "AFRICA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final AnimalListAdapter adapter = new AnimalListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AgregarAnimal.class);
                startActivityForResult(intent,NUEVO_ANIMAL_RC);
            }
        });

        animalViewModel = ViewModelProviders.of(this).get(AnimalViewModel.class);
        animalViewModel.getmAllAnimales().observe(this, new Observer<List<Animal>>() {
            @Override
            public void onChanged(List<Animal> animals) {
                adapter.setAnimales(animals);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NUEVO_ANIMAL_RC && resultCode == RESULT_OK){
            Animal animal = new Animal(data.getStringExtra("nombre"), data.getStringExtra("estructura")
                    , data.getStringExtra("alimentacion"), data.getStringExtra("continente"));
            animalViewModel.insert(animal);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
