package com.example.muqitt.Interface;

import com.example.muqitt.Model.Appointment;
import com.example.muqitt.Model.JobItem;
import com.example.muqitt.Model.Provider.ProviderModel;
import com.example.muqitt.Model.categories.Category;
import com.example.muqitt.Model.packages.PackageItem;

/**
 * Created by Gohar Ali on 12/13/2017.
 */

public interface OnListInteractionListener  {

     void onProviderListInteraction(ProviderModel item) ;

     void onCategoryListInteraction(Category item) ;

     void onAppointmentInteraction(Appointment item, int pos) ;

     void onProviderFavorite(ProviderModel item);

     void onJobItemSelection(JobItem item);

     void onUserMessageSelection(String path, int post);

     void onPackageSelection(PackageItem item);

     void removeItem(int position);
}
