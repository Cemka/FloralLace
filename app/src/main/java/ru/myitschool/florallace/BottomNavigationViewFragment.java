package ru.myitschool.florallace;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class BottomNavigationViewFragment extends Fragment implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView bottomNavigation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bottom_navigation_view_fragment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bottomNavigation = view.findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(this);
        bottomNavigation.setItemIconTintList(null);


    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.home:
                Toast.makeText(getContext(), "It's home", Toast.LENGTH_SHORT).show();
                menuItem.setChecked(true);
                Intent intent = new Intent(getActivity(), MoreActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(0, 0);
                return true;
            case R.id.cart:
                // обработка нажатия на кнопку "Исследовать"
                Toast.makeText(getContext(), "It's cart", Toast.LENGTH_SHORT).show();
                menuItem.setChecked(true);
                return true;
            case R.id.more:
                // обработка нажатия на кнопку "Профиль"
                Toast.makeText(getContext(), "It's more", Toast.LENGTH_SHORT).show();
                menuItem.setChecked(true);
                return true;
            default:
                return false;
        }
    }

}
