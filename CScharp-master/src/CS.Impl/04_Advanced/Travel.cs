using System;
using System.Collections.Generic;

namespace CS.Impl._04_Advanced
{
    public class Travel
    {
        public TravelRoadmap BuildTravelRoadmap(City initial, City destination)
        {
            TravelRoadmap travelRoadmap=new TravelRoadmap(initial, destination);
            List<TransportMode> Modes = new List<TransportMode>();
            DistanceHelper distanceHelper = new DistanceHelper();

            if (distanceHelper.GetDistance(initial, destination).Equals(Distance.Short))
            {
                Modes.Add(TransportMode.Foot);
                Modes.Add(TransportMode.Car);
                Modes.Add(TransportMode.Train);
                travelRoadmap.Modes = Modes;
            }
            else if(distanceHelper.GetDistance(initial, destination).Equals(Distance.Medium))
            {
                Modes.Add(TransportMode.Plane);
                Modes.Add(TransportMode.Car);
                Modes.Add(TransportMode.Train);
                travelRoadmap.Modes = Modes;

            }
            else {
                Modes.Add(TransportMode.Boat);
                Modes.Add(TransportMode.Plane);
                travelRoadmap.Modes = Modes;

            }

            return travelRoadmap;
        }
    }

    public class TravelRoadmap
    {
        public IEnumerable<TransportMode> Modes { get; set; }
        public City initial { get; set; }
        public City destination { get; set; }

        public TravelRoadmap(City initial, City destination)
        {
            this.initial = initial;
            this.destination = destination;
        }

    }

    public enum City
    {
        Barcelona,
        London,
        Sydney
    }

    public enum TransportMode
    {
        Foot,
        Car,
        Train,
        Boat,
        Plane
    }

    public class DistanceHelper
    {
        public Distance GetDistance(City initial, City destination)
        {
            if (initial.Equals(destination)) {
                return Distance.Short;
            }
            else if (!initial.Equals(City.Sydney) && !destination.Equals(City.Sydney))
            {
                return Distance.Medium;

            }
            else
            {
                return Distance.Long;

            }

        }
    }

    public enum Distance
    {
        Short,
        Medium,
        Long
    }
}