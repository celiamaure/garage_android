package fr.ipac.garage.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;
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
    private Button changeAvailability;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_car);

        final Car car = getIntent().getExtras().getParcelable("carkey");

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
        changeAvailability = findViewById(R.id.changeAvailability);

        Picasso.get().load(car.getPicture()).into(picture);

        brand.setText(car.getBrand());
        model.setText(car.getModel());
        gearBox.setText(car.getGearBox());
        type.setText(car.getType());
        state.setText(car.getState());
        fuel.setText(car.getFuel());
        mileage.setText(car.getMileage().toString());
        doorNumber.setText(car.getDoorNumber().toString());

        if (car.getAvailable()) {
            available.setText("Disponible");
            changeAvailability.setText("Reserver");
            changeAvailability.setBackgroundColor(getResources().getColor(R.color.green));
        } else {
            available.setText("Indisponible");
            changeAvailability.setText("Supprimer la reservation");
            changeAvailability.setBackgroundColor(getResources().getColor(R.color.red));
        }
        color.setText(car.getColor());
        cylinder.setText(car.getCylinder());

        changeAvailability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                car.setAvailable(!car.getAvailable());
                if (car.getAvailable()) {
                    available.setText("Disponible");
                    changeAvailability.setText("Reserver");
                    changeAvailability.setBackgroundColor(getResources().getColor(R.color.green));
                } else {
                    available.setText("Indisponible");
                    changeAvailability.setText("Supprimer la reservation");
                    changeAvailability.setBackgroundColor(getResources().getColor(R.color.red));
                }

            }
        });
    }
}
