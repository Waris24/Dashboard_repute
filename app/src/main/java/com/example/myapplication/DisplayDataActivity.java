package com.example.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DisplayDataActivity extends AppCompatActivity {

    private TableLayout tableLayout;
    private int serialNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        tableLayout = findViewById(R.id.tableLayout);

        String apiUrl = getIntent().getStringExtra("apiUrl");
        new FetchDataFromApiTask().execute(apiUrl);
    }

    private class FetchDataFromApiTask extends AsyncTask<String, Void, JSONArray> {

        @Override
        protected JSONArray doInBackground(String... urls) {
            String urlString = urls[0];
            JSONArray jsonArray = null;

            try {
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = connection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                    String response = stringBuilder.toString();
                    jsonArray = new JSONArray(response);
                }
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }

            return jsonArray;
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            if (jsonArray != null) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        String bookingDate = jsonArray.getJSONObject(i).getString("Booking_Date");
                        String consignmentNo = jsonArray.getJSONObject(i).getString("ConsignmentNo");

                        TableRow tableRow = (TableRow) LayoutInflater.from(DisplayDataActivity.this).inflate(R.layout.table_row_item, null);
                        TextView serialNumberTextView = tableRow.findViewById(R.id.serialNumberTextView);
                        TextView bookingDateTextView = tableRow.findViewById(R.id.bookingDateTextView);
                        TextView consignmentNoTextView = tableRow.findViewById(R.id.consignmentNoTextView);

                        serialNumberTextView.setText(String.valueOf(serialNumber));
                        bookingDateTextView.setText(bookingDate);
                        consignmentNoTextView.setText(consignmentNo);

                        tableRow.setBackground(getResources().getDrawable(R.drawable.table_row_background));
                        tableLayout.addView(tableRow);
                        serialNumber++;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
