package com.rikkei.dagger2.di.component;

import android.content.Context;

import com.rikkei.dagger2.di.modules.MainActivityMvpModule;
import com.rikkei.dagger2.di.modules.UserAdapterModule;
import com.rikkei.dagger2.di.qualifer.ActivityContext;
import com.rikkei.dagger2.di.scopes.ActivityScope;
import com.rikkei.dagger2.screen.main.MainActivity;

import dagger.Component;

@ActivityScope
@Component(
        modules = {UserAdapterModule.class, MainActivityMvpModule.class},
        dependencies = ApplicationComponent.class
)
public interface MainActivityComponent {
    @ActivityContext
    Context getContext();

    void injectMainActivity(MainActivity mainActivity);
}
