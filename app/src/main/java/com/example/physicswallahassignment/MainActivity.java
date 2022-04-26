package com.example.physicswallahassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   /* private Button bt_view_more;
    private ConstraintLayout expandable;
    private RequestQueue mQueue;*/

    RecyclerView recyclerView;
    List<Faculty>faculties;
    private static String JSON_URL = "https://my-json-server.typicode.com/easygautam/data/users";
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* bt_view_more = findViewById(R.id.bt_view_more);
        expandable = findViewById(R.id.expandable);

        mQueue = Volley.newRequestQueue(this);

        bt_view_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        }); */

        recyclerView = findViewById(R.id.recycler_view);
        faculties = new ArrayList<>();

        extractFaculties();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, faculties);
        recyclerView.setAdapter(adapter);

    }

    private void extractFaculties(){
        RequestQueue queue  = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                JSON_URL,
                null,
                new Response.Listener<JSONArray>(){
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject facultyObject = response.getJSONObject(i);

                                Faculty faculty = new Faculty();
                                faculty.setName(facultyObject.getString("name"));
                                faculty.setSubject(facultyObject.getString("subjects"));
                                faculty.setCollege(facultyObject.getString("qualification"));
                                faculty.setPersonURL(facultyObject.getString("profileImage"));

                                faculties.add(faculty);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        adapter = new Adapter(getApplicationContext(), faculties);
                        recyclerView.setAdapter(adapter);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("tag","onErrorResponse"+error.getMessage());
                    }
                });

        queue.add(jsonArrayRequest);
    }
}