package com.dharmbir.customlistadapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends Activity {

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listview);

        String jsonStr = "[{\n" +
                "\t\"name\": \"The Mobile Era\",\n" +
                "\t\"description\": \"This is mobile solution provider.\",\n" +
                "\t\"image\": \"https://s21.postimg.org/wekkhv39j/10348618_611887282283436_5106581981740849851_n.jpg\"\n" +
                "}, {\n" +
                "\t\"name\": \"Dharmbir Singh\",\n" +
                "\t\"description\": \"This is mobile solution provider.\",\n" +
                "\t\"image\": \"https://s21.postimg.org/wekkhv39j/10348618_611887282283436_5106581981740849851_n.jpg\"\n" +
                "}]";


        Type type = new TypeToken<List<UserM>>(){}.getType();
        Gson gson = new Gson();
        List<UserM> users = (List<UserM>) gson.fromJson(jsonStr, type);
        CustomAdapter adapter = new CustomAdapter(this, users);
        listview.setAdapter(adapter);
    }
}
