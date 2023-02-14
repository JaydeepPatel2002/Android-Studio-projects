package com.example.intropage.ui.gallery;

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
import com.example.intropage.databinding.FragmentGalleryBinding;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewPopularList;
    private RecyclerView.Adapter adapter2;
    private RecyclerView recyclerViewPopularList2;
    private RecyclerView.Adapter adapter3;
    private RecyclerView recyclerViewPopularList3;
    private RecyclerView.Adapter adapter4;
    private RecyclerView recyclerViewPopularList4;

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = root.findViewById(R.id.recycleside);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<Pizza> foodList = new ArrayList<>();
        foodList.add(new Pizza("Taco-Salad", "tacosalad", "slices pepperoni,mozzerella cheese,fresh oregano, ground black pepper,pizza sauce", 4.56));
        foodList.add(new Pizza("Greek-Salad", "greeksalad", "beef, Gouda Cheese, greek sauce, black olive, Lettuce, tomato", 5.4));
        foodList.add(new Pizza("Ceaser-Salad", "ceasersalad", "olive oil, ceaser salad, pitted kalamata, cherry tomatoes, fresh oregano, basil", 4.8));
        foodList.add(new Pizza("Chicken-Salad", "chickensalad", "olive oil, Vegetable oil, pitted kalamata, cherry tomatoes, fresh oregano, basil", 5.3));
        foodList.add(new Pizza("Pasta-Salad", "pastasalad", "olive oil, pasta masala, pitted kalamata, cherry tomatoes, fresh oregano, mozzerella cheese", 6.7));
        foodList.add(new Pizza("Ranch-Salad", "chikenranchsalad", "plain chicken, Vegetable oil, ranch sauce, cherry tomatoes, fresh oregano, basil", 6.2));
        foodList.add(new Pizza("Veg-Salad", "vegesalad", "olive oil, Vegetable oil, lettuce, cherry tomatoes, jalapino, fresh oregano, basil", 5.8));

        adapter = new PopularAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter);


        //=================================================================================================

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList2 = root.findViewById(R.id.recycleside2);
        recyclerViewPopularList2.setLayoutManager(linearLayoutManager2);

        ArrayList<Pizza> foodList2 = new ArrayList<>();
        foodList2.add(new Pizza("Chickens", "chicken", "fresh hot chickens", 9.76));
        foodList2.add(new Pizza("Fish-finger", "fish", "crispy fish", 8.79));
        foodList2.add(new Pizza("Wings", "wings", "crunchy wings", 8.5));
        foodList2.add(new Pizza("Boneless-Bites", "boneless", "Tasty boneless bytes", 8.5));
        foodList2.add(new Pizza("Ribs", "ribs", "ribs", 7.5));
        foodList2.add(new Pizza("Beef Balls", "beefball", "beef ball", 9.5));
        foodList2.add(new Pizza("Nuggets", "nugget", "chicken nuggets", 8.5));

        adapter2 = new PopularAdaptor(foodList2);
        recyclerViewPopularList2.setAdapter(adapter2);

        //================================================================================================
        //===================================this is for cheese Sticks=============================================================


        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList3 = root.findViewById(R.id.recycleside3);
        recyclerViewPopularList3.setLayoutManager(linearLayoutManager3);

        ArrayList<Pizza> foodList3 = new ArrayList<>();
        foodList3.add(new Pizza("CheeseStick", "cheesestick2" , "slices pepperoni,mozzerella cheese,fresh oregano, ground black pepper,pizza sauce", 4.76));
        foodList3.add(new Pizza("BaconStick", "baconranchstick", "beef, Gouda Cheese, Special Sauce, Lettuce, tomato", 4.79));
        foodList3.add(new Pizza("VeggieStick", "veggiestick", "olive oil, Vegetable oil, pitted kalamata, cherry tomatoes, fresh oregano, basil", 4.5));
        foodList3.add(new Pizza("BeefStick", "beefstick", "olive oil, Vegetable oil, ginger paste, cherry tomatoes, fresh oregano, basil", 5.5));
        foodList3.add(new Pizza("BreadStick", "breadstick", "olive oil,ginger paste, Vegetable oil, pitted kalamata, cherry tomatoes, fresh oregano, basil", 4.5));

        adapter3 = new PopularAdaptor(foodList3);
        recyclerViewPopularList3.setAdapter(adapter3);
        //===================================this is for other side items======================================================

        //=========================================================================================

        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList4 = root.findViewById(R.id.recycleside4);
        recyclerViewPopularList4.setLayoutManager(linearLayoutManager4);

        ArrayList<Pizza> foodList4 = new ArrayList<>();
        foodList4.add(new Pizza("Poutine", "poutine2", "fries, gravy, cheese", 6.76));
        foodList4.add(new Pizza("Onion rings", "onion", "olive oil, Vegetable oil, onion, indian spices", 6.5));
        foodList4.add(new Pizza("crispy-Fries", "fries", "Potato, oil", 7.5));
        foodList4.add(new Pizza("Potato-wedges", "potato", "olive oil, Vegetable oil, potato, salt", 5.5));
        foodList4.add(new Pizza("Beef-fries", "beefpoutine", "beef gravy, Vegetable oil, fries, fresh oregano", 6.4));
        foodList4.add(new Pizza("garlic-bread", "garlic", "olive oil, Vegetable oil, whole wheat bread, garlic, fresh oregano, ginger paste", 5.5));

        adapter4 = new PopularAdaptor(foodList4);
        recyclerViewPopularList4.setAdapter(adapter4);

        //===========================================================================================
//        final TextView textView = binding.textGallery;
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}