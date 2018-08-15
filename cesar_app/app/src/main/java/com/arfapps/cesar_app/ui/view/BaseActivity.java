package com.arfapps.cesar_app.ui.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.arfapps.cesar_app.R;
import com.arfapps.cesar_app.data.model.BaseModel;
import com.arfapps.cesar_app.ui.presenter.BasePresenter;
import com.arfapps.cesar_app.ui.presenter.IPresenter;

/**
 * Created by Alex on 16/03/2017.
 */

public abstract class BaseActivity<ModelType extends BaseModel,
		ViewType extends BasePresenter.View,
		PresenterType extends IPresenter>
		extends AppCompatActivity
		implements BasePresenter.View {

	private static final String TAG = BaseActivity.class.getSimpleName();
	protected ModelType mData;
	protected PresenterType mPresenter;
	protected String mTitle;

	protected ProgressBar mProgressBar;
	protected Toolbar mToolbar;

	public BaseActivity() {
	}

	@Override
	protected void onStart() {
		super.onStart();
		if (mPresenter != null) {
			mPresenter.startPresenterView();
		}
	}

	@Override
	public void initializeWidgets(Bundle savedInstanceState) {
		mToolbar = findViewById(R.id.myToolBar);
		mProgressBar = findViewById(R.id.progressBar);
		if (mProgressBar == null) {
			throw new NullPointerException("A Activity não tem progressBar no layout.");
		}
		if (mToolbar == null) {
			throw new NullPointerException("A Activity não tem myToolBar no layout.");
		}

		configureSupportActionBar();
	}

	private void configureSupportActionBar() {
		setSupportActionBar(mToolbar);
		ActionBar supportActionBar = getSupportActionBar();
		if (supportActionBar != null) {
			if (mTitle != null) {
				supportActionBar.setTitle(mTitle);
			}
			supportActionBar.setDisplayHomeAsUpEnabled(true);

			Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
			drawable.setBounds(24, 24, 24, 24);
			supportActionBar.setHomeAsUpIndicator(drawable);
		} else {
			throw new RuntimeException("Não foi possivel configurar a action bar para suporte a versoes antigas");
		}
	}

	@Override
	public void showErrorMsg(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
	}

	@Override
	public void showSuccessMsg(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void setLoadProgressBarVisibility(boolean toVisible) {
		if (toVisible) {
			mProgressBar.setVisibility(View.VISIBLE);
		} else {
			mProgressBar.setVisibility(View.GONE);
		}
	}

	@Override
	public void setActionBarTitle(String title) {
		mTitle = title;
		ActionBar supportActionBar = getSupportActionBar();
		if (supportActionBar != null) {
			supportActionBar.setTitle(mTitle);
		} else {
			Log.w(TAG, "Não foi possivel recuperar a actionBar");
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		if (mPresenter != null) {
			mPresenter.saveInstanceState(outState);
		}
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		if (mPresenter != null) {
			mPresenter.restoreInstanceState(savedInstanceState);
		}
	}
}
