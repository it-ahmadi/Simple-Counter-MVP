package ir.applicore.mvpcounter.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ir.applicore.mvpcounter.Contract.Contract;
import ir.applicore.mvpcounter.Presenter.Presenter;
import ir.applicore.mvpcounter.R;

public class MainActivity extends AppCompatActivity implements Contract.View {
    private TextView textView;
    private Button button;
    private Contract.Presenter presenter = new Presenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter.onAttach(this);
    }

    @Override
    public void initViews() {
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onCounterClick(v);
            }
        });
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                return false;
            }
        });
    }

    @Override
    public void updateViewData(String data) {
        textView.setText(data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }
}