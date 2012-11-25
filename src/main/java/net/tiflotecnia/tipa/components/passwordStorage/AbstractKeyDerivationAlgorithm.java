package net.tiflotecnia.tipa.components.passwordStorage;

import com.typesafe.config.Config;

/**
 * Abstract class for key derivation algorithms to implement.
 * 
 * @author Rui Batista
 *
 */
public abstract class AbstractKeyDerivationAlgorithm {
	
	private Config _config;
	
protected AbstractKeyDerivationAlgorithm(Config config) {
		_config = config;
	}

/**
 * Gets the configuration object for this algorithm to use.
 * 
 * @return
 */
protected final Config getConfig() {
		return _config;
}

	
	/**
	 * Generates a key from the password. If any parameters are needed they must be retrieved from the config object.
	 * 
	 * @param password the plain text password
	 * @return a String suitable for storage.
	 */
	protected abstract String generateKey(String password);
	
	/**
	 * Checks if the given password matches the store key.
	 * 
	 * @param password
	 * @param Key
	 * @return
	 */
	protected abstract boolean check(String password, String ey);
}
