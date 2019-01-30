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
        public ActionResult Index(string movieGenre, string searchString)
        {
            var GenreLst = new List<string>();
            foreach (Movie m in movies)
            {
                GenreLst.Add(m.Genre);
            }

            ViewBag.movieGenre = new SelectList(GenreLst.Distinct());
              var list = movies.ToList();
        
            if (!String.IsNullOrEmpty(searchString))
            {
               list = movies.Where(s => s.Title.Contains(searchString)).ToList();
             
            }
            var list1 = list;
            if (!String.IsNullOrEmpty(movieGenre))
            {
                list1 = list.Where(x => x.Genre.Contains(movieGenre)).ToList();
            }

            return View(list1);
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

        // GET: Movie/Creer
        public ActionResult Creer()
        {



            return View();
        }

        // POST: /Movies/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]

        public ActionResult Creer([Bind(Include = "ID,Title,Genre,Price")] Movie movie)
        {
            List<Movie> list = movies.ToList();
            list.Add(movie);
            movies = list.ToArray();

            return RedirectToAction("Index");
        }
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
