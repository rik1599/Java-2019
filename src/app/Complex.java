package app;

public class Complex {

    private final double real;
    private final double imaginary;

    public Complex(double r, double i) {
        this.real = r;
        this.imaginary = i;
    }

    public Complex add(Complex z) {
        return new Complex(this.real + z.real, this.imaginary + z.imaginary);
    }

    public Complex sub(Complex z) {
        return new Complex(this.real - z.real, this.imaginary - z.imaginary);
    }

    public Complex mul(Complex z) {
        return new Complex(
                this.real * z.real - this.imaginary * z.imaginary,
                this.real * z.imaginary + z.real * this.imaginary);
    }

    public Complex div(Complex z) {
        double div = Math.pow(z.real, 2) + Math.pow(z.imaginary, 2);
        double realPart = (this.real * z.real + this.imaginary * z.imaginary) / div;
        double imaginaryPart = (this.imaginary * z.real - this.real * z.imaginary) / div;
        return new Complex(realPart, imaginaryPart);
    }

    @Override
    public String toString() {
        String sgn = this.imaginary < 0 ? "-" : "+";
        return this.real + sgn + "i" + Math.abs(this.imaginary);
    }
}
