package com.arfapps.cesar_app.repository;

import com.arfapps.cesar_app.data.model.Email;
import com.arfapps.cesar_app.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository implements DefaultRepository<Email> {

	private List<Email> emailsFake = new ArrayList<>();

	public ItemRepository() {
		for (int i = 0; i < 100; i++) {
			emailsFake.add(createFakeEmail("titulo" + i, "content" + i));
		}
	}

	private Email createFakeEmail(String title, String content) {
		Email email = new Email();
		email.setTitle(title);
		email.setContent(content);

		return email;
	}

	@Override
	public void setCacheToDirty() {

	}

	@Override
	public boolean hasCache() {
		return false;
	}

	@Override
	public List<Email> getCurrentCache() {
		return null;
	}

	@Override
	public Email create(Email model) {
		return null;
	}

	@Override
	public Email recover(Long id) {
		return null;
	}

	@Override
	public Email update(Email model) {
		return null;
	}

	@Override
	public Email delete(Email model) {
		return null;
	}

	public List<Email> getAllEmails() {
		return emailsFake;
	}

	public List<Email> getAllEmailsByTitulo(String titulo) {
		List<Email> emailListFiltered = new ArrayList<>();

		for (Email email : emailsFake) {
			if (StringUtil.stringsHasPermuted(email.getTitle().toCharArray(), titulo.toCharArray())) {
				emailListFiltered.add(email);
			} else if (StringUtil.stringsHasTypoChanged(email.getTitle().toCharArray(), titulo.toCharArray())) {
				emailListFiltered.add(email);
			}
		}

		return emailListFiltered;
	}
}
