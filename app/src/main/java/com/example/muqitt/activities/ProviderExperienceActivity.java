package com.example.muqitt.activities;

import com.example.muqitt.Model.Provider.Experience;
import com.example.muqitt.Utils.Constants;
import com.example.muqitt.adapters.ProviderExperienceAdapter;

import java.util.List;

public class ProviderExperienceActivity extends CommonProviderInfoActivity {

    @Override
    protected void setAdapter() {
        List<Experience> services = (List<Experience>) (getIntent().getBundleExtra(Constants.DATA)).getSerializable(Constants.DATA);
        if (services != null && !services.isEmpty()) {
            getRecyclerView().setAdapter(new ProviderExperienceAdapter
                    (services, null));
        }else{
            showNoData();
        }
    }
}
