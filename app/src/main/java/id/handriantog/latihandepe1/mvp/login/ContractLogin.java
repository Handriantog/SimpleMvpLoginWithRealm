package id.handriantog.latihandepe1.mvp.login;

/**
 * Define all interface from view, presenter, and interactor
 */
public interface ContractLogin {

    interface View{

        void loginSuccess();

        void loginFailed();

    }

    interface Presenter{

        void resetPassword(String email);

        void registerUser(String nama, String email, String password);

        void loginUser(String email, String password);

    }

    interface Callback{

        void loginResult(String result);

        void resetResult(String result);

        void registerResult(String result);

    }

    interface Interactor{

        void reset(String email, Callback resetCallback);

        void register(String name, String email, String password, Callback registerCallback);

        void login(String email, String password, Callback loginCallback);

    }

}
