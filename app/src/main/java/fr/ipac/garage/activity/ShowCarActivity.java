package fr.ipac.garage.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import fr.ipac.garage.R;
import fr.ipac.garage.model.Car;

public class ShowCarActivity extends AppCompatActivity {

    private ImageView picture;
    private TextView brand;
    private TextView model;
    private TextView gearBox;
    private TextView type;
    private TextView state;
    private TextView fuel;
    private TextView mileage;
    private TextView doorNumber;
    private TextView available;
    private TextView color;
    private TextView cylinder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_car);

        Car car = getIntent().getExtras().getParcelable("carkey");

        picture = findViewById(R.id.picture);
        brand = findViewById(R.id.brand);
        model = findViewById(R.id.model);
        gearBox = findViewById(R.id.gearBox);
        type = findViewById(R.id.type);
        state = findViewById(R.id.state);
        fuel = findViewById(R.id.fuel);
        mileage = findViewById(R.id.mileage);
        doorNumber = findViewById(R.id.doorNumber);
        available = findViewById(R.id.availability);
        color = findViewById(R.id.color);
        cylinder = findViewById(R.id.cylinder);

        //picture.setImageURI(car.getPicture());
        brand.setText(car.getBrand());
        model.setText(car.getModel());
        gearBox.setText(car.getGearBox());
        type.setText(car.getType());
        state.setText(car.getState());
        fuel.setText(car.getFuel());
        mileage.setText(car.getMileage().toString());
        doorNumber.setText(car.getDoorNumber().toString());
        //TODO: faire une confition
        if (car.getAvailable()) {
            available.setText("Disponible");
        } else {
            available.setText("Indisponible");
        }
        color.setText(car.getColor());
        cylinder.setText(car.getCylinder());
    }
}
