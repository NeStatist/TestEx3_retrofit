package com.example.retrofit.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import com.example.retrofit.CallBack.ChannelCallback;
import com.example.retrofit.R;
import com.example.retrofit.network.model.channel.ChannelResponse;
import com.example.retrofit.presenter.PresenterChannel;

public class ChannelActivity extends AppCompatActivity implements ChannelCallback {

    private ChannelRecyclerAdapter adapter;
    private RecyclerView recyclerView;
    private PresenterChannel presenterChannel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel);

        presenterChannel = new PresenterChannel(this);

        recyclerView = findViewById(R.id.recyclerCateg);
        adapter = new ChannelRecyclerAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        presenterChannel.getChannel();
    }

    @Override
    public void success(ChannelResponse response) {
        adapter.submitList(response.getData());
    }

    @Override
    public void fail(Throwable throwable) {
        Log.e("Response", throwable.toString());
    }
}
