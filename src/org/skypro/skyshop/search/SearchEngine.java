package org.skypro.skyshop.search;

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
}

