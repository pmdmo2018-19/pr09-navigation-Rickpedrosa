package com.example.pr09_rickpedrosa.ui.settings;

import android.os.Bundle;
import android.view.View;

import com.example.pr09_rickpedrosa.R;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.preference.PreferenceFragmentCompat;

@SuppressWarnings("WeakerAccess")
public class SettingsFragment extends PreferenceFragmentCompat {

    public SettingsFragment() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupToolBar(requireView());
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }

    private void setupToolBar(View view) {
        Toolbar toolbar = ViewCompat.requireViewById(view, R.id.toolbar_fragmentSettings);
        toolbar.setNavigationOnClickListener(v -> requireActivity().onBackPressed());
    }
}
