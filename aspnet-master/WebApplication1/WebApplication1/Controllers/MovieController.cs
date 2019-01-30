using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WebApplication1.Models.MvcMovie.Models;

namespace WebApplication1.Controllers
{



    public class MovieController : Controller
    {
        static Movie[] movies = { new Movie(1, "au dieu", "comedie", 12), new Movie(2, "au dieu2", "comedie", 15), new Movie
        {   ID=3,
            Title = "When Harry Met Sally",
            Genre = "Romantic Comedy",
            Price = 7.99M
        },

         new Movie
         {ID=4,
             Title = "Ghostbusters ",
             Genre = "Comedy",
             Price = 8.99M
         },

         new Movie
         {ID=5,
             Title = "Ghostbusters 2",
             Genre = "Comedy",
             Price = 9.99M
         },   new Movie
       {ID=6,
           Title = "Rio Bravo",
           Genre = "Western",
           Price = 3.99M
       } };


        // GET: Movie
        public ActionResult Index()
        {
            return View(movies.ToList());
        }

        // GET: Movie/Details/5
        public ActionResult Details(int id)
        {
            Movie detail = new Movie();
            foreach (Movie m in movies)
            {
                if (m.ID == id)
                {
                    detail = m;
                    break;
                }
            }

            return View(detail);
        }

        // GET: Movie/Create
        public ActionResult Create()
        {



            return View();
        }

        //// POST: Movie/Create
        //[HttpPost]
        //public ActionResult Create(FormCollection collection)
        //{
        //    try
        //    {
        //        // TODO: Add insert logic here

        //        return RedirectToAction("Index");
        //    }
        //    catch
        //    {
        //        return View();
        //    }
        //}

        // GET: Movie/Edit/5
        public ActionResult Edit(int id)
        {
            Movie detail = new Movie();
            foreach (Movie m in movies)
            {
                if (m.ID == id)
                {
                    detail = m;
                    break;
                }
            }

            return View(detail);
        }

        // POST: Movie/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "ID,Title,Genre,Price")] Movie movie)
        {
            Movie detail = new Movie();
            foreach (Movie m in movies)
            {
                if (m.ID == movie.ID)
                {
                    m.Price = movie.Price;
                    m.Genre = movie.Genre;
                    m.Title = movie.Title;
                    break;
                }
            }

            return View(movie);
        }

        // GET: Movie/Delete/5
        public ActionResult Delete(int id)
        {

            Movie detail = new Movie();
            foreach (Movie m in movies)
            {
                if (m.ID == id)
                {
                    detail = m;
                    break;
                }
            }

            return View(detail);
        }

        // POST: /Movies/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed([Bind(Include = "ID,Title,Genre,Price")] Movie movie)
        {

            int delete = 0;
                      
            for (int i=0;i< movies.Length; i++)
            {
                if (movies[i].ID == movie.ID
                )
                {
                    delete = i;
                    break;
                }
            }
            List<Movie> list = movies.ToList();
            list.RemoveAt(delete);
            movies=list.ToArray();

            return RedirectToAction("Index");
        }
    }
    }
