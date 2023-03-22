package ru.myitschool.florallace;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {
    private ImageButton homeButton, moreButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, container, false);
        homeButton = view.findViewById(R.id.home_button);
        moreButton = view.findViewById(R.id.more_button);
        moreButton.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), MoreActivity.class);
            startActivity(intent);
            moreButton.setImageResource(R.drawable.pressedmore);
            homeButton.setImageResource(R.drawable.unpressedhome);
            getActivity().overridePendingTransition(0, 0);
        });
        if (savedInstanceState != null) {
            Drawable homeButtonImageDrawable = savedInstanceState.getParcelable("homeButtonImageDrawable");
            homeButton.setImageDrawable(homeButtonImageDrawable);
            Drawable moreButtonImageDrawable = savedInstanceState.getParcelable("moreButtonImageDrawable");
            moreButton.setImageDrawable(moreButtonImageDrawable);
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeButton = view.findViewById(R.id.home_button);
        moreButton = view.findViewById(R.id.more_button);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Drawable.ConstantState homeConstantState = homeButton.getDrawable().getConstantState();
        Drawable homeDrawable = homeConstantState.newDrawable().mutate();
        outState.putParcelable("homeButtonImageDrawable", homeDrawable);

        Drawable.ConstantState moreConstantState = moreButton.getDrawable().getConstantState();
        Drawable moreDrawable = moreConstantState.newDrawable().mutate();
        outState.putParcelable("moreButtonImageDrawable", moreDrawable);
    }



}
