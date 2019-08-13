/**
 * 
 */
package com.project.restauranttablereservation.service;

import java.util.HashSet;
import java.util.Set;

import com.project.restauranttablereservation.models.PaymentType;

/**
 * @author sivasaiv
 *
 */
public interface PaymentTypeService {
	
	public HashSet<PaymentType> getPaymentTypes(Set<String> paymentTypes);
	
}
