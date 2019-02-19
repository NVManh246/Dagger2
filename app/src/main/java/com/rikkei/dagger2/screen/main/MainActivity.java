package com.rikkei.dagger2.screen.main;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rikkei.dagger2.MyApplication;
import com.rikkei.dagger2.R;
import com.rikkei.dagger2.data.model.User;
import com.rikkei.dagger2.di.component.ApplicationComponent;
import com.rikkei.dagger2.di.component.DaggerMainActivityComponent;
import com.rikkei.dagger2.di.component.MainActivityComponent;
import com.rikkei.dagger2.di.modules.MainActivityContextModule;
import com.rikkei.dagger2.di.modules.MainActivityMvpModule;
import com.rikkei.dagger2.di.qualifer.ActivityContext;
import com.rikkei.dagger2.di.qualifer.ApplicationContext;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity
        implements UserAdapter.OnItemClickListener, MainContract.View {

    private RecyclerView mRecyclerUser;
    private ProgressBar mProgressBar;
    private MainActivityComponent mMainActivityComponent;

    @Inject
    public UserAdapter mUserAdapter;

    @Inject
    @ApplicationContext
    public Context mApplicationContext;

    @Inject
    @ActivityContext
    public Context mActivityContext;

    @Inject
    public MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApplicationComponent applicationComponent
                = MyApplication.getInstance(this).getApplicationComponent();
        mMainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityContextModule(new MainActivityContextModule(this))
                .applicationComponent(applicationComponent)
                .mainActivityMvpModule(new MainActivityMvpModule(this))
                .build();
        mMainActivityComponent.injectMainActivity(this);

        initView();

        mPresenter.getUsers();
    }

    private void initView() {
        mRecyclerUser = findViewById(R.id.recycler_user);
        mRecyclerUser.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerUser.setAdapter(mUserAdapter);
        mProgressBar = findViewById(R.id.progress_bar);
    }

    @Override
    public void onItemClick(User user) {
        Toast.makeText(this, user.getUsername(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showData(List<User> data) {
        mUserAdapter.setData(data);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }
}
