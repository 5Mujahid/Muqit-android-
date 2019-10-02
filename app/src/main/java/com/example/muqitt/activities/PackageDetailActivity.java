package com.example.muqitt.activities;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.example.muqitt.Model.packages.PackageItem;
import com.example.muqitt.R;
import com.example.muqitt.Utils.Constants;
import com.example.muqitt.adapters.PackageDetailsAdapter;

public class PackageDetailActivity extends BaseActivity {

    ShimmerRecyclerView recyclerView;
    PackageItem item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_detail);

        item = (PackageItem) getIntent().getSerializableExtra(Constants.DATA);

        recyclerView = findViewById(R.id.list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PackageDetailsAdapter(item.getMetaData()));

    }
}
