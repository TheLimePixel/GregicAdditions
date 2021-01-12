package gregicadditions.machines;

import net.minecraft.init.*;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Tests for validating correctness of logic for the Processing Array.
 */
public class ProcessingArrayTests {

    /**
     * Required. Without this all item-related operations will fail because registries haven't been initialized.
     */
    @BeforeClass
    public static void bootStrap() {
        Bootstrap.register();
    }

    @Test
    @Ignore
    public void test_goes_here() {
        fail();
    }

}