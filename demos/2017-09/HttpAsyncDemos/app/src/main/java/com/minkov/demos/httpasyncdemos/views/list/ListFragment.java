package com.minkov.demos.httpasyncdemos.views.list;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;
import com.minkov.demos.httpasyncdemos.R;
import com.minkov.demos.httpasyncdemos.models.Person;
import com.minkov.demos.httpasyncdemos.views.utils.FragmentUtils;

public class ListFragment extends Fragment implements ListContracts.View<ListContracts.Presenter>, View.OnClickListener, AdapterView.OnItemClickListener, FragmentUtils.LoadingView {
  private ListContracts.Presenter mPresenter;

  private Button mBtnAdd;

  private ListView mListViewPeople;
  private ArrayAdapter<Person> mListAdapeter;

  // Modals
  private NiftyDialogBuilder mDialogBuilder;
  private EditText mEditTextName;
  private EditText mEditTextAge;
  private Button mBtnCancel;
  private Button mBtnSave;

  @Override
  public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_list, container, false);

    mBtnAdd = root.findViewById(R.id.btn_add);
    mBtnAdd.setOnClickListener(this);

    mListViewPeople = root.findViewById(R.id.lv_people);
    mListViewPeople.setOnItemClickListener(this);
    mListAdapeter = new ArrayAdapter<Person>(getContext(), android.R.layout.simple_list_item_1) {
      @NonNull
      @Override
      public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView view = null;
        if (convertView == null || !(convertView instanceof TextView)) {
          LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          view = (TextView) layoutInflater.inflate(android.R.layout.simple_list_item_1, null);
        } else {
          view = (TextView) convertView;
        }
        view.setText(getItem(position).getName());

        return view;
      }
    };

    mListViewPeople.setAdapter(mListAdapeter);

    setupDialog();

    return root;
  }

  private void setupDialog() {
    mDialogBuilder = NiftyDialogBuilder.getInstance(getContext());
    mDialogBuilder
            .withTitle("Add Person")
            .withTitleColor("#000000")
            .withDividerColor("#11000000")
            .withDialogColor("#ffffff")
            .withDuration(700)
            .withEffect(Effectstype.Slidetop)
            .isCancelableOnTouchOutside(true)
            .setCustomView(R.layout.modal_add_person, getContext());

    mEditTextName = mDialogBuilder.findViewById(R.id.et_name);
    mEditTextAge = mDialogBuilder.findViewById(R.id.et_age);

    mBtnSave = mDialogBuilder.findViewById(R.id.btn_save);
    mBtnCancel = mDialogBuilder.findViewById(R.id.btn_cancel);

    mBtnSave.setOnClickListener(this);
    mBtnCancel.setOnClickListener(this);
  }

  @Override
  public void setPresenter(ListContracts.Presenter presenter) {
    mPresenter = presenter;
    mPresenter.setView(this);
  }

  @Override
  public void update(final Person[] people) {
    getActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        mListAdapeter.clear();
        mListAdapeter.addAll(people);
      }
    });
  }

  @Override
  public void onResume() {
    mPresenter.load();

    super.onResume();
  }

  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.btn_add:
        mDialogBuilder.show();
        break;
      case R.id.btn_save:
        String name = mEditTextName.getText().toString();
        String ageString = mEditTextAge.getText().toString();
        int age = Integer.parseInt(ageString);
        mPresenter.save(name, age);
      case R.id.btn_cancel:
        mDialogBuilder.hide();
        break;
    }
  }

  @Override
  public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT)
            .show();
  }

//  void showLoading2() {
//    FragmentUtils.showLoading(this);
//  }

  @Override
  public View getContentContainer() {
    return getView().findViewById(R.id.container_content);
  }

  @Override
  public ViewGroup getLoadingContainer() {
    return getView().findViewById(R.id.container_loading);
  }

  @Override
  public void showLoading() {
    getActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        FragmentUtils.showLoading(ListFragment.this);
      }
    });
  }

  @Override
  public void hideLoading() {
    getActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        FragmentUtils.hideLoading(ListFragment.this);
      }
    });
  }
}
