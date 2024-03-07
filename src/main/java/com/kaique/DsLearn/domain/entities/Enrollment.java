package com.kaique.DsLearn.domain.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;

import com.kaique.DsLearn.domain.entities.pk.EnrollmentPk;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_enrollment")
public class Enrollment {

	@Id
	@EmbeddedId
	private EnrollmentPk id = new EnrollmentPk();
	private Instant enrollMoment;
	private Instant refundMoment;
	private boolean available;
	private boolean onlyUpdate;
	
	@ManyToMany(mappedBy = "enrollmentsDone")
	private Set<Lesson> lessonsDone = new HashSet<>();
	
	public Enrollment() {
	}

	public Enrollment(User user, Offer offer, Instant enrollMoment, Instant refundMoment, boolean available,
			boolean onlyUpdate) {
		id.setUser(user);
		id.setOffer(offer);
		this.enrollMoment = enrollMoment;
		this.refundMoment = refundMoment;
		this.available = available;
		this.onlyUpdate = onlyUpdate;
	}

	public User getStudent() {
		return id.getUser();
	}
	
	public void setStudent(User user) {
		id.setUser(user);
	}

	public Offer getOffer() {
		return id.getOffer();
	}
	
	public void setOffer(Offer offer) {
		id.setOffer(offer);
	}
	
	public Instant getEnrollMoment() {
		return enrollMoment;
	}

	public void setEnrollMoment(Instant enrollMoment) {
		this.enrollMoment = enrollMoment;
	}

	public Instant getRefundMoment() {
		return refundMoment;
	}

	public void setRefundMoment(Instant refundMoment) {
		this.refundMoment = refundMoment;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean isOnlyUpdate() {
		return onlyUpdate;
	}

	public void setOnlyUpdate(boolean onlyUpdate) {
		this.onlyUpdate = onlyUpdate;
	}

	public Set<Lesson> getLessonsDone() {
		return lessonsDone;
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
		Enrollment other = (Enrollment) obj;
		return Objects.equals(id, other.id);
	}

}
