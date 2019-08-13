/**
 * 
 */
package com.project.restauranttablereservation.service;

import com.project.restauranttablereservation.models.BaseResponse;

/**
 * @author sivasaiv
 *
 */
public interface BaseService {

	public default void handleException(BaseResponse response, final String message, final String errorCode) {
		response.setMessage(message);
		response.setStatus(errorCode); 
	}
}
