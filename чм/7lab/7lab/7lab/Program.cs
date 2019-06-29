using MathNet.Numerics.LinearAlgebra;
using MathNet.Numerics.LinearAlgebra.Double;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _7lab
{
    class Program
    {

        public static Matrix<double> dF(Vector<double> X)
        {
            Matrix<double> df = DenseMatrix.Create(X.Count, X.Count, 0);
            df[0, 0] = 0.6 + 2 * X[0] * X[1];
            df[0, 1] = 7.5 + X[0] * X[0];
            df[1, 0] = 6;
            df[1, 1] = -Math.Sin(X[1]);

            //df[0, 0] = Math.Cos(X[0] + 0.4); // dF1/dx
            //df[0, 1] = 3.5; // dF1/dy
            //df[1, 0] = 0.5; // dF2/dx
            //df[1, 1] = -Math.Sin(X[1] + 0.2); // dF2/dy
            return df;
        }

        public static Vector<double> F(Vector<double> X)
        {
            Vector<double> f = DenseVector.Create(X.Count, 0);
            f[0] = 0.6 * X[0] + 7.5*X[1] + (X[0]*X[0]) * X[1];
            f[0] = Math.Cos(X[1]) + 6 * X[0];
            //f[0] = Math.Sin(X[0] + 0.4) + 3.5 * X[1] - 1.5; //sin(x+0.4)+3.5*y-1.5
            //f[1] = Math.Cos(X[1] + 0.2) + 0.5 * X[0]; //cos(y + 0.2) + 0.5*x
            return f;
        }

        static void Main(string[] args)
        {
            Console.WriteLine("7 лабораторная по численным методам");
            Vector<double> X = DenseVector.Build.Random(2);
            Vector<double> Xlast;
            Matrix<double> W = DenseMatrix.Create(X.Count, X.Count, 0);
            Console.WriteLine($"X0 = [{string.Join(",", X)}]");
            Vector<double> dX = DenseVector.Build.Random(2);
            double Dx = double.MaxValue;
            while (Dx > 1e-10) { // пока не достигнем точности 1e-10
                Xlast = X;
                W = dF(X); // расчет якобиана
                X -= W.Inverse() * F(Xlast);  // X(i+1) = Xi - W^(-1)(Xi)*F(Xi)
                dX = X - Xlast; // вычисляем точность
                Dx = dX.SumMagnitudes(); // суммируем абсолютные значения вектора
            }
            Console.WriteLine($"X = {X}");
            Console.WriteLine($"F(x) = {F(X)}");
            Console.ReadKey();
        }
    }
}
// https://algowiki-project.org/ru/%D0%9C%D0%B5%D1%82%D0%BE%D0%B4_%D0%9D%D1%8C%D1%8E%D1%82%D0%BE%D0%BD%D0%B0_%D0%B4%D0%BB%D1%8F_%D1%81%D0%B8%D1%81%D1%82%D0%B5%D0%BC_%D0%BD%D0%B5%D0%BB%D0%B8%D0%BD%D0%B5%D0%B9%D0%BD%D1%8B%D1%85_%D1%83%D1%80%D0%B0%D0%B2%D0%BD%D0%B5%D0%BD%D0%B8%D0%B9