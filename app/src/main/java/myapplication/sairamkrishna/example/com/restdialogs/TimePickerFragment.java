package myapplication.sairamkrishna.example.com.restdialogs;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by programer on 17.5.2016..
 */

//Najprije extendamo DialogFragment
//Onda definiramo timePickerDialog
//Pa  iskoristimo Calendar klasu
//Onda override-amo onTimeSet metodu
public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.HOUR_OF_DAY);

        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));

        return timePickerDialog;

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        MainActivity mainActivity = (MainActivity) getActivity();
        String time = hourOfDay + ":" + minute;
        mainActivity.setTime(time);
    }
}
