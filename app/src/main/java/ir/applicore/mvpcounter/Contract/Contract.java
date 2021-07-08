package ir.applicore.mvpcounter.Contract;

public interface Contract {
    interface View {
        void initViews();

        void updateViewData(String data);

    }

    interface Presenter {

        void onAttach(Contract.View view);
        void onCounterClick(android.view.View view);
        void onDetach();
    }
}
