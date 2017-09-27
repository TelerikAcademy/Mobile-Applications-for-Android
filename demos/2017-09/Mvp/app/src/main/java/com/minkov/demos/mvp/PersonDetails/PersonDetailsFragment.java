package com.minkov.demos.mvp.PersonDetails;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.minkov.demos.mvp.R;
import com.minkov.demos.mvp.models.Person;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonDetailsFragment extends Fragment implements PersonDetailsContacts.View {
  private PersonDetailsContacts.Presenter mPresenter;

  public PersonDetailsFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_person_details, container, false);
  }

  public static PersonDetailsFragment newInstance() {
    return new PersonDetailsFragment();
  }

  @Override
  public void setPresenter(PersonDetailsContacts.Presenter presenter) {
    mPresenter = presenter;
  }

  @Override
  public void onResume() {
    super.onResume();
    mPresenter.subscribe(this);
  }

  @Override
  public void onPause() {
    super.onPause();
    mPresenter.unsubscribe();
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    mPresenter.unsubscribe();
    mPresenter = null;
  }

  @Override
  public void setPerson(Person person) {
    Toast.makeText(getContext(), person.getName(), Toast.LENGTH_SHORT)
            .show();
  }
}
