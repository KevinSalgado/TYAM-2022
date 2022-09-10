package mx.uv.sbc.trigonometriccalc;

public class Maths {
    public static double calcular (int grados, Funcs func) {
        double bar = 0.0;

        if (grados > -1 && func != null) {

            switch (func.name ()) {
                case "Sin":
                    //bar = Math.sin (Math.toRadians (grados));
                    bar = Math.sin (grados);
                    break;
                case "Cos":
                    //bar = Math.cos (Math.toRadians (grados));
                    bar = Math.cos (grados);
                    break;
                case "Tan":
                    //bar = Math.tan (Math.toRadians (grados));
                    bar = Math.tan (grados);
                    break;
            }

        }

        return bar;
    }
}
