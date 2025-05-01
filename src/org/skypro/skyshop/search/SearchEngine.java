package org.skypro.skyshop.search;

import org.skypro.skyshop.product.BestResultNotFound;

import java.util.List;

public class SearchEngine {
    private  Searchable[] searchables;
    private int size = 0;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
    }

    public void add(Searchable searchable) {
        if (size < searchables.length) {
            searchables[size++] = searchable;
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultIndex = 0;

        for (int i = 0; i < size; i++) {
            if (searchables[i].getSearchTerm().contains(query)) {
                results[resultIndex++] = searchables[i];
                if (resultIndex == 5) break;
            }
        }
        return results;
    }
    public Searchable findBestMatch(String search, List<Searchable> items) throws BestResultNotFound {
        int maxCount = 0;
        Searchable bestMatch = null;

        for (Searchable item : items) {
            int count = countOccurrences(item.getSearchTerm(), search);
            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено подходящих результатов для запроса '" + search + "'");
        }

        return bestMatch;
    }

    private int countOccurrences(String text, String search) {
        int count = 0;
        int index = 0;

        while ((index = text.indexOf(search, index)) != -1) {
            count++;
            index += search.length();
        }

        return count;
    }
}


