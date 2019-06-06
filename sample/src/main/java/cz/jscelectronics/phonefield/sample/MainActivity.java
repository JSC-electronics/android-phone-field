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

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cz.jscelectronics.phonefield.PhoneEditText;
import cz.jscelectronics.phonefield.PhoneInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final PhoneInputLayout phoneInputLayout =
                findViewById(R.id.phone_input_layout);
        final PhoneEditText phoneEditText = findViewById(R.id.edit_text);

        CustomPhoneInputLayout customPhoneInputLayout = new CustomPhoneInputLayout(this, "EG");

        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this
                .findViewById(android.R.id.content)).getChildAt(0);

        viewGroup.addView(customPhoneInputLayout, 2);


        final Button button = findViewById(R.id.submit_button);

        assert phoneInputLayout != null;
        assert phoneEditText != null;
        assert button != null;

        phoneInputLayout.setHint(R.string.phone_hint);
        phoneInputLayout.setDefaultCountry("DE");

        phoneEditText.setHint(R.string.phone_hint);
        phoneEditText.setDefaultCountry("FR");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean valid = true;
                if (phoneInputLayout.isValid()) {
                    phoneInputLayout.setError(null);
                } else {
                    phoneInputLayout.setError(getString(R.string.invalid_phone_number));
                    valid = false;
                }

                if (phoneEditText.isValid()) {
                    phoneEditText.setError(null);
                } else {
                    phoneEditText.setError(getString(R.string.invalid_phone_number));
                    valid = false;
                }

                if (valid) {
                    Toast.makeText(MainActivity.this, R.string.valid_phone_number, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, R.string.invalid_phone_number, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
