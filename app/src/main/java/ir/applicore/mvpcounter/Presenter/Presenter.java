package ir.applicore.mvpcounter.Presenter;

import android.view.View;

import ir.applicore.mvpcounter.Contract.Contract;
import ir.applicore.mvpcounter.Model.Model;

public class Presenter implements Contract.Presenter {
    private Contract.View view;
    private Model model = new Model();

    @Override
    public void onAttach(Contract.View view) {
        this.view = view;
        view.initViews();
    }

    @Override
    public void onCounterClick(android.view.View view) {
        this.view.updateViewData(model.getCount());
    }

    @Override
    public void onDetach() {
        view = null;
    }
}
