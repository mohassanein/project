package com.example.amitnew.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.amitnew.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EcommerceAmit extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecommerce_amit);
     //   showFragment(new HomeFragment());
        initview();

      //  bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        //    @Override
          //  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            //    switch (item.getItemId()) {
              //      case R.id.homeFragment:
                //        showFragment(new HomeFragment());
                  //      return true;
                    //case R.id.categoriesFragment:
                      //  showFragment(new CategoriesFragment());
                        //return true;
                    //case R.id.cartfragment:
                     //   showFragment(new Cartfragment());
                      //  return true;
                   // case R.id.profileFragment:
                     //   showFragment(new ProfileFragment());
                      //  return true;
     //           }
       //         return true;
         //   }

     //   });
    }

    // connect the navigation controller with bottom_navigation_menu
        protected void initview(){
            bottomNavigationView = findViewById(R.id.bottom_navigation_menu);
           navController = Navigation.findNavController(this,R.id.fragment_container);
            NavigationUI.setupWithNavController(bottomNavigationView,navController);

        }


        //private void showFragment (Fragment fragment){
          //  FragmentManager fm = getSupportFragmentManager();
            //FragmentTransaction ft = fm.beginTransaction();
            //ft.replace(R.id.fragment_container, fragment);
            //ft.commit();
        //}
    }
