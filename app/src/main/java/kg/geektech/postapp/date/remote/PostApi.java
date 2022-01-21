package kg.geektech.postapp.date.remote;

import java.util.List;

import kg.geektech.postapp.date.models.Post;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PostApi {

    @GET("/posts")
    Call<List<Post>> getPost();

    @POST("/posts")
    Call<Post> createPost(
      @Body Post post
    );

    @DELETE("/posts/{id}")
    Call<Post> deletePost(
            @Path("id") int id
    );
}
