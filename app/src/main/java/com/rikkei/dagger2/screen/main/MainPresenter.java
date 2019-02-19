package com.rikkei.dagger2.screen.main;

import com.rikkei.dagger2.data.api.APIInterface;
import com.rikkei.dagger2.data.model.User;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter  {

    private APIInterface mAPIInterface;
    private MainContract.View mView;

    @Inject
    public MainPresenter(APIInterface APIInterface, MainContract.View view) {
        mAPIInterface = APIInterface;
        mView = view;
    }

    @Override
    public void getUsers() {
        mView.showProgress();
        mAPIInterface.getUser().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                mView.showData(response.body());
                mView.hideProgress();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                mView.showError(t.toString());
                mView.hideProgress();
            }
        });
    }
}
