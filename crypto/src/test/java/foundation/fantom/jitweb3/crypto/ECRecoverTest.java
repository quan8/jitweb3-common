/*
 * Copyright 2019 Web3 Labs Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package foundation.fantom.jitweb3.crypto;

import java.math.BigInteger;
import java.util.Arrays;

import foundation.fantom.jitweb3.crypto.Hash;
import org.junit.jupiter.api.Test;

import foundation.fantom.jitweb3.crypto.Sign.SignatureData;
import foundation.fantom.jitweb3.utils.Numeric;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ECRecoverTest {

    public static final String PERSONAL_MESSAGE_PREFIX = "\u0019Ethereum Signed Message:\n";

    @Test
    public void testRecoverAddressFromSignature() {

        String signature =
                "0x2c6401216c9031b9a6fb8cbfccab4fcec6c951cdf40e2320108d1856eb532250576865fbcd452bcdc4c57321b619ed7a9cfd38bd973c3e1e0243ac2777fe9d5b1b";

        String address = "0x31b26e43651e9371c88af3d36c14cfd938baf4fd";
        String message = "v0G9u7huK4mJb2K1";

        String prefix = PERSONAL_MESSAGE_PREFIX + message.length();
        byte[] msgHash = Hash.sha3((prefix + message).getBytes());

        byte[] signatureBytes = Numeric.hexStringToByteArray(signature);
        byte v = signatureBytes[64];
        if (v < 27) {
            v += 27;
        }

        SignatureData sd =
                new SignatureData(
                        v,
                        (byte[]) Arrays.copyOfRange(signatureBytes, 0, 32),
                        (byte[]) Arrays.copyOfRange(signatureBytes, 32, 64));

        String addressRecovered = null;
        boolean match = false;

        // Iterate for each possible key to recover
        for (int i = 0; i < 4; i++) {
            BigInteger publicKey =
                    Sign.recoverFromSignature(
                            (byte) i,
                            new ECDSASignature(
                                    new BigInteger(1, sd.getR()), new BigInteger(1, sd.getS())),
                            msgHash);

            if (publicKey != null) {
                addressRecovered = "0x" + Keys.getAddress(publicKey);

                if (addressRecovered.equals(address)) {
                    match = true;
                    break;
                }
            }
        }

        assertEquals(addressRecovered, (address));
        assertTrue(match);
    }
}
