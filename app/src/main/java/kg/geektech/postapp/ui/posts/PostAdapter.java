package kg.geektech.postapp.ui.posts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kg.geektech.postapp.databinding.ItemPostBinding;
import kg.geektech.postapp.date.models.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
private ItemPostBinding binding;
    private List<Post> posts = new ArrayList<>();
private onClick onClick;

    public void setOnClick(PostAdapter.onClick onClick) {
        this.onClick = onClick;
    }


    public void setPosts(List<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }





    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPostBinding binding = ItemPostBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new PostViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.onBind(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();

    }

    protected class PostViewHolder extends RecyclerView.ViewHolder {

        private ItemPostBinding binding;

        public PostViewHolder(@NonNull ItemPostBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Post post) {
            binding.tvUserId.setText(String.valueOf(post.getUserId()));
            binding.tvTitle.setText(post.getTittle());
            binding.tvContent.setText(post.getContent());
        }
    }

   interface onClick {
        void onItemClick(int position);
        void onLongClick(int position);


   }
}
