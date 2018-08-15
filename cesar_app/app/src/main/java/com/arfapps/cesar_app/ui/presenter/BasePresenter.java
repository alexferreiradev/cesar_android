package com.arfapps.cesar_app.ui.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import com.arfapps.cesar_app.data.model.BaseModel;
import com.arfapps.cesar_app.repository.DefaultRepository;


@SuppressWarnings("WeakerAccess")
public abstract class BasePresenter<ViewType extends BasePresenter.View,
		ModelType extends BaseModel,
		RepoType extends DefaultRepository,
		TaskParamType, TaskProgressType, TaskResultType> implements IPresenter {

	private static final String TAG = BasePresenter.class.getSimpleName();

	protected Context mContext;
	protected ViewType mView;
	protected RepoType mRepository;

	protected BasePresenter(ViewType mView, Context mContext, Bundle savedInstanceState, RepoType mRepository) {
		this.mContext = mContext;
		this.mView = mView;
		this.mRepository = mRepository;
		initializeWidgets(savedInstanceState);
	}

	/**
	 * Deve ser chamado depois de instanciar o presenter.
	 * <p>
	 * Realiza funções necessárias para view iniciar: carrega argumentos, carrega lista.
	 */
	public void startPresenterView() {
		mView.initializeArgumentsFromIntent();
		initialize();
	}

	protected abstract void initialize();

	protected void hideProgressView() {
		mView.setLoadProgressBarVisibility(false);
	}

	protected void showProgressView() {
		mView.setLoadProgressBarVisibility(true);
	}

	/**
	 * Chamado para fazer bind entre view e atributos da activity.
	 *
	 * @param savedInstanceState -
	 */
	protected void initializeWidgets(Bundle savedInstanceState) {
		mView.initializeWidgets(savedInstanceState);
	}

	protected void backgroundFinished(@NonNull TaskResultType taskResultType) {
	}

	@Override
	public void saveInstanceState(Bundle outState) {
	}

	@Override
	public void restoreInstanceState(Bundle savedInstanceState) {
	}

	protected TaskResultType loadInBackground(TaskParamType[] taskParamTypes) {
		return null;
	}

	public interface View {
		/**
		 * Inverte o atributo visible de um progressBar
		 */
		void setLoadProgressBarVisibility(boolean toVisible);

		/**
		 * Faz bind entre view e atributos da activity.
		 * <p>
		 * O presenter neste momento ainda não foi instanciado.
		 *
		 * @param savedInstanceState - dados da instancia salvos
		 */
		void initializeWidgets(Bundle savedInstanceState);

		void initializeArgumentsFromIntent();

		void showErrorMsg(String msg);

		void showSuccessMsg(String msg);

		void setActionBarTitle(String title);
	}

	@SuppressLint("StaticFieldLeak")
	public class BackgroundTask extends AsyncTask<TaskParamType, TaskProgressType, TaskResultType> {

		@Override
		protected void onPreExecute() {
			mView.setLoadProgressBarVisibility(true);
		}

		@SafeVarargs
		@Override
		protected final TaskResultType doInBackground(TaskParamType... taskParamTypes) {
			return loadInBackground(taskParamTypes);
		}

		@Override
		protected void onPostExecute(TaskResultType taskResultType) {
			mView.setLoadProgressBarVisibility(false);
			if (taskResultType == null) {
				Log.e(TAG, "Erro interno");
				mView.showErrorMsg("Erro interno");
				return;
			}
			backgroundFinished(taskResultType);
		}
	}
}
