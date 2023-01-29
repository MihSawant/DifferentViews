package sawant.mihir.differentviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    Button buyButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView) findViewById(R.id.logo);
        buyButton = (Button) findViewById(R.id.buyBtn);

        buyButton.setOnClickListener(view -> {
            Intent myIntent = new Intent(view.getContext(), CoffeeList.class);

            myIntent.putExtra("logo", R.mipmap.coffee_cup);
            if(myIntent.resolveActivity(getPackageManager()) != null){
                startActivity(myIntent);
            }
        });
    }
}