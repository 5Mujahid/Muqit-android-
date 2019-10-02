package com.example.muqitt.activities;

import com.example.muqitt.Model.Provider.Qualification;
import com.example.muqitt.Utils.Constants;
import com.example.muqitt.adapters.ProviderQualificationAdapter;

import java.util.List;

public class ProviderQualificationActivity extends CommonProviderInfoActivity {

    @Override
    protected void setAdapter() {
        List<Qualification> services = (List<Qualification>) (getIntent().getBundleExtra(Constants.DATA)).getSerializable(Constants.DATA);
        if (services != null && !services.isEmpty()) {
            getRecyclerView().setAdapter(new ProviderQualificationAdapter
                    (services, null));
        }else{
            showNoData();
        }
    }
}
