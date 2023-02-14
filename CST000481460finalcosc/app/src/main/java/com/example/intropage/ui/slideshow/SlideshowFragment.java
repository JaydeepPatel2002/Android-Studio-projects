package com.example.intropage.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.intropage.Pizza;
import com.example.intropage.PopularAdaptor;
import com.example.intropage.R;
import com.example.intropage.databinding.FragmentSlideshowBinding;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewPopularList;
    private RecyclerView.Adapter adapter2;
    private RecyclerView recyclerViewPopularList2;

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList2 = root.findViewById(R.id.recyclercan2);
        recyclerViewPopularList2.setLayoutManager(linearLayoutManager);
        //=======================for 2 litre bottles========================

        ArrayList<Pizza> foodList2 = new ArrayList<>();
        foodList2.add(new Pizza("Pepsi", "pepsibottle", "Pepsi 2 liter bottle", 3.5));
        foodList2.add(new Pizza("Coke", "cokebottle", "Coke 2 liter bottle", 2.9));
        foodList2.add(new Pizza("Sprite", "spritebottle", "Sprite 2 liter bottle", 3.4));
        foodList2.add(new Pizza("CokeZero", "cokezerobottlw", "CokeZero 2 liter bottle", 3.3));
        foodList2.add(new Pizza("Dr Pepper", "drpepperbottle", "Dr Pepper 2 liter bottle", 3.4));

        adapter2 = new PopularAdaptor(foodList2);
        recyclerViewPopularList2.setAdapter(adapter2);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);

        recyclerViewPopularList = root.findViewById(R.id.recyclercan);
        recyclerViewPopularList.setLayoutManager(gridLayoutManager);

        //=================for small cans=============================================

        ArrayList<Pizza> foodList = new ArrayList<>();
        foodList.add(new Pizza("Coke", "coke", "Coke 255 ml can", 1.9));
        foodList.add(new Pizza("Brisk", "brisk", "Brisk 255 ml can", 1.9));
        foodList.add(new Pizza("Canada Dry", "canadadry", "Canada Dry 255 ml can", 2.1));
        foodList.add(new Pizza("Coke Zero", "cokezero", "Coke Zero 255 ml can", 2.1));
        foodList.add(new Pizza("Diet Coke", "dietcoke", "Diet Coke 255 ml can", 1.8));
        foodList.add(new Pizza("Diet Pepsi", "dietpepsi", "Diet Pepsi 255 ml can", 1.7));
        foodList.add(new Pizza("Pepsi", "pepsi", "Pepsi 255 ml can", 1.9));
        foodList.add(new Pizza("Crush", "crush", "Crush 255 ml can", 2.2));
        foodList.add(new Pizza("Dr Pepper", "drpepper", "Dr Pepper 255 ml can", 2.1));
        foodList.add(new Pizza("Fanta", "fanta", "Fanta 255 ml can", 1.6));
        foodList.add(new Pizza("Lemonade", "lemon", "Lemonade 255 ml can", 1.8));
        foodList.add(new Pizza("Monster", "monster", "Monster 255 ml can", 1.7));
        foodList.add(new Pizza("Sprite", "sprite", "Sprite 255 ml can", 1.7));
        foodList.add(new Pizza("Red bull", "redbull", "Red bull 255 ml can", 1.6));
        foodList.add(new Pizza("Nestea", "nestea", "Nestea 255 ml can", 1.7));

        adapter = new PopularAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter);



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}