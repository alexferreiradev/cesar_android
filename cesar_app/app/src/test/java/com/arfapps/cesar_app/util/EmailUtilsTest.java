package com.arfapps.cesar_app.util;

import android.support.annotation.NonNull;
import com.arfapps.cesar_app.data.model.Email;
import com.arfapps.cesar_app.data.model.linked_list.SingleLinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class EmailUtilsTest {

	@Test
	public void cleanDuplicatedEmails() {
		SingleLinkedList<Email> emailListFake = new SingleLinkedList<>();
		String emailTitle[] = {"A", "B", "C"};
		for (int i = 0; i < 30; i++) {
			if (i % 2 == 0) {
				emailListFake.addLast(createEmail(emailTitle[0]));
			} else if (i == 7 || i == 3) {
				emailListFake.addLast(createEmail(emailTitle[2]));
			} else {
				emailListFake.addLast(createEmail(emailTitle[1]));
			}
		}
		Long beforeSize = emailListFake.getSize();

		SingleLinkedList<Email> emails = EmailUtils.cleanDuplicatedEmails(emailListFake);

		assertNotEquals(beforeSize, emails.getSize());
		assertEquals(Long.valueOf(3L), emails.getSize());
	}

	@NonNull
	private Email createEmail(String suffixTitle) {
		Email email = new Email();
		email.setTitle("Titulo " + suffixTitle);
		return email;
	}
}