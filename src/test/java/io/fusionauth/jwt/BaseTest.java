/*
 * Copyright (c) 2023, FusionAuth, All Rights Reserved
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
package io.fusionauth.jwt;

import org.testng.Assert.ThrowingRunnable;
import static org.testng.Assert.fail;

/**
 * @author Daniel DeGroff
 */
public abstract class BaseTest {
  protected void expectException(Class<? extends Exception> expected, ThrowingRunnable runnable) throws Throwable {
    try {
      runnable.run();
      fail("Expected [" + expected.getCanonicalName() + "] to be thrown. No Exception was thrown.");
    } catch (Exception e) {
      if (!e.getClass().isAssignableFrom(expected)) {
        fail("Expected [" + expected.getCanonicalName() + "] to be thrown. Caught this instead [" + e.getClass().getCanonicalName() + "]");
      }
    }
  }
}
