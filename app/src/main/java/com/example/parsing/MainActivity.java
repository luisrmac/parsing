package com.example.parsing;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parsing.model.generated.RandomResponse;
import com.example.parsing.util.Parser;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity_TAG";
    private static final String BASE_URL = "https://randomuser.me/api";

    private OkHttpClient okClient;
    private TextView resultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTV = findViewById(R.id.result);
        okClient = new OkHttpClient();
        performCall(BASE_URL);
    }

    private Request prepareRequest(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        return request;
    }

    private void performCall(String url) {
        okClient.newCall(prepareRequest(url)).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                // handle error
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final String res = response.body().string();
                Gson gson = new Gson();
//                final RandomResponse randomPerson = Parser.getInstance().parseResponse(res);
                final RandomResponse randomPerson = gson.fromJson(res, RandomResponse.class);
                resultTV.post(new Runnable() {
                    @Override
                    public void run() {
                        resultTV.setText(randomPerson.getResults().get(0).getName().toString());
                    }
                });
                Log.d(TAG, "setUpClient: parsed " + randomPerson);
                Log.d(TAG, "setUpClient: unparsed" + res);
            }
        });
    }

}
