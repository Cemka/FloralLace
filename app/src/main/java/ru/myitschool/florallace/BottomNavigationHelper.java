package ru.myitschool.florallace;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationHelper {
    private SharedPreferences preferences;
    private String selectedItemIdKey = "selectedItemId";
    private BottomNavigationView bottomNavigationView;

    public BottomNavigationHelper(Context context, BottomNavigationView bottomNavigationView) {
        this.bottomNavigationView = bottomNavigationView;
        preferences = context.getSharedPreferences("BottomNavigation", Context.MODE_PRIVATE);
    }

    public void setSelectedItemId(int itemId) {
        preferences.edit().putInt(selectedItemIdKey, itemId).apply();
    }

    public int getSelectedItemId() {
        return preferences.getInt(selectedItemIdKey, -1);
    }

    public void removeSelectedItemId() {
        preferences.edit().remove(selectedItemIdKey).apply();
    }

    public void restoreSelectedItemId() {
        int selectedItemId = getSelectedItemId();
        if (selectedItemId != -1) {
            bottomNavigationView.getMenu().findItem(selectedItemId).setChecked(true);
        }
    }
}

