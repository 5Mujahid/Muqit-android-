package com.example.muqitt.activities;

import com.example.muqitt.Model.Provider.BusinessHours;
import com.example.muqitt.Utils.Constants;
import com.example.muqitt.adapters.ProviderBusinessHoursAdapter;

public class BusinessHoursActivity extends CommonProviderInfoActivity {
    @Override
    protected void setAdapter() {
        BusinessHours services = (BusinessHours)(getIntent().getBundleExtra(Constants.DATA)).getSerializable(Constants.DATA);
        if(services != null) {
            getRecyclerView().setAdapter(new ProviderBusinessHoursAdapter
                    (services, null));
        }else{
            showNoData();
        }
    }
}
