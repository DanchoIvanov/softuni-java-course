package core;

import models.Doodle;

import java.util.*;
import java.util.stream.Collectors;

public class DoodleSearchImpl implements DoodleSearch {
    LinkedHashMap<String, Doodle> doodlesByIDOrdered = new LinkedHashMap<>();
    Set<Doodle> doodleAds = new LinkedHashSet<>();
    HashMap<String, Doodle> doodlesByTitle = new LinkedHashMap<>();

    Comparator<Doodle> orderByRevenueDescVisitsDesc = (t, o) -> {
        int cmp = Double.compare(o.getRevenue(), t.getRevenue());
        if (cmp == 0) {
            cmp = Integer.compare(o.getVisits(), t.getVisits());
        }
        return cmp;
    };


    @Override
    public void addDoodle(Doodle doodle) {
        //void addDoodle(Doodle doodle) – adds a Doodle to the DoodleSearch. NOTE: Doodle titles are unique.

        doodlesByIDOrdered.putIfAbsent(doodle.getId(), doodle);

        if (doodle.getIsAd()) {
            doodleAds.add(doodle);
        }

        doodlesByTitle.putIfAbsent(doodle.getTitle(), doodle);
    }

    @Override
    public void removeDoodle(String doodleId) {
        //void removeDoodle(String doodleId) – removes the doodle with the given id from the DoodleSearch.
        //If there is no such doodle - throw IllegalArgumentException()

        Doodle toRemove = doodlesByIDOrdered.remove(doodleId);

        if (toRemove == null) {
            throw new IllegalArgumentException();
        }

        if (toRemove.getIsAd()) {
            doodleAds.remove(toRemove);
        }

        doodlesByTitle.remove(toRemove.getTitle());
    }

    @Override
    public int size() {
        //●	int size() – returns the total count of all doodles.
        return doodlesByIDOrdered.size();
    }

    @Override
    public boolean contains(Doodle doodle) {
        //●	bool contains(Doodle doodle) – returns whether the doodle is contained inside the DoodleSearch.
        return doodlesByIDOrdered.containsKey(doodle.getId());
    }

    @Override
    public Doodle getDoodle(String id) {
        //●	Doodle getDoodle(String doodleId) – returns the doodle with the given id.
        //If there is no such doodle - throw IllegalArgumentException().

        Doodle result = doodlesByIDOrdered.get(id);

        if (result == null) {
            throw new IllegalArgumentException();
        }

        return result;
    }

    @Override
    public double getTotalRevenueFromDoodleAds() {
        //●	double getTotalRevenueFromDoodleAds() – returns the total revenue from all Doodles that are ads.
        //The total revenue is calculated by multiplying the visits by the revenue for each ad Doodle (visits * revenue).
        //You need to calculate that for all Doodles that ARE ADS, then you need to sum the values and return the result.
        double result = 0;

        for (Doodle doodle : doodleAds) {
            result += (doodle.getRevenue() * doodle.getVisits());
        }

        return result;
    }

    @Override
    public void visitDoodle(String title) {
        //●	void visitDoodle(String doodleTitle) – increases the visits of the Doodle with the given title with 1.
        //If there is no such doodle - throw IllegalArgumentException()

        Doodle doodle = this.doodlesByTitle.get(title);

        if (doodlesByTitle == null) {
            throw new IllegalArgumentException();
        }

        doodle.setVisits(doodle.getVisits() + 1);
    }

    @Override
    public Iterable<Doodle> searchDoodles(String searchQuery) {
        //●	Iterable<Doodle> searchDoodles(string searchQuery) – returns all doodles that have a title,
        // which contains the search query. The results should be ordered by relevance (earliest match of the search query),
        // then by visits in descending order. but Ad Doodles should come first, regardless of relevance or visits.
        //o	NOTE: Ad Doodles should also be ordered by relevance and by visits in descending order.
        //o	If the search query is "asd" and we have titles "casd" and "ddasd", then "casd" comes first (more relevant).
        // (other example: "casd" and "basd" are equal)
        //o	If there aren’t any doodles that match the search query – return an empty collection.

        Comparator<Doodle> orderAdsFirstByRelevanceVisitsDesc = (t, o) -> {
            int cmp = 0;

            if (t.getIsAd() && !o.getIsAd()) {
                cmp = -1;
            } else if (!t.getIsAd() && o.getIsAd()) {
                cmp = 1;
            }

            if (cmp == 0) {
                if (t.getTitle().contains(searchQuery) && !o.getTitle().contains(searchQuery)) {
                    cmp = -1;
                } else if (!t.getTitle().contains(searchQuery) && o.getTitle().contains(searchQuery)) {
                    cmp = 1;
                } else {
                    cmp = t.getTitle().indexOf(searchQuery) - o.getTitle().indexOf(searchQuery);
                }
            }

            if (cmp == 0) {
                cmp = Integer.compare(o.getVisits(), t.getVisits());
            }

            return cmp;
        };

        return doodlesByIDOrdered.values()
                .stream()
                .filter(d -> d.getIsAd() || d.getTitle().contains(searchQuery))
                .sorted(orderAdsFirstByRelevanceVisitsDesc)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Doodle> getDoodleAds() {
        //●	Iterable<Doodle> getDoodleAds() – returns all Doodles that are Ads. The results should be ordered by revenue
        // in descending order and then by visits in descending order.
        //o	If there aren’t any doodle ads – return an empty collection.

        List<Doodle> result = new ArrayList<>(doodleAds);
        result.sort(orderByRevenueDescVisitsDesc);
        return result;
    }

    @Override
    public Iterable<Doodle> getTop3DoodlesByRevenueThenByVisits() {
        //●	Iterable<Doodle> getTop3DoodlesByRevenueThenByVisits() – returns the top 3 of the Doodles in terms of revenue
        // in descending order, then by visits in descending order. If there aren’t any doodles – return an empty collection

        List<Doodle> result = new ArrayList<>(doodlesByIDOrdered.values());
        result.sort(orderByRevenueDescVisitsDesc);
        if (result.size() > 3) {
            result = result.subList(0, 3);
        }
        return result;
    }

    //NOTE: If all sorting criteria fails, you should order by order of input. This is for all methods with ordered output.
}
