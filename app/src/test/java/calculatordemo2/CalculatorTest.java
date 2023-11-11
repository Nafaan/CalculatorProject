package calculatordemo2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class CalculatorTest {
    private static Calculator classUnderTest;


    @BeforeAll
    public static void setUp() {
        classUnderTest = new Calculator();
    }

    @DisplayName("Tests the square function")
    @Test
    void testSquare() {
        double num = 5.0;
        assertEquals(num*num, classUnderTest.calcScience(Calculator.singleOperator.square, num));
    }

    @DisplayName("Tests the square root function")
    @Test
    void testSquareRoot() {
        double num = 9.0;
        assertEquals(Math.sqrt(num), classUnderTest.calcScience(Calculator.singleOperator.squareRoot, num));
    }

    @DisplayName("Tests the 1/x function")
    @Test
    void testOneDividedBy() {
        double num = 2.0;
        assertEquals(1/num, classUnderTest.calcScience(Calculator.singleOperator.oneDevidedBy, num));
    }

    @DisplayName("Tests the cosine function in degrees")
    @Test
    void testCos() {
        double num = 45.0;
        assertEquals(Math.cos(num), classUnderTest.calcScience(Calculator.singleOperator.cos, num));
    }

    @DisplayName("Tests the sine function in degrees")
    @Test
    void testSin() {
        double num = 30.0;
        assertEquals(Math.sin(num), classUnderTest.calcScience(Calculator.singleOperator.sin, num));
    }

    @DisplayName("Tests the tangent function in degrees")
    @Test
    void testTan() {
        double num = 60.0;
        assertEquals(Math.tan(num), classUnderTest.calcScience(Calculator.singleOperator.tan, num));
    }

    @DisplayName("Tests whether an error is thrown if a null mode is passed")
    @Test
    void testThrowError() {
        assertThrows(Error.class, () -> classUnderTest.calcScience(null, 10.0));
    }

    // Helper method to set private fields
    private void setPrivateField(String fieldName, Object val) throws Exception {
        Field field = Calculator.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(classUnderTest, val);
    }
    // Helper method to get private fields
    private Object getPrivateField(String fieldName) throws Exception {
        Field field = Calculator.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(classUnderTest);
    }
    // Helper method to access private method
    private double accessPrivateMethod(String methodName) throws Exception {
        Method method = Calculator.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        return (double) method.invoke(classUnderTest);
    }

    @Test
    public void testTwoOpAdd() throws Exception {
        setPrivateField("num1", 9.0);
        setPrivateField("num2", 30.0);
        setPrivateField("mode", Calculator.twoOperator.add);

        double result = accessPrivateMethod("twoOpOperations");

        assertEquals(39.0, result);
    }

    @Test
    public void testTwoOpSub() throws Exception {
        setPrivateField("num1", 30.0);
        setPrivateField("num2", 9.0);
        setPrivateField("mode", Calculator.twoOperator.subtract);

        double result = accessPrivateMethod("twoOpOperations");

        assertEquals(21.0, result);
    }

    @Test
    public void testTwoOpMult() throws Exception {
        setPrivateField("num1", 9.0);
        setPrivateField("num2", 3.0);
        setPrivateField("mode", Calculator.twoOperator.multiply);

        double result = accessPrivateMethod("twoOpOperations");

        assertEquals(27.0, result);
    }
    
    @Test
    public void testTwoOpDiv() throws Exception {
        setPrivateField("num1", 9.0);
        setPrivateField("num2", 3.0);
        setPrivateField("mode", Calculator.twoOperator.divide);

        double result = accessPrivateMethod("twoOpOperations");

        assertEquals(3.0, result);
    }

    @Test
    public void testTwoOpMultAdd() throws Exception {
        setPrivateField("num1", 9.0);
        setPrivateField("num2", 3.0);
        setPrivateField("mode", Calculator.twoOperator.multiply);

        double initial = accessPrivateMethod("twoOpOperations");

        setPrivateField("num1", initial);
        setPrivateField("num2", 2.0);
        setPrivateField("mode", Calculator.twoOperator.add);

        double result = accessPrivateMethod("twoOpOperations");

        assertEquals(29.0, result);
    }

    @Test
    public void testTwoOpDivAdd() throws Exception {
        setPrivateField("num1", 9.0);
        setPrivateField("num2", 3.0);
        setPrivateField("mode", Calculator.twoOperator.divide);

        double initial = accessPrivateMethod("twoOpOperations");

        setPrivateField("num1", initial);
        setPrivateField("num2", 21.0);
        setPrivateField("mode", Calculator.twoOperator.add);

        double result = accessPrivateMethod("twoOpOperations");

        assertEquals(24.0, result);
    }

    @Test
    public void testTwoOpAddSub() throws Exception {
        setPrivateField("num1", 9.0);
        setPrivateField("num2", 3.0);
        setPrivateField("mode", Calculator.twoOperator.add);

        double initial = accessPrivateMethod("twoOpOperations");

        setPrivateField("num1", initial);
        setPrivateField("num2", 2.0);
        setPrivateField("mode", Calculator.twoOperator.subtract);

        double result = accessPrivateMethod("twoOpOperations");

        assertEquals(10.0, result);
    }

    @Test
    public void testTwoOpCallerNormal() throws Exception {
        setPrivateField("num1", 9.0);
        setPrivateField("num2", 0.0);
        setPrivateField("mode", Calculator.twoOperator.normal);

        double result = classUnderTest.twoOpCaller(Calculator.twoOperator.add, 2.0);

        assertEquals(Double.NaN, result);
        assertEquals(2.0, getPrivateField("num1"));
        assertEquals(0.0, getPrivateField("num2"));
        assertEquals(Calculator.twoOperator.add, getPrivateField("mode"));
    }

    @Test
    public void testTwoOpCallerNotNormal() throws Exception {
        setPrivateField("num1", 9.0);
        setPrivateField("num2", 3.0);
        setPrivateField("mode", Calculator.twoOperator.add);

        double result = classUnderTest.twoOpCaller(Calculator.twoOperator.subtract, 2.0);

        assertEquals(getPrivateField("num1"), result);
        assertEquals(11.0, getPrivateField("num1"));
        assertEquals(2.0, getPrivateField("num2"));
        assertEquals(Calculator.twoOperator.subtract, getPrivateField("mode"));
    }
}
