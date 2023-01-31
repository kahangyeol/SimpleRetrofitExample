package com.android.study.retrofit_example;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Call<DataModel> call;
    Call<List<DataModel>> callAll;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView =findViewById(R.id.textView);
        call = RetrofitClient.getApiService().testApiGet("5");
        call.enqueue(new Callback<DataModel>(){
            //콜백 받는 부분
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                DataModel result = response.body();
                String str;
                str= result.getUserId() +"\n"+
                        result.getId()+"\n"+
                        result.getTitle()+"\n"+
                        result.getBody();
                textView.setText(str);
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {

            }
        });

        callAll = RetrofitClient.getApiService().testApiGetAll();
        callAll.enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                List<DataModel> result = response.body();
                for(DataModel data : result){
                    String str = data.getUserId() +"\n"+
                            data.getId()+"\n"+
                            data.getTitle()+"\n"+
                            data.getBody() + "\n\n";
                    textView.append(str);
                }
            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {

            }
        });


    }
}