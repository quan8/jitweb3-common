package foundation.fantom.jitweb3.abi.datatypes.generated;

import java.math.BigInteger;
import foundation.fantom.jitweb3.abi.datatypes.Int;

/**
 * Auto generated code.
 * <p><strong>Do not modifiy!</strong>
 * <p>Please use foundation.fantom.jitweb3.codegen.AbiTypesGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 */
public class Int40 extends Int {
    public static final Int40 DEFAULT = new Int40(BigInteger.ZERO);

    public Int40(BigInteger value) {
        super(40, value);
    }

    public Int40(long value) {
        this(BigInteger.valueOf(value));
    }
}
