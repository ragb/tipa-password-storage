/**
 * 
 */
package net.tiflotecnia.tipa.components.passwordStorage;

import com.lambdaworks.crypto.SCryptUtil;
import com.typesafe.config.Config;

/**
 * Scrypt key derivation algorithm implemenation. This algorithm uses memory-hard functions to prevent brut-force attacs.
 * <p>
 * See algorithm details at http://www.bsdcan.org/2009/schedule/attachments/87_scrypt.pdf <br>
 * More details and a sample file encrypt tool can be found here: http://www.tarsnap.com/scrypt.html
 * 
 * <p>
 * We are using the java implementation from lanbdaworks that can be found here:
 * https://github.com/wg/scrypt
 * 
 * @author Rui Batista
 *
 */
public class ScryptKeyDerivationAlgorithm extends
		AbstractKeyDerivationAlgorithm {

	private int _n, _r, _p;
	
	/**
	 * Creates a new Scrypt algorithm. Config must have the following parameters, to tune the scrypt algorithm:
	 * <ul>
	 * <li>n: CPU cost</li>
	 * <li>r: Memory cost</li<
	 * <li>p: parallelization cost</li>
	 * </ul>
	 * @param config the config object to use
	 */
	public ScryptKeyDerivationAlgorithm(Config config) {
		super(config);
		_n = config.getInt("n");
		_r = config.getInt("r");
		_p = config.getInt("p");
	}

	/**
	 *  Generates a key from the password using the parameters from the config object, storing them with the key.
	 *  
	 * @see net.tiflotecnia.tipa.components.passwordStorage.AbstractKeyDerivationAlgorithm#generateKey(java.lang.String)
	 */
	@Override
	protected String generateKey(String password) { 
		return SCryptUtil.scrypt(password, _n, _r, _p);
	}

	/**
	 *  Checks if the given password matches the given scrypt key. 
	 * @see net.tiflotecnia.tipa.components.passwordStorage.AbstractKeyDerivationAlgorithm#check(java.lang.String, java.lang.String)
	 */
	@Override
	protected boolean check(String password, String key) {
		return SCryptUtil.check(password, key);
	}

}
