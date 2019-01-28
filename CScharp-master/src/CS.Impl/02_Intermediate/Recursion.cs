using System;
using System.Collections.Generic;

namespace CS.Impl._02_Intermediate
{
    public class Recursion
    {
        public IEnumerable<int> GetNaturalNumbers(int n)
        {
            List<int> list = new List<int>();
            return GetNaturalNumbers(list, 1, n);
        }

        private IEnumerable<int> GetNaturalNumbers(List<int> naturalNumbers, int current, int max)
        {
            naturalNumbers.Add(current);
            if (current == max)
                return naturalNumbers;
            else
                return GetNaturalNumbers(naturalNumbers, current + 1, max);
        }

        public int SumNaturalNumbers(int n)
        {
            if (n == 0)
                return 0;
            else
                return n + SumNaturalNumbers(n - 1);
        }

        private int ComputeSum(int min, int current)
        {
            throw new NotImplementedException();
        }

        public bool IsPrime(int n)
        {
            return IsPrime(n, 0);
        }

        private bool IsPrime(int n, int current)
        {
            if (n <= 1) return false;

            if (current == 0 || current == 1)
                return IsPrime(n, current + 1);
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
                        return IsPrime(n, current + 1);
                }
                catch (Exception)
                {
                    return false;
                }
                
            }
            
        }

        public bool IsPalindrome(string text)
        {
            if (text.Length == 1)
                return true;

            else {
                string a = text.Substring(0, 1),
                    b = text.Substring(text.Length - 1, 1);
                
                if (a == b)
                    return IsPalindrome(text.Substring(1, text.Length - 2));
                else
                    return false;
            }

        }
    }
}
