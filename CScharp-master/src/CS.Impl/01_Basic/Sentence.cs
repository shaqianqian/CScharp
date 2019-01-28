using System;

namespace CS.Impl._01_Basic
{
    public class Sentence
    {
        public string Reverse(string sentence)
        {
            Array a = sentence.Split(" ");
            String s = "";

            for (int i = a.Length - 1; i > 0; i -= 1)
                s += a.GetValue(i) + " ";
            s += a.GetValue(0);
            return s;
        }
    }
}
