package io.fusionauth.jwt.unsecured;

import io.fusionauth.jwt.BaseTest;
import io.fusionauth.jwt.InvalidJWTException;
import io.fusionauth.jwt.Signer;
import io.fusionauth.jwt.UnsecuredSigner;
import io.fusionauth.jwt.domain.JWT;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 * @author Daniel DeGroff
 */
public class NoneActionTest extends BaseTest {
  @Test
  public void test_none() throws Throwable {
    JWT jwt = new JWT().setSubject("123456789");
    Signer signer = new UnsecuredSigner();

    String encodedJWT = JWT.getEncoder().encode(jwt, signer);
    assertEquals(encodedJWT, "eyJhbGciOiJub25lIiwidHlwIjoiSldUIn0.eyJzdWIiOiIxMjM0NTY3ODkifQ.");

    JWT actual = JWT.getDecoder().decode(encodedJWT);
    assertEquals(actual.subject, jwt.subject);

    // Remove the last '.' (dot) and try again - this will fail, invalid JWT. All three parts are required, even for 'none'
    expectException(InvalidJWTException.class, () -> JWT.getDecoder().decode("eyJhbGciOiJub25lIiwidHlwIjoiSldUIn0.eyJzdWIiOiIxMjM0NTY3ODkifQ"));
  }
}
