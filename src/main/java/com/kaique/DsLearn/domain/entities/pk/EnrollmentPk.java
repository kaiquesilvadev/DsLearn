package com.kaique.DsLearn.domain.entities.pk;

import java.util.Objects;

import com.kaique.DsLearn.domain.entities.Offer;
import com.kaique.DsLearn.domain.entities.User;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class EnrollmentPk {

	@JoinColumn(name = "user_id")
	@ManyToOne
	private User user;
	
	@JoinColumn(name = "offer_id")
	@ManyToOne
	private Offer offer;

	public EnrollmentPk() {
	}

	public EnrollmentPk(User user, Offer offer) {
		this.user = user;
		this.offer = offer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(offer, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnrollmentPk other = (EnrollmentPk) obj;
		return Objects.equals(offer, other.offer) && Objects.equals(user, other.user);
	}
}
