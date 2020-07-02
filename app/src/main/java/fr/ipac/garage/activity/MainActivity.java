package fr.ipac.garage.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.ListIterator;

import fr.ipac.garage.R;
import fr.ipac.garage.adapter.CarAdapter;
import fr.ipac.garage.model.Car;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Car> cars;

    private RadioButton all;
    private RadioButton sells;
    private RadioButton rents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.display_cars_rv);

        all = findViewById(R.id.radioAll);
        sells = findViewById(R.id.radioSell);
        rents = findViewById(R.id.radioRent);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        cars = new ArrayList<>();

        populateCars();

        sells.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cars.clear();
                populateCars();
                ListIterator<Car> listIterator = cars.listIterator();
                while (listIterator.hasNext()) {
                    String type = listIterator.next().getType();
                    if (!type.equals("Vente")) {
                        listIterator.remove();
                    }
                }
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        });

        rents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cars.clear();
                populateCars();
                ListIterator<Car> listIterator = cars.listIterator();
                while (listIterator.hasNext()) {
                    String type = listIterator.next().getType();
                    if (!type.equals("Location")) {
                        listIterator.remove();
                    }
                }
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        });

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cars.clear();
                populateCars();
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        });

        recyclerView.setAdapter(new CarAdapter(this, cars));
    }

    public void populateCars() {
        for (int i = 0; i<5; i++) {
            cars.add(new Car(
                            "picturepath",
                            "Renault",
                            "Clio",
                            "1500cm3",
                            80,
                            "noir",
                            5,
                            "diesel",
                            "manuelle",
                            "neuve",
                            "Vente",
                            true
                    )
            );
        }
        for (int i = 0; i<5; i++) {
            cars.add(new Car(
                            "picturepath",
                            "Renault",
                            "Clio",
                            "1500cm3",
                            2000,
                            "noir",
                            5,
                            "diesel",
                            "automatique",
                            "neuve",
                            "Vente",
                            false
                    )
            );
        }

        for (int i = 0; i<5; i++) {
            cars.add(new Car(
                            "picturepath",
                            "Peugeot",
                            "208",
                            "1500cm3",
                            26000,
                            "noir",
                            5,
                            "diesel",
                            "manuelle",
                            "Occasion",
                            "Location",
                            false
                    )
            );
        }
        for (int i = 0; i<5; i++) {
            cars.add(new Car(
                            "picturepath",
                            "Peugeot",
                            "208",
                            "1500cm3",
                            50000,
                            "noir",
                            5,
                            "diesel",
                            "auto",
                            "Occasion",
                            "Location",
                            true
                    )
            );
        }
    }
}
