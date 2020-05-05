package com.example.foodology;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

//public class Act2 extends AppCompatActivity {

   // @Override
    //protected void onCreate(Bundle savedInstanceState) {
       // super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_act2);

   // }
//}
public class Act2 extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem customization, nearme,myfav,myacc;
    public PagerAdapter pagerAdapter;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);
        tabLayout=(TabLayout) findViewById(R.id.tablayout);
        customization=(TabItem) findViewById(R.id.customization_button);
        nearme=(TabItem)findViewById(R.id.nearme_button);
        myfav=(TabItem)findViewById(R.id.my_favorite_button);
        myacc=(TabItem)findViewById(R.id.my_account_button);
        viewPager =findViewById(R.id.viewpager);
        pagerAdapter=new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0){
                    pagerAdapter.notifyDataSetChanged();}
                else if (tab.getPosition()==1){
                    pagerAdapter.notifyDataSetChanged();}
                else if (tab.getPosition()==2){
                    pagerAdapter.notifyDataSetChanged();}
                else if (tab.getPosition()==3){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_send:
                        String[] email = {"dy23@gmail.com"}; // 需要注意，email必须以数组形式传入
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("message/rfc822"); // 设置邮件格式
                        intent.putExtra(Intent.EXTRA_EMAIL, email); // 接收人
                        intent.putExtra(Intent.EXTRA_CC, email); // 抄送人
                        intent.putExtra(Intent.EXTRA_SUBJECT, "这是邮件的主题部分"); // 主题
                        intent.putExtra(Intent.EXTRA_TEXT, "这是邮件的正文部分"); // 正文
                        startActivity(Intent.createChooser(intent, "请选择邮件类应用"));
                        break;
                }
                return true;
            }
        });
    }


}

