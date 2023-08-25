package io.fusionauth.jwt.unsecured;

import io.fusionauth.jwt.Signer;
import io.fusionauth.jwt.domain.Algorithm;

/**
 * Unsecured signer. You should probably never use this signer.
 *
 * @author Daniel DeGroff
 */
public class UnsecuredSigner implements Signer {
  @Override
  public Algorithm getAlgorithm() {
    return None.none;
  }

  @Override
  public String getKid() {
    return null;
  }

  @Override
  public byte[] sign(String payload) {
    return new byte[0];
  }
}
