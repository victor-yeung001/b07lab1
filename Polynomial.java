public class Polynomial {

    double[] coeff = new double[10];

    public Polynomial() {
        for (int i = 0; i < coeff.length; i++) {
            coeff[i] = 0;
        }
    }

    public Polynomial(double[] inputCoeff) {
        for (int i = 0; i < inputCoeff.length; i++) {
            coeff[i] = inputCoeff[i];
        }
    }

    public double[] getCoeff() {
        return this.coeff;
    }

    public Polynomial add(Polynomial p) {
        Polynomial result;
        int length = Math.max(coeff.length, p.getCoeff().length);
        double[] c = new double[length];
        double[] otherC = new double[length];

        if (coeff.length < p.getCoeff().length) {
            for (int i = 0; i < length; i++) {
                otherC[i] = coeff[i];
            }
            for (int i = 0; i < length; i++) {
                c[i] = otherC[i] + p.getCoeff()[i];
            }
        } else if (coeff.length > p.getCoeff().length) {
            for (int i = 0; i < length; i++) {
                otherC[i] = p.getCoeff()[i];
            }
            for (int i = 0; i < length; i++) {
                c[i] = otherC[i] + coeff[i];
            }
        } else {
            for (int i = 0; i < length; i++) {
                c[i] = coeff[i] + p.getCoeff()[i];
            }
        }

        result = new Polynomial(c);

        return result;
    }

    public double evaluate(double x) {
        double result = 0;

        for (int i = 0; i < coeff.length; i++) {
            result = (coeff[i] * Math.pow(x, i)) + result;
        }

        return result;
    }

    public Boolean hasRoot(double x) {
        if (this.evaluate(x) == 0) {
            return true;
        }
        return false;
    }

}