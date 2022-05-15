import java.util.*;


public class RoyaleArena implements IArena {

    private Comparator<Battlecard> comparatorBySwagDesc = ((t, o) -> {
        int cmp = Double.compare(o.getSwag(), t.getSwag());
        if (cmp == 0) {
            cmp = Integer.compare(t.getId(), o.getId());
        }
        return cmp;
    });

    private Comparator<Battlecard> comparatorBySwagAsc = (Comparator.comparingDouble(Battlecard::getSwag).thenComparingInt(Battlecard::getId));


    private Map<Integer, Battlecard> arena = new LinkedHashMap<>();
    private Map<CardType, Set<Battlecard>> arenaByType = new HashMap<>();
    private Map<String, Set<Battlecard>> arenaByName = new HashMap<>();
    private Set<Battlecard> arenaBySwagDesc = new TreeSet<>(comparatorBySwagDesc);
    private Set<Battlecard> arenaBySwagAsc = new TreeSet<>(comparatorBySwagAsc);


    @Override
    public void add(Battlecard card) {
        if (this.contains(card)) {
            return;
        }

        this.arena.put(card.getId(), card);

        this.arenaByType.putIfAbsent(card.getType(), new TreeSet<>(Battlecard::compareTo));
        this.arenaByType.get(card.getType()).add(card);

        this.arenaByName.putIfAbsent(card.getName(), new TreeSet<>(comparatorBySwagDesc));
        this.arenaByName.get(card.getName()).add(card);

        this.arenaBySwagDesc.add(card);
        this.arenaBySwagAsc.add(card);
    }

    @Override
    public boolean contains(Battlecard card) {
        return arena.containsKey(card.getId());
    }

    @Override
    public int count() {
        return arena.size();
    }

    @Override
    public void changeCardType(int id, CardType type) {
        Battlecard card = this.arena.get(id);

        if (card == null) {
            throw new IllegalArgumentException();
        }

        card.setType(type);
    }

    @Override
    public Battlecard getById(int id) {
        Battlecard card = this.arena.get(id);

        if (card == null) {
            throw new UnsupportedOperationException();
        }

        return card;
    }

    @Override
    public void removeById(int id) {
        Battlecard card = this.arena.remove(id);;

        if (card == null) {
            throw new UnsupportedOperationException();
        }

        this.arenaByType.get(card.getType()).remove(card);
        this.arenaByName.get(card.getName()).remove(card);
        this.arenaBySwagDesc.remove(card);
        this.arenaBySwagAsc.remove(card);
    }

    @Override
    public Iterable<Battlecard> getByCardType(CardType type) {
        Set<Battlecard> cardsByType = this.arenaByType.get(type);

        if (cardsByType == null) {
            throw new UnsupportedOperationException();
        }

        return cardsByType;
    }

    @Override
    public Iterable<Battlecard> getByTypeAndDamageRangeOrderedByDamageThenById(CardType type, int lo, int hi) {
        Iterable<Battlecard> cardsByType = this.getByCardType(type);

        List<Battlecard> result = new ArrayList<>();

        for (Battlecard battlecard : cardsByType) {
            if (battlecard.getDamage() <= lo) {
                break;
            }
            if (battlecard.getDamage() < hi) {
                result.add(battlecard);
            }
        }

        return result;
    }

    @Override
    public Iterable<Battlecard> getByCardTypeAndMaximumDamage(CardType type, double damage) {
        List<Battlecard> cardsByType = (List<Battlecard>) this.getByCardType(type);

        List<Battlecard> result = new ArrayList<>();

        for (Battlecard battlecard : cardsByType) {
            if (battlecard.getDamage() <= damage) {
                result.add(battlecard);
            }
        }

        if (result.isEmpty()) {
            throw new UnsupportedOperationException();
        }

        return result;
    }

    @Override
    public Iterable<Battlecard> getByNameOrderedBySwagDescending(String name) {
        Set<Battlecard> cardsByName = this.arenaByName.get(name);

        if (cardsByName == null) {
            throw new UnsupportedOperationException();
        }

        return cardsByName;
    }

    @Override
    public Iterable<Battlecard> getByNameAndSwagRange(String name, double lo, double hi) {
        Iterable<Battlecard> cardsByName = this.getByNameOrderedBySwagDescending(name);

        Set<Battlecard> result = new TreeSet<>(comparatorBySwagDesc);

        for (Battlecard battlecard : cardsByName) {
            if (battlecard.getSwag() < lo) {
                break;
            }
            if (battlecard.getSwag() < hi) {
                result.add(battlecard);
            }
        }

        if (result.isEmpty()) {
            throw new UnsupportedOperationException();
        }

        return result;
    }

    @Override
    public Iterable<Battlecard> getAllByNameAndSwag() {
        List<Battlecard> result = new ArrayList<>();

        for (String name : arenaByName.keySet()) {
            Iterable<Battlecard> cardsByName = this.getByNameOrderedBySwagDescending(name);
            for (Battlecard battlecard : cardsByName) {
                result.add(battlecard);
                break;
            }
        }

        return result;
    }

    @Override
    public Iterable<Battlecard> findFirstLeastSwag(int n) {
        if (n > arenaBySwagAsc.size()) {
            throw new UnsupportedOperationException();
        }

        List<Battlecard> result = new ArrayList<>();

        for (Battlecard battlecard : arenaBySwagAsc) {
            if (n == 0) {
                break;
            }

            result.add(battlecard);
            n--;
        }

        return result;
    }

    @Override
    public Iterable<Battlecard> getAllInSwagRange(double lo, double hi) {
        List<Battlecard> result = new ArrayList<>();

        for (Battlecard battlecard : arenaBySwagAsc) {
            if (battlecard.getSwag() > hi) {
                break;
            }
            if (battlecard.getSwag() >= lo) {
                result.add(battlecard);
            }
        }

        return result;
    }

    @Override
    public Iterator<Battlecard> iterator() {
        Deque<Battlecard> deque = new ArrayDeque<>(arena.values());

        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return !deque.isEmpty();
            }

            @Override
            public Battlecard next() {
                return deque.poll();
            }
        };
    }
}
