package com.arfapps.cesar_app.ui.presenter;

import android.os.Bundle;

/**
 * Created by Alex on 25/12/2017.
 */

public interface IPresenter {

	void startPresenterView();

	void saveInstanceState(Bundle outState);

	void restoreInstanceState(Bundle savedInstanceState);
}
