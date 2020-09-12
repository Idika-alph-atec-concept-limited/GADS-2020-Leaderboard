package ng.com.alphatec.gads2020leaderboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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

public class TopLearners extends Fragment {
    RecyclerView recyclerView;
    ArrayList<TopLearnHelperClass> posts;
    private static String JSON_URL ="https://gadsapi.herokuapp.com/api/hours";
    TopLearnAdapter adapter;

    public TopLearners() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_top_learners, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewPost);
        posts = new ArrayList<>();
        extractPost();
        return view;
    }
    private void extractPost() {
        RequestQueue queue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject postObject = response.getJSONObject(i);
                        TopLearnHelperClass post = new TopLearnHelperClass();
                        post.setName(postObject.getString("name"));
                        post.setHours(postObject.getString("hours"));
                        post.setCountry(postObject.getString("country"));
                        post.setBadgeUrl(postObject.getString("badgeUrl"));
                        posts.add(post);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                adapter = new TopLearnAdapter(getContext(), posts);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TAG", "onErrorResponse: "+ error.getMessage());
            }
        });

        queue.add(jsonArrayRequest);
    }
}