package test;

import net.gudenau.lib.unsafe.Unsafe;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class UnsafeTest extends Unsafe {
    @Test void allocateInstanceTest() {
        assert allocateInstance(UnsafeTest.class).getClass() == UnsafeTest.class;
    }

    @Test void throwable() {
        var throwable = new Throwable();

        try {
            throwException(throwable);

            throw new AssertionError();
        } catch (Throwable trouble) {
            assert trouble == throwable;
        }
    }
}
