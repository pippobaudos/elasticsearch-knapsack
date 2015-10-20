/*
 * Copyright (C) 2014 Jörg Prante
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.xbib.elasticsearch.action.knapsack.suggest;

import org.elasticsearch.action.Action;
import org.elasticsearch.client.ElasticsearchClient;
import org.xbib.elasticsearch.action.knapsack.suggest.BuildSuggestRequest;
import org.xbib.elasticsearch.action.knapsack.suggest.BuildSuggestRequestBuilder;
import org.xbib.elasticsearch.action.knapsack.suggest.BuildSuggestResponse;

/**
 * The knapsack export action exports data to archive files
 */
public class BuildSuggestAction extends Action<BuildSuggestRequest, BuildSuggestResponse, BuildSuggestRequestBuilder> {

    public final static String NAME = "org.xbib.elasticsearch.knapsack.suggest";

    public final static BuildSuggestAction INSTANCE = new BuildSuggestAction(NAME);

    protected BuildSuggestAction(String name) {
        super(name);
    }

    @Override
    public BuildSuggestResponse newResponse() {
        return new BuildSuggestResponse();
    }

    @Override
    public BuildSuggestRequestBuilder newRequestBuilder(ElasticsearchClient client) {
        return new BuildSuggestRequestBuilder(client);
    }
}
