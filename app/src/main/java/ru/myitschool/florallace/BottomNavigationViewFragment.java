package ru.myitschool.florallace;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import java.util.ArrayList;


public class BottomNavigationViewFragment extends Fragment implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView bottomNavigation;
    private int selectedItem = 0; // переменная для хранения выбранного пункта меню
    private Intent intent;

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
                // Обрабатываем нажатие на кнопку домой
                selectedItem = 0;
                Toast.makeText(getContext(), "It's home", Toast.LENGTH_SHORT).show();
                menuItem.setChecked(true);
                intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(0, 0);
                return true;
            case R.id.cart:
                // Обрабатываем нажатие на кнопку корзина
                selectedItem = 1;
                Toast.makeText(getContext(), "It's cart", Toast.LENGTH_SHORT).show();
                menuItem.setChecked(true);
                return true;
            case R.id.more:
                // Обрабатываем нажатие на кнопку Ещё
                selectedItem = 2;
                Toast.makeText(getContext(), "It's more", Toast.LENGTH_SHORT).show();
                menuItem.setChecked(true);
                intent = new Intent(getActivity(), MoreActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(0, 0);
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        // Сохраняем выбранный пункт меню в SharedPreferences
        SharedPreferences sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("selected_item", selectedItem);
        editor.apply();
    }

    @Override
    public void onResume() {
        super.onResume();
        // Восстанавливаем выбранный пункт меню из SharedPreferences
        SharedPreferences sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
        selectedItem = sharedPreferences.getInt("selected_item", 0);
        bottomNavigation.getMenu().getItem(selectedItem).setChecked(true);
    }



}
