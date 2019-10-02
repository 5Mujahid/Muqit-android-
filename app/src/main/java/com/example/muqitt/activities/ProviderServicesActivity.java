package com.example.muqitt.activities;

import com.example.muqitt.Model.Provider.ProfileServices;
import com.example.muqitt.Utils.Constants;
import com.example.muqitt.adapters.ProviderServicesRecyclerViewAdapter;

import java.util.List;

public class ProviderServicesActivity extends CommonProviderInfoActivity {

    @Override
    protected void setAdapter() {
        List<ProfileServices> services = (List<ProfileServices>) (getIntent().getBundleExtra(Constants.DATA)).getSerializable(Constants.DATA);
        if (services != null && !services.isEmpty()) {
            getRecyclerView().setAdapter(new ProviderServicesRecyclerViewAdapter
                    (services, null));
        } else {
            showNoData();
        }
    }
}
