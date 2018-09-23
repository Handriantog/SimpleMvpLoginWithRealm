package id.handriantog.latihandepe1.mvp.login;

/**
 * todo FILE FOR
 */
public class PresenterLogin implements ContractLogin.Presenter, ContractLogin.Callback{

    private ContractLogin.View view;
    private ContractLogin.Interactor interactor;

    public PresenterLogin(ContractLogin.View view, ContractLogin.Interactor interactor){
        this.view = view;
        this.interactor = interactor;
    }

    //region Presenter
    @Override
    public void loginUser(String email, String password) {
        interactor.login(email,password,this);
    }

    @Override
    public void resetPassword(String email) {

    }

    @Override
    public void registerUser(String nama, String email, String password) {

    }
    //endregion

    //region Callback
    @Override
    public void resetResult(String result) {

    }

    @Override
    public void registerResult(String result) {

    }

    @Override
    public void loginResult(String result) {
        if(result.equals("success")){
            view.loginSuccess();
        }else if(result.equals("failed")){
            view.loginFailed();
        }
    }
    //endregion
}
