package couponsopsjava;

import java.util.*;


public class CouponOperation implements ICouponOperation {
    HashMap<Website, HashSet<Coupon>> websites;

    public CouponOperation() {
        websites = new HashMap<>();
    }

    public void registerSite(Website w) {
        if (websites.containsKey(w)) {
            throw new IllegalArgumentException();
        }
        websites.put(w, new HashSet<>());
    }

    public void addCoupon(Website w, Coupon c) {
        if (!websites.containsKey(w)) {
            throw new IllegalArgumentException();
        }

        if (websites.get(w).contains(c)) {
            throw new IllegalArgumentException();
        }

        websites.get(w).add(c);
    }

    public Website removeWebsite(String domain) {
        for (Website website : websites.keySet()) {
            if (website.domain.equals(domain)) {
                websites.remove(website);
                return website;
            }
        }
        throw new IllegalArgumentException();
    }

    public Coupon removeCoupon(String code) {
        for (Website website : websites.keySet()) {
            Set<Coupon> coupons = websites.get(website);
            for (Coupon coupon : coupons) {
                if (coupon.code.equals(code)) {
                    websites.get(website).remove(coupon);
                    return coupon;
                }
            }
        }
        throw new IllegalArgumentException();
    }

    public boolean exist(Website w) {
        return websites.containsKey(w);
    }

    public boolean exist(Coupon c) {
        for (Website website : websites.keySet()) {
            Set<Coupon> coupons = websites.get(website);
            if (coupons.contains(c)) {
                return true;
            }
        }
        return false;
    }

    public Collection<Website> getSites() {
        if (websites.isEmpty()) {
            return new ArrayList<>();
        }
        return websites.keySet();
    }

    public Collection<Coupon> getCouponsForWebsite(Website w) {
        if (!websites.containsKey(w)) {
            throw new IllegalArgumentException();
        }
        return websites.get(w);
    }

    public void useCoupon(Website w, Coupon c) {
        if (!websites.containsKey(w)) {
            throw new IllegalArgumentException();
        }

        if (!websites.get(w).contains(c)) {
            throw new IllegalArgumentException();
        }

        websites.get(w).remove(c);
    }

    public Collection<Coupon> getCouponsOrderedByValidityDescAndDiscountPercentageDesc() {
        List<Coupon> result = new ArrayList<>();

        for (Website website : websites.keySet()) {
            Set<Coupon> coupons = websites.get(website);
            result.addAll(coupons);
            }

        result.sort((o1, o2) -> {
            int result1 = Integer.compare(o2.validity, o1.validity);
            if (result1 == 0) {
                result1 = Integer.compare(o2.discountPercentage, o1.discountPercentage);
            }
            return result1;
        });
        return result;
    }

    public Collection<Website> getWebsitesOrderedByUserCountAndCouponsCountDesc() {

        List<Website> result = new ArrayList<>(websites.keySet());

        result.sort((o1, o2) -> {
            int result1 = Integer.compare(o1.usersCount, o2.usersCount);
            if (result1 == 0) {
                result1 = Integer.compare(websites.get(o2).size(), websites.get(o1).size());
            }
            return result1;
        });
        return result;
    }
}
