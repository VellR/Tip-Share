package com.google.android.gms.internal;

public enum zznk {
    CLIENT_LOGIN_DISABLED("ClientLoginDisabled"),
    DEVICE_MANAGEMENT_REQUIRED("DeviceManagementRequiredOrSyncDisabled"),
    SOCKET_TIMEOUT("SocketTimeout"),
    SUCCESS("Ok"),
    UNKNOWN_ERROR("UNKNOWN_ERR"),
    NETWORK_ERROR("NetworkError"),
    SERVICE_UNAVAILABLE("ServiceUnavailable"),
    INTNERNAL_ERROR("InternalError"),
    BAD_AUTHENTICATION("BadAuthentication"),
    EMPTY_CONSUMER_PKG_OR_SIG("EmptyConsumerPackageOrSig"),
    NEEDS_2F("InvalidSecondFactor"),
    NEEDS_POST_SIGN_IN_FLOW("PostSignInFlowRequired"),
    NEEDS_BROWSER("NeedsBrowser"),
    UNKNOWN("Unknown"),
    NOT_VERIFIED("NotVerified"),
    TERMS_NOT_AGREED("TermsNotAgreed"),
    ACCOUNT_DISABLED("AccountDisabled"),
    CAPTCHA("CaptchaRequired"),
    ACCOUNT_DELETED("AccountDeleted"),
    SERVICE_DISABLED("ServiceDisabled"),
    NEED_PERMISSION("NeedPermission"),
    INVALID_SCOPE("INVALID_SCOPE"),
    USER_CANCEL("UserCancel"),
    PERMISSION_DENIED("PermissionDenied"),
    INVALID_AUDIENCE("INVALID_AUDIENCE"),
    UNREGISTERED_ON_API_CONSOLE("UNREGISTERED_ON_API_CONSOLE"),
    THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED("ThirdPartyDeviceManagementRequired"),
    DM_INTERNAL_ERROR("DeviceManagementInternalError"),
    DM_SYNC_DISABLED("DeviceManagementSyncDisabled"),
    DM_ADMIN_BLOCKED("DeviceManagementAdminBlocked"),
    DM_ADMIN_PENDING_APPROVAL("DeviceManagementAdminPendingApproval"),
    DM_STALE_SYNC_REQUIRED("DeviceManagementStaleSyncRequired"),
    DM_DEACTIVATED("DeviceManagementDeactivated"),
    DM_REQUIRED("DeviceManagementRequired"),
    ALREADY_HAS_GMAIL("ALREADY_HAS_GMAIL"),
    BAD_PASSWORD("WeakPassword"),
    BAD_REQUEST("BadRequest"),
    BAD_USERNAME("BadUsername"),
    DELETED_GMAIL("DeletedGmail"),
    EXISTING_USERNAME("ExistingUsername"),
    LOGIN_FAIL("LoginFail"),
    NOT_LOGGED_IN("NotLoggedIn"),
    NO_GMAIL("NoGmail"),
    REQUEST_DENIED("RequestDenied"),
    SERVER_ERROR("ServerError"),
    USERNAME_UNAVAILABLE("UsernameUnavailable"),
    GPLUS_OTHER("GPlusOther"),
    GPLUS_NICKNAME("GPlusNickname"),
    GPLUS_INVALID_CHAR("GPlusInvalidChar"),
    GPLUS_INTERSTITIAL("GPlusInterstitial"),
    GPLUS_PROFILE_ERROR("ProfileUpgradeError");
    
    private final String fx;

    private zznk(String str) {
        this.fx = str;
    }

    public static boolean zza(zznk zznk) {
        return BAD_AUTHENTICATION.equals(zznk) || CAPTCHA.equals(zznk) || NEED_PERMISSION.equals(zznk) || NEEDS_BROWSER.equals(zznk) || USER_CANCEL.equals(zznk) || DEVICE_MANAGEMENT_REQUIRED.equals(zznk) || DM_INTERNAL_ERROR.equals(zznk) || DM_SYNC_DISABLED.equals(zznk) || DM_ADMIN_BLOCKED.equals(zznk) || DM_ADMIN_PENDING_APPROVAL.equals(zznk) || DM_STALE_SYNC_REQUIRED.equals(zznk) || DM_DEACTIVATED.equals(zznk) || DM_REQUIRED.equals(zznk) || THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED.equals(zznk);
    }

    public static boolean zzb(zznk zznk) {
        return NETWORK_ERROR.equals(zznk) || SERVICE_UNAVAILABLE.equals(zznk);
    }

    public static final zznk zzfy(String str) {
        zznk zznk = null;
        zznk[] values = values();
        int length = values.length;
        int i = 0;
        while (i < length) {
            zznk zznk2 = values[i];
            if (!zznk2.fx.equals(str)) {
                zznk2 = zznk;
            }
            i++;
            zznk = zznk2;
        }
        return zznk;
    }
}
