package myapplication.sairamkrishna.example.com.restdialogs;

import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnCircle;
    private Button btnProgress;
    private Button btnSetDate;
    private Button btnSetTime;
    private ProgressDialog progressDialog; //ovaj dialog extenda fragment ProgressDialog
    private TextView tvDate;
    private TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupListeners();
    }

    private void initWidgets() {
        btnCircle = (Button) findViewById(R.id.btnCircle);
        btnProgress = (Button) findViewById(R.id.btnProgress);
        btnSetDate = (Button) findViewById(R.id.btnSetDate);
        btnSetTime = (Button) findViewById(R.id.btnSetTime);
        tvDate = (TextView) findViewById(R.id.tvDate);
        tvTime = (TextView) findViewById(R.id.tvTime);
    }

    private void setupListeners() {
        btnCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //FACTORY METODA:
                progressDialog = ProgressDialog.show(MainActivity.this, "Loading", "Please wait");

                //Netko treba ubit progressDialog, pa napravimo dependency injection:
                SeparateThread separateThread = new SeparateThread(progressDialog, false); //napravili smo thread
                separateThread.start(); //zapocinjemo Thread
            }
        });

        btnProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL); //Pogress Dialog horizontalnog tipa
                progressDialog.setMessage("Downloading");
                progressDialog.show();


                SeparateThread separateThread = new SeparateThread(progressDialog, true); //napravili smo thread
                separateThread.start(); //zapocinjemo Thread
            }
        });

        btnSetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment df = new DatePickerFragment();
                df.show(getFragmentManager(), null);
            }
        });

        btnSetTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new TimePickerFragment();
                dialogFragment.show(getFragmentManager(), null);
            }
        });
    }

    //ENKAPSULACIJA -> otvaramo se preko Main Activityja:
    public void setTime(String time) {
        tvTime.setText(time);
    }

    public void setDate(String date) {
        tvDate.setText(date);
    }
}
