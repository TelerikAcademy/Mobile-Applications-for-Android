package com.minkov.demos.mvp.PersonsLists;

import com.minkov.demos.mvp.models.Person;

import java.util.List;

public class PersonsListViewState implements PersonsListContracts.ViewState {
    private List<Person> mPersons;
    private boolean hHasCache;

    @Override
    public void setPersons(List<Person> persons) {
        mPersons = persons;
    }

    @Override
    public List<Person> getPersons() {
        return mPersons;
    }

    @Override
    public void setHasCache(boolean hasCache) {
        hHasCache = hasCache;
    }

    @Override
    public boolean getHasCache() {
        return hHasCache;
    }
}
