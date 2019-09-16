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

package cz.jscelectronics.phonefield;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Implementation of PhoneField that uses an {@link EditText}
 * Created by Ismail on 5/6/16.
 */
public class PhoneTextView extends PhoneField {

    public PhoneTextView(Context context) {
        this(context, null);
    }

    public PhoneTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PhoneTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void updateLayoutAttributes() {
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        setGravity(Gravity.CENTER_VERTICAL);
        setOrientation(HORIZONTAL);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.phone_text_view;
    }
}
