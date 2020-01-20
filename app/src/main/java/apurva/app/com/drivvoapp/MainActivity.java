package apurva.app.com.drivvoapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import apurva.app.com.drivvoapp.R;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    FloatingActionButton fab, income, service, route, refueling, reminder;



    BottomSheetBehavior sheetBehavior;
    LinearLayout bottom_sheet_layout;
    Animation fab_open, fab_close, rotate_forward, rotate_backward;
    boolean isOpen= true;
    @BindView(R.id.bottom_sheet)
    RelativeLayout layoutBottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);



        fab = (FloatingActionButton) findViewById(R.id.fab);
        income = (FloatingActionButton) findViewById(R.id.income);
        service = (FloatingActionButton) findViewById(R.id.service);
        route = (FloatingActionButton) findViewById(R.id.route);
        refueling = (FloatingActionButton) findViewById(R.id.imgrefueling);
        reminder = (FloatingActionButton) findViewById(R.id.reminder);
        // layoutBottomSheet = (LinearLayout) findViewById(R.id.bottom_sheet);

        fab_open =AnimationUtils.loadAnimation(this,R.anim.fab_open);
        fab_close =AnimationUtils.loadAnimation(this,R.anim.fab_close);
        rotate_forward =AnimationUtils.loadAnimation(this,R.anim.rotate_forward);
        rotate_backward =AnimationUtils.loadAnimation(this,R.anim.rotate_backward);

        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);

//        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
//            @Override
//            public void onStateChanged(@NonNull View bottomSheet, int newState) {
//                switch (newState) {
//                    case BottomSheetBehavior.STATE_HIDDEN:
//
//                        layoutBottomSheet.setVisibility(View.INVISIBLE);
//                        break;
//                    case BottomSheetBehavior.STATE_EXPANDED: {
//                        layoutBottomSheet.setVisibility(View.VISIBLE);
//
//                    }
//                    break;
////                    case BottomSheetBehavior.STATE_COLLAPSED: {
////
////                    }
////                    break;
////                    case BottomSheetBehavior.STATE_DRAGGING:
////                        break;
////                    case BottomSheetBehavior.STATE_SETTLING:
////                        break;
//                }
//            }
//
//            @Override
//            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
//
//            }
//        });


        fab.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {


                if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

                    layoutBottomSheet.setVisibility(View.VISIBLE);

                } else {

                    layoutBottomSheet.setVisibility(View.INVISIBLE);
                    sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

                }

                animateFab();





            }
        });

        refueling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Refueling.class);
                startActivity(i);
            }
        });

    }

    private void animateFab(){
        if(isOpen){
            fab.startAnimation(rotate_forward);
            isOpen = false;
            Log.d("isOpen", String.valueOf(isOpen));

        }else {

            fab.startAnimation(rotate_backward);
            isOpen = true;

            Log.d("isOpen", String.valueOf(isOpen));

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
