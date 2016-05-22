package com.mikebull94.demo.sitemap.service;

import com.mikebull94.demo.sitemap.model.BlogEntry;
import com.mikebull94.demo.sitemap.model.BlogRepository;
import com.redfin.sitemapgenerator.WebSitemapGenerator;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.net.MalformedURLException;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public final class SitemapService {
	private static final String BASE_URL = "https://example.com";

	private final BlogRepository blogRepository;

	@Inject
	public SitemapService(BlogRepository blogRepository) {
		this.blogRepository = Objects.requireNonNull(blogRepository);
	}

	public String createSitemap() throws MalformedURLException {
		WebSitemapGenerator sitemap = new WebSitemapGenerator(BASE_URL);

		for (BlogEntry entry : blogRepository.findAll()) {
			sitemap.addUrl(BASE_URL + "/blog/" + entry.getTitle());
		}

		return sitemap.writeAsStrings().stream().collect(Collectors.joining());
	}
}
