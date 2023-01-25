package com.example.class3demo2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.class3demo2.databinding.FragmentUserRecipePageBinding;
import com.squareup.picasso.Picasso;

public class UserRecipePageFragment extends RecipeFragment {

    FragmentUserRecipePageBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentUserRecipePageBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        this.getElement();

        avatarImg = (RecipeFragmentArgs.fromBundle(getArguments()).getAvatarUrl());

        if (title != null){
            binding.recipeTitleTv.setText(title);
        }
        if (ingredients != null){
            binding.IngredientsTv.setText(ingredients);
        }
        if (instructions != null){
            binding.InstructionsTv.setText(instructions);
        }
        if (avatarImg != ""){
            Picasso.get().load(avatarImg).error(R.drawable.errorpizza).into(binding.avatarImg);
        }else{
            binding.avatarImg.setImageResource(R.drawable.photorecipe);
        }

        binding.recipeEditBtn.setOnClickListener((view2)->{
            UserRecipePageFragmentDirections.ActionFragmentUserRecipePageToEditUserRecipePageFragment2 action = UserRecipePageFragmentDirections.actionFragmentUserRecipePageToEditUserRecipePageFragment2(title,ingredients,instructions,avatarImg);
            Navigation.findNavController(view).navigate(action);
        });

        binding.backBtn.setOnClickListener((view1)->{
            Navigation.findNavController(view1).popBackStack();
        });

        return view;
    }
}