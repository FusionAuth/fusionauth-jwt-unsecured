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

import io.fusionauth.jwt.OpenIDConnect;
import org.testng.annotations.Test;
import static io.fusionauth.jwt.OpenIDConnect.c_hash;
import static org.testng.AssertJUnit.fail;

/**
 * @author Daniel DeGroff
 */
public class OpenIdConnectTest {
  @Test
  public void validation() {
    try {
      OpenIDConnect.at_hash("foo", None.none);
      fail("expected exception when passing an invalid Algorithm");
    } catch (IllegalArgumentException ignore) {
    }

    try {
      c_hash("foo", None.none);
      fail("expected exception when passing an invalid Algorithm");
    } catch (IllegalArgumentException ignore) {
    }
  }
}
