package foundation.fantom.jitweb3.abi.datatypes.generated;

import java.math.BigInteger;
import foundation.fantom.jitweb3.abi.datatypes.Uint;

/**
 * Auto generated code.
 * <p><strong>Do not modifiy!</strong>
 * <p>Please use foundation.fantom.jitweb3.codegen.AbiTypesGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 */
public class Uint120 extends Uint {
    public static final Uint120 DEFAULT = new Uint120(BigInteger.ZERO);

    public Uint120(BigInteger value) {
        super(120, value);
    }

    public Uint120(long value) {
        this(BigInteger.valueOf(value));
    }
}
