package ng.com.alphatec.gads2020leaderboard;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProjectSubmission extends AppCompatActivity {
    ImageButton backButton;
    EditText fName, lName, email, gitHub;
    TextView textViewResult;
    Button submit;
    PostHolderAPI holderAPI;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_submission);
        //hooks
        fName = findViewById(R.id.firstName);
        lName = findViewById(R.id.lastName);
        email = findViewById(R.id.emailAddress);
        gitHub = findViewById(R.id.gitHub);
        backButton = findViewById(R.id.backBtn);
        submit = findViewById(R.id.submitBtn);
        textViewResult = findViewById(R.id.title);

        //setOnclick listener on the back image
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProjectSubmission.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                //.baseUrl("https://docs.google.com/forms/d/e/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        holderAPI = retrofit.create(PostHolderAPI.class);

        String emailAddress = email.getText().toString().trim();
        String firstName = fName.getText().toString().trim();
        String lastName = lName.getText().toString().trim();
        String gitHubLink = gitHub.getText().toString().trim();

       // Call<PostHolder> call = PostHolderAPI.createPost(emailAddress, firstName, lastName, gitHubLink);
        /*Call<PostHolder> call = PostHolderAPI.createTestPost(23, "emailAddress", "firstName");
        call.enqueue(new Callback<PostHolder>() {
            @Override
            public void onResponse(Call<PostHolder> call, Response<PostHolder> response) {

                if(!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                }
                PostHolder postResponse = response.body();
                String content = "";
                content += "Code: " + response.code() + "\n";
                content += "ID: " + postResponse.getId() + "\n";
                content += "User ID: " + postResponse.getUserId() + "\n";
                content += "Title: " + postResponse.getTitle() + "\n";
                content += "Body: " + postResponse.getBody() + "\n";
                textViewResult.setText(content);
            }

            @Override
            public void onFailure(Call<PostHolder> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });*/
    }

}