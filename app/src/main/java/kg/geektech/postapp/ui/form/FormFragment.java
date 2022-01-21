package kg.geektech.postapp.ui.form;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kg.geektech.postapp.App;
import kg.geektech.postapp.R;
import kg.geektech.postapp.databinding.FragmentFormBinding;
import kg.geektech.postapp.date.models.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FormFragment extends Fragment {
   private static final int groupId = 38;
   private static final int userId = 0;
 private FragmentFormBinding binding;
    public FormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentFormBinding.inflate(inflater, container,false);
       return binding.getRoot();
    }

   @Override
   public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);

      binding.btnSend.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            String tittle = binding.etTitle.getText()
                    .toString();
            String content = binding.etContent.getText()
                    .toString();
            Post post = new Post(
                    tittle,
                    content,
                    userId,
                    groupId
            );
            App.api.createPost(post).enqueue(new Callback<Post>() {
               @Override
               public void onResponse(Call<Post> call, Response<Post> response) {
                  if (response.isSuccessful() && response.body() != null){
                     requireActivity().onBackPressed();
                  }
               }

               @Override
               public void onFailure(Call<Post> call, Throwable t) {

               }
            });
         }
      });
   }
}