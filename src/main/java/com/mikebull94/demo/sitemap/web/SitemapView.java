package com.mikebull94.demo.sitemap.web;

import com.mikebull94.demo.sitemap.service.SitemapService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import java.util.Objects;

@Component
public final class SitemapView extends AbstractView {
	private final SitemapService service;

	@Inject
	public SitemapView(SitemapService service) {
		this.service = Objects.requireNonNull(service);
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType(MediaType.APPLICATION_XML_VALUE);

		Writer writer = response.getWriter();
		writer.append(service.createSitemap());
		writer.flush();
	}
}
