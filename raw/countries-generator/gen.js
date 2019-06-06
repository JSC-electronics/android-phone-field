#!/usr/bin/env node

/*
 * Copyright 2016 lamudi-gmbh
 * Copyright 2019 and modified by JSC electronics
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

'use strict';

var _ = require("lodash"),
	_s = require("underscore.string"),
	fs = require("fs"),
	countries = require('./countries');

var output = "";



function generateCountriesClass() {
    var generatedClass = "";
    var a = function (l, indent) {
      if (_.isArray(l)) {
        _.each(l, function (eachL) {
          a(eachL, indent);
        });
      } else {
        generatedClass += (indent ? _s.repeat(" ", indent) : "") + (l||"") + "\n";
      }
    };

    a("package cz.jscelectronics.phonefield;");
    a();
    a("import java.util.ArrayList;");
    a("import java.util.List;");
    a();
    a("public final class Countries {");
    a();
    a("public static final List<Country> COUNTRIES = new ArrayList<>();",4);
    a("static {",4);
    countries.forEach(function(country) {
    	a("COUNTRIES.add(new Country(\""+country.cca2+"\", \""+country.name.common+"\"));", 8);
	});
	a("}",4);
    a();
    a("}");

    return generatedClass;
  }



  var generated = generateCountriesClass();
  fs.writeFileSync("Countries.java", generated);