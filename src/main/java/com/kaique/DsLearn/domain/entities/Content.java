package com.kaique.DsLearn.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_content")
public class Content extends Lesson {

	private String textContent;
	private String videoUrl;

	public Content() {
	}

	public Content(Long id, String title, Integer position, Section section, String textContent, String videoUrl) {
		super(id, title, position, section);
		this.textContent = textContent;
		this.videoUrl = videoUrl;
	}

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
}
