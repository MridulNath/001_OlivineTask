package com.example.olivinetask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.olivinetask.PersonRecyclerViewList.*;

public class MainActivity extends AppCompatActivity implements SignUpFragment.onRegistrationListener {
    private BottomNavigationView mMainNav;
    private LogInFragment logInFragment;
    private SignUpFragment signUpFragment;
    private PersonRecyclerViewList personRecyclerViewList;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainNav=findViewById(R.id.bottomNavigation);
        logInFragment=new LogInFragment();

        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        signUpFragment=new SignUpFragment();
        fragmentTransaction.add(R.id.frameLayoutContainer, logInFragment);
        fragmentTransaction.commit();



        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.logIn:
                        mMainNav.setItemBackgroundResource(R.color.navigationStyle);

                        Toast.makeText(MainActivity.this, "Log In is clicked", Toast.LENGTH_SHORT).show();

                        fragmentManager=getSupportFragmentManager();
                        fragmentTransaction=fragmentManager.beginTransaction();
                        signUpFragment=new SignUpFragment();
                        fragmentTransaction.replace(R.id.frameLayoutContainer, logInFragment);
                        fragmentTransaction.commit();

                        return true;
                    case R.id.signUp:
                        //This one is for changing color after pressing
                        mMainNav.setItemBackgroundResource(R.color.colorSignUp);

                        fragmentManager=getSupportFragmentManager();
                        fragmentTransaction=fragmentManager.beginTransaction();
                        signUpFragment=new SignUpFragment();
                        fragmentTransaction.replace(R.id.frameLayoutContainer, signUpFragment);
                        fragmentTransaction.commit();
                        return true;

                        default:
                            return false;
                }
            }
        });
    }

    @Override
    public void registrationButtonClidked() {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        personRecyclerViewList=new PersonRecyclerViewList();
        fragmentTransaction.replace(R.id.frameLayoutContainer, personRecyclerViewList);
        fragmentTransaction.commit();
    }


  /*  private void setFragment(Fragment fragment) {
        fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        signUpFragment=new SignUpFragment();
        fragmentTransaction.add(R.id.frameLayoutContainer, signUpFragment);
        fragmentTransaction.commit();


    }*/
}
