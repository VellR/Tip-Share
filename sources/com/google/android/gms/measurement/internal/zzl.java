package com.google.android.gms.measurement.internal;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzre;

public final class zzl {
    public static zza<Long> akA = zza.zzf("measurement.upload.window_interval", 3600000);
    public static zza<Long> akB = zza.zzf("measurement.upload.interval", 3600000);
    public static zza<Long> akC = zza.zzf("measurement.upload.stale_data_deletion_interval", 86400000);
    public static zza<Long> akD = zza.zzf("measurement.upload.initial_upload_delay_time", 15000);
    public static zza<Long> akE = zza.zzf("measurement.upload.retry_time", 1800000);
    public static zza<Integer> akF = zza.zzaa("measurement.upload.retry_count", 6);
    public static zza<Long> akG = zza.zzf("measurement.upload.max_queue_time", 2419200000L);
    public static zza<Integer> akH = zza.zzaa("measurement.lifetimevalue.max_currency_tracked", 4);
    public static zza<Long> akI = zza.zzf("measurement.service_client.idle_disconnect_millis", 5000);
    public static zza<Boolean> aki = zza.zzo("measurement.service_enabled", true);
    public static zza<Boolean> akj = zza.zzo("measurement.service_client_enabled", true);
    public static zza<String> akk = zza.zzl("measurement.log_tag", "FA", "FA-SVC");
    public static zza<Long> akl = zza.zzf("measurement.ad_id_cache_time", 10000);
    public static zza<Long> akm = zza.zzf("measurement.monitoring.sample_period_millis", 86400000);
    public static zza<Long> akn = zza.zzb("measurement.config.cache_time", 86400000, 3600000);
    public static zza<String> ako = zza.zzav("measurement.config.url_scheme", "https");
    public static zza<String> akp = zza.zzav("measurement.config.url_authority", "app-measurement.com");
    public static zza<Integer> akq = zza.zzaa("measurement.upload.max_bundles", 100);
    public static zza<Integer> akr = zza.zzaa("measurement.upload.max_batch_size", 65536);
    public static zza<Integer> aks = zza.zzaa("measurement.upload.max_bundle_size", 65536);
    public static zza<Integer> akt = zza.zzaa("measurement.upload.max_events_per_bundle", CredentialsApi.ACTIVITY_RESULT_ADD_ACCOUNT);
    public static zza<Integer> aku = zza.zzaa("measurement.upload.max_events_per_day", 100000);
    public static zza<Integer> akv = zza.zzaa("measurement.upload.max_public_events_per_day", 50000);
    public static zza<Integer> akw = zza.zzaa("measurement.upload.max_conversions_per_day", 500);
    public static zza<Integer> akx = zza.zzaa("measurement.store.max_stored_events_per_app", 100000);
    public static zza<String> aky = zza.zzav("measurement.upload.url", "https://app-measurement.com/a");
    public static zza<Long> akz = zza.zzf("measurement.upload.backoff_period", 43200000);

    public static final class zza<V> {
        private final V I;
        private final zzre<V> J;
        private final String zzaxn;

        private zza(String str, zzre<V> zzre, V v) {
            zzab.zzaa(zzre);
            this.J = zzre;
            this.I = v;
            this.zzaxn = str;
        }

        static zza<Integer> zzaa(String str, int i) {
            return zzo(str, i, i);
        }

        static zza<String> zzav(String str, String str2) {
            return zzl(str, str2, str2);
        }

        static zza<Long> zzb(String str, long j, long j2) {
            return new zza<>(str, zzre.zza(str, Long.valueOf(j2)), Long.valueOf(j));
        }

        static zza<Boolean> zzb(String str, boolean z, boolean z2) {
            return new zza<>(str, zzre.zzm(str, z2), Boolean.valueOf(z));
        }

        static zza<Long> zzf(String str, long j) {
            return zzb(str, j, j);
        }

        static zza<String> zzl(String str, String str2, String str3) {
            return new zza<>(str, zzre.zzab(str, str3), str2);
        }

        static zza<Integer> zzo(String str, int i, int i2) {
            return new zza<>(str, zzre.zza(str, Integer.valueOf(i2)), Integer.valueOf(i));
        }

        static zza<Boolean> zzo(String str, boolean z) {
            return zzb(str, z, z);
        }

        public V get() {
            return this.I;
        }

        public V get(V v) {
            return v != null ? v : this.I;
        }

        public String getKey() {
            return this.zzaxn;
        }
    }
}
