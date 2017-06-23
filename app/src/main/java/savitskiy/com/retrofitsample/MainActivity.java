package savitskiy.com.retrofitsample;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    private Button button;
    private final String URL = "https://www.googleapis.com";
    private final String key = "AIzaSyAn2bDeGHo8n5UpjARutwnOW8KecYK_wjs";
    private Gson gson = new GsonBuilder().setLenient().create();
    private Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson)).baseUrl(URL).build();
    private ILink intf = retrofit.create(ILink.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Task().execute(editText.getText().toString());
            }
        });


    }


    private class Task extends AsyncTask<String, String, String> {


        @Override
        protected String doInBackground(String... params) {
            Map<String, String> mapJson = new HashMap<String, String>();
            String s = null;
            try {
                s = URLEncoder.encode(params[0], "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            mapJson.put("key", key);
            mapJson.put("q", s);
            mapJson.put("target", "uk");
            mapJson.put("source", "en");

            Call<Object> call = intf.translate(mapJson);
            String res = null;
            try {
                Response<Object> response = call.execute();
//                String ss = response.body().toString().replaceAll("[^\\p{L}\\s0-9.\\{\\}\\[\\]\\:\\,\\=]+", "").trim();
                String ss = response.body().toString();//.replaceAll("\\s+\\+\\s+", " ");

                JsonReader reader = new JsonReader(new StringReader(ss));
                reader.setLenient(true);

                savitskiy.com.retrofitsample.Response resp = gson.fromJson(reader, savitskiy.com.retrofitsample.Response.class);
                Data data = resp.getData();
                res = data.getTranslations().get(0).getTranslatedText();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return res;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textView.setText(s);
        }
    }
}
