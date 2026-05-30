import java.util.Set;
import java.util.HashSet;
import java.util.List;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        return new HashSet(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        if (myCollection.isEmpty() || theirCollection.isEmpty())
            return false;

        Set<String> sm = myCollection.size() < theirCollection.size() ? myCollection : theirCollection;
        Set<String> bg = sm == theirCollection ? myCollection : theirCollection;

        sm.removeAll(bg);

        return sm.size() > 0;
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        Set<String> s = new HashSet<>(collections.get(0));

        for (int i = 1; i < collections.size(); i++) {
            s.retainAll(collections.get(i));

            if (s.isEmpty())
                return s;
        }

        System.out.println(s);
        return s;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> res = new HashSet();

        for (Set<String> s : collections) {
            res.addAll(s);
        }

        return res;
    }
}
