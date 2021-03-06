package com.example.pr09_rickpedrosa.ui.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pr09_rickpedrosa.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

@SuppressWarnings("WeakerAccess")
public class DetailFragment extends Fragment {

    private NavController navController;

    public DetailFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.detail_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        navController = NavHostFragment.findNavController(this);
        setupViews(requireView());

    }

    private void setupViews(View view) {
        NestedScrollView nestedScrollView = ViewCompat.requireViewById(view, R.id.scvDetail);
        TextView lblDetail = ViewCompat.requireViewById(view, R.id.lblDetail);
        setupToolbar(view);
        setupFab(view);
    }

    private void setupToolbar(View view) {
        Toolbar toolbar = ViewCompat.requireViewById(view, R.id.toolbar_detailFragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                navController.getGraph()).build();
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
    }

    private void setupFab(View view) {
        FloatingActionButton fab = ViewCompat.requireViewById(view, R.id.detailFragment_fab);
        fab.setOnClickListener(v -> Toast.makeText(requireContext(), "CYKA BLYAT", Toast.LENGTH_SHORT).show());
    }
}
