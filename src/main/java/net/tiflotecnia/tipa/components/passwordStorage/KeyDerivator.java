/**
 * 
 */
package net.tiflotecnia.tipa.components.passwordStorage;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * Class to derive keys from passwords, using various algorithms; keys are suitable for password storage.
 * <p>
 * This class uses typesafe configuration for it's parameterization.
 * All keys are kept on the net.tiflotecnia.components.passwordStorage config subtree.
 * For the used parameters and format please check the reference configuration file in
 * src/main/resources/reference.conf
 * <p>
 * With the algorithms subkey, we can add external algorithms.
 * 
 * @author Rui Batista
 * @see Config
 * @see ConfigFactory
 */
public class KeyDerivator {

	private Map<String, AbstractKeyDerivationAlgorithm> _algorithms = new HashMap<String, AbstractKeyDerivationAlgorithm>();
	private String _defaultAlgorithm;

	private Config _config = null;

	/**
	 * Constructs a new factory with an explicit config object.
	 * 
	 * @param config
	 *            the config object to use
	 */
	public KeyDerivator(Config config) {
		_config = config
				.getConfig("net.tiflotecnia.tipa.components.passwordStorage");
		populateAlgorithms();
		_defaultAlgorithm = _config.getString("defaultAlgorithm");
	}

	/**
	 * Construct a new factory using the default config object from typesafe
	 * config factory.
	 * 
	 * @see ConfigFactory #load();
	 */
	public KeyDerivator() {
		this(ConfigFactory.load());
	}

	/**
	 * Derives  a key from the given password, using the given algorithm
	 * @param password the password
	 * @param algorithm the algorithm to use (algorithm identifier)
	 * @return the new key containing algorithm identification
	 */
	public String deriveKey(String password, String algorithm) {
		AbstractKeyDerivationAlgorithm instance = getAlgorithm(algorithm);
		return algorithm + ':' + instance.generateKey(password);
	}
	
	/**
	 * Derives a key from the given password, using the default algorithm.
	 * @param password the password
	 * @return the derived key.
	 */
	public String deriveKey(String password) {
		return deriveKey(password, _defaultAlgorithm);
	}
	
	public boolean check(String password, String key) {
		int index = key.indexOf(':');
		String algorithm = key.substring(0,  index);
		AbstractKeyDerivationAlgorithm instance = getAlgorithm(algorithm);
		return instance.check(password, key.substring(index+1));	
	}

	public final Set<String> getAvailableAlgorithms() {
		return _algorithms.keySet();
	}

	private void populateAlgorithms() {
	for(Config c : _config.getConfigList("algorithms")) {
String identifier = c.getString("identifier");
Config params = c.getConfig("params");
String className = c.getString("class");
AbstractKeyDerivationAlgorithm algorithm;
try {
	Class<?> classRef = Class.forName(className);
	algorithm = (AbstractKeyDerivationAlgorithm)classRef.getConstructor(Config.class).newInstance(params);
} catch (ClassNotFoundException | InstantiationException
		| IllegalAccessException | IllegalArgumentException
		| InvocationTargetException | NoSuchMethodException | SecurityException e) {
// This is to be used on a non-exception trappy context.
	throw new RuntimeException("Error creating key derivation algorithm class", e);

}
_algorithms.put(identifier, algorithm);
	}
}
	
	private AbstractKeyDerivationAlgorithm getAlgorithm(String algorithm) {
		if (!_algorithms.containsKey(algorithm)) {
			throw new IllegalArgumentException("Unkown algorithm: " + algorithm);
		}
return _algorithms.get(algorithm);
	}
}