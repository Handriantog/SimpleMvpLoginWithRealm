package id.handriantog.latihandepe1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.handriantog.latihandepe1.mvp.login.ContractLogin;
import id.handriantog.latihandepe1.mvp.login.InteractorLogin;
import id.handriantog.latihandepe1.mvp.login.PresenterLogin;

public class MainActivity extends AppCompatActivity implements ContractLogin.View{

    //region Binding
    @BindView(R.id.etEmail)
    EditText etEmail;

    @BindView(R.id.etPassword)
    EditText etPassword;
    //endregion

    private PresenterLogin presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupPresenter();
    }

    private void setupPresenter(){
        InteractorLogin interactor = new InteractorLogin();
        presenter = new PresenterLogin(this, interactor);
    }

    @OnClick(R.id.btnLogin)
    public void loginUser(View view){
        presenter.loginUser(etEmail.getText().toString(), etPassword.getText().toString());
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, HomeActivity.class));
    }

    @Override
    public void loginFailed() {
        Toast.makeText(this, "Login Gagal", Toast.LENGTH_SHORT).show();
    }
}
