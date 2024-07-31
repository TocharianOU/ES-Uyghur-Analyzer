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

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.plugin.analysis.TokenFilterFactory;
import org.elasticsearch.plugin.NamedComponent;
import java.io.IOException; // 添加这个导入

@NamedComponent(value = "uyghur_word_original")
public class UyghurWordOriginalTokenFilterFactory implements TokenFilterFactory {
    private final DictionaryLoader dictionaryLoader;

    public UyghurWordOriginalTokenFilterFactory() {
        this.dictionaryLoader = new DictionaryLoader();
        try {
            if (dictionaryLoader.getDictionary().isEmpty()) {
                dictionaryLoader.initializeFromResource("/ug_mor_original.txt");
            }
        } catch (IOException e) {
            throw new RuntimeException("Initialization Failed: " + e.getMessage(), e);
        }
    }

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new UyghurWordTokenFilter(tokenStream, dictionaryLoader.getDictionary());
    }
}
