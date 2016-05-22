package com.mikebull94.demo.sitemap.model;

import java.time.LocalDate;
import java.util.Objects;

public final class BlogEntry {
	private final String title;
	private final String content;
	private final LocalDate date;

	public BlogEntry(String title, String content, LocalDate date) {
		this.title = Objects.requireNonNull(title);
		this.content = Objects.requireNonNull(content);
		this.date = Objects.requireNonNull(date);
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public LocalDate getDate() {
		return date;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BlogEntry blogEntry = (BlogEntry) o;
		return Objects.equals(title, blogEntry.title)
			&& Objects.equals(content, blogEntry.content)
			&& Objects.equals(date, blogEntry.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, content, date);
	}

	@Override
	public String toString() {
		return "BlogEntry{" +
			"title='" + title + '\'' +
			", content='" + content + '\'' +
			", date=" + date +
			'}';
	}
}
