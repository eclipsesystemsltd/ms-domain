/**
  __  __           _     _               _____                           
 |  \/  |         (_)   | |             / ____|                          
 | \  / | ___ _ __ _  __| | ___ _ __   | (___  _ __   __ _ _ __ ___  ___ 
 | |\/| |/ _ \ '__| |/ _` |/ _ \ '_ \   \___ \| '_ \ / _` | '__/ _ \/ __|
 | |  | |  __/ |  | | (_| |  __/ | | |  ____) | |_) | (_| | | |  __/\__ \
 |_|  |_|\___|_|  |_|\__,_|\___|_| |_| |_____/| .__/ \__,_|_|  \___||___/
                                              | |                        
                                              |_|                        
 */
package uk.co.meridenspares.domain;

import java.io.Serializable;

/**
 * Base class for domain model objects.
 * Child objects should implement toString(), equals() and hashCode().
 * @author user
 *
 */
public abstract class DomainObject implements Serializable {

	private static final long serialVersionUID = -3870000841106569914L;

	/**
	 * Returns a multi-line String with key=value pairs.
	 * 
	 * @Return a String representation of this class
	 */
	@Override
	public abstract String toString();
	
	/**
	 * Compares object equality.
	 * When using Hibernate the primary key should not be included in the comparison.
	 * 
	 * @return true/false based on equality tests
	 */
	@Override
	public abstract boolean equals(Object o);
	
	/**
	 * When you override equals(), you should also override hashCode().
	 * 
	 * @return int - hash code
	 */
	@Override
	public abstract int hashCode();
}
