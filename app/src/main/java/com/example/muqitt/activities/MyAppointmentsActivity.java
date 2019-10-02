package com.example.muqitt.activities;

import com.example.muqitt.Model.Appointment;
import com.example.muqitt.Model.Login.User;
import com.example.muqitt.Retrofit.RetrofitUtil;
import com.example.muqitt.Utils.AppUtils;
import com.example.muqitt.Utils.DatabaseUtil;
import com.example.muqitt.adapters.MyAppointmentsRecyclerViewAdapter;

import java.util.List;

import static com.example.muqitt.Retrofit.RetrofitUtil.getUserAppointments;


public class MyAppointmentsActivity extends CommonProviderInfoActivity {

    @Override
    public void onAppointmentsLoad(List<Appointment> items) {
        if(items != null && items.size() >0) {
            getRecyclerView().setAdapter(new MyAppointmentsRecyclerViewAdapter(items,this));
        }else{
            showNoData();
        }
    }

    @Override
    protected void setAdapter() {
        User user = DatabaseUtil.getInstance().getUser();
        RetrofitUtil.createProviderAPI().getUserAppointments(user.getData().getID()).
                enqueue(getUserAppointments(MyAppointmentsActivity.this));
    }

    @Override
    public void onAppointmentInteraction(Appointment item, int pos) {
        AppUtils.showDialog(this,item.toString(),null);
    }
}
