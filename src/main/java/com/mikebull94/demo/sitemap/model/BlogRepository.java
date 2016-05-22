package com.mikebull94.demo.sitemap.model;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public final class BlogRepository {
	private final List<BlogEntry> blogEntries = new ArrayList<>();

	public BlogRepository() {
		blogEntries.add(new BlogEntry("an-old-blog-post", "Some content...", LocalDate.of(2014, Month.DECEMBER, 1)));
		blogEntries.add(new BlogEntry("a-newer-blog-post", "Some content...", LocalDate.of(2016, Month.MAY, 22)));
	}

	public List<BlogEntry> findAll() {
		return Collections.unmodifiableList(blogEntries);
	}
}
