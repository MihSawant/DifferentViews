package sawant.mihir.differentviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class CoffeeList extends AppCompatActivity {

    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_list);

        image = (ImageView) findViewById(R.id.displayImage);
        int id = getIntent().getExtras().getInt("logo");
        image.setImageResource(id);

    }
}