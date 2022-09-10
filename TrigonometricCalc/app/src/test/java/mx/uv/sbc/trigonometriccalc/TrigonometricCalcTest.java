package mx.uv.sbc.trigonometriccalc;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrigonometricCalcTest {
    @Test
    public void calcular_sin_test () {
        //setup
        int degrees = 45;
        Funcs func = Funcs.Sin;
        double expected = 0.8509035245341184;

        //act
        double result = Maths.calcular (degrees, func);

        //assert
        assertEquals (expected, result, 0);
    }

    @Test
    public void calcular_cos_test () {
        //setup
        int degrees = 45;
        Funcs func = Funcs.Cos;
        double expected = 0.5253219888177297;

        //act
        double result = Maths.calcular (degrees, func);

        //assert
        assertEquals (expected, result, 0);
    }

    @Test
    public void calcular_tan_test () {
        //setup
        int degrees = 45;
        Funcs func = Funcs.Tan;
        double expected = 1.6197751905438615;

        //act
        double result = Maths.calcular (degrees, func);

        //assert
        assertEquals (expected, result, 0);
    }
}