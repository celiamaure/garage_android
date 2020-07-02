package fr.ipac.garage.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
//FIXME: que pasa ?
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import fr.ipac.garage.R;
import fr.ipac.garage.activity.MainActivity;
import fr.ipac.garage.model.Car;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    private MainActivity activity;
    private ArrayList<Car> cars;

    public CarAdapter(MainActivity activity, ArrayList<Car> cars) {
        this.cars = cars;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.car_card, viewGroup, false);
        return new CarAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final Car car = cars.get(position);
        Picasso.get().load(car.getPicture()).into(viewHolder.picture);
        viewHolder.brand.setText(car.getBrand());
        viewHolder.model.setText(car.getModel());
        viewHolder.type.setText(car.getType());
        if (car.getAvailable()) {
            viewHolder.availability.setText("Disponible");
        } else {
            viewHolder.availability.setText("Non-disponible");
        }

        //TODO: au clic, rediriger vers la fiche produit et lui passer l'objet "car"
        /*viewHolder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileManager.getInstance().setPlayer(player);
                ActivityUtils.launchActivity(activity, MainActivity.class, ActivityUtils.TYPE_SLIDE);
            }

        });*/
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout container;
        private ImageView picture;
        private TextView brand;
        private TextView model;
        private TextView type;
        private TextView availability;
        ViewHolder(View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.container);
            picture = itemView.findViewById(R.id.picture);
            brand = itemView.findViewById(R.id.brand);
            model = itemView.findViewById(R.id.model);
            type = itemView.findViewById(R.id.type);
            availability = itemView.findViewById(R.id.availability);
        }
    }
}