package com.arfapps.cesar_app.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arfapps.cesar_app.R;
import com.arfapps.cesar_app.data.model.Email;

import java.util.List;

public final class MainAdapter extends RecyclerView.Adapter<MainAdapter.ItemHolder> {

	private List<Email> emails;
	private Context context;

	public MainAdapter(List<Email> emails, final TextView emptyTV, Context context) {
		this.emails = emails;
		this.context = context;
		registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
			@Override
			public void onItemRangeChanged(int positionStart, int itemCount) {
				if (itemCount == 0) {
					emptyTV.setVisibility(View.VISIBLE);
				} else {
					emptyTV.setVisibility(View.GONE);
				}
			}
		});
	}

	@NonNull
	@Override
	public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(context).inflate(R.layout.adapter_email, parent, false);

		return new ItemHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
		Email email = emails.get(position);

		holder.titleTV.setText(email.getTitle());
		holder.contentTV.setText(email.getContent());
	}

	@Override
	public int getItemCount() {
		return emails.size();
	}

	class ItemHolder extends RecyclerView.ViewHolder {

		@BindView(R.id.tvTitle)
		TextView titleTV;
		@BindView(R.id.tvContent)
		TextView contentTV;

		ItemHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
	}
}
