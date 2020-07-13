package com.example.someinterview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    APIInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        //This is the subclass of our WorkRequest
//        final OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(MyWorker.class).build();
//
////        PeriodicWorkRequest periodicWorkRequest=new PeriodicWorkRequest.Builder(MyWorker.class).build();
//        //A click listener for the button
//        //inside the onClick method we will perform the work
//        findViewById(R.id.buttonEnqueue).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Enqueuing the work request
//                WorkManager.getInstance().enqueue(workRequest);
//                Toast.makeText(MainActivity.this, "clcik", Toast.LENGTH_SHORT).show();
//            }
//        });
//        //Getting the TextView
//        final TextView textView = findViewById(R.id.textViewStatus);
//
//        //Listening to the work status
//        WorkManager.getInstance().getWorkInfoByIdLiveData(workRequest.getId())
//                .observe(this, new Observer<WorkInfo>() {
//                    @Override
//                    public void onChanged(@Nullable WorkInfo workInfo) {
//
//                        //Displaying the status into TextView
//                        textView.append(workInfo.getState().name() + "\n");
//                    }
//                });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIInterface.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        //apiInterface=APIClient.getClient().create(APIInterface.class);

        apiInterface=retrofit.create(APIInterface.class);

        Log.d("sasasa","adsdsadddddddddddddddddddddddd");

    }

    public void sentOTP(View view) {
        mobile("7013468134");

    }

    private void mobile(String mobile){

        OTPModal modal=new OTPModal(mobile);
        Call<OTPModal> call=apiInterface.sentOTP(modal);
        call.enqueue(new Callback<OTPModal>() {
            @Override
            public void onResponse(Call<OTPModal> call, Response<OTPModal> response) {
                OTPModal otpModal=response.body();
                Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<OTPModal> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
