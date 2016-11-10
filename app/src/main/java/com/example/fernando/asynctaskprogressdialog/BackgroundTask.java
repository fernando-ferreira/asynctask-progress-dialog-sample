package com.example.fernando.asynctaskprogressdialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

public class BackgroundTask extends AsyncTask<Void, Void, Void>{
    private ProgressDialog progressDialog;

    public BackgroundTask(Activity activity) {
        this.progressDialog = new ProgressDialog(activity);
    }

    @Override
    protected void onPreExecute() {
        this.progressDialog.setMessage("Doing something, please wait.");
        this.progressDialog.show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if (this.progressDialog.isShowing())
            this.progressDialog.dismiss();
    }
}
