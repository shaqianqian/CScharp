using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CS.Impl._04_Advanced
{
    class CheckPrime
    {
        public List<string> arraySimpleNumb = new List<string>();
        public bool CheckNumb(int numb)
        {
            for (int i = 2; i <= Math.Sqrt(numb); i++)
            {
                if (numb % i == 0)
                {
                    return false;
                }
            }
            return true;
        }
        private void FillList(int numb)
        {
            bool simpleNumb;
            int valueMax = numb.ToString().Length;
            int valueMin;
            String maxValue = "";
            String minValue = "1";
            for (int i = 0; i < valueMax; i++)
            {
                maxValue = maxValue + "9";
                if (i != valueMax - 1)
                {
                    minValue = minValue + "0";
                }

            }

            valueMax = Convert.ToInt32(maxValue);
            valueMin = Convert.ToInt32(minValue);
            for (int i = valueMin; i < valueMax; i++)
            {
                simpleNumb = CheckNumb(i);



                if (simpleNumb)
                {
                    arraySimpleNumb.Add(i.ToString());
                }
            }
        }
        public int Factorial(int numb)
        {
            if (numb == 0)
            {
                return 1;
            }
            else
            {
                return numb * Factorial(numb - 1);
            }
        }
        public int UnicDigit(int numb)
        {
            int unic = numb.ToString().Distinct().ToArray().Length;
            return unic;
        }
        public bool Finalcheck(bool simple, int numb)
        {
            if (simple)
            {
                string primeD = "";
                string temp = "";
                string stringNumb = numb.ToString();
                int count = 0;
                bool checkDigit;
                FillList(numb);
                for (int i = 0; i < arraySimpleNumb.Count; i++)
                {
                    checkDigit = true;
                    primeD = arraySimpleNumb[i];
                    for (int j = 0; j < stringNumb.Length; j++)
                    {


                        if (arraySimpleNumb[i].ToString().Contains(stringNumb[j]))
                        {
                            temp = arraySimpleNumb[i].ToString();
                            if (temp.Length != 1)
                            {
                                arraySimpleNumb[i] = temp.Remove(temp.IndexOf(stringNumb[j]), 1);
                            }
                        }
                        else
                        {
                            checkDigit = false;
                            break;
                        }
                    }
                    if (checkDigit)
                    {
                        Console.WriteLine("  -  " + primeD + "  -  ");

                        count++;
                    }
                }

                arraySimpleNumb.Clear();
                if (stringNumb.Length != Factorial(UnicDigit(numb)) && UnicDigit(numb) != 1)
                {
                    count--;
                }
                if (count == Factorial(UnicDigit(numb)))
                {
                    return true;
                }

                return false;
            }
            else
            {
                return false;
            }

        }
    }
}