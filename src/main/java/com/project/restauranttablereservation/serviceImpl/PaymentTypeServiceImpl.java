/**
 * 
 */
package com.project.restauranttablereservation.serviceImpl;

import static com.project.restauranttablereservation.util.RestaurantUtils.captalize;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.project.restauranttablereservation.models.PaymentType;
import com.project.restauranttablereservation.repositories.PaymentTypeRepository;
import com.project.restauranttablereservation.service.PaymentTypeService;

/**
 * @author sivasaiv
 *
 */
@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

	@Autowired
	PaymentTypeRepository paymentTypeRepo;

	@Override
	public HashSet<PaymentType> getPaymentTypes(Set<String> paymentTypes) {

		HashSet<PaymentType> paymentTypeObjs = new HashSet<>();

		paymentTypes.forEach(typeName -> {
			typeName = StringUtils.capitalize(typeName.toLowerCase());
			Optional<PaymentType> optionalType = paymentTypeRepo.findByType(captalize(typeName));
			if (optionalType.isPresent()) {
				paymentTypeObjs.add(optionalType.get());
			} else {
				PaymentType paymentType = new PaymentType(typeName);
				paymentTypeObjs.add(paymentType);
			}

		});

		return paymentTypeObjs;
	}
}
