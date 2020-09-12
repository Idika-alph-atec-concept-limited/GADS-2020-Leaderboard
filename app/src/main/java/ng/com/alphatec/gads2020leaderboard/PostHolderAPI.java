package ng.com.alphatec.gads2020leaderboard;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PostHolderAPI {

    @GET("posts")
    Call<List<PostHolder>> getPosts();

    @FormUrlEncoded
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    Call<PostHolder> createPost(
            @Field("entry.1824927963") String email,
            @Field("entry.1877115667") String firstName,
            @Field("entry.2006916086") String lastName,
            @Field("entry.642603327") String trackNumber,
            @Field("entry.284483984") String gitHub
    );

    @FormUrlEncoded
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    Call<PostHolder> createTestPost(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String body
    );
}
