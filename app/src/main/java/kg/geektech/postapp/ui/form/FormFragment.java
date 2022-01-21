package kg.geektech.postapp.ui.form;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import kg.geektech.postapp.App;
import kg.geektech.postapp.databinding.FragmentFormBinding;
import kg.geektech.postapp.date.models.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FormFragment extends Fragment {

   private static final int GROUP_ID = 38;
   private static final int USER_ID = 0;
   private Post post;
   private FragmentFormBinding binding;

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      binding = FragmentFormBinding.inflate(inflater, container, false);
      return binding.getRoot();
   }

   @Override
   public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
      initArgument();
      initLogic();
   }

   private void initLogic() {
      binding.btnSend.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            String tittle = binding.etTitle.getText()
                    .toString();
            String content = binding.etContent.getText()
                    .toString();
            if (getArguments() != null) {
               App.api.updateList(post.getId(), post).enqueue(new Callback<Post>() {
                  @Override
                  public void onResponse(Call<Post> call, Response<Post> response) {
                     requireActivity().onBackPressed();
                  }

                  @Override
                  public void onFailure(Call<Post> call, Throwable t) {

                  }
               });
            } else {
               post = new Post(
                       tittle,
                       content,
                       USER_ID,
                       GROUP_ID
               );
               App.api.createPost(post).enqueue(new Callback<Post>() {
                  @Override
                  public void onResponse(Call<Post> call, Response<Post> response) {
                     requireActivity().onBackPressed();
                  }

                  @Override
                  public void onFailure(Call<Post> call, Throwable t) {

                  }
               });
            }
         }
      });
   }

   private void initArgument() {
      if (getArguments() != null) {
         post = (Post) getArguments().getSerializable("key");
         binding.etTitle.setText(post.getTittle());
         binding.etContent.setText(post.getContent());
      }
   }
}