package com.rikkei.dagger2.di.modules;

import com.rikkei.dagger2.di.scopes.ActivityScope;
import com.rikkei.dagger2.screen.main.MainActivity;
import com.rikkei.dagger2.screen.main.UserAdapter;

import dagger.Module;
import dagger.Provides;

@Module(includes = MainActivityContextModule.class)
public class UserAdapterModule {

    @Provides
    @ActivityScope
    public UserAdapter getUserAdapter(UserAdapter.OnItemClickListener listener) {
        return new UserAdapter(listener);
    }

    @Provides
    @ActivityScope
    public UserAdapter.OnItemClickListener getListener(MainActivity mainActivity) {
        return mainActivity;
    }
}
