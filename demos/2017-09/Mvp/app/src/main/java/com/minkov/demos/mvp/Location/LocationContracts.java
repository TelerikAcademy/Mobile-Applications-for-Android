package com.minkov.demos.mvp.Location;

import com.minkov.demos.mvp.base.BaseContracts;
import com.minkov.demos.mvp.providers.LocationProvider;

/**
 * Created by doncho on 10/5/17.
 */

public interface LocationContracts {
    public interface View extends BaseContracts.View<Presenter> {

        void showLocation(LocationProvider.Location location);
    }

    public interface Presenter extends BaseContracts.Presenter<View> {

    }
}
