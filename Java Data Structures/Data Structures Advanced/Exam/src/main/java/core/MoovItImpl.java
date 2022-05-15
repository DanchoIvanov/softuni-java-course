package core;

import models.Route;

import java.util.*;

public class MoovItImpl implements MoovIt {
    Set<Route> routes = new LinkedHashSet<>();
    Map<String, Route> routesByID = new HashMap<>();
    Set<Route> favoriteRoutes = new LinkedHashSet<>();

    @Override
    public void addRoute(Route route) {
        //●	void addRoute(Route route) – adds a Route to MoovIt.
        //If route already exists - throw IllegalArgumentException()

        if (routes.contains(route)) {
            throw new IllegalArgumentException();
        }

        routes.add(route);
        routesByID.put(route.getId(), route);

        if (route.getIsFavorite()) {
            favoriteRoutes.add(route);
        }

    }

    @Override
    public void removeRoute(String routeId) {
        //●	void removeRoute(String routeId) – removes the route with the given id from MoovIt.
        //If there is no such route - throw IllegalArgumentException()

        Route toRemove = routesByID.remove(routeId);

        if (toRemove == null) {
            throw new IllegalArgumentException();
        }

        routes.remove(toRemove);

        if (toRemove.getIsFavorite()) {
            favoriteRoutes.add(toRemove);
        }
    }

    @Override
    public boolean contains(Route route) {
        //●	bool contains(Route route) – returns whether the route is contained inside MoovIt
        return routes.contains(route);
    }

    @Override
    public int size() {
        //●	int size() – returns the total count of all routes.
        return routes.size();
    }

    @Override
    public Route getRoute(String routeId) {
        //●	Route getRoute(String routeId) – returns the route with the given id.
        //If there is no such route - throw IllegalArgumentException()

        Route result = routesByID.get(routeId);

        if (result == null) {
            throw new IllegalArgumentException();
        }

        return result;
    }

    @Override
    public void chooseRoute(String routeId) {
        //●	void chooseRoute(String routeId) – increases the popularity of the Route with the given id with 1.
        //If there is no such route - throw IllegalArgumentException()

        Route chosenRoute = this.getRoute(routeId);
        chosenRoute.setPopularity(chosenRoute.getPopularity() + 1);
    }

    @Override
    public Iterable<Route> searchRoutes(String startPoint, String endPoint) {
        //●	Iterable<Route> searchRoutes(String startPoint, String endPoint) – returns all routes that have a logical route,
        // which contains the starting point and the end point.
        // The results should be ordered by distance between the 2 points (lowest count of points between them),
        // then by popularity in descending order. but Favourity Routes should come first,
        // regardless of distance or popularity.
        //o	NOTE: Favourity Routes should also be ordered by distance and by popularity in descending order.
        //o	Explanation: If the given points are Sofia (start) and Plovdiv (end) and we have the following routes:
        //▪	Route 1 – LocationPoints (Vraca -> Sofia -> Ihtiman -> Pazardzhik -> Plovdiv)
        //▪	Route 2 – LocationPoints (Pleven -> Sofia -> Pazardzhik -> Plovdiv)
        //▪	Route 3 – LocationPoints (Belgrade -> Sofia -> Plovdiv)
        //▪	The order by distance would be Route 3 -> Route 2 -> Route 1, because the number of locations between the desired ones is lowest at Route 3.
        //o	If there aren’t any routes that match the search points – return an empty collection.

        List<Route> result = new ArrayList<>();
        Map<Route, Integer> distanceBetweenPoints = new HashMap<>();

        for (Route route : routes) {
            if (containsDestinationPointsInLogicalOrder(route, startPoint, endPoint, distanceBetweenPoints)) {
                result.add(route);
            }
        }

        Comparator<Route> orderByFavouritesFirstDistanceBetweenTwoPointsAscPopularityDesc = (t, o) -> {
            int cmp = 0;

            if(t.getIsFavorite() && !o.getIsFavorite()) {
                cmp = -1;
            } else if (!t.getIsFavorite() && o.getIsFavorite()){
                cmp = 1;
            }

            if (cmp == 0) {
                cmp = Integer.compare(distanceBetweenPoints.get(t), distanceBetweenPoints.get(o));
            }

            if (cmp == 0) {
                cmp = Integer.compare(o.getPopularity(), t.getPopularity());
            }

            return cmp;
        };

        result.sort(orderByFavouritesFirstDistanceBetweenTwoPointsAscPopularityDesc);

        return result;
    }

    private boolean containsDestinationPointsInLogicalOrder(Route route, String startPoint, String endPoint, Map<Route, Integer> distanceBetweenPoints) {
        List<String> locations = route.getLocationPoints();
        int indexStartPoint = locations.indexOf(startPoint);

        if (indexStartPoint == -1) {
            return false;
        }

        int indexEndPoint = locations.indexOf(endPoint);

        if (indexEndPoint == -1) {
            return false;
        }

        int distance = indexEndPoint - indexStartPoint;

        if (distance < 1) {
            return false;
        }

        distanceBetweenPoints.put(route, distance);

        return true;
    }

    @Override
    public Iterable<Route> getFavoriteRoutes(String destinationPoint) {
        //●	Iterable<Route> getFavoriteRoutes(String destinationPoint) –
        // returns all Routes that are Favorite and contain the given destinationPoint as a non-starting point (not first index).
        // The results should be ordered by distance in ascending order and then by popularity in descending order.
        //o	If there aren’t any favorite routes – return an empty collection.

        Comparator<Route> orderByDistanceAscPopularityDesc = (t, o) -> {
            int cmp = Double.compare(t.getDistance(), o.getDistance());
            if (cmp == 0) {
                cmp = Integer.compare(o.getPopularity(), t.getPopularity());
            }
            return cmp;
        };

        List<Route> result = new ArrayList<>();

        for (Route route : favoriteRoutes) {
            List<String> locations = route.getLocationPoints();
            if (locations.size() > 1) {
                for (int i = 1; i < locations.size(); i++) {
                    if (locations.get(i).equals(destinationPoint)) {
                        result.add(route);
                        break;
                    }
                }
            }
        }

        result.sort(orderByDistanceAscPopularityDesc);

        return result;
    }

    @Override
    public Iterable<Route> getTop5RoutesByPopularityThenByDistanceThenByCountOfLocationPoints() {
        //●	Iterable<Route> getTop5RoutesByPopularityThenByDistanceThenByCountOfLocationPoints() –
        // returns the top 5 of the Routes in terms of popularity in descending order,
        // then by Distance in ascending order and then by count of location points in ascending order.
        // If there aren’t any routes – return an empty collection.

        Comparator<Route> orderByPopularityDescDistanceAscCountOfLocationPointsAsc = (t, o) -> {
            int cmp = Integer.compare(o.getPopularity(), t.getPopularity());
            if (cmp == 0) {
                cmp = Double.compare(t.getDistance(), o.getDistance());
            }
            if (cmp == 0) {
                cmp = Integer.compare(t.getLocationPoints().size(), o.getLocationPoints().size());
            }
            return cmp;
        };

        List<Route> result = new ArrayList<>(routes);
        result.sort(orderByPopularityDescDistanceAscCountOfLocationPointsAsc);

        if (result.size() > 5) {
            result = result.subList(0, 5);
        }

        return result;
    }
}
