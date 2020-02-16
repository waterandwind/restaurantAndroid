package com.example.testapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.ScrollIndicatorView;
import com.shizhefei.view.indicator.slidebar.ColorBar;
import com.shizhefei.view.indicator.slidebar.ScrollBar;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main2Activity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        initViews();
//        IntentFilter intentFilter = new IntentFilter(CAR_ACTION);
//        intentFilter.addAction(CLEARCAR_ACTION);
//        registerReceiver(broadcastReceiver, intentFilter);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                final Bitmap bitmap= HttpUtil.getImage(UrlString.systemUrl+"file/imgShow/123.jpg");
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        imageView.setImageBitmap(bitmap);
//                    }
//                });
//            }
//        }).start();


//        Toolbar toolbar=findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        mDrawerLayout=findViewById(R.id.drawer_layout);
//        NavigationView navigationView=findViewById(R.id.nav_view);
//        ActionBar actionBar= getSupportActionBar();
//        if (actionBar != null){
//            actionBar.setDisplayHomeAsUpEnabled(true);
//            actionBar.setHomeAsUpIndicator(R.drawable.ic_launcher_background);
//        }
//        navigationView.setCheckedItem(R.id.person);
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                Toast.makeText(Main2Activity.this,"点击我的资料",Toast.LENGTH_LONG).show();
//                return true;
//            }
//        });
    }
