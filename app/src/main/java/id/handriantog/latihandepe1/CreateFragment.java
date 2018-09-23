package id.handriantog.latihandepe1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreateFragment extends Fragment {

    @BindView(R.id.etInsertEmail)
    EditText etEmail;

    public CreateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btnInsert)
    public void insertData(View view){
        Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
        final String email = etEmail.getText().toString();
        final int id = 1;

        Realm realm = Realm.getDefaultInstance();
        try{

            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    User user = new User();
                    user.setId(id);
                    user.setEmail(email);
                    realm.insertOrUpdate(user);
                    Toast.makeText(getContext(), "Insert", Toast.LENGTH_SHORT).show();
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (realm != null) {
                Toast.makeText(getContext(), "Closed", Toast.LENGTH_SHORT).show();
                realm.close();
            }
        }

    }

}
