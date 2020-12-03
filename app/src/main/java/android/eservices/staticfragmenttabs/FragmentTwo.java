package android.eservices.staticfragmenttabs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

//TODO : fix this fragment so it works :)
//Once it's done, then create a second fragment with the other layout
public class FragmentTwo extends Fragment {

    public static final String TAB_NAME = "REMOVE TO COUNTER";
    private MyItf itf;
    private View view;


    public FragmentTwo() {
    //    super(R.layout.fragment_two);
    }

    public static FragmentTwo newInstance() {
        return new FragmentTwo();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_two, container, false);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        setListener();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.itf = (MyItf) context;
    }

    //TODO add listener to button and transmit the information to parent Activity
    //TODO read the Android doc, as suggested, to do it the right way

    private void setListener() {
        Button button = view.findViewById(R.id.button_decrement);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itf.decrementCounter();
            }
        });
    }
}
