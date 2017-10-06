package com.minkov.demos.mvp.Locations;

import com.minkov.demos.mvp.apiproviders.LocationApiProvider;
import com.minkov.demos.mvp.base.BaseContracts;

/**
 * Created by minkov on 10/6/17.
 */

public interface LocationsContracts {
    public interface View extends BaseContracts.View<Presenter> {

        void showLocation(LocationApiProvider.Location location);
    }

    public interface Presenter extends BaseContracts.Presenter<View> {

    }
}
