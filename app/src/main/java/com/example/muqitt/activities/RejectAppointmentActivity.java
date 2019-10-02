package com.example.muqitt.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.muqitt.Model.Appointment;
import com.example.muqitt.Model.ManageAppointmentRequest;
import com.example.muqitt.R;
import com.example.muqitt.Retrofit.RetrofitUtil;
import com.example.muqitt.Utils.Constants;
import com.example.muqitt.Utils.DatabaseUtil;

public class RejectAppointmentActivity extends BaseActivity {

    private EditText title;
    private EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reject_appointment);

        getSupportActionBar().setTitle(R.string.reject_appointment);

        title = findViewById(R.id.rejection_title);
        description = findViewById(R.id.rejection_description);

        final Appointment apt = (Appointment) getIntent().
                getBundleExtra(Constants.DATA).getSerializable(Constants.DATA);

        findViewById(R.id.reject_now).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ManageAppointmentRequest req = new ManageAppointmentRequest();
                if(title.getText() != null && !title.getText().toString().trim().isEmpty()){
                    req.setRejectionTitle(title.getText().toString());
                }else{
                    title.setError(getString(R.string.required_field));
                    return;
                }

                if(description.getText() != null && !description.getText().toString().trim().isEmpty()){
                    req.setrejectionReason(title.getText().toString());
                }else{
                    description.setError(getString(R.string.required_field));
                    return;
                }

                req.setpostId(apt.getPostId());
                req.setPublisherId(DatabaseUtil.getInstance().getUserID());
                req.setAction("trash");

                showProgressDialog("Updating...");
                RetrofitUtil.createProviderAPI().updateProviderAppointments
                        (req).enqueue(RetrofitUtil.sendRequest(RejectAppointmentActivity.this));

            }
        });
    }

    @Override
    public void onPositiveClick(String msg) {
        super.onPositiveClick(msg);
        setResult(RESULT_OK);
        finish();
    }
}
