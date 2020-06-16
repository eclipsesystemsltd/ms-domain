package uk.co.meridenspares.domain.util;

import java.util.Collection;

/**
 * This class contains some simple methods to validate method input, e.g. null checking. 
 * @author user
 *
 */
public class ValidationUtil {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private ValidationUtil() {
	}
	
	/**
	 * Validates an object to ensure it is not null.
	 * @param object
	 * @param entityName
	 */
	public static void nullCheck(final Object object, final String entityName) {
		if (object == null) {
			throw new IllegalArgumentException(entityName + " cannot be null");
		}
	}
	
	/**
	 * Validates an object to ensure it is not null.
	 * @param object
	 * @param entityName
	 * @param message
	 */
	public static void nullCheck(final Object object, final String entityName, final String message) {
		if (object == null) {
			throw new IllegalArgumentException(entityName + " cannot be null, " + message);
		}
	}

	/**
	 * Validates a collection to ensure it is not empty.
	 * @param collection
	 * @param entityName
	 */
	public static void notEmptyCheck(final Collection<?> collection, final String entityName) {
		if (collection.isEmpty()) {
			throw new IllegalArgumentException(entityName + " cannot be empty");
		}
	}

}
