package Practice2;

import java.rmi.RemoteException;

import static java.lang.Math.sqrt;

public class EquationImpl implements Equation {
    @Override
    public void CalcEquation(int a, int b, int c) throws RemoteException {
        int descr = b*b - 4 * a * c;
        if(descr > 0){
            double x1 = (-b + sqrt(descr))/(2*a);
            double x2 = (-b - sqrt(descr))/(2*a);
            System.out.println("Первый корень уравнения: " + x1 + "\n"
            + "Второй корень уравнения: " + x2);
        } else if(descr == 0){
            double x1 = -b/(2*a);
            System.out.println("Корень уравнения: " + x1);
        } else {
            System.out.println("Корней нет");
        }

    }
}
