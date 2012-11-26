/**
 * 
 */
package net.tiflotecnia.tipa.components.passwordStorage.examples;

import net.tiflotecnia.tipa.components.passwordStorage.AbstractKeyDerivationAlgorithm;

/**
 * This is a dummy example of a key derivation algorithm the return theh plain password (identity funciton).
 * Don't use this in production!
 * @author Rui Batista
 *
 */
public class PlainKeyDerivationAlgorithm extends AbstractKeyDerivationAlgorithm {

	@Override
	protected String generateKey(String password) {
		return password;
	}

	@Override
	protected boolean check(String password, String key) {
		return key.equals(password);
	}

}
