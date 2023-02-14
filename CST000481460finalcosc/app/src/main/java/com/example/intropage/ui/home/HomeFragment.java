package com.example.intropage.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.intropage.Pizza;
import com.example.intropage.PopularAdaptor;
import com.example.intropage.R;
import com.example.intropage.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewPopularList;



    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //============================Displaying all pizzas in grid view =============================================//


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = root.findViewById(R.id.recyclePopular);
        recyclerViewPopularList.setLayoutManager(gridLayoutManager);

        ArrayList<Pizza> foodList = new ArrayList<>();
        foodList.add(new Pizza("All-meat", "allmeat", "slices pepperoni,mozzerella cheese,fresh oregano,ham, beef, bacon, ground black pepper,pizza sauce", 9.76));
        foodList.add(new Pizza("Veggie-fan", "allveg", " Gouda Cheese, Special Sauce,black olive, pineapple, Lettuce, tomato", 8.79));
        foodList.add(new Pizza("Chedder tomato", "cheddartomato", "olive oil, Vegetable oil, chedder cheese, cherry tomatoes, fresh oregano, basil", 8.34));
        foodList.add(new Pizza("cheese-pizza", "cheesepizza", "olive oil, Vegetable oil, feta cheese, cheddar cheese, fresh oregano, mozzerella cheese", 8.98));
        foodList.add(new Pizza("Butter Chicken", "chickenbutterpizza", "olive oil, Vegetable oil, butterchicken, cherry tomatoes, fresh oregano, basil", 8.67));
        foodList.add(new Pizza("Chicken-onion", "chickenonion", "olive oil, Vegetable oil, pitted kalamata, cherry tomatoes, fresh oregano, basil", 9.3));
        foodList.add(new Pizza("Veg-Paneer", "vegpaneer", "olive oil, Vegetable oil, paneer, cherry tomatoes, fresh oregano, mozzerella cheese", 7.6));
        foodList.add(new Pizza("Beef-Taco", "taco", "olive oil, sour cream and salsa cream, pitted kalamata, fresh oregano, basil", 8.5));
        foodList.add(new Pizza("shrimp", "shrimp", "shrimp, Vegetable oil, pitted kalamata, cherry tomatoes, fresh oregano, mozzerella cheese", 9.8));
        foodList.add(new Pizza("sour-chicken", "sourchicken", "olive oil, Vegetable oil, pitted kalamata, cherry tomatoes, fresh oregano, basil", 8.5));
        foodList.add(new Pizza("Pepperoni", "peppronipizza", "olive oil, Vegetable oil, pitted kalamata, cherry tomatoes, fresh oregano, mozzerella cheese", 9.4));
        foodList.add(new Pizza("Plain-chicken", "plainchicken", "olive oil, Vegetable oil, pitted kalamata, cherry tomatoes, fresh oregano, basil", 7.95));
        foodList.add(new Pizza("Picante", "pizza2", "olive oil, chorizo, salami, mushroom,fresh oregano, basil", 9.5));
        foodList.add(new Pizza("Veg-Spicy", "pizza3", "olive oil, Vegetable oil, pitted kalamata, cherry tomatoes, fresh oregano, mozzerella cheese", 8.5));
        foodList.add(new Pizza("Paper-Paneer", "paperpaneer", "olive oil,paneer, Vegetable oil, pitted kalamata, cherry tomatoes, fresh oregano, basil", 8.3));
        foodList.add(new Pizza("Magrita", "magrita", "olive oil, Vegetable oil, paneer, pitted kalamata, cherry tomatoes, fresh oregano, basil", 9.5));
        foodList.add(new Pizza("Hot-Maxico", "hotmaxico", "olive oil, Vegetable oil, pitted kalamata, cherry tomatoes, fresh oregano, basil", 8.5));
        foodList.add(new Pizza("Hawaiin", "hawaiin", "olive oil, Vegetable oil, pitted kalamata, cherry tomatoes, fresh oregano, mozzerella cheese", 8.8));
        foodList.add(new Pizza("Ham-Special", "ham", "ham, Vegetable oil, pineapple, cherry tomatoes, pizza sauce, basil", 8.5));
        foodList.add(new Pizza("Chilli jalapino", "chillijalapino", "chilli, jalapino, Vegetable oil, pizza sauce, mozzerella cheese", 8.7));
        foodList.add(new Pizza("Spicy-Chicken", "chickentikka", "olive oil, plain chicken, pitted kalamata, cherry tomatoes, fresh oregano, basil", 9.5));
        foodList.add(new Pizza("chipotle", "pizza", "chipotle chicken, Vegetable oil,mozzerella cheese, fresh oregano, basil", 8.5));

        adapter = new PopularAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter);



//        final TextView textView = binding.textPopular;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}