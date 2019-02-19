package com.rikkei.dagger2.screen.main;

import com.rikkei.dagger2.data.model.User;

import java.util.List;

public interface MainContract {
    interface View {
        void showData(List<User> data);
        void showError(String message);
        void showProgress();
        void hideProgress();
    }

    interface Presenter {
        void getUsers();
    }
}
