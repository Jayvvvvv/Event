//package com.example.event;
//
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentTransaction;
//
//import android.content.Intent;
//import android.os.Bundle;
//
//import com.example.event.databinding.ActivityBottomNavigationBarBinding;
//
//public class BottomNavigationBar extends AppCompatActivity {
//
//    ActivityBottomNavigationBarBinding binding;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivityBottomNavigationBarBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//        replaceFragment(new HomeFragment());
//
//        binding.bottomNavigation.setOnItemSelectedListener(item -> {
//
//                switch (item.getItemId()){
//                    case R.id.home:
//                        replaceFragment(new HomeFragment());
//                        break;
//
//                    case R.id.vendor:
//                        replaceFragment(new HomeFragment());
//                        break;
//
//                    case R.id.e_invites:
//                        replaceFragment(new HomeFragment());
//                        break;
//
//                    case R.id.ideas:
//                        startActivity(new Intent(getApplicationContext(), IdeaScreen.class));
//                        overridePendingTransition(0,0);
//                        return true;
//
//                    case R.id.plane:
//                        startActivity(new Intent(getApplicationContext(), PlanningScreen.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                }
//
//                return true;
//        });
//    }
//    private void replaceFragment(Fragment fragment){
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frame, fragment);
//        fragmentTransaction.commit();
////                ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//    }
//}