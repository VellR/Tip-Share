package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthRecentLoginRequiredException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public final class zzafg {
    private static final SparseArray<Pair<String, String>> aNG = new SparseArray<>();

    static {
        aNG.put(17000, new Pair("ERROR_INVALID_CUSTOM_TOKEN", "The custom token format is incorrect. Please check the documentation."));
        aNG.put(17002, new Pair("ERROR_CUSTOM_TOKEN_MISMATCH", "The custom token corresponds to a different audience."));
        aNG.put(17004, new Pair("ERROR_INVALID_CREDENTIAL", "The supplied auth credential is malformed or has expired."));
        aNG.put(17008, new Pair("ERROR_INVALID_EMAIL", "The email address is badly formatted."));
        aNG.put(17009, new Pair("ERROR_WRONG_PASSWORD", "The password is invalid or the user does not have a password."));
        aNG.put(17024, new Pair("ERROR_USER_MISMATCH", "The supplied credentials do not correspond to the previously signed in user."));
        aNG.put(17014, new Pair("ERROR_REQUIRES_RECENT_LOGIN", "This operation is sensitive and requires recent authentication. Log in again before retrying this request."));
        aNG.put(17012, new Pair("ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL", "An account already exists with the same email address but different sign-in credentials. Sign in using a provider associated with this email address."));
        aNG.put(17007, new Pair("ERROR_EMAIL_ALREADY_IN_USE", "The email address is already in use by another account."));
        aNG.put(17025, new Pair("ERROR_CREDENTIAL_ALREADY_IN_USE", "This credential is already associated with a different user account."));
        aNG.put(17005, new Pair("ERROR_USER_DISABLED", "The user account has been disabled by an administrator."));
        aNG.put(17021, new Pair("ERROR_USER_TOKEN_EXPIRED", "The user's credential is no longer valid. The user must sign in again."));
        aNG.put(17011, new Pair("ERROR_USER_NOT_FOUND", "There is no user record corresponding to this identifier. The user may have been deleted."));
        aNG.put(17017, new Pair("ERROR_INVALID_USER_TOKEN", "The user's credential is no longer valid. The user must sign in again."));
        aNG.put(17006, new Pair("ERROR_OPERATION_NOT_ALLOWED", "This operation is not allowed. You must enable this service in the console."));
        aNG.put(17026, new Pair("ERROR_WEAK_PASSWORD", "The given password is invalid."));
    }

    private static String zza(String str, Status status) {
        if (TextUtils.isEmpty(status.getStatusMessage())) {
            return str;
        }
        return String.format(String.valueOf(str).concat(" [ %s ]"), new Object[]{status.getStatusMessage()});
    }

    private static String zzacx(int i) {
        Pair pair = (Pair) aNG.get(i);
        return pair != null ? (String) pair.first : "INTERNAL_ERROR";
    }

    private static String zzacy(int i) {
        Pair pair = (Pair) aNG.get(i);
        return pair != null ? (String) pair.second : "An internal error happened";
    }

    public static FirebaseException zzes(Status status) {
        int statusCode = status.getStatusCode();
        switch (statusCode) {
            case 17000:
            case 17002:
            case 17004:
            case 17008:
            case 17009:
            case 17024:
                return new FirebaseAuthInvalidCredentialsException(zzacx(statusCode), zzacy(statusCode));
            case 17005:
            case 17011:
            case 17017:
            case 17021:
                return new FirebaseAuthInvalidUserException(zzacx(statusCode), zzacy(statusCode));
            case 17006:
                return new FirebaseAuthException(zzacx(statusCode), zzacy(statusCode));
            case 17007:
            case 17012:
            case 17025:
                return new FirebaseAuthUserCollisionException(zzacx(statusCode), zzacy(statusCode));
            case 17010:
                return new FirebaseTooManyRequestsException(zza("We have blocked all requests from this device due to unusual activity. Try again later.", status));
            case 17014:
                return new FirebaseAuthRecentLoginRequiredException(zzacx(statusCode), zzacy(statusCode));
            case 17015:
                return new FirebaseException("User has already been linked to the given provider.");
            case 17016:
                return new FirebaseException("User was not linked to an account with the given provider.");
            case 17020:
                return new FirebaseNetworkException("A network error (such as timeout, interrupted connection or unreachable host) has occurred.");
            case 17026:
                return new FirebaseAuthWeakPasswordException(zzacx(statusCode), zza(zzacy(statusCode), status), status.getStatusMessage());
            case 17495:
                return new zzalu("Please sign in before trying to get a token.");
            case 17499:
                return new FirebaseException(zza("An internal error has occured.", status));
            default:
                return new FirebaseException("An internal error has occurred.");
        }
    }
}
