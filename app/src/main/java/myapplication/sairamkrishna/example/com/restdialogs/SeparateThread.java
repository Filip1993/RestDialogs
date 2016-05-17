package myapplication.sairamkrishna.example.com.restdialogs;

import android.app.ProgressDialog;

/**
 * Created by programer on 17.5.2016..
 */

/************************************************************************************
 1.Najprije definiramo varijable
 2.Definiramo constructor
 3.overrideamo metodu run
 4.Imamo 2 vrste progress dialoga: withProgress i withNoProgress
 ************************************************************************************/

public class SeparateThread extends Thread {

    private ProgressDialog progressDialog;
    private boolean hasProgress;

    public SeparateThread(ProgressDialog progressDialog, boolean hasProgress) {
        this.progressDialog = progressDialog;
        this.hasProgress = hasProgress;
    }

    @Override
    public void run() {
        if (hasProgress) {
            sleepWithProgress();
        } else {
            sleepNoProgress();
        }

        progressDialog.dismiss();
    }

    private void sleepWithProgress() {
        while (progressDialog.getProgress() < 100) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
            progressDialog.incrementProgressBy(10);
        }
    }

    private void sleepNoProgress() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
    }
}

