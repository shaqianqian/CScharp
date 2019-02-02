using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace CS.Impl._03_Linq
{
    public class Linq
    {
        public IEnumerable<string> FindStringsWhichStartsAndEndsWithSpecificCharacter(string startCharacter, string endCharacter, IEnumerable<string> strings)
        {
           return from s in strings where s.StartsWith(startCharacter) && s.EndsWith(endCharacter) select s;
       
        }

        public IEnumerable<int> GetGreaterNumbers(int limit, IEnumerable<int> numbers)
        {
            return from n in numbers where n > limit select n;
        }

        public IEnumerable<int> GetTopNRecords(int limit, IEnumerable<int> numbers)
        {
         var newNumbers=from n in numbers orderby n descending select n;
            return newNumbers.Take(3);
            
        }

        public IDictionary<string, int> GetFileCountByExtension(IEnumerable<string> files)
        {

            var myfiles = from f in files group f by f.Split(".")[1].ToLower();
            return myfiles.ToDictionary(m => m.Key, m => m.Count());
        }

        public IEnumerable<Tuple<string, string, int, double>> GetFinalReceipe(List<Item> items, List<Client> clients, List<Purchase> purchases)
        {
             List<Tuple<string, string, int, double>> result = new List<Tuple<string, string, int, double>>();
            return (from q in purchases join i in items on q.ItemId equals i.Id join c in clients on q.ClientId equals c.Id select new Tuple<string, string, int, double>( c.Name, i.Label, q.Quantity,i.Price)).ToList();

        }
    }

    public class Item
    {
        public int Id { get; set; }
        public string Label { get; set; }
        public double Price { get; set; }
    }

    public class Purchase
    {
        public int ItemId { get; set; }
        public int Quantity { get; set; }
        public int ClientId { get; set; }
    }

    public class Client
    {
        public int Id { get; set; }
        public string Name { get; set; }
    }
}
