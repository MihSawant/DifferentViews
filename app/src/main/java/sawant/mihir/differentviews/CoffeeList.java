package sawant.mihir.differentviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class CoffeeList extends AppCompatActivity {

    ImageView image;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_list);


        image = (ImageView) findViewById(R.id.displayImage);
        listView = (ListView) findViewById(R.id.ordersList);

        ArrayList<String> selectedItems = getIntent().getExtras().getStringArrayList("orders");

        System.out.println(selectedItems);


        ArrayAdapter<Object> orders = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, selectedItems.toArray());

        listView.setAdapter(orders);

        int id = getIntent().getExtras().getInt("logo");
        image.setImageResource(id);

    }
}