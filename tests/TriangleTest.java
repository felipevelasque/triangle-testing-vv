import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TriangleTest {

    @Nested
    @DisplayName("Particionamento de Equivalência")
    class EquivalencePartitioningTests {

        @Test
        @DisplayName("EP01 - Triângulo válido com lados iguais")
        void shouldReturnTrueForValidEquilateralTriangle() {
            assertTrue(Triangle.isTriangle(3, 3, 3));
        }

        @Test
        @DisplayName("EP02 - Triângulo válido com lados diferentes")
        void shouldReturnTrueForValidScaleneTriangle() {
            assertTrue(Triangle.isTriangle(4, 5, 6));
        }

        @Test
        @DisplayName("EP03 - Primeiro lado maior que a soma dos outros")
        void shouldReturnFalseWhenFirstSideIsTooLarge() {
            assertFalse(Triangle.isTriangle(6, 2, 3));
        }

        @Test
        @DisplayName("EP04 - Segundo lado maior que a soma dos outros")
        void shouldReturnFalseWhenSecondSideIsTooLarge() {
            assertFalse(Triangle.isTriangle(2, 6, 3));
        }

        @Test
        @DisplayName("EP05 - Lado igual a zero")
        void shouldReturnFalseWhenSideIsZero() {
            assertFalse(Triangle.isTriangle(0, 2, 2));
        }

        @Test
        @DisplayName("EP06 - Lado negativo")
        void shouldReturnFalseWhenSideIsNegative() {
            assertFalse(Triangle.isTriangle(-1, 2, 2));
        }
    }

    @Nested
    @DisplayName("Análise de Valores Limite")
    class BoundaryValueAnalysisTests {

        @Test
        @DisplayName("BVA01 - Abaixo do limite inferior")
        void shouldReturnFalseBelowLowerBoundary() {
            assertFalse(Triangle.isTriangle(2, 3, 0));
        }

        @Test
        @DisplayName("BVA02 - Exatamente no limite inferior")
        void shouldReturnFalseAtLowerBoundary() {
            assertFalse(Triangle.isTriangle(2, 3, 1));
        }

        @Test
        @DisplayName("BVA03 - Logo acima do limite inferior")
        void shouldReturnTrueAboveLowerBoundary() {
            assertTrue(Triangle.isTriangle(2, 3, 2));
        }

        @Test
        @DisplayName("BVA04 - Logo abaixo do limite superior")
        void shouldReturnTrueBelowUpperBoundary() {
            assertTrue(Triangle.isTriangle(2, 3, 4));
        }

        @Test
        @DisplayName("BVA05 - Exatamente no limite superior")
        void shouldReturnFalseAtUpperBoundary() {
            assertFalse(Triangle.isTriangle(2, 3, 5));
        }

        @Test
        @DisplayName("BVA06 - Acima do limite superior")
        void shouldReturnFalseAboveUpperBoundary() {
            assertFalse(Triangle.isTriangle(2, 3, 6));
        }
    }
}