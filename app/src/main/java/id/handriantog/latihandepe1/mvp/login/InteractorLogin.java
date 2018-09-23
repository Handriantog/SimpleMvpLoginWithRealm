package id.handriantog.latihandepe1.mvp.login;

/**
 * todo FILE FOR
 */
public class InteractorLogin implements ContractLogin.Interactor{

    @Override
    public void login(String email, String password, ContractLogin.Callback loginCallback) {

        if(email.equals("admin")&&password.equals("pass")){
            loginCallback.loginResult("success");
        }else{
            loginCallback.loginResult("failed");
        }
    }

    @Override
    public void reset(String email, ContractLogin.Callback resetCallback) {
        resetCallback.resetResult("");
    }

    @Override
    public void register(String name, String email, String password, ContractLogin.Callback registerCallback) {
        registerCallback.registerResult("");
    }
}
