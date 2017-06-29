package jungle68.com.musiclineview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import jungle68.com.library.widget.MusicLineView;

public class MainActivity extends AppCompatActivity {
    MusicLineView mMusicLineView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMusicLineView= (MusicLineView) findViewById(R.id.mlv_test);
        mMusicLineView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
