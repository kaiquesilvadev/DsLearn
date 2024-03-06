package com.kaique.DsLearn.domain.entities;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_offer")
public class Offer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String edition;
	private OffsetDateTime startMoment;
	private OffsetDateTime endMoment;

	@JoinColumn(name = "course_id")
	@ManyToOne
	private Course course;
	
	@OneToMany(mappedBy = "offer")
	private List<Resource> resources = new ArrayList<>();

	public Offer() {
	}

	public Offer(Long id, String edition, OffsetDateTime startMoment, OffsetDateTime endMoment, Course course) {
		this.id = id;
		this.edition = edition;
		this.startMoment = startMoment;
		this.endMoment = endMoment;
		this.course = course;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public OffsetDateTime getStartMoment() {
		return startMoment;
	}

	public void setStartMoment(OffsetDateTime startMoment) {
		this.startMoment = startMoment;
	}

	public OffsetDateTime getEndMoment() {
		return endMoment;
	}

	public void setEndMoment(OffsetDateTime endMoment) {
		this.endMoment = endMoment;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Resource> getResources() {
		return resources;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offer other = (Offer) obj;
		return Objects.equals(id, other.id);
	}
}
