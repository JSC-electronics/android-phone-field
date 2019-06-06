/*
 * Copyright 2016 lamudi-gmbh
 * Copyright 2019 JSC electronics
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cz.jscelectronics.phonefield.sample;

import android.content.Context;
import android.util.AttributeSet;

import cz.jscelectronics.phonefield.PhoneInputLayout;

/**
 * Custom PhoneInputLayout
 * Created by Ismail on 8/30/16.
 * Modified by vzahradnik on 6/6/2019.
 */

public class CustomPhoneInputLayout extends PhoneInputLayout {

    private String mCountryCode;

    public CustomPhoneInputLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomPhoneInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CustomPhoneInputLayout(Context context, String countryCode) {
        super(context);
        mCountryCode = countryCode;
        init();
    }

    private void init() {
        setDefaultCountry(mCountryCode);
        setHint(R.string.phone_hint);
    }
}
