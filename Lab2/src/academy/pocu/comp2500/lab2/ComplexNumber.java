package academy.pocu.comp2500.lab2;

public class ComplexNumber {
    public double real;
    public double imaginary;

    public ComplexNumber() {
        this(0.0, 0.0);
    }

    public ComplexNumber(double real) {
        this(real, 0.0);
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public boolean isReal() {
        if (imaginary == 0.0) {
            return true;
        }
        return false;
    }

    public boolean isImaginary() {
        if (real == 0.0) {
            return true;
        }
        return false;
    }

    public ComplexNumber getConjugate() {
        ComplexNumber conjugate = new ComplexNumber(this.real, -(this.imaginary));

        return conjugate;
    }

    public ComplexNumber add(ComplexNumber num) {
        ComplexNumber sum = new ComplexNumber(this.real + num.real, this.imaginary + num.imaginary);

        return sum;
    }

    public ComplexNumber subtract(ComplexNumber num) {
        ComplexNumber diff = new ComplexNumber(this.real - num.real, this.imaginary - num.imaginary);

        return diff;
    }

    public ComplexNumber multiply(ComplexNumber num) {
        double real = (this.real * num.real) - (this.imaginary * num.imaginary);
        double imaginary = (this.real * num.imaginary) + (this.imaginary * num.real);

        ComplexNumber product = new ComplexNumber(real, imaginary);

        return product;
    }

    public ComplexNumber divide(ComplexNumber num) {
        ComplexNumber numConjugate = num.getConjugate();
        ComplexNumber product = this.multiply(numConjugate);

        double real = product.real / (num.real * num.real + num.imaginary * num.imaginary);
        double imaginary = product.imaginary / (num.real * num.real + num.imaginary * num.imaginary);
        ComplexNumber divide = new ComplexNumber(real, imaginary);

        return divide;
    }
}
