package cz.jsc.electronics.phonefield;

import android.content.Context;
import android.content.res.Resources;

import androidx.annotation.IdRes;

import java.util.Locale;

/**
 * Country object that holds the country iso2 code, name, and dial code.
 *
 * @author Ismail Almetwally
 */
@SuppressWarnings("WeakerAccess")
public class Country {

    private final String mCode;

    private final String mName;

    public Country(String code, String name) {
        mCode = code;
        mName = name;
    }

    public String getCode() {
        return mCode;
    }

    public String getName() {
        return mName;
    }

    public String getDisplayName() {
        return new Locale("", mCode).getDisplayCountry();
    }

    public @IdRes int getResId(Context context) {
        String name = String.format("country_flag_%s", mCode.toLowerCase());
        final Resources resources = context.getResources();
        @IdRes int resourceId = resources.getIdentifier(name, "drawable", context.getPackageName());
        if (resourceId == 0) {
            // Resource not found. Fallback to UNKNOWN flag.
            name = "country_flag_unknown";
            resourceId = resources.getIdentifier(name, "drawable", context.getPackageName());
        }

        return resourceId;
    }
}
