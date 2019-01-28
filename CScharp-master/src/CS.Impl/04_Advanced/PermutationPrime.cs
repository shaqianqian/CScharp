using System;
using System.Collections.Generic;
using System.Linq;

namespace CS.Impl._04_Advanced
{
    public class PermutationPrime
    {
        public int[] GetPermutationPrimes(int upperBound)
        {
            List<int> res = new List<int>();
            for (int i = 0; i < upperBound; i++) {

                if(this.IsPrimes(i)&&i<100)
                {
                    if (this.IsPrimes(this.Reverse(i)))
                    { if (!res.Contains(i)) 
                    {
                            Console.WriteLine(i);
                     res.Add(i); 
                    } }      
                }
                else if (this.IsPrimes(i) && i >= 100) { 
                
                
                
                
                }

            }
      

            int[] result = res.ToArray();
       
          
            return result;


        }



        public int  Reverse(int x)
        {
            int m = 0;
            while (x > 0)
            {
                m = m * 10 + x % 10;
                x = x / 10;
            }
            return m;
        }

        public bool IsPrimes(int n)
        {
            return IsPrimes(n, 0);
        }

        private bool IsPrimes(int n, int current)
        {
            if (n < 2) return false;

            if (current == 0 || current == 1)
                return IsPrimes(n, current + 1);
            else if (current == n)
                return true;

            else
            {
                try
                {
                    double a = n % current;
                    if (a == 0)
                        return false;
                    else
                        return IsPrimes(n, current + 1);
                }
                catch (Exception)
                {
                    return false;
                }

            }

        }











    }
}
