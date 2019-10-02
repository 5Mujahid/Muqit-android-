package com.example.muqitt.Interface;

import com.example.muqitt.Model.Appointment;
import com.example.muqitt.Model.Countries;
import com.example.muqitt.Model.JobItem;
import com.example.muqitt.Model.Provider.BusinessHours;
import com.example.muqitt.Model.Provider.PrivacySettings;
import com.example.muqitt.Model.Provider.ProfileServices;
import com.example.muqitt.Model.Provider.ProviderModel;
import com.example.muqitt.Model.Provider.ProviderReviewListData;
import com.example.muqitt.Model.categories.Category;
import com.example.muqitt.Model.packages.PackageItem;
import com.example.muqitt.Utils.Constants;

import java.util.List;

/**
 * Created by Gohar Ali on 12/14/2017.
 */

public interface OnDataLoadListener {

    void onCategoriesLoad(List<Category> items);

    void onProviderLoad(List<ProviderModel> items);

    void onCountriesLoad(List<Countries> items);

    void onAppointmentsLoad(List<Appointment> items);

    void onServiceLoad(List<ProfileServices> items);

    void onReviewsLoad(List<ProviderReviewListData> items);

    void onUpdateFavorites(ProviderModel item);

    void onPrivacyLoaded(PrivacySettings item);

    void onBusinessHoursLoaded(BusinessHours item);

    void onJobsLoaded(List<JobItem> items);

    void onProfileLoaded(ProviderModel items);

    void onPackagesLoad(List<PackageItem> items);

    void onSuccess(String msg);

    void onError(Constants.Errors errorCode, String error);
}
