package id.handriantog.latihandepe1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadFragment extends Fragment {

    @BindView(R.id.tvEmail)
    TextView tvEmail;

    @BindView(R.id.tvId)
    TextView tvId;

    private Realm realm;

    public ReadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_read, container, false);
        ButterKnife.bind(this,view);
        readData();
        return view;
    }

    private void readData(){
        realm = Realm.getDefaultInstance();
        try{
            User user = realm.where(User.class).findFirst();
            if (user != null) {
                tvEmail.setText(user.getEmail());
                tvId.setText(user.getId());
            }else {
                Toast.makeText(getContext(), "Data tak ada", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            realm.close();
        }
    }

}
