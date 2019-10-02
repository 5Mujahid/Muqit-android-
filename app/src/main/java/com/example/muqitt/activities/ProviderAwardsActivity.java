package com.example.muqitt.activities;

import com.example.muqitt.Model.Provider.Award;
import com.example.muqitt.Utils.Constants;
import com.example.muqitt.adapters.ProviderAwardsAdapter;

import java.util.List;

public class ProviderAwardsActivity extends CommonProviderInfoActivity {

    @Override
    protected void setAdapter() {
        List<Award> services = (List<Award>) (getIntent().getBundleExtra(Constants.DATA)).getSerializable(Constants.DATA);
        if (services != null && !services.isEmpty()) {
            getRecyclerView().setAdapter(new ProviderAwardsAdapter
                    (services, null));
        }else{
            showNoData();
        }
    }
}
