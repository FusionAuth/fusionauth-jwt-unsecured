/*
 * Copyright (c) 2016-2023, FusionAuth, All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package io.fusionauth.jwt.unsecured;

import io.fusionauth.jwt.BaseTest;
import io.fusionauth.jwt.InvalidJWTException;
import io.fusionauth.jwt.JWTUtils;
import io.fusionauth.jwt.Signer;
import io.fusionauth.jwt.domain.JWT;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 * @author Daniel DeGroff
 */
public class NoneActionTest extends BaseTest {
  @Test
  public void decodePayload() {
    JWT jwt = new JWT().setSubject("123456789");

    // Test with an unsecured signer
    String unsecuredJWT = JWT.getEncoder().encode(jwt, new UnsecuredSigner());
    assertEquals(JWTUtils.decodePayload(unsecuredJWT).subject, "123456789");
  }

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
