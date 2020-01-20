package apurva.app.com.drivvoapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Refueling extends AppCompatActivity {

    EditText etDate, etHour, etOdometer, etFuel, etPrice_ltr, etTotalPrice, etGallons,etGasStation;

    double price_ltr;
    double total_price;
    double gallons;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.refueling);

        etDate = (EditText)findViewById(R.id.etDate);
        etHour = (EditText)findViewById(R.id.etHour);
        etOdometer = (EditText)findViewById(R.id.etOdometer);
        etFuel = (EditText)findViewById(R.id.etFuel);
        etPrice_ltr = (EditText)findViewById(R.id.etPrice_ltr);
        etTotalPrice = (EditText)findViewById(R.id.etTotalPrice);
        etGallons = (EditText)findViewById(R.id.etGallons);
        etGasStation = (EditText)findViewById(R.id.etGasStation);

        etDate.setFocusable(false);


        total_price = price_ltr * gallons;
        price_ltr = total_price/gallons;
        gallons = total_price / price_ltr;







//        String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());
//
//// textView is the TextView view that should display it
//        textView.setText(currentDateTimeString);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeF = new SimpleDateFormat("HH:mm", Locale.getDefault());
        String date = sdf.format(new Date());
        String time = timeF.format(Calendar.getInstance().getTime());

        etDate.setText(date);
        etHour.setText(time);


        etGasStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
//                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//                mapIntent.setPackage("com.google.android.apps.maps");
//                if (mapIntent.resolveActivity(getPackageManager()) != null) {
//                    startActivity(mapIntent);
//                }

                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(i);



            }
        });

        }


}
