package ru.dudin.asynctasktest;

/**
 * @created 07.03.2019
 * @author Andrey Dudin <programmer1973@mail.ru>
 * @version 0.1.0.2019.03.07
 */

import android.os.AsyncTask;

import java.util.concurrent.TimeUnit;

public class AsyncTaskTestClass extends AsyncTask<String, Integer, Void> {

    public Listener listener;
    private static final String STARTED = "AsyncTasc started...";
    private static final String FINISHED = "AsyncTasc finished...";
    private static final String CANCELLED = "AsyncTasc canselled...";

    public void registerListener(Listener listener){
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        listener.setText(STARTED);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        listener.setText(FINISHED);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        listener.setText("Download " + values[0] + " file");
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();

        listener.setText(CANCELLED);
    }

    @Override
    protected Void doInBackground(String... voids) {
        int i = 0;
        try {
            for(String str : voids) {
                publishProgress(i++);
                TimeUnit.SECONDS.sleep(5);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    interface Listener {
        void setText(String text);
    }
}