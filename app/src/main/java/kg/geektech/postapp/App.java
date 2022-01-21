package kg.geektech.postapp;

import android.app.Application;

import kg.geektech.postapp.date.remote.PostApi;
import kg.geektech.postapp.date.remote.RetrofitClient;

public class App extends Application {

    private RetrofitClient client;
     public static PostApi api;

    @Override
    public void onCreate() {
        super.onCreate();
        client = new RetrofitClient();
        api = client.provideApi();
    }
}
