package foundation.fantom.jitweb3.abi.datatypes.generated;

import java.math.BigInteger;
import foundation.fantom.jitweb3.abi.datatypes.Int;

/**
 * Auto generated code.
 * <p><strong>Do not modifiy!</strong>
 * <p>Please use foundation.fantom.jitweb3.codegen.AbiTypesGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 */
public class Int192 extends Int {
    public static final Int192 DEFAULT = new Int192(BigInteger.ZERO);

    public Int192(BigInteger value) {
        super(192, value);
    }

    public Int192(long value) {
        this(BigInteger.valueOf(value));
    }
}
