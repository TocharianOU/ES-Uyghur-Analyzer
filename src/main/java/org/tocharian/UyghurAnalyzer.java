/*
 * Licensed to Tocharian under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Tocharian licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.tocharian;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardTokenizer;

import java.util.Map;

public class UyghurAnalyzer extends Analyzer {
    private final Map<String, String[]> dictionary;

    public UyghurAnalyzer(Map<String, String[]> dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
        StandardTokenizer tokenizer = new StandardTokenizer();
        TokenStream tokenStream = new UyghurWordTokenFilter(tokenizer, dictionary);
        return new TokenStreamComponents(tokenizer, tokenStream);
    }
}
