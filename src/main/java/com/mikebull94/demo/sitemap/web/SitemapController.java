package com.mikebull94.demo.sitemap.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.Objects;

import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@Controller
public final class SitemapController {
	private final SitemapView view;

	@Inject
	public SitemapController(SitemapView view) {
		this.view = Objects.requireNonNull(view);
	}

	@RequestMapping(path = "/sitemap.xml", produces = APPLICATION_XML_VALUE)
	public SitemapView create() {
		return view;
	}
}
