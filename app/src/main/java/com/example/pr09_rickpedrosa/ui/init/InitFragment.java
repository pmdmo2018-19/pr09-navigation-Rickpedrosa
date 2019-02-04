package com.example.pr09_rickpedrosa.ui.init;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pr09_rickpedrosa.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.preference.PreferenceManager;

@SuppressWarnings("WeakerAccess")
public class InitFragment extends Fragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    private SharedPreferences sharedPreferences;
    private TextView lblLorem;
    private NavController navController;

    public InitFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.init_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        navController = NavHostFragment.findNavController(this);
        setupViews(requireView());
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        showLoremText();
    }

    private void setupViews(View view) {
        lblLorem = ViewCompat.requireViewById(view, R.id.lblLorem);
        setupToolbar(view);
        setupFab(view);
    }

    private void showLoremText() {
        lblLorem.setText(sharedPreferences.getString(getString(R.string.lore_or_chiquito_prefkey), getString(R.string.main_latin_ipsum)));
    }


    private void setupFab(View view) {
        FloatingActionButton fab = ViewCompat.requireViewById(view, R.id.initFragment_fab);
        fab.setOnClickListener(v -> navController.navigate(R.id.action_initFragment_to_detailFragment));
    }


    private void setupToolbar(View view) {
        Toolbar toolbar = ViewCompat.requireViewById(view, R.id.toolbar_initFragment);
        toolbar.setTitle(R.string.initFragment_lblTitle);
        toolbar.inflateMenu(R.menu.init_fragment);
        toolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.action_initFragment_to_settingsFragment) {
                navController.navigate(R.id.action_initFragment_to_settingsFragment);
                return true;
            } else {
                return false;
            }
        });
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                navController.getGraph()).build();
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (TextUtils.equals(key, getString(R.string.lore_or_chiquito_prefkey))) {
            showLoremText();
        }
    }
}
