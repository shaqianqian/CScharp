using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebApplication1.Models
{
    using System;

    namespace MvcMovie.Models
    {
        public class Movie
        {
            public int ID { get; set; }
            public string Title { get; set; }
            public string Genre { get; set; }
            public decimal Price { get; set; }
            public Movie(int id, string title,string genre, decimal price) {
                ID = id;
                Title = title;
                Genre = genre;
                Price = price;

            }
            public Movie()
            {
           

            }
        }
    }
 
}