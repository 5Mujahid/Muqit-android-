package com.example.muqitt.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muqitt.Model.packages.PackageItem;
import com.example.muqitt.R;
import com.example.muqitt.Retrofit.RetrofitUtil;
import com.example.muqitt.Utils.Constants;
import com.example.muqitt.activities.PackageDetailActivity;

import java.util.List;

import static com.example.muqitt.Retrofit.RetrofitUtil.loadPackages;

/**
 * A fragment representing a list of Items.
 * <p/>
 * interface.
 */
public class UpdatePackageFragment extends BaseFragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    RecyclerView recyclerView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public UpdatePackageFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static UpdatePackageFragment newInstance(int columnCount) {
        UpdatePackageFragment fragment = new UpdatePackageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_packages_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        }



        return view;
    }

    @Override
    public void onPackagesLoad(List<PackageItem> items) {
        super.onPackagesLoad(items);
        recyclerView.setAdapter(new PackagesRecyclerViewAdapter(items, this));
    }

    @Override
    public void onPackageSelection(PackageItem item) {
        super.onPackageSelection(item);
        Intent detailActiivtyIntent = new Intent(getActivity(), PackageDetailActivity.class);
        detailActiivtyIntent.putExtra(Constants.DATA, item);
        startActivity(detailActiivtyIntent);
    }
}
