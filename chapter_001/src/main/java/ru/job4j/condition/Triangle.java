package ru.job4j.condition;

/**
 * Точка в системе координат.
 */
public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double period(double ab, double ac, double bc) {
        return ( ab + ac + bc ) / 2; // вместо -1 нужно написать формулу вычисляющую полуперимент.
    }
    public double area() {
        double rsl = -1; // мы устанавливаем значение -1, так как может быть что треугольника нет. Это значение говорит о том. что треугольника нет.
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            // написать формулу для расчета площади треугольника.
            rsl = Math.sqrt(p * (p - ab) * (p - bc) * (p - ac)); //вместо многоточия нужно написать формулу Герона с подставленными переменные ab, ac, dc, p.
            // Для извлечение квадратного корня надо использовать метод

        }
        return rsl;
    }
    private boolean exist(double ab, double ac, double bc) {
        return ((ab < bc + ac) && ( bc < ab + ac ) && ( ac < ab + bc)) ? true : false;
    }
}


