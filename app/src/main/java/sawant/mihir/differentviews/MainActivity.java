package sawant.mihir.differentviews;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    Button buyButton;

    ListView coffees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView) findViewById(R.id.logo);
        buyButton = (Button) findViewById(R.id.buyBtn);

        coffees = (ListView) findViewById(R.id.coffees);

        ArrayList<String> orders = new ArrayList<>();

        ArrayAdapter<String> coffeeMenu = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_checked,
                new String[]{"Java Chip", "Vanilla Cream", "Caramel Espresso", "White Mocha"});

        coffees.setAdapter(coffeeMenu);


        coffees.setOnItemClickListener(( adapterView,  view,  i,  l) -> {

            Adapter myAdapter = adapterView.getAdapter();
                myAdapter.getView(i, view, adapterView)
                        .setBackgroundColor(Color.LTGRAY);

            orders.add((String) myAdapter.getItem(i));

            }
        );


        buyButton.setOnClickListener(view -> {
            Intent myIntent = new Intent(view.getContext(), CoffeeList.class);
            myIntent.putExtra("logo", R.mipmap.coffee_cup);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("orders", orders);
            myIntent.putExtras(bundle);
            if(myIntent.resolveActivity(getPackageManager()) != null){
                startActivity(myIntent);
            }
        });
    }
}