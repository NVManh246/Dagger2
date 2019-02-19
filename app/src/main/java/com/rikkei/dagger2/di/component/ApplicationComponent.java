package com.rikkei.dagger2.di.component;

import android.content.Context;

import com.rikkei.dagger2.MyApplication;
import com.rikkei.dagger2.data.api.APIInterface;
import com.rikkei.dagger2.di.modules.ContextModule;
import com.rikkei.dagger2.di.modules.RetrofitModule;
import com.rikkei.dagger2.di.qualifer.ApplicationContext;
import com.rikkei.dagger2.di.scopes.ApplicationScope;

import dagger.Component;

@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {
    APIInterface getApiInterface();

    @ApplicationContext
    Context getContext();

    void injectApplication(MyApplication myApplication);
}
