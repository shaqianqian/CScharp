using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace WebApplication1.Controllers
{
    public class HelloworldController : Controller
    {
        // GET: Helloworld
        public ActionResult Welcome(String name, int numTimes=1)
        {
            ViewBag.Name = name;
            ViewBag.Num = numTimes;
            return View();
        }
    }
}