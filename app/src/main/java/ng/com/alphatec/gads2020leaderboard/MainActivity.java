package ng.com.alphatec.gads2020leaderboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager;
    TabLayout mTabLayout;
    TabItem newsitem, galleonitem;
    PageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//hooks
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.getMinimumHeight();
        setSupportActionBar(toolbar);
        viewPager = findViewById(R.id.viewpager);
        mTabLayout = findViewById(R.id.tablayout);
        newsitem = findViewById(R.id.newsitem);
        galleonitem = findViewById(R.id.galleonitem);

        adapter = new PageAdapter(this);
        viewPager.setAdapter(adapter);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(mTabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position){
                            case 0:{
                                tab.setText("Leading Learners");
                                break;
                            }
                            case 1:{
                                tab.setText("Skill IQ Leaders");
                                break;
                            }
                        }
                    }
                });
        tabLayoutMediator.attach();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.right_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_home:
                Intent intent = new Intent(this, ProjectSubmission.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}