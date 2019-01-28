using System;

namespace CS.Impl._04_Advanced
{
    public abstract class Shape
    {
        public abstract double GetArea();

        public abstract double GetPerimeter();

        public override string ToString()
        {return GetType().Name;
       
        }
    }

    public class Circle : Shape

    {
        public double r { get; set; }
        public Circle(double radius)
        {
            this.r = radius;
            
        }

        public override double GetArea()
        {
            return Math.Round(this.r * this.r * 3.14);
            
        }

        public override double GetPerimeter()
        {
            return Math.Round(2* this.r * 3.14);
        }




    }

    public class Rectangle : Shape

    {
        public double l{ get; set; }
        public double w { get; set; }

        public Rectangle(double length, double width)
        {
            this.l = length;
            this.w = width;
        }

        public override double GetArea()
        {
            return Math.Round(this.l * this.w);

        }

        public override double GetPerimeter()
        {
            return 2*(this.l + this.w);
        }
    }

    public class Square : Shape
    {
        public double s { get; set; }
        public Square(double sideLength)
        {
            this.s = sideLength;
    }

    public override double GetArea()
        {
            return Math.Round(this.s * this.s);
        }

        public override double GetPerimeter()
        {
            return 4 * this.s;
        }
    }
}