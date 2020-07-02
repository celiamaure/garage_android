package fr.ipac.garage.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import fr.ipac.garage.R;
import fr.ipac.garage.adapter.CarAdapter;
import fr.ipac.garage.model.Car;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Car> cars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.display_cars_rv);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        cars = new ArrayList<>();

        for (int i = 0; i<10; i++) {
            cars.add(new Car(
                    "picturepath",
                    "Renault",
                    "Clio",
                    "1500cm3",
                    0,
                    "noir",
                    5,
                    "diesel",
                    "manuelle",
                    "neuve",
                    "vente",
                    true
                    )
            );
        }
        recyclerView.setAdapter(new CarAdapter(this, cars));
    }
}
