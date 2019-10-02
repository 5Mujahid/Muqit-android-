package com.example.muqitt.Interface;

import com.example.muqitt.Model.Login.User;

/**
 * Created by Gohar Ali on 12/24/2017.
 */

public interface OnSignupLoginListener  {
    void onSignup(User data);
    void onLoginUser(User data);
    void OnError(String error);
}
