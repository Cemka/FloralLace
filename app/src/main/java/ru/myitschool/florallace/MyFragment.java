package ru.myitschool.florallace;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {
    private boolean isLayoutMain, isLayoutMore;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, container, false);
        ImageButton home = (ImageButton) view.findViewById(R.id.home_button); // находим кнопку по id
        ImageButton more = (ImageButton) view.findViewById(R.id.more_button); // находим кнопку по id
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
                more.setImageResource(R.drawable.pressedmore);
                home.setImageResource(R.drawable.unpressedhome);
                getActivity().overridePendingTransition(0, 0);

            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageButton homeButton = (ImageButton) view.findViewById(R.id.home_button);
//        ImageButton shop_button = (ImageButton) view.findViewById(R.id.person);
        ImageButton moreButton = (ImageButton) view.findViewById(R.id.more_button);

//        homeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                homeButton.setImageResource(R.drawable.pressedhome);
//                moreButton.setImageResource(R.drawable.unpressedmore);
//                Intent intent = new Intent(getContext(), MainActivity.class);
//                startActivity(intent);
//                getActivity().overridePendingTransition(0, 0);
//            }
//        });

//        moreButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                moreButton.setImageResource(R.drawable.pressedmore);
//                homeButton.setImageResource(R.drawable.unpressedhome);
//                Intent intent = new Intent(getContext(), MoreActivity.class);
//                startActivity(intent);
//                getActivity().overridePendingTransition(0, 0);
//            }
//        });

//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (v.getId() == R.id.button3) {
//                    button3.setImageResource(R.drawable.new_image);
//                } else {
//                    button3.setImageResource(R.drawable.default_image);
//                }
//            }
//        });


    }
}
