package com.bawei.volleystudio.loginmvp;

public interface LoginConstract {
    //ILoginView
    interface ILoginView{
            void getPreData(String data);
    }

    //ILoginModel
    interface ILoginModel{
        void getPre();

    }

    //ILoginPresenter
    interface ILoginPresenter{

    }
}
