package com.network.app;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.network.sdk.activity.BaseActivity;
import com.network.sdk.activity.ImageViewerActivity;
import com.network.sdk.utils.FileUtils;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.imageViewer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPhotoByAlbum(new GetMediaListener() {
                    @Override
                    public void onSuccess(Uri uri) {
                        ArrayList<String> list = new ArrayList<>();
                        list.add(FileUtils.getFileByUri(MainActivity.this, uri).getAbsolutePath());
                        list.add("https://static.usasishu.com/image/2018/09/29/course_bg2_new.jpg");
                        list.add("https://static.usasishu.com/image/2018/09/30/bg-china-map.png");
                        list.add("https://static.usasishu.com/image/2018/09/30/bg-index.jpg");
                        list.add("https://static.usasishu.com/image/2018/10/12/course_first_bg.png");
                        list.add("https://static.usasishu.com/image/2018/10/12/how_to_learn_banner.png");
                        ImageViewerActivity.start(MainActivity.this, list, 0, null);
                    }
                });
            }
        });
    }
}