//    @Override
//    public void onAddClick(View view, FoodBean fb) {
//        dealCar(fb);
//        ViewUtils.addTvAnim(view, shopCarView.carLoc, mContext, rootview);
//    }
//
//    @Override
//    public void onSubClick(FoodBean fb) {
//        dealCar(fb);
//    }
//
//    private void dealCar(FoodBean foodBean) {
//        HashMap<String, Long> typeSelect = new HashMap<>();//更新左侧类别badge用
//        BigDecimal amount = new BigDecimal(0.0);
//        int total = 0;
//        boolean hasFood = false;
//        if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
//            firstFragment.getFoodAdapter().notifyDataSetChanged();
//        }
//        List<FoodBean> flist = carAdapter.getData();
//        int p = -1;
//        for (int i = 0; i < flist.size(); i++) {
//            FoodBean fb = flist.get(i);
//            if (fb.getId() == foodBean.getId()) {
//                fb = foodBean;
//                hasFood = true;
//                if (foodBean.getSelectCount() == 0) {
//                    p = i;
//                } else {
//                    carAdapter.setData(i, foodBean);
//                }
//            }
//            total += fb.getSelectCount();
//            if (typeSelect.containsKey(fb.getType())) {
//                typeSelect.put(fb.getType(), typeSelect.get(fb.getType()) + fb.getSelectCount());
//            } else {
//                typeSelect.put(fb.getType(), fb.getSelectCount());
//            }
//            amount = amount.add(fb.getPrice().multiply(BigDecimal.valueOf(fb.getSelectCount())));
//        }
//        if (p >= 0) {
//            carAdapter.remove(p);
//        } else if (!hasFood && foodBean.getSelectCount() > 0) {
//            carAdapter.addData(foodBean);
//            if (typeSelect.containsKey(foodBean.getType())) {
//                typeSelect.put(foodBean.getType(), typeSelect.get(foodBean.getType()) + foodBean.getSelectCount());
//            } else {
//                typeSelect.put(foodBean.getType(), foodBean.getSelectCount());
//            }
//            amount = amount.add(foodBean.getPrice().multiply(BigDecimal.valueOf(foodBean.getSelectCount())));
//            total += foodBean.getSelectCount();
//        }
//        shopCarView.showBadge(total);
//        firstFragment.getTypeAdapter().updateBadge(typeSelect);
//        shopCarView.updateAmount(amount);
//    }
//    @Override
//    protected int getLayoutId() {
//        return R.layout.activity_main2;
//    }
//    private void initViews() {
//        rootview =  findViewById(R.id.rootview);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        initViewpager();
//        initShopCar();
//    }
//    private void initViewpager() {
//        scroll_container = findViewById(R.id.scroll_container);
//        ScrollIndicatorView mSv = (ScrollIndicatorView) findViewById(R.id.indicator);
//        ColorBar colorBar = new ColorBar(mContext, ContextCompat.getColor(mContext, R.color.dicator_line_blue), 6,
//                ScrollBar.Gravity.BOTTOM);
//        colorBar.setWidth(ViewUtils.dip2px(mContext, 30));
//        mSv.setScrollBar(colorBar);
//        mSv.setSplitAuto(false);
//        mSv.setOnTransitionListener(new OnTransitionTextListener().setColor(ContextCompat.getColor(mContext, R.color.dicator_line_blue),
//                ContextCompat.getColor(mContext, R.color.black)));
//        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewpager);
//        IndicatorViewPager indicatorViewPager = new IndicatorViewPager(mSv, mViewPager);
//        firstFragment = new FirstFragment();
//        ViewpagerAdapter myAdapter = new ViewpagerAdapter(getSupportFragmentManager());
//        indicatorViewPager.setAdapter(myAdapter);
//    }
//
//    private class ViewpagerAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {
//        private LayoutInflater inflater;
//        private int padding;
//        private String[] tabs = new String[]{"商品"};
//
//        ViewpagerAdapter(FragmentManager fragmentManager) {
//            super(fragmentManager);
//            inflater = LayoutInflater.from(mContext);
//            padding = ViewUtils.dip2px(mContext, 20);
//        }
//
//        @Override
//        public int getCount() {
//            return tabs.length;
//        }
//
//        @Override
//        public View getViewForTab(int position, View convertView, ViewGroup container) {
//            convertView = inflater.inflate(R.layout.item_textview, container, false);
//            TextView textView = (TextView) convertView;
//            textView.setText(tabs[position]); //名称
//            textView.setPadding(padding, 0, padding, 0);
//            return convertView;
//        }
//
//        @Override
//        public Fragment getFragmentForPage(int position) {
//            switch (position) {
//                case 0:
//                    return firstFragment;
//            }
//            return null;
//        }
//
//    }
//    private void initShopCar() {
//        behavior = BottomSheetBehavior.from(findViewById(R.id.car_container));
//        shopCarView = (ShopCarView) findViewById(R.id.car_mainfl);
//        View blackView = findViewById(R.id.blackview);
//        shopCarView.setBehavior(behavior, blackView);
//        RecyclerView carRecView = (RecyclerView) findViewById(R.id.car_recyclerview);
////		carRecView.setNestedScrollingEnabled(false);
//        carRecView.setLayoutManager(new LinearLayoutManager(mContext));
//        ((DefaultItemAnimator) carRecView.getItemAnimator()).setSupportsChangeAnimations(false);
//        carAdapter = new CarAdapter(new ArrayList<FoodBean>(), this);
//        carAdapter.bindToRecyclerView(carRecView);
//    }
//
//
//    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            switch (intent.getAction()) {
//                case CAR_ACTION:
//                    FoodBean foodBean = (FoodBean) intent.getSerializableExtra("foodbean");
//                    FoodBean fb = foodBean;
//                    int p = intent.getIntExtra("position", -1);
//                    if (p >= 0 && p < firstFragment.getFoodAdapter().getItemCount()) {
//                        fb = firstFragment.getFoodAdapter().getItem(p);
//                        fb.setSelectCount(foodBean.getSelectCount());
//                        firstFragment.getFoodAdapter().setData(p, fb);
//                    } else {
//                        for (int i = 0; i < firstFragment.getFoodAdapter().getItemCount(); i++) {
//                            fb = firstFragment.getFoodAdapter().getItem(i);
//                            if (fb.getId() == foodBean.getId()) {
//                                fb.setSelectCount(foodBean.getSelectCount());
//                                firstFragment.getFoodAdapter().setData(i, fb);
//                                break;
//                            }
//                        }
//                    }
//                    dealCar(fb);
//                    break;
//                case CLEARCAR_ACTION:
//                    clearCar();
//                    break;
//            }
//            if (CAR_ACTION.equals(intent.getAction())) {
//
//            }
//        }
//    };
//
//    private void clearCar() {
//        List<FoodBean> flist = carAdapter.getData();
//        for (int i = 0; i < flist.size(); i++) {
//            FoodBean fb = flist.get(i);
//            fb.setSelectCount(0);
//        }
//        carAdapter.setNewData(new ArrayList<FoodBean>());
//        firstFragment.getFoodAdapter().notifyDataSetChanged();
//        shopCarView.showBadge(0);
//        firstFragment.getTypeAdapter().updateBadge(new HashMap<String, Long>());
//        shopCarView.updateAmount(new BigDecimal(0.0));
//    }
}
