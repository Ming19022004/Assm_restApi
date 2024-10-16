package fpoly.duyltph38444.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import fpoly.duyltph38444.assignment.adapter.FragmentAdapter;
import fpoly.duyltph38444.assignmentand103.R;

public class NavigationBottom extends AppCompatActivity {
    ViewPager2 viewPager2;
    BottomNavigationView bottomNavigationView;
    FragmentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_bottom);
viewPager2=findViewById(R.id.viewPager2);
bottomNavigationView=findViewById(R.id.bottomNavigatin);
       adapter=new FragmentAdapter(this);
       viewPager2.setAdapter(adapter);
//chuyển màn hình fragnment khi nhấn vào nút dưới drawerbottom

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id =item.getItemId();
                if (id == R.id.navigation_home) {
                    viewPager2.setCurrentItem(0);
                } else if (id == R.id.navigation_detail) {
                    viewPager2.setCurrentItem(1);
                } else if (id == R.id.navigation_favourite) {
                    viewPager2.setCurrentItem(2);
                }
                else if (id == R.id.navigation_frofile) {
                    viewPager2.setCurrentItem(3);
                }
                return false;
            }
        });
        //chuyển các fragnment trong drawer
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.navigation_home).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.navigation_detail).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.navigation_favourite).setChecked(true);
                        break;
                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.navigation_frofile).setChecked(true);
                        break;
                }
            }
        });

    }
}