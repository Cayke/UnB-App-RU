package com.caykeprudente.ru;


import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

/**
 * Created by cayke on 28/09/16.
 */

public class TabBarActivity extends AppCompatActivity {
    private Fragment currentFragment;
    private AHBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_bar_layout);
        initUI();
    }

    private void initUI() {

        bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);

        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.tab_1, R.drawable.icon_cardapio, R.color.colorPrimary);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.tab_2, R.drawable.icon_saldo, R.color.colorPrimary);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.tab_3, R.drawable.icon_info, R.color.colorPrimary);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.tab_4, R.drawable.icon_config, R.color.colorPrimary);

        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        bottomNavigation.addItem(item4);

        // Set background color
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

        // Disable the translation inside the CoordinatorLayout
        bottomNavigation.setBehaviorTranslationEnabled(false);

        // Change colors
        bottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));


        currentFragment = new CardapioFragment();
        //jogar na tela
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, currentFragment);
        fragmentTransaction.commit();

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                if (wasSelected) {
                    //currentFragment.refresh();
                    return true;
                } else {
                    if (position == 0) //cardapio
                        currentFragment = new CardapioFragment();
                    else if (position == 1) //consulta
                        currentFragment = new ConsultaFragment();
                    else if (position == 2) // info
                        currentFragment = new InfoFragment();
                    else if (position == 3) //config
                        currentFragment = new ConfigFragment();
                    else
                        return false;


                    //jogar na tela
                    FragmentManager fragmentManager;
                    FragmentTransaction fragmentTransaction;
                    fragmentManager = getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment, currentFragment);
                    fragmentTransaction.commit();

                    return true;
                }
            }
        });
    }

    /**
     * Show or hide the bottom navigation with animation
     */
    public void showOrHideBottomNavigation(boolean show) {
        if (show) {
            bottomNavigation.restoreBottomNavigation(true);
        } else {
            bottomNavigation.hideBottomNavigation(true);
        }
    }
}