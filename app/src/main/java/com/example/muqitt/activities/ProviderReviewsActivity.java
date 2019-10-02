package com.example.muqitt.activities;

import com.example.muqitt.Model.Provider.ProviderReviewListData;
import com.example.muqitt.Model.ReviewProvider;
import com.example.muqitt.Retrofit.RetrofitUtil;
import com.example.muqitt.Utils.Constants;
import com.example.muqitt.adapters.ProviderReviewAdapter;

import java.util.List;

import static com.example.muqitt.Retrofit.RetrofitUtil.getProviderReviews;

public class ProviderReviewsActivity extends CommonProviderInfoActivity {

    @Override
    protected void setAdapter() {
        if(getIntent().getBundleExtra(Constants.DATA) != null){
            ReviewProvider provider = new ReviewProvider();
            provider.setProviderId(getIntent().getBundleExtra(Constants.DATA).getInt(Constants.ID));
            RetrofitUtil.createProviderAPI().getProviderReviews(provider).enqueue(getProviderReviews(this));
        }
    }

    @Override
    public void onReviewsLoad(List<ProviderReviewListData> items) {
        if (items != null && !items.isEmpty()) {
            getRecyclerView().setAdapter(new ProviderReviewAdapter
                    (items));
        } else {
            showNoData();
        }
    }
}
