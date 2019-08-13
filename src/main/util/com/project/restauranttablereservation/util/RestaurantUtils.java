package com.project.restauranttablereservation.util;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 
 */

/**
 * @author sivasaiv
 *
 */
@Component
public class RestaurantUtils {

	public static String captalize(String str) {
		
		return StringUtils.capitalize(str.toLowerCase());
	}
}
