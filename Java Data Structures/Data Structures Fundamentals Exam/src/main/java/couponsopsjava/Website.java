package couponsopsjava;

import java.util.Objects;

public class Website {

    public String domain;
    public int usersCount;

    public Website(String domain, int usersCount) {
        this.domain = domain;
        this.usersCount = usersCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Website website = (Website) o;
        return Objects.equals(domain, website.domain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(domain);
    }
}
