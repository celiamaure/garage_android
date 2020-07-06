package fr.ipac.garage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import fr.ipac.garage.R;
import fr.ipac.garage.model.Car;
import fr.ipac.garage.utils.ActivityUtils;

public class AddCarActivity extends AppCompatActivity {

    private static final int PICK_IMAGE = 1000;
    private static final boolean DEFAULT_AVAILABILITY = true;

    private String imageUrl;

    private TextView brand;
    private TextView model;
    private TextView cylinder;
    private TextView mileage;
    private TextView color;
    private TextView doorNumber;
    private TextView fuel;
    private TextView gearBox;
    private TextView state;
    private TextView type;
    private ImageView image;
    private Button validate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_car);

        image = findViewById(R.id.image);
        brand = findViewById(R.id.brand);
        model = findViewById(R.id.model);
        gearBox = findViewById(R.id.gearBox);
        type = findViewById(R.id.type);
        state = findViewById(R.id.state);
        fuel = findViewById(R.id.fuel);
        mileage = findViewById(R.id.mileage);
        doorNumber = findViewById(R.id.doorNumber);
        color = findViewById(R.id.color);
        cylinder = findViewById(R.id.cylinder);
        validate = findViewById(R.id.validate);


        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!brand.getText().toString().isEmpty() &&
                        !model.getText().toString().isEmpty() &&
                        !gearBox.getText().toString().isEmpty() &&
                        !type.getText().toString().isEmpty() &&
                        !state.getText().toString().isEmpty() &&
                        !fuel.getText().toString().isEmpty() &&
                        !mileage.getText().toString().isEmpty() &&
                        !doorNumber.getText().toString().isEmpty() &&
                        !color.getText().toString().isEmpty() &&
                        !cylinder.getText().toString().isEmpty()
                       ) {

                    Car car = new Car(
                            imageUrl,
                            brand.getText().toString(),
                            model.getText().toString(),
                            cylinder.getText().toString(),
                            Integer.parseInt(mileage.getText().toString()),
                            color.getText().toString(),
                            Integer.parseInt(doorNumber.getText().toString()),
                            fuel.getText().toString(),
                            gearBox.getText().toString(),
                            state.getText().toString(),
                            type.getText().toString(),
                            DEFAULT_AVAILABILITY
                    );

                    Intent intent = new Intent(AddCarActivity.this, MainActivity.class);
                    startActivity(intent);
                    ActivityUtils.launchActivity(AddCarActivity.this, MainActivity.class, ActivityUtils.TYPE_SLIDE);
                    finish();
                } else {
                    Toast.makeText(AddCarActivity.this, "Informations manquantes", Toast.LENGTH_SHORT).show();
                }

            }
        });


        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(Intent.createChooser(intent, "Choix de la photo"), PICK_IMAGE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && data != null) {
            Picasso.get().load(data.getData()).into(image);
            imageUrl = data.getDataString();
        }
    }

}
