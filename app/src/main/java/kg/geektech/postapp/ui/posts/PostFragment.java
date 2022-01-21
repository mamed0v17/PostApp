package kg.geektech.postapp.ui.posts;

import static android.provider.Contacts.SettingsColumns.KEY;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

import kg.geektech.postapp.App;
import kg.geektech.postapp.R;
import kg.geektech.postapp.databinding.FragmentPostBinding;
import kg.geektech.postapp.date.models.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PostFragment extends Fragment {

    private FragmentPostBinding binding;
private PostAdapter adapter;
private NavController controller;

    public PostFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new PostAdapter();
        adapter.setOnClick(new PostAdapter.onClick() {
            @Override
            public void onItemClick(int position) {
                Bundle bundle = new Bundle();
                 Post post = adapter.getItemCount(position);
                 bundle.putSerializable("key", post);
            }

            @Override
            public void onLongClick(int position) {

            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recycler.setAdapter(adapter);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.navigate(R.id.action_postFragment_to_formFragment);
            }
        });
        App.api.getPost().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful() && response.body() != null){
                    adapter.setPosts(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }
}