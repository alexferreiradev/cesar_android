package com.arfapps.cesar_app.data.model;

@SuppressWarnings("SimplifiableIfStatement")
public class Email extends BaseModel<Email> {

	private String title;
	private String content;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override

	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Email)) return false;

		Email email = (Email) o;

		if (title != null ? !title.equals(email.title) : email.title != null) return false;
		return content != null ? content.equals(email.content) : email.content == null;
	}

	@Override
	public int hashCode() {
		int result = title != null ? title.hashCode() : 0;
		result = 31 * result + (content != null ? content.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Email{" +
				"title='" + title + '\'' +
				", content='" + content + '\'' +
				", id=" + id +
				'}';
	}
}
