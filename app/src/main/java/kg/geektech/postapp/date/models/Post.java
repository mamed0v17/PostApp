package kg.geektech.postapp.date.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Post implements Serializable {

    int id;
    String tittle;
    String content;
    @SerializedName("user")
    int userId;
    @SerializedName("group")
    int groupId;

    public Post(String tittle, String content, int userId, int groupId) {
        this.tittle = tittle;
        this.content = content;
        this.userId = userId;
        this.groupId = groupId;
    }

    public int getId() {
        return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
