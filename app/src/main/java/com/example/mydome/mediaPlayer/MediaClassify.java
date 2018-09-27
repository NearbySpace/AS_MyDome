package com.example.mydome.mediaPlayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.mydome.R;
import com.example.mydome.adapter.MyAdapter;

public class MediaClassify extends FragmentActivity {
    private final String TAG = "MediaClassify";
    private String[] title = {"音乐频谱展示", "视频放缩和拖动"};
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common);
        initVeiw();
    }

    private void initVeiw() {
        lv = (ListView) findViewById(R.id.common_lv);
        MyAdapter adapter = new MyAdapter(this, title, null);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new MyOnItemClickListener());
    }


    class MyOnItemClickListener implements OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            switch (position) {
                case 0:
                    Intent intent = new Intent();
                    intent.setClass(MediaClassify.this, AudioWaveform.class);
                    startActivity(intent);
                    break;
                case 1:
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(android.R.id.content ,VideoFragment.newInstance() ,"VideoFragment");
                    transaction.addToBackStack(null);
                    transaction.commit();
                    break;

                default:
                    break;
            }
        }

    }

    private void loadFragment(int id, Fragment fragment) {
        Fragment f = getSupportFragmentManager().findFragmentByTag(fragment.getClass().getSimpleName());
        if (f != null) {
            Log.d(TAG ,"fragment is already added: " + f.getClass().getSimpleName());
            return;
        }
        getSupportFragmentManager().beginTransaction()
                .add(id, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
        //如果需要动画，可以把动画添加进来
        //                .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_right
        //                , R.anim.slide_in_left, R.anim.slide_out_right)
    }

}
