package uk.co.meridenspares.domain.util;

import java.math.BigDecimal;

public class CurrencyUtil {

	/**
	 * Defined centrally, to allow for easy changes to the rounding mode.
	 */
	public static int ROUNDING_MODE = BigDecimal.ROUND_HALF_EVEN;

	/**
	 * Number of decimals to retain.
	 * An alternate style for this value:
	 * private static int DECIMAL_PLACES = Currency.getInstance("USD").getDefaultFractionDigits();
	 */
	public static int SCALE = 2;

	/**
	 * Private constructor to prevent instantiation.
	 */
	private CurrencyUtil() {
	}
	
	public static BigDecimal round(BigDecimal number) {
		return number.setScale(SCALE, ROUNDING_MODE);
	}
}
